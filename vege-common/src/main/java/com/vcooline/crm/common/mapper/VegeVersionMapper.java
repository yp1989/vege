package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.VegeVersion;

public interface VegeVersionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insert(VegeVersion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int insertSelective(VegeVersion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    VegeVersion selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKeySelective(VegeVersion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_version
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    int updateByPrimaryKey(VegeVersion record);
}