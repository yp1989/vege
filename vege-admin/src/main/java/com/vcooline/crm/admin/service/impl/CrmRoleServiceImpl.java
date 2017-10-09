package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.CrmRoleService;
import com.vcooline.crm.common.exception.ServiceProcessException;
import com.vcooline.crm.common.mapper.CrmAdminRoleMapper;
import com.vcooline.crm.common.mapper.CrmRoleAuthMapper;
import com.vcooline.crm.common.mapper.CrmRoleMapper;
import com.vcooline.crm.common.model.CrmAdminRole;
import com.vcooline.crm.common.model.CrmRole;
import com.vcooline.crm.common.model.CrmRoleAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CrmRoleServiceImpl implements CrmRoleService {

    @Autowired
    private CrmRoleMapper crmRoleMapper;

    @Autowired
    private CrmRoleAuthMapper crmRoleAuthMapper;

    @Autowired
    private CrmAdminRoleMapper crmAdminRoleMapper;

    @Override
    public List<CrmRole> getRoleList() {
        List<CrmRole> roleList = crmRoleMapper.getRoleList();
        return roleList;
    }

    /**
     * @param @param role    设定文件
     * @return void    返回类型
     * @throws Exception
     * @throws
     * @Description:添加角色
     * @author caohuan
     * @date 2015年7月16日 下午5:03:17
     * 上海微客来软件技术有限公司
     */
    public void addRole(CrmRole role) throws Exception {
        if (role != null && !"".equals(role.getRoleName())) {
            Date date = new Date();
            role.setIsDel(false);
            role.setCreateTime(date);
            role.setUpdateTime(date);
            role.setRoleType((byte) 1);
            //添加角色
            this.crmRoleMapper.insertSelective(role);
            if (role.getAuthIdArray() != null && role.getId() != null) {
                List<CrmRoleAuth> roleAuthList = new ArrayList<CrmRoleAuth>();
                CrmRoleAuth roleAuth = null;
                for (long authId : role.getAuthIdArray()) {
                    roleAuth = new CrmRoleAuth();
                    roleAuth.setRoleId(role.getId());
                    roleAuth.setAuthId(authId);
                    roleAuth.setIsDel(false);
                    roleAuth.setCreateTime(date);
                    roleAuth.setUpdateTime(date);
                    roleAuthList.add(roleAuth);
                }
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("roleAuthList", roleAuthList);

                int count = crmRoleAuthMapper.batchInsert(map);
                System.out.println("批量插入角色权限关联数据条数 = " + count);
            }
        }
    }

    /**
     * @param role
     * @return void    返回类型
     * @throws Exception 设定文件
     * @throws
     * @Description:更新角色
     * @author caohuan
     * @date 2015年7月28日 上午10:31:58
     * 上海微客来软件技术有限公司
     */
    public void updateRole(CrmRole role) throws Exception {
        if (role != null && role.getId() != null) {
            Date date = new Date();
            role.setUpdateTime(date);
            crmRoleMapper.updateByPrimaryKeySelective(role);
            crmRoleAuthMapper.deleteAuthByRole(role.getId());
            if (role.getAuthIdArray() != null && role.getId() != null) {
                List<CrmRoleAuth> roleAuthList = new ArrayList<CrmRoleAuth>();
                CrmRoleAuth roleAuth = null;
                for (long authId : role.getAuthIdArray()) {
                    roleAuth = new CrmRoleAuth();
                    roleAuth.setRoleId(role.getId());
                    roleAuth.setAuthId(authId);
                    roleAuth.setIsDel(false);
                    roleAuth.setCreateTime(date);
                    roleAuth.setUpdateTime(date);
                    roleAuthList.add(roleAuth);
                }
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("roleAuthList", roleAuthList);

                int count = crmRoleAuthMapper.batchInsert(map);
                System.out.println("批量插入角色权限关联数据条数 = " + count);
            }
        }
    }

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return CrmRole    返回类型
     * @throws
     * @Description:根据id获取角色信息
     * @author caohuan
     * @date 2015年7月27日 下午4:56:58
     * 上海微客来软件技术有限公司
     */
    public CrmRole getRoleById(Long id) {
        return crmRoleMapper.getRoleById(id);
    }

    public void deleteRole(Long id) throws Exception {
        if (id != null) {
            List<CrmAdminRole> list = crmAdminRoleMapper.selectAdminByRole(id);
            if (list != null && list.size() != 0) {
                throw new ServiceProcessException("该角色关联有效的管理员，无法删除");
            } else {
                CrmRole role = new CrmRole();
                role.setId(id);
                role.setIsDel(true);
                crmRoleMapper.updateByPrimaryKeySelective(role);
            }
        }
    }
}
