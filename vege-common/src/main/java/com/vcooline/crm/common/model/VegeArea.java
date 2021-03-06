package com.vcooline.crm.common.model;

import java.io.Serializable;
import java.util.Date;

public class VegeArea extends BaseModel implements Serializable {
    /**
     * 编号 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Integer id;

    /**
     * 创建时间 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Date createDate;

    /**
     * 修改时间 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Date modifyDate;

    /**
     * 创建人 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private String creator;

    /**
     * 修改人 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private String modifier;

    /**
     * 是否有效 1代表有效,0代表失效已删除
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Byte isValid;

    /**
     * 区域编号 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private String areaNo;

    /**
     * 区域名称 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private String areaName;

    /**
     * 父级编号 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Integer parentId;

    /**
     * 摊主编号 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Integer vendorId;

    /**
     * 系统公司编号 
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private Integer sysCompanyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vege_area
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.id
     *
     * @return the value of vege_area.id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.id
     *
     * @param id the value for vege_area.id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.create_date
     *
     * @return the value of vege_area.create_date
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.create_date
     *
     * @param createDate the value for vege_area.create_date
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.modify_date
     *
     * @return the value of vege_area.modify_date
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.modify_date
     *
     * @param modifyDate the value for vege_area.modify_date
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.creator
     *
     * @return the value of vege_area.creator
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.creator
     *
     * @param creator the value for vege_area.creator
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.modifier
     *
     * @return the value of vege_area.modifier
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.modifier
     *
     * @param modifier the value for vege_area.modifier
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.is_valid
     *
     * @return the value of vege_area.is_valid
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Byte getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.is_valid
     *
     * @param isValid the value for vege_area.is_valid
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.area_no
     *
     * @return the value of vege_area.area_no
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public String getAreaNo() {
        return areaNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.area_no
     *
     * @param areaNo the value for vege_area.area_no
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo == null ? null : areaNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.area_name
     *
     * @return the value of vege_area.area_name
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.area_name
     *
     * @param areaName the value for vege_area.area_name
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.parent_id
     *
     * @return the value of vege_area.parent_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.parent_id
     *
     * @param parentId the value for vege_area.parent_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.vendor_id
     *
     * @return the value of vege_area.vendor_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Integer getVendorId() {
        return vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.vendor_id
     *
     * @param vendorId the value for vege_area.vendor_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vege_area.sys_company_id
     *
     * @return the value of vege_area.sys_company_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public Integer getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vege_area.sys_company_id
     *
     * @param sysCompanyId the value for vege_area.sys_company_id
     *
     * @mbggenerated Sun Oct 15 15:29:20 CST 2017
     */
    public void setSysCompanyId(Integer sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }
}