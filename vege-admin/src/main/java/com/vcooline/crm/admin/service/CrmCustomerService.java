package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmCustomer;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/17.
 */
public interface CrmCustomerService {

    int deleteByPrimaryKey(Long id);

    int insert(CrmCustomer record);

    int insertSelective(CrmCustomer record);

    CrmCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrmCustomer record);

    int updateByPrimaryKey(CrmCustomer record);

    /**
     * 根据线索ID查询该线索的联系人
     * @param clueId
     * @param releType
     * @return
     */
    List<CrmCustomer> getCustlistByClueId(Long clueId, Byte releType);

    /**
     * 根据手机号模糊查询客户信息
     * @param phone
     * @return
     */
    List<CrmCustomer> getCustListByPhone(String phone);

}
