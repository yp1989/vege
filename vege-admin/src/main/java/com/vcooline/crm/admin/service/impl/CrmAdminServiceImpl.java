package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmAdminService;
import com.vcooline.crm.common.exception.ServiceProcessException;
import com.vcooline.crm.common.mapper.CrmAdminMapper;
import com.vcooline.crm.common.mapper.CrmAdminRoleMapper;
import com.vcooline.crm.common.mapper.CrmAuthMapper;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmAdminRole;
import com.vcooline.crm.common.model.CrmAuth;
import com.vcooline.crm.common.model.Page;
import com.vcooline.crm.common.util.TreeUtil;
import com.vcooline.crm.common.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmAdminServiceImpl extends BaseService implements CrmAdminService {

    @Autowired
    private CrmAdminMapper adminMapper;

    @Autowired
    private CrmAdminRoleMapper crmAdminRoleMapper;

    @Autowired
    private CrmAuthMapper crmAuthMapper;

    @Value("${admin.initial.password}")
    private String adminInitialPassword;// 管理员初始密码

    /**
     * @param adminName     用户名
     * @param adminPassword 密码
     * @return void 返回类型
     * @Description:用户登录接口
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21 上海微客来软件技术有限公司
     */
    @Override
    public String adminLogin(CrmAdmin admin) throws ServiceProcessException {
        int sumCode = 0;
        if (admin != null) {
            if (admin.getAdminName() != null
                    && admin.getAdminPassword() != null) {
                admin.setAdminPassword(Md5Util.Md5(admin.getAdminPassword()));
                CrmAdmin adminResult = adminMapper
                        .selctByAdminNameAndPassword(admin);
                if (adminResult != null && adminResult.getId() != null) {
                    List<CrmAuth> authList = crmAuthMapper
                            .getMenuAuthListByAdmin(String.valueOf(adminResult
                                    .getId()));
                    List<CrmAuth> auths = crmAuthMapper
                            .getAllAuthListByAdmin(String.valueOf(adminResult
                                    .getId()));
                    if (auths != null) {
                        for (CrmAuth auth : auths) {
                            if (auth.getAuthCode() != null && auth.getAuthCode() != 0) {
                                sumCode += auth.getAuthCode();
                            }
                        }
                    }
                    authList = TreeUtil.createTree(authList);
                    getRequest().getSession().setAttribute("sumCode", sumCode);
                    getRequest().getSession()
                            .setAttribute("admin", adminResult);
                    getRequest().getSession()
                            .setAttribute("authList", authList);
                    getRequest().getSession()
                            .setAttribute("authUrls", auths);
                } else {
                    logger.info("admin表中不存在该用户名或者密码错误");
                    throw new ServiceProcessException("admin表中不存在该用户名或者密码错误");
                }
            } else {
                logger.info("参数admin中用户名或者密码为空");
                throw new ServiceProcessException("参数admin中用户名或者密码为空");
            }
        } else {
            logger.info("传入参数admin对象为空");
            throw new ServiceProcessException("传入参数admin对象为空");
        }

        return "0";
    }

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(CrmAdmin admin) {
        if (admin != null) {
            if (admin.getAdminDep() != null && admin.getRole_id() != null) {
                Date date = new Date();
                admin.setAdminPassword(Md5Util.Md5(adminInitialPassword));
                admin.setAdminStatus((byte) 1);
                admin.setIsDel(false);
                admin.setCreateTime(date);
                admin.setUpdateTime(date);
                adminMapper.insertSelective(admin);

                // 新增管理员角色关联数据
                if (admin.getId() != null) {
                    CrmAdminRole adminRole = new CrmAdminRole();
                    adminRole.setAdminId(admin.getId());
                    adminRole.setRoleId(admin.getRole_id());
                    adminRole.setIsDel(false);
                    adminRole.setCreateTime(date);
                    adminRole.setUpdateTime(date);
                    return crmAdminRoleMapper.insertSelective(adminRole);
                }
            }
        }
        return 0;
    }

    /**
     * @return List<CrmAdmin> 返回类型
     * @Description:获取管理员列表
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21 上海微客来软件技术有限公司
     */
    public Page<CrmAdmin> getAdminList(Page<CrmAdmin> page, CrmAdmin admin) {
        // 设置查询条件
        Map<String, Object> params = new HashMap<>();
        params.put("adminRealName", admin.getAdminRealName());
        params.put("adminStatus", admin.getAdminStatus());
        params.put("role_id", admin.getRole_id());
        page.setParams(params);

        page.setResults(adminMapper.getAdminListPage(page));
        return page;
    }

    /**
     * @param adminDep 部门id
     * @return List<CrmAdmin> 返回类型
     * @Description:根据部门id获取管理员列表
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21 上海微客来软件技术有限公司
     */
    public Page<CrmAdmin> selectByAdminDep(Page<CrmAdmin> page, String adminDep) {
        // 设置查询条件
        Map<String, Object> params = new HashMap<>();
        params.put("adminDep", adminDep);
        page.setParams(params);

        List<CrmAdmin> adminList = adminMapper.selectByAdminDep(page);
        page.setResults(adminList);

        return page;
    }

    /**
     * @param admin
     * @return int 返回类型
     * @throws
     * @Description:移动管理员
     * @author caohuan
     * @date 2015年7月23日 上午11:44:41 上海微客来软件技术有限公司
     */
    public void moveAdmin(CrmAdmin admin) {
        if (admin != null && admin.getId() != null
                && admin.getAdminDep() != null) {
            adminMapper.updateAdminDepById(admin);
        }
    }

    @Override
    public List<CrmAdmin> getOwerList(CrmAdmin admin) {
        List<CrmAdmin> adminList = adminMapper.getOwerList(admin);
        return adminList;
    }

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return CrmAdmin 返回类型
     * @throws
     * @Description:根据管理员id获取管理员
     * @author caohuan
     * @date 2015年7月27日 上午11:51:30 上海微客来软件技术有限公司
     */
    public CrmAdmin selectAdminById(Long id) {
        if (id != null) {
            return this.adminMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    /**
     * @return int 返回类型
     * @throws
     * @Description:根据管理员id修改管理员姓名和角色
     * @author caohuan
     * @date 2015年7月27日 下午1:22:15 上海微客来软件技术有限公司
     */
    public int updateAdminById(CrmAdmin admin) {
        if (admin != null && admin.getId() != null
                && admin.getRole_id() != null
                && admin.getAdminRealName() != null) {
            Date date = new Date();
            admin.setUpdateTime(date);
            if ("1".equals(String.valueOf(admin.getIsResetPassword()))) {
                admin.setAdminPassword(Md5Util.Md5(adminInitialPassword));
            }
            CrmAdminRole adminRole = new CrmAdminRole();
            adminRole.setAdminId(admin.getId());
            adminRole.setRoleId(admin.getRole_id());
            adminRole.setUpdateTime(date);
            adminMapper.updateAdminById(admin);
            return crmAdminRoleMapper.updateRoleByAdmin(adminRole);
        }
        return 0;
    }

    /**
     * @param admin
     * @return int 返回类型
     * @throws
     * @Description:根据id修改管理员状态
     * @author caohuan
     * @date 2015年7月27日 下午2:03:47 上海微客来软件技术有限公司
     */
    public int updateAdminStatusById(CrmAdmin admin) {
        if (admin != null && admin.getId() != null) {
            admin.setUpdateTime(new Date());
            return adminMapper.updateByPrimaryKeySelective(admin);
        }
        return 0;
    }

    /**
     * @param admin
     * @return int 返回类型
     * @throws
     * @Description:设置部门管理员
     * @author caohuan
     * @date 2015年7月27日 下午2:29:47 上海微客来软件技术有限公司
     */
    public int setIsDepManager(CrmAdmin admin) {
        if (admin != null && admin.getId() != null) {
            admin.setUpdateTime(new Date());
            //删除该部门下已经存在的管理员
            adminMapper.setIsDepManagerToFalse(admin);
            //设置管理员为部门管理者
            adminMapper.setIsDepManager(admin);
        }
        return 0;
    }

    /**
     * @param adminPassword
     * @return CrmAdmin 返回类型
     * @throws
     * @Description:验证密码是否有效
     * @author caohuan
     * @date 2015年7月29日 上午9:46:10 上海微客来软件技术有限公司
     */
    public Boolean checkPassword(String adminPassword) {
        if (adminPassword != null && !"".equals(adminPassword)) {
            CrmAdmin admin = getUser();
            if (admin != null) {
                if (Md5Util.Md5(adminPassword).equals(admin.getAdminPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param admin
     * @return int 返回类型
     * @throws
     * @Description:保存修改的密码
     * @author caohuan
     * @date 2015年7月29日 上午10:50:27 上海微客来软件技术有限公司
     */
    public int savaUpdatePassword(CrmAdmin admin) {
        if (admin != null && admin.getId() != null) {
            admin.setUpdateTime(new Date());
            admin.setAdminPassword(Md5Util.Md5(admin.getAdminPassword()));
            adminMapper.updateByPrimaryKeySelective(admin);
            admin.setAdminName(getUser().getAdminName());
            CrmAdmin adminResult = adminMapper
                    .selctByAdminNameAndPassword(admin);
            if (adminResult != null && adminResult.getId() != null) {
                getRequest().getSession().setAttribute("admin", adminResult);
            }
        }

        return 0;
    }

    @Override
    public CrmAdmin selectAdminByRealName(String adminRealName) {
        return adminMapper.selectAdminByRealName(adminRealName);
    }
}
