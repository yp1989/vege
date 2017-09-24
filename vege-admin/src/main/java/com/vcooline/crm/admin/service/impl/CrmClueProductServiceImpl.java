package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmClueProductService;
import com.vcooline.crm.common.mapper.CrmClueProductMapper;
import com.vcooline.crm.common.model.CrmClueProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmClueProductServiceImpl extends BaseService implements CrmClueProductService {

    @Autowired
    private CrmClueProductMapper clueProductMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clueProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmClueProduct record) {
        return clueProductMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmClueProduct record) {
        return clueProductMapper.insertSelective(record);
    }

    @Override
    public CrmClueProduct selectByPrimaryKey(Long id) {
        return clueProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmClueProduct record) {
        return clueProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmClueProduct record) {
        return clueProductMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据线索ID删除线索产品关联
     *
     * @param clueId
     * @return
     */
    @Override
    public int deleteByClueId(Long clueId) {
        return clueProductMapper.deleteByClueId(clueId);
    }
}
