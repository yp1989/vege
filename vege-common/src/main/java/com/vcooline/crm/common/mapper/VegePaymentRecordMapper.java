package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.VegePaymentRecord;

public interface VegePaymentRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insert(VegePaymentRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insertSelective(VegePaymentRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    VegePaymentRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKeySelective(VegePaymentRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_payment_record
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKey(VegePaymentRecord record);
}