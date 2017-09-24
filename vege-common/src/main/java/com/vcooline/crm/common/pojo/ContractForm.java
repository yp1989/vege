package com.vcooline.crm.common.pojo;

import com.vcooline.crm.common.model.CrmContProduct;
import com.vcooline.crm.common.model.CrmContract;
import com.vcooline.crm.common.model.CrmContractFile;
import com.vcooline.crm.common.model.CrmCustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinbaojian on 15/8/4.
 */
public class ContractForm {
    private Long busiId;
    private CrmContract contract;
    private List<CrmContProduct> contProducts;
    private List<CrmCustomer> customerList;

    private String versionIds;

    private List<CrmContractFile> contractFileList = new ArrayList<>();

    public String getVersionIds() {
        return versionIds;
    }

    public void setVersionIds(String versionIds) {
        this.versionIds = versionIds;
    }

    public List<CrmCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CrmCustomer> customerList) {
        this.customerList = customerList;
    }

    public Long getBusiId() {
        return busiId;
    }

    public void setBusiId(Long busiId) {
        this.busiId = busiId;
    }

    public CrmContract getContract() {
        return contract;
    }

    public void setContract(CrmContract contract) {
        this.contract = contract;
    }

    public List<CrmContProduct> getContProducts() {
        return contProducts;
    }

    public void setContProducts(List<CrmContProduct> contProducts) {
        this.contProducts = contProducts;
    }

    public Long getContReceivable(){
        Long result = 0l;
        if (this.getContProducts() != null){
            for (CrmContProduct contProduct : contProducts) {
                if (contProduct.getBuyCount() != null){
                    result += contProduct.getActualAmount() * contProduct.getBuyCount();
                }else {
                    result += contProduct.getActualAmount() == null ? 0 : contProduct.getActualAmount();
                }

            }
        }
        return  result;
    }

    public List<CrmContractFile> getContractFileList() {
        return contractFileList;
    }

    public void setContractFileList(List<CrmContractFile> contractFileList) {
        this.contractFileList = contractFileList;
    }
}
