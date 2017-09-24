package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmReleCust;

/**
 * Created by xinbaojian on 15/7/17.
 */
public interface CrmReleCustService {
    int deleteByPrimaryKey(Long id);

    int insert(CrmReleCust record);

    int insertSelective(CrmReleCust record);

    CrmReleCust selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrmReleCust record);

    int updateByPrimaryKey(CrmReleCust record);
}
