package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.CrmDepService;
import com.vcooline.crm.common.mapper.CrmAdminMapper;
import com.vcooline.crm.common.mapper.CrmDepMapper;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmDep;
import com.vcooline.crm.common.util.AdditionalParameters;
import com.vcooline.crm.common.util.ConstantUtil;
import com.vcooline.crm.common.util.Tree;
import com.vcooline.crm.common.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class CrmDepServiceImpl implements CrmDepService {

    @Autowired
    private CrmDepMapper crmDepMapper;

    @Autowired
    private CrmAdminMapper crmAdminMapper;

    @Override
    public List<CrmDep> getDepList() {
        return crmDepMapper.getDepList();
    }

    /**
     * @param @return 设定文件
     * @return List<CrmDep>    返回类型
     * @throws
     * @Description:获取树状部门数据
     * @author caohuan
     * @date 2015年7月23日 下午3:42:35
     * 上海微客来软件技术有限公司
     */
    @Override
    public List<Tree> getTreeDepList(Long id) {
        if (id == null) {
            id = (long) 0;
        }
        return getTreeNodeByParent(id);
    }

    /**
     * @param dep
     * @return int   返回类型
     * @throws
     * @Description:新增部门
     * @author caohuan
     * @date 2015年7月24日 下午3:42:35
     * 上海微客来软件技术有限公司
     */
    @Override
    public CrmDep addDep(CrmDep dep) {
        if (dep != null && dep.getParentId() != null) {
            dep.setDepIsleaf((byte) 1);
            Date date = new Date();
            dep.setIsDel(false);
            dep.setCreateTime(date);
            dep.setUpdateTime(date);
            //新增部门
            crmDepMapper.insertSelective(dep);
            //修改父部门的is_leaf
            crmDepMapper.updateDepIsleaf(dep.getParentId());
        }
        return dep;
    }

    /**
     * @param dep
     * @return int   返回类型
     * @throws
     * @Description:修改部门
     * @author caohuan
     * @date 2015年7月24日 下午3:42:35
     * 上海微客来软件技术有限公司
     */
    @Override
    public int updateDep(CrmDep dep) {
        if (dep != null && dep.getId() != null) {
            dep.setUpdateTime(new Date());
            return crmDepMapper.updateByPrimaryKeySelective(dep);
        }
        return 0;
    }

    @Override
    public int deleteDep(Long id) {
        //删除前先查询该部门下是否有人员
        List<CrmAdmin> admin = crmAdminMapper.selectAdminByDep(id);
        if (admin == null || (admin != null && admin.size() == 0)) {
            return crmDepMapper.deleteDepById(id);
        }
        return 0;
    }

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return List<CrmDep>    返回类型
     * @throws
     * @Description:递归获取树状部门数据
     * @author caohuan
     * @date 2015年7月23日 下午3:44:10
     * 上海微客来软件技术有限公司
     */
    private List<TreeNode> initDepTree(Long id) {

        List<CrmDep> depList = crmDepMapper.getChildrenDeps(id);
        List<TreeNode> tree = new ArrayList<TreeNode>();
        TreeNode node = null;
        for (CrmDep dep : depList) {
            node = new TreeNode();
            node.setId(String.valueOf(dep.getId()));
            node.setName(dep.getDepName() + ConstantUtil.TREE_EDIT_ICON);
            if (dep.getParentId() == id) {
                AdditionalParameters adp = new AdditionalParameters();
                adp.setChildren(initDepTree(dep.getId()));
                node.setAdditionalParameters(adp);
            }
            if (node.getAdditionalParameters() != null
                    && node.getAdditionalParameters().getChildren() != null
                    && node.getAdditionalParameters().getChildren().size() != 0) {
                node.setType("folder");
            } else {
                node.setType("item");
            }

            tree.add(node);
        }
        return tree;
    }

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return List<Tree>    返回类型
     * @throws
     * @Description:根据id获取子节点部门
     * @author caohuan
     * @date 2015年8月20日 上午10:53:00
     * 上海微客来软件技术有限公司
     */
    private List<Tree> getTreeNodeByParent(Long id) {
        List<CrmDep> orgas = crmDepMapper.getChildrenDeps(id);
        List<Tree> list = new ArrayList<Tree>();
        Tree node = null;
        if (null != orgas) {
            for (CrmDep org : orgas) {
                node = new Tree();
                node.setId(org.getId());
                node.setText(org.getDepName());
                if (org.getDepIsleaf() == 1) {
                    node.setHasChild(true);
                }
                //node.setChildren(getTreeNodeByParent(org.getId()));
                if (null == id) {
                    node.setOpen(true);
                }
                if ("0".equals(String.valueOf(id))) {
                    //	node.setState("open");
                }
                list.add(node);
            }
        }
        return list;
    }
}
