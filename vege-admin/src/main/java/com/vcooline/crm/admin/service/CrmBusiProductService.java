package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmBusiProduct;

/**
 * Created by xinbaojian on 15/7/29.
 */
public interface CrmBusiProductService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    int insert(CrmBusiProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    int insertSelective(CrmBusiProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    CrmBusiProduct selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    int updateByPrimaryKeySelective(CrmBusiProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_busi_product
     *
     * @mbggenerated Wed Jul 29 14:31:47 CST 2015
     */
    int updateByPrimaryKey(CrmBusiProduct record);

    /**
     * 根据商机ID产出商机套餐关联
     * @param busiId
     * @return
     */
    int deleteByBusiId(Long busiId);
}
