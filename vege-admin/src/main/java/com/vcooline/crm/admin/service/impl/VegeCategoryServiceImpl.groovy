package com.vcooline.crm.admin.service.impl

import com.vcooline.crm.admin.service.IVegeCategoryService
import com.vcooline.crm.common.mapper.VegeCategoryMapper
import com.vcooline.crm.common.model.VegeCategory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VegeCategoryServiceImpl implements IVegeCategoryService{

    @Autowired
    private VegeCategoryMapper vegeCategoryMapper;

    @Override
    int deleteByPrimaryKey(Integer id) {
        return vegeCategoryMapper.deleteByPrimaryKey(id)
    }

    @Override
    int insert(VegeCategory record) {
        return vegeCategoryMapper.insert(record)
    }

    @Override
    int insertSelective(VegeCategory record) {
        return vegeCategoryMapper.insertSelective(record)
    }

    @Override
    VegeCategory selectByPrimaryKey(Integer id) {
        return vegeCategoryMapper.selectByPrimaryKey(id)
    }

    @Override
    int updateByPrimaryKeySelective(VegeCategory record) {
        return vegeCategoryMapper.updateByPrimaryKeySelective(record)
    }

    @Override
    int updateByPrimaryKey(VegeCategory record) {
        return vegeCategoryMapper.updateByPrimaryKey(record)
    }

    @Override
    int saveOrUpdate(VegeCategory record) {
        assert record != null
        assert record.categoryName != null
        VegeCategory category = vegeCategoryMapper.selectByName(record.categoryName)
        int result = 0
        if (category == null){
            vegeCategoryMapper.insertSelective(record)
        }else{
            record.id = category.id
            vegeCategoryMapper.updateByPrimaryKeySelective(record)
        }
        return result
    }
}
