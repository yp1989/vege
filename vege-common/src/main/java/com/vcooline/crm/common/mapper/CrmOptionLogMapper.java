package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.CrmOptionLog;

import java.util.List;

public interface CrmOptionLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    int insert(CrmOptionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    int insertSelective(CrmOptionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    CrmOptionLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    int updateByPrimaryKeySelective(CrmOptionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    int updateByPrimaryKey(CrmOptionLog record);

    List<CrmOptionLog> selectListByTargetId(CrmOptionLog record);
}