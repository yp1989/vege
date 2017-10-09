package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmRole;

import java.util.List;

public interface CrmRoleService {

    /**
     * @param @return 设定文件
     * @return List<CrmRole>    返回类型
     * @throws
     * @Description:获取角色列表
     * @author caohuan
     * @date 2015年7月16日 下午5:02:57
     * 上海微客来软件技术有限公司
     */
    List<CrmRole> getRoleList();

    /**
     * @param @param role    设定文件
     * @return void    返回类型
     * @throws
     * @Description:添加角色
     * @author caohuan
     * @date 2015年7月16日 下午5:03:17
     * 上海微客来软件技术有限公司
     */
    void addRole(CrmRole role) throws Exception;

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
    void updateRole(CrmRole role) throws Exception;

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
    CrmRole getRoleById(Long id);

    void deleteRole(Long id) throws Exception;
}
