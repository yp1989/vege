package com.vcooline.crm.common.pojo;

import com.vcooline.crm.common.model.CrmBusiness;
import com.vcooline.crm.common.model.CrmCallback;
import com.vcooline.crm.common.model.CrmCustomer;
import com.vcooline.crm.common.model.CrmProductVersion;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/31.
 */
public class BusinessForm {

    private CrmBusiness business;

    private List<CrmCustomer> customerList;

    private String versionIds;

    private CrmCallback callback;

    public CrmCallback getCallback() {
        return callback;
    }

    public void setCallback(CrmCallback callback) {
        this.callback = callback;
    }

    public String getVersionIds() {
        return versionIds;
    }

    public void setVersionIds(String versionIds) {
        this.versionIds = versionIds;
    }


    public CrmBusiness getBusiness() {
        return business;
    }

    public void setBusiness(CrmBusiness business) {
        this.business = business;
    }

    public List<CrmCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CrmCustomer> customerList) {
        this.customerList = customerList;
    }
}
