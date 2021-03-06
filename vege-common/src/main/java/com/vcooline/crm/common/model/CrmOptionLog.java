package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;

public class CrmOptionLog extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Long id;

    /**
     * 1 表示线索
     * 2 表示商机
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Byte alloType;

    /**
     * 目标Id 由 allo_type类型决定
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Long targetId;

    /**
     * 操作人
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Long alloAdmin;

    private String alloAdminName; //虚属性 操作人名字

    /**
     * 操作
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Byte option;

    //虚属性 操作类型名字
    private String optionStr;

    /**
     * 删除标识
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Boolean isDel;

    /**
     * 创建时间
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crm_option_log
     *
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.id
     *
     * @return the value of crm_option_log.id
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.id
     *
     * @param id the value for crm_option_log.id
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.allo_type
     *
     * @return the value of crm_option_log.allo_type
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Byte getAlloType() {
        return alloType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.allo_type
     *
     * @param alloType the value for crm_option_log.allo_type
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setAlloType(Byte alloType) {
        this.alloType = alloType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.target_id
     *
     * @return the value of crm_option_log.target_id
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.target_id
     *
     * @param targetId the value for crm_option_log.target_id
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.allo_admin
     *
     * @return the value of crm_option_log.allo_admin
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Long getAlloAdmin() {
        return alloAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.allo_admin
     *
     * @param alloAdmin the value for crm_option_log.allo_admin
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setAlloAdmin(Long alloAdmin) {
        this.alloAdmin = alloAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.option
     *
     * @return the value of crm_option_log.option
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Byte getOption() {
        return option;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.option
     *
     * @param option the value for crm_option_log.option
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setOption(Byte option) {
        this.option = option;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.is_del
     *
     * @return the value of crm_option_log.is_del
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.is_del
     *
     * @param isDel the value for crm_option_log.is_del
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.create_time
     *
     * @return the value of crm_option_log.create_time
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.create_time
     *
     * @param createTime the value for crm_option_log.create_time
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_option_log.update_time
     *
     * @return the value of crm_option_log.update_time
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_option_log.update_time
     *
     * @param updateTime the value for crm_option_log.update_time
     * @mbggenerated Fri Jul 24 16:50:38 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAlloAdminName() {
        return alloAdminName;
    }

    public void setAlloAdminName(String alloAdminName) {
        this.alloAdminName = alloAdminName;
    }

    public String getOptionStr() {
        return optionStr;
    }

    public void setOptionStr(String optionStr) {
        this.optionStr = optionStr;
    }
}