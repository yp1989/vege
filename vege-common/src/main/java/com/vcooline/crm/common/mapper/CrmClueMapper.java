package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.CrmClue;
import com.vcooline.crm.common.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrmClueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int insert(CrmClue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int insertSelective(CrmClue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    CrmClue selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int updateByPrimaryKeySelective(CrmClue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    int updateByPrimaryKey(CrmClue record);

    /**
     * 获取当前自增码最大值
     * @return
     */
    Integer getMaxNumCode();

    List<CrmClue> queryCrmClueForPage(@Param("page")Page<CrmClue> page);

    /**
     * 根据手机号查询所关联线索
     * @param phone
     * @return
     */
    List<CrmClue> queryCrmClueByPhone(@Param("phone") String phone);

    /**
     * 根据客户名称查询所关联线索
     * @param custName
     * @return
     */
    List<CrmClue> queryCrmClueByCustName(@Param("custName") String custName);

    /**
     * 根据老Admin线索ID查询该线索是否存在
     * @param clueId
     * @return
     */
    CrmClue selectByClueId(@Param("clueId")Long clueId);
}