package com.vcooline.crm.admin.service.impl

import com.vcooline.crm.admin.service.IVegeMachineService
import com.vcooline.crm.common.mapper.VegeMachineMapper
import com.vcooline.crm.common.model.VegeMachine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VegeMachineServiceImpl implements IVegeMachineService{

    @Autowired
    private VegeMachineMapper machineMapper

    @Override
    int deleteByPrimaryKey(Integer id) {
        return machineMapper.deleteByPrimaryKey(id)
    }

    @Override
    int insert(VegeMachine record) {
        return machineMapper.insert(record)
    }

    @Override
    int insertSelective(VegeMachine record) {
        return machineMapper.insertSelective(record)
    }

    @Override
    VegeMachine selectByPrimaryKey(Integer id) {
        return machineMapper.selectByPrimaryKey(id)
    }

    @Override
    int updateByPrimaryKeySelective(VegeMachine record) {
        return machineMapper.updateByPrimaryKeySelective(record)
    }

    @Override
    int updateByPrimaryKey(VegeMachine record) {
        return machineMapper.updateByPrimaryKey(record)
    }
}
