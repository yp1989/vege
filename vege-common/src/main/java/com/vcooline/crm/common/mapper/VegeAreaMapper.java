package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.VegeArea;

public interface VegeAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insert(VegeArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insertSelective(VegeArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    VegeArea selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKeySelective(VegeArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKey(VegeArea record);
}