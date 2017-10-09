package com.vcooline.crm.common.pojo;

import com.vcooline.crm.common.model.CrmCallback;
import com.vcooline.crm.common.model.CrmClue;
import com.vcooline.crm.common.model.CrmCustomer;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/20.
 */
public class ClueAddForm {
    private CrmClue clue;

    private List<CrmCustomer> customerList;

    private Long[] productIds;

    private CrmCallback callback;

    private List<CrmCallback> callbackList;

    private Boolean isAllot = false;//标记是否分配给自己，true 分配给自己，false不分配

    public CrmClue getClue() {
        return clue;
    }

    public void setClue(CrmClue clue) {
        this.clue = clue;
    }

    public List<CrmCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CrmCustomer> customerList) {
        this.customerList = customerList;
    }

    public Long[] getProductIds() {
        return productIds;
    }

    public void setProductIds(Long[] productIds) {
        this.productIds = productIds;
    }

    public CrmCallback getCallback() {
        return callback;
    }

    public void setCallback(CrmCallback callback) {
        this.callback = callback;
    }

    public Boolean getIsAllot() {
        return isAllot;
    }

    public void setIsAllot(Boolean isAllot) {
        this.isAllot = isAllot;
    }

    public List<CrmCallback> getCallbackList() {
        return callbackList;
    }

    public void setCallbackList(List<CrmCallback> callbackList) {
        this.callbackList = callbackList;
    }
}
