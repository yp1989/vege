package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmContProductService;
import com.vcooline.crm.common.mapper.CrmContProductMapper;
import com.vcooline.crm.common.model.CrmContProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xinbaojian on 15/8/4.
 */
@Transactional
@Service
public class CrmContProductServiceImpl extends BaseService implements CrmContProductService {

    @Autowired
    private CrmContProductMapper contProductMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return contProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmContProduct record) {
        return contProductMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmContProduct record) {
        return contProductMapper.insertSelective(record);
    }

    @Override
    public CrmContProduct selectByPrimaryKey(Long id) {
        return contProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmContProduct record) {
        return contProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmContProduct record) {
        return contProductMapper.updateByPrimaryKey(record);
    }
}
