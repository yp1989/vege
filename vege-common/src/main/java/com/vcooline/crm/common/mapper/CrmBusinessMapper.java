package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.CrmBusiness;
import com.vcooline.crm.common.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrmBusinessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int insert(CrmBusiness record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int insertSelective(CrmBusiness record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    CrmBusiness selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int updateByPrimaryKeySelective(CrmBusiness record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_business
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int updateByPrimaryKey(CrmBusiness record);

    /**
     * 获取当前自增码最大值
     * @return
     */
    Integer getMaxNumCode();

    /**
     * 根据条件查询分页
     * @param page
     * @return
     */
    List<CrmBusiness> queryCrmBusieForPage(@Param("page")Page<CrmBusiness> page);


    /**
     * 查询列表
     * @param record
     * @return
     */
    List<CrmBusiness> selectByParam(CrmBusiness record);
}