package com.vcooline.crm.admin.service

import com.vcooline.crm.common.model.VegeProdect
import com.vcooline.crm.common.model.VegeProdectWithBLOBs

interface IVegeProductService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int deleteByPrimaryKey(Integer id)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int insert(VegeProdectWithBLOBs record)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int insertSelective(VegeProdectWithBLOBs record)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    VegeProdectWithBLOBs selectByPrimaryKey(Integer id)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int updateByPrimaryKeySelective(VegeProdectWithBLOBs record)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(VegeProdectWithBLOBs record)

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_product
     *
     * @mbggenerated Tue Oct 10 23:00:17 CST 2017
     */
    int updateByPrimaryKey(VegeProdect record)



    int saveOrUpdate(VegeProdect record)



}