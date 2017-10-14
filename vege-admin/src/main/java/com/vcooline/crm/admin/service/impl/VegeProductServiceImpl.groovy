package com.vcooline.crm.admin.service.impl

import com.vcooline.crm.admin.service.IVegeProductService
import com.vcooline.crm.common.mapper.VegeProdectMapper
import com.vcooline.crm.common.model.VegeProdect
import com.vcooline.crm.common.model.VegeProdectWithBLOBs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VegeProductServiceImpl implements IVegeProductService{

    @Autowired
    private VegeProdectMapper vegeProdectMapper;

    @Override
    int deleteByPrimaryKey(Integer id) {
        return vegeProdectMapper.deleteByPrimaryKey(id)
    }

    @Override
    int insert(VegeProdectWithBLOBs record) {
        return vegeProdectMapper.insert(record)
    }

    @Override
    int insertSelective(VegeProdectWithBLOBs record) {
        return vegeProdectMapper.insertSelective(record)
    }

    @Override
    VegeProdectWithBLOBs selectByPrimaryKey(Integer id) {
        return vegeProdectMapper.selectByPrimaryKey(id)
    }

    @Override
    int updateByPrimaryKeySelective(VegeProdectWithBLOBs record) {
        return vegeProdectMapper.updateByPrimaryKeySelective(record)
    }

    @Override
    int updateByPrimaryKeyWithBLOBs(VegeProdectWithBLOBs record) {
        return vegeProdectMapper.updateByPrimaryKeyWithBLOBs(record)
    }

    @Override
    int updateByPrimaryKey(VegeProdect record) {
        return vegeProdectMapper.updateByPrimaryKey(record)
    }

    @Override
    int saveOrUpdate(VegeProdectWithBLOBs record) {
        //根据商品编码查询商品
        VegeProdect prodect = vegeProdectMapper.selectByNumber(record.number)
        int result = 0
        if (prodect == null)
            vegeProdectMapper.insertSelective(record)
        else
            vegeProdectMapper.updateByPrimaryKeySelective(record)
        return result
    }

    @Override
    List<VegeProdectWithBLOBs> getAllList(VegeProdect vegeProdect) {
        return vegeProdectMapper.getAllList(vegeProdect)
    }

    @Override
    List<VegeProdectWithBLOBs> getAllListByCategoryId(Integer categoryId) {
        return vegeProdectMapper.getAllListByCategoryId(categoryId)
    }
}
