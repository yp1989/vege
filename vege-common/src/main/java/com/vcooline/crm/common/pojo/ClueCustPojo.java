package com.vcooline.crm.common.pojo;

import com.vcooline.crm.common.model.CrmCallback;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by xinbaojian on 15/8/19.
 */
public class ClueCustPojo {
    private Long id;
    private String custName;
    private String custAddr;
    private Integer custProvince;
    private Integer custCity;
    private Integer custArea;
    private Byte clueKnow;
    private Byte clueType;
    private String userName;
    private String custPhone;
    private String custQq;
    private String custEmail;
    private Long[] productIds;
    private Byte callBargain;//成交意向
    private Date createTime;//创建时间
    private List<CrmCallback> callbackList;

    //录入人
    private String adminName;
    //归属人
    private String ownerName;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public Integer getCustProvince() {
        return custProvince;
    }

    public void setCustProvince(Integer custProvince) {
        this.custProvince = custProvince;
    }

    public Integer getCustCity() {
        return custCity;
    }

    public void setCustCity(Integer custCity) {
        this.custCity = custCity;
    }

    public Integer getCustArea() {
        return custArea;
    }

    public void setCustArea(Integer custArea) {
        this.custArea = custArea;
    }

    public Byte getClueKnow() {
        return clueKnow;
    }

    public void setClueKnow(Byte clueKnow) {
        this.clueKnow = clueKnow;
    }

    public Byte getClueType() {
        return clueType;
    }

    public void setClueType(Byte clueType) {
        this.clueType = clueType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustQq() {
        return custQq;
    }

    public void setCustQq(String custQq) {
        this.custQq = custQq;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public Long[] getProductIds() {
        return productIds;
    }

    public void setProductIds(Long[] productIds) {
        this.productIds = productIds;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Byte getCallBargain() {
        return callBargain;
    }

    public void setCallBargain(Byte callBargain) {
        this.callBargain = callBargain;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CrmCallback> getCallbackList() {
        return callbackList;
    }

    public void setCallbackList(List<CrmCallback> callbackList) {
        this.callbackList = callbackList;
    }


    @Override
    public String toString() {
        return "ClueCustPojo{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", custAddr='" + custAddr + '\'' +
                ", custProvince=" + custProvince +
                ", custCity=" + custCity +
                ", custArea=" + custArea +
                ", clueKnow=" + clueKnow +
                ", clueType=" + clueType +
                ", userName='" + userName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custQq='" + custQq + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", productIds=" + Arrays.toString(productIds) +
                ", callBargain=" + callBargain +
                ", createTime=" + createTime +
                ", callbackList=" + callbackList +
                ", adminName='" + adminName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
