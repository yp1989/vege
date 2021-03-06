package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;

public class CrmProductVersion extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Long id;

    private Long versionId;
    /**
     * 产品id
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Long prodId;

    /**
     * 版本状态
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Byte versStatus;

    /**
     * 版本名称
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private String versName;

    /**
     * 版本描述
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private String versDesc;

    /**
     * 版本标准价格
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Long versPrice;

    /**
     * 删除标识
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Boolean isDel;

    /**
     * 创建时间
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private Date updateTime;

    /**
     * 套餐所属产品名称
     */
    private String productName;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crm_product_version
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    private static final long serialVersionUID = 1L;


    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.id
     *
     * @return the value of crm_product_version.id
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.id
     *
     * @param id the value for crm_product_version.id
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.prod_id
     *
     * @return the value of crm_product_version.prod_id
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.prod_id
     *
     * @param prodId the value for crm_product_version.prod_id
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.vers_status
     *
     * @return the value of crm_product_version.vers_status
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Byte getVersStatus() {
        return versStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.vers_status
     *
     * @param versStatus the value for crm_product_version.vers_status
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setVersStatus(Byte versStatus) {
        this.versStatus = versStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.vers_name
     *
     * @return the value of crm_product_version.vers_name
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public String getVersName() {
        return versName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.vers_name
     *
     * @param versName the value for crm_product_version.vers_name
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setVersName(String versName) {
        this.versName = versName == null ? null : versName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.vers_desc
     *
     * @return the value of crm_product_version.vers_desc
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public String getVersDesc() {
        return versDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.vers_desc
     *
     * @param versDesc the value for crm_product_version.vers_desc
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setVersDesc(String versDesc) {
        this.versDesc = versDesc == null ? null : versDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.vers_price
     *
     * @return the value of crm_product_version.vers_price
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Long getVersPrice() {
        return versPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.vers_price
     *
     * @param versPrice the value for crm_product_version.vers_price
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setVersPrice(Long versPrice) {
        this.versPrice = versPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.is_del
     *
     * @return the value of crm_product_version.is_del
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.is_del
     *
     * @param isDel the value for crm_product_version.is_del
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.create_time
     *
     * @return the value of crm_product_version.create_time
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.create_time
     *
     * @param createTime the value for crm_product_version.create_time
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_product_version.update_time
     *
     * @return the value of crm_product_version.update_time
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_product_version.update_time
     *
     * @param updateTime the value for crm_product_version.update_time
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}