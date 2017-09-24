package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmCustomerService;
import com.vcooline.crm.common.enumutil.CustRoleEnum;
import com.vcooline.crm.common.mapper.CrmCustomerMapper;
import com.vcooline.crm.common.model.CrmCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客户联系人信息业务实现表
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmCustomerServiceImpl extends BaseService implements CrmCustomerService {

    @Autowired
    private CrmCustomerMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmCustomer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmCustomer record) {
        if (record.getIsDel() == null){
            record.setIsDel(false);
        }
        return customerMapper.insertSelective(record);
    }

    @Override
    public CrmCustomer selectByPrimaryKey(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmCustomer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmCustomer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据线索ID查询该线索的联系人
     *
     * @param clueId
     * @param releType
     * @return
     */
    @Override
    public List<CrmCustomer> getCustlistByClueId(Long clueId, Byte releType) {
        List<CrmCustomer> list = customerMapper.getCustlistByClueId(clueId,releType);
        return list;
    }

    @Override
    public List<CrmCustomer> getCustListByPhone(String phone) {
        List<CrmCustomer> customerList = customerMapper.getCustListByPhone(phone);
        for (CrmCustomer customer : customerList) {
            customer.setCustRoleName(CustRoleEnum.getByCode(customer.getCustRole()).getDesc());
        }
        return customerList;
    }
}
