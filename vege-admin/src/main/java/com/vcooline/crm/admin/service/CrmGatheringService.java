package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmGathering;
import com.vcooline.crm.common.model.Page;

/**
 * 收款管理
 * Created by xinbaojian on 15/8/5.
 */
public interface CrmGatheringService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int insert(CrmGathering record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int insertSelective(CrmGathering record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    CrmGathering selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int updateByPrimaryKeySelective(CrmGathering record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_gathering
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int updateByPrimaryKey(CrmGathering record);

    int saveGathering(CrmGathering gathering);

    int updateGathering(CrmGathering gathering);

    Page<CrmGathering> queryGatherForPage(CrmGathering gathering, Integer pageNo, Integer pageSize);
}
