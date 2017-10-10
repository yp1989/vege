package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.VegeCategory;
import org.apache.ibatis.annotations.Param;

public interface VegeCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    int insert(VegeCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    int insertSelective(VegeCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    VegeCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    int updateByPrimaryKeySelective(VegeCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vege_category
     *
     * @mbggenerated Tue Oct 10 22:03:14 CST 2017
     */
    int updateByPrimaryKey(VegeCategory record);

    VegeCategory selectByName(@Param("name") String name);
}