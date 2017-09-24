package com.vcooline.crm.common.pojo;

import com.vcooline.crm.common.model.CrmBusiProduct;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/29.
 */
public class ProductVersionForm {

    private Long clueId;

    List<CrmBusiProduct> busiProducts;

    public Long getClueId() {
        return clueId;
    }

    public void setClueId(Long clueId) {
        this.clueId = clueId;
    }

    public List<CrmBusiProduct> getBusiProducts() {
        return busiProducts;
    }

    public void setBusiProducts(List<CrmBusiProduct> busiProducts) {
        this.busiProducts = busiProducts;
    }
}
