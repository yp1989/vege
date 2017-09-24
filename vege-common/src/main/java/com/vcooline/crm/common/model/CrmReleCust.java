package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;

public class CrmReleCust extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long id;

    /**
     * 线索id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long targetId;

    /**
     * 客户id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private Long custId;

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
     * 关联类型
     */
    private Byte releType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crm_clue_cust
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue_cust.id
     *
     * @return the value of crm_clue_cust.id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue_cust.id
     *
     * @param id the value for crm_clue_cust.id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue_cust.cust_id
     *
     * @return the value of crm_clue_cust.cust_id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue_cust.cust_id
     *
     * @param custId the value for crm_clue_cust.cust_id
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue_cust.is_del
     *
     * @return the value of crm_clue_cust.is_del
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue_cust.is_del
     *
     * @param isDel the value for crm_clue_cust.is_del
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue_cust.create_time
     *
     * @return the value of crm_clue_cust.create_time
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue_cust.create_time
     *
     * @param createTime the value for crm_clue_cust.create_time
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue_cust.update_time
     *
     * @return the value of crm_clue_cust.update_time
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue_cust.update_time
     *
     * @param updateTime the value for crm_clue_cust.update_time
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getReleType() {
        return releType;
    }

    public void setReleType(Byte releType) {
        this.releType = releType;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }


}