package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmReleCustService;
import com.vcooline.crm.common.mapper.CrmReleCustMapper;
import com.vcooline.crm.common.model.CrmReleCust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmReleCustServiceImpl extends BaseService implements CrmReleCustService {

    @Autowired
    private CrmReleCustMapper clueCustMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clueCustMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmReleCust record) {
        return clueCustMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmReleCust record) {
        return clueCustMapper.insertSelective(record);
    }

    @Override
    public CrmReleCust selectByPrimaryKey(Long id) {
        return clueCustMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmReleCust record) {
        return clueCustMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmReleCust record) {
        return clueCustMapper.updateByPrimaryKey(record);
    }
}
