package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.CrmAdminRole;

import java.util.List;

public interface CrmAdminRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int insert(CrmAdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int insertSelective(CrmAdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    CrmAdminRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int updateByPrimaryKeySelective(CrmAdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_admin_role
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int updateByPrimaryKey(CrmAdminRole record);

    /**
     * @param @param  record
     * @param @return 设定文件
     * @return int    返回类型
     * @throws
     * @Description:根据管理员id修改角色
     * @author caohuan
     * @date 2015年7月27日 下午1:31:24
     * 上海微客来软件技术有限公司
     */
    int updateRoleByAdmin(CrmAdminRole record);

    /**
     * @param 设定文件
     * @return void    返回类型
     * @throws
     * @Description:根据角色id获取管理员
     * @author caohuan
     * @date 2015年7月28日 下午12:03:09
     * 上海微客来软件技术有限公司
     */
    List<CrmAdminRole> selectAdminByRole(Long id);
}