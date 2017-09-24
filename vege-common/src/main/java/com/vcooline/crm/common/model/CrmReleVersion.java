package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;

public class CrmReleVersion extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Long id;

    /**
     * 关联类型 1 线索 ；2 商机；3 合同
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Byte releType;

    /**
     * 关联id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Long releId;

    /**
     * 套餐id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Long versionId;

    /**
     * 删除标识
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Boolean isDel;

    /**
     * 创建时间
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crm_rele_version
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.id
     *
     * @return the value of crm_rele_version.id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.id
     *
     * @param id the value for crm_rele_version.id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.rele_type
     *
     * @return the value of crm_rele_version.rele_type
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Byte getReleType() {
        return releType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.rele_type
     *
     * @param releType the value for crm_rele_version.rele_type
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setReleType(Byte releType) {
        this.releType = releType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.rele_id
     *
     * @return the value of crm_rele_version.rele_id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Long getReleId() {
        return releId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.rele_id
     *
     * @param releId the value for crm_rele_version.rele_id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setReleId(Long releId) {
        this.releId = releId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.version_id
     *
     * @return the value of crm_rele_version.version_id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.version_id
     *
     * @param versionId the value for crm_rele_version.version_id
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.is_del
     *
     * @return the value of crm_rele_version.is_del
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.is_del
     *
     * @param isDel the value for crm_rele_version.is_del
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.create_time
     *
     * @return the value of crm_rele_version.create_time
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.create_time
     *
     * @param createTime the value for crm_rele_version.create_time
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_rele_version.update_time
     *
     * @return the value of crm_rele_version.update_time
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_rele_version.update_time
     *
     * @param updateTime the value for crm_rele_version.update_time
     *
     * @mbggenerated Thu Jul 30 15:40:22 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}