package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.CrmContractFileService;
import com.vcooline.crm.common.mapper.CrmContractFileMapper;
import com.vcooline.crm.common.model.CrmContractFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xinbaojian on 15/11/11.
 */
@Service
public class CrmContractFileServiceImpl implements CrmContractFileService {

    @Autowired
    private CrmContractFileMapper fileMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return fileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmContractFile record) {
        return fileMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmContractFile record) {
        return fileMapper.insertSelective(record);
    }

    @Override
    public CrmContractFile selectByPrimaryKey(Long id) {
        return fileMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmContractFile record) {
        return fileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmContractFile record) {
        return fileMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrmContractFile> selectByTypeTargetId(CrmContractFile record) {
        return fileMapper.selectByTypeTargetId(record);
    }
}
