package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CrmContract extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long id;

    /**
     * 商机id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long busiId;

    /**
     * 合同编号
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private String contNumber;

    /**
     * 编号自增码
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Integer numCode;

    /**
     * 签订日期
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Date contSigntime;

    /**
     * 合同类型
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte contType;

    /**
     * 合同状态
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte contStatus;

    /**
     * 代理商级别
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte agentLevel;

    /**
     * 服务级别
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte contServiceLevel;

    /**
     * 类别
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte contCategory;

    /**
     * 有效期
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Date contValidityDate;

    /**
     * 应收款
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long contReceivable;

    /**
     * 已收款
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long contCollected;

    /**
     * 未收款
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */

    /**
     * 合同附件名称
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private String contAccessoryName;

    /**
     * 账号开通状态个
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Byte accStatus;

    private Long contUncollected;

    /**
     * 备注
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private String contRemark;

    /**
     * 删除标识
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Boolean isDel;

    /**
     * 创建时间
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Date updateTime;


    /**
     * 联系人集合
     */
    private List<CrmCustomer> customerList;

    /**
     * 套餐集合
     */
    private List<CrmProductVersion> versionList;

    /**
     * 产品接口
     */
    private List<CrmContProduct> contProductList;

    /**
     * 商机来源
     */
    private Byte busiSource;

    /**
     * 线索录入人
     */
    private String adminName;

    /**
     * 合同退回修改备注
     */
    private String returnChangeRemark;

    /***********查询条件***********************/
    private Long clue_id;
    private String cust;//客户名称
    private String ownerName;//归属人姓名
    private Long owner;//归属人id
    private Date createStartTime;//合同生成时间 ---开始
    private Date createEndTime;//合同生成时间 ---结束
    private Integer uncollected;
    private Long contStartUncollected;//未收款区间 ----开始
    private Long contEndUncollected;//未收款区间 ----结束
    private String[] versionIds;//套餐id
    private String custAddr;
    private Integer custProvince;
    private Integer custCity;
    private Integer custArea;
    private Long adminDep;//归属人部门id
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.id
     *
     * @return the value of crm_contract.id
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.id
     *
     * @param id the value for crm_contract.id
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClue_id() {
        return clue_id;
    }

    public void setClue_id(Long clue_id) {
        this.clue_id = clue_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.busi_id
     *
     * @return the value of crm_contract.busi_id
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getBusiId() {
        return busiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.busi_id
     *
     * @param busiId the value for crm_contract.busi_id
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setBusiId(Long busiId) {
        this.busiId = busiId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_number
     *
     * @return the value of crm_contract.cont_number
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public String getContNumber() {
        return contNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_number
     *
     * @param contNumber the value for crm_contract.cont_number
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContNumber(String contNumber) {
        this.contNumber = contNumber == null ? null : contNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.num_code
     *
     * @return the value of crm_contract.num_code
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Integer getNumCode() {
        return numCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.num_code
     *
     * @param numCode the value for crm_contract.num_code
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_signtime
     *
     * @return the value of crm_contract.cont_signtime
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getContSigntime() {
        return contSigntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_signtime
     *
     * @param contSigntime the value for crm_contract.cont_signtime
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContSigntime(Date contSigntime) {
        this.contSigntime = contSigntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_type
     *
     * @return the value of crm_contract.cont_type
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Byte getContType() {
        return contType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_type
     *
     * @param contType the value for crm_contract.cont_type
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContType(Byte contType) {
        this.contType = contType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_status
     *
     * @return the value of crm_contract.cont_status
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Byte getContStatus() {
        return contStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_status
     *
     * @param contStatus the value for crm_contract.cont_status
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContStatus(Byte contStatus) {
        this.contStatus = contStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.agent_level
     *
     * @return the value of crm_contract.agent_level
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Byte getAgentLevel() {
        return agentLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.agent_level
     *
     * @param agentLevel the value for crm_contract.agent_level
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setAgentLevel(Byte agentLevel) {
        this.agentLevel = agentLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_service_level
     *
     * @return the value of crm_contract.cont_service_level
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Byte getContServiceLevel() {
        return contServiceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_service_level
     *
     * @param contServiceLevel the value for crm_contract.cont_service_level
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContServiceLevel(Byte contServiceLevel) {
        this.contServiceLevel = contServiceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_category
     *
     * @return the value of crm_contract.cont_category
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Byte getContCategory() {
        return contCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_category
     *
     * @param contCategory the value for crm_contract.cont_category
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContCategory(Byte contCategory) {
        this.contCategory = contCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_validity_date
     *
     * @return the value of crm_contract.cont_validity_date
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getContValidityDate() {
        return contValidityDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_validity_date
     *
     * @param contValidityDate the value for crm_contract.cont_validity_date
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContValidityDate(Date contValidityDate) {
        this.contValidityDate = contValidityDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_receivable
     *
     * @return the value of crm_contract.cont_receivable
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getContReceivable() {
        return contReceivable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_receivable
     *
     * @param contReceivable the value for crm_contract.cont_receivable
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContReceivable(Long contReceivable) {
        this.contReceivable = contReceivable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_collected
     *
     * @return the value of crm_contract.cont_collected
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getContCollected() {
        return contCollected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_collected
     *
     * @param contCollected the value for crm_contract.cont_collected
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContCollected(Long contCollected) {
        this.contCollected = contCollected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_uncollected
     *
     * @return the value of crm_contract.cont_uncollected
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getContUncollected() {
        return contUncollected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_uncollected
     *
     * @param contUncollected the value for crm_contract.cont_uncollected
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContUncollected(Long contUncollected) {
        this.contUncollected = contUncollected;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.cont_remark
     *
     * @return the value of crm_contract.cont_remark
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public String getContRemark() {
        return contRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.cont_remark
     *
     * @param contRemark the value for crm_contract.cont_remark
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setContRemark(String contRemark) {
        this.contRemark = contRemark == null ? null : contRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.is_del
     *
     * @return the value of crm_contract.is_del
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.is_del
     *
     * @param isDel the value for crm_contract.is_del
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.create_time
     *
     * @return the value of crm_contract.create_time
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.create_time
     *
     * @param createTime the value for crm_contract.create_time
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_contract.update_time
     *
     * @return the value of crm_contract.update_time
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_contract.update_time
     *
     * @param updateTime the value for crm_contract.update_time
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<CrmCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CrmCustomer> customerList) {
        this.customerList = customerList;
    }

    public List<CrmProductVersion> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<CrmProductVersion> versionList) {
        this.versionList = versionList;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    public Long getContStartUncollected() {
        return contStartUncollected;
    }

    public void setContStartUncollected(Long contStartUncollected) {
        this.contStartUncollected = contStartUncollected;
    }

    public Long getContEndUncollected() {
        return contEndUncollected;
    }

    public void setContEndUncollected(Long contEndUncollected) {
        this.contEndUncollected = contEndUncollected;
    }

    public String[] getVersionIds() {
        return versionIds;
    }

    public void setVersionIds(String[] versionIds) {
        this.versionIds = versionIds;
    }

    public Integer getUncollected() {
        return uncollected;
    }

    public void setUncollected(Integer uncollected) {
        this.uncollected = uncollected;
    }

    public Byte getBusiSource() {
        return busiSource;
    }

    public void setBusiSource(Byte busiSource) {
        this.busiSource = busiSource;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getContAccessoryName() {
        return contAccessoryName;
    }

    public void setContAccessoryName(String contAccessoryName) {
        this.contAccessoryName = contAccessoryName;
    }

    public Byte getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(Byte accStatus) {
        this.accStatus = accStatus;
    }

    public String getReturnChangeRemark() {
        return returnChangeRemark;
    }

    public void setReturnChangeRemark(String returnChangeRemark) {
        this.returnChangeRemark = returnChangeRemark;
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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getAdminDep() {
        return adminDep;
    }

    public void setAdminDep(Long adminDep) {
        this.adminDep = adminDep;
    }

    public List<CrmContProduct> getContProductList() {
        return contProductList;
    }

    public void setContProductList(List<CrmContProduct> contProductList) {
        this.contProductList = contProductList;
    }

    @Override
    public String toString() {
        return "CrmContract{" +
                "id=" + id +
                ", busiId=" + busiId +
                ", contNumber='" + contNumber + '\'' +
                ", numCode=" + numCode +
                ", contSigntime=" + contSigntime +
                ", contType=" + contType +
                ", contStatus=" + contStatus +
                ", agentLevel=" + agentLevel +
                ", contServiceLevel=" + contServiceLevel +
                ", contCategory=" + contCategory +
                ", contValidityDate=" + contValidityDate +
                ", contReceivable=" + contReceivable +
                ", contCollected=" + contCollected +
                ", contAccessoryName='" + contAccessoryName + '\'' +
                ", accStatus=" + accStatus +
                ", contUncollected=" + contUncollected +
                ", contRemark='" + contRemark + '\'' +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", customerList=" + customerList +
                ", versionList=" + versionList +
                ", busiSource=" + busiSource +
                ", adminName='" + adminName + '\'' +
                ", returnChangeRemark='" + returnChangeRemark + '\'' +
                ", cust='" + cust + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", createStartTime=" + createStartTime +
                ", createEndTime=" + createEndTime +
                ", uncollected=" + uncollected +
                ", contStartUncollected=" + contStartUncollected +
                ", contEndUncollected=" + contEndUncollected +
                ", versionIds='" + versionIds + '\'' +
                '}';
    }
}