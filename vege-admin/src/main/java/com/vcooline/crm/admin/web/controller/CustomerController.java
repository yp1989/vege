package com.vcooline.crm.admin.web.controller;

import com.vcooline.crm.admin.service.CrmCustomerService;
import com.vcooline.crm.common.model.CrmCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 联系人管理
 * Created by xinbaojian on 15/7/27.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CrmCustomerService customerService;

    @RequestMapping("/query")
    @ResponseBody
    public List<CrmCustomer> getCustomerList(String phone) {
        List<CrmCustomer> customerList = customerService.getCustListByPhone(phone);
        return customerList;
    }
}
