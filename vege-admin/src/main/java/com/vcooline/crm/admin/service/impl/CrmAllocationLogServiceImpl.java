package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmAllocationLogService;
import com.vcooline.crm.common.mapper.CrmAllocationLogMapper;
import com.vcooline.crm.common.model.CrmAllocationLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/24.
 */
@Transactional
@Service
public class CrmAllocationLogServiceImpl extends BaseService implements CrmAllocationLogService{

    @Autowired
    private CrmAllocationLogMapper allocationLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return allocationLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmAllocationLog record) {
        return allocationLogMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmAllocationLog record) {
        return allocationLogMapper.insertSelective(record);
    }

    @Override
    public CrmAllocationLog selectByPrimaryKey(Long id) {
        return allocationLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmAllocationLog record) {
        return allocationLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmAllocationLog record) {
        return allocationLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrmAllocationLog> selectListByTargetId(CrmAllocationLog record) {
        return allocationLogMapper.selectListByTargetId(record);
    }
}
