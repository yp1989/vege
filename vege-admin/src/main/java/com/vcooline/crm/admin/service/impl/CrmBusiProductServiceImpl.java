package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmBusiProductService;
import com.vcooline.crm.common.mapper.CrmBusiProductMapper;
import com.vcooline.crm.common.model.CrmBusiProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xinbaojian on 15/7/29.
 */
@Transactional
@Service
public class CrmBusiProductServiceImpl extends BaseService implements CrmBusiProductService{

    @Autowired
    private CrmBusiProductMapper busiProductMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return busiProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmBusiProduct record) {
        return busiProductMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmBusiProduct record) {
        return busiProductMapper.insertSelective(record);
    }

    @Override
    public CrmBusiProduct selectByPrimaryKey(Long id) {
        return busiProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmBusiProduct record) {
        return busiProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmBusiProduct record) {
        return busiProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByBusiId(Long busiId) {
        return busiProductMapper.deleteByBusiId(busiId);
    }
}
