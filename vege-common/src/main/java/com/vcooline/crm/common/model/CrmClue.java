package com.vcooline.crm.common.model;

import com.vcooline.crm.common.enumutil.ClueKnowEnum;
import com.vcooline.crm.common.enumutil.ClueSourceEnum;
import com.vcooline.crm.common.enumutil.ClueStatusEnum;
import com.vcooline.crm.common.enumutil.ClueTypeEnum;
import com.vcooline.crm.common.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CrmClue extends BaseModel implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Long id;

    private Long clueId;

    /**
     * 线索编号
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String clueNumber;

    /**
     * 编号自增码
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Integer numCode;

    /**
     * 线索来源
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Byte clueSource;

    /**
     * 线索来源，文本
     */
    private String clueSourceStr;

    /**
     * 了解方式
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Byte clueKnow;

    /**
     * 了解方式，文本
     */
    private String clueKnowStr;

    /**
     * 咨询方式
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Byte clueConsult;

    /**
     * 线索类型
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Byte clueType;

    /**
     * 线索类型，文本
     */
    private String clueTypeStr;

    /**
     * 线索状态
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Byte clueStatusOnline;

    /**
     * 线索状态，文本
     */
    private String clueStatusOnlineStr;

    /**
     * 关键字
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String clueKeyword;

    /**
     * 录入人
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Long adminId;

    /**
     * 录入人姓名
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String adminName;

    /**
     * 归属人
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Long owner;

    /**
     * 归属人姓名
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String ownerName;

    /**
     * 客户名称
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String custName;

    /**
     * 客户详细地址
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String custAddr;

    /**
     * 所属省份
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Integer custProvince;

    /**
     * 所属城市
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Integer custCity;

    /**
     * 所属区域
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Integer custArea;

    /**
     * 是否回访
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Boolean isCallback;

    /**
     * 备注
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private String remark;

    /**
     * 商机审核失败返回修改备注
     */
    private String returnChangeRemark;

    /**
     * 删除标识
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Boolean isDel;

    /**
     * 线索分配时间
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Date allotTime;

    /**
     * 创建时间
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Date createTime;

    private Long createTimeLong;

    /**
     * 更新时间
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private Date updateTime;

    /**
     * 归属人 类型
     */
    private Byte ownerType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crm_clue
     *
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    private static final long serialVersionUID = 1L;

    //虚属性
    private String contacts;//联系人

    private String contactsPhone;//联系人方式
    private String contactsQQ;//联系人方式

    private String provinceName;//省份名称

    private String cityName;//城市名称

    private Long productId;//预购产品ID

    private Byte callBargain; //成交意向
    private String callBargainStr; //成交意向
    private Date callTime;
    private Date callNextTime;

    private Date createTimestart;
    private Date createTimeend;
    private Date allotTimestart;
    private Date allotTimeend;

    private Date callTimestart;
    private Date callTimeend;
    //下次回访时间段--查询所用
    private Date nextTimestart;
    private Date nextTimeend;

    private Integer optionStatus;//操作状态

    private Byte searchType;//线索管理查询0 ，呼叫中心查询 1
    private Byte isDepManager;//是否是管理员查询 0不是 1是

    private Byte isRepeat; //标记联系人是否重复，0未重复，1已重复

    private List<CrmProduct> productList;

    private List<Long> ownersList;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.id
     *
     * @return the value of crm_clue.id
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.id
     *
     * @param id the value for crm_clue.id
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_number
     *
     * @return the value of crm_clue.clue_number
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getClueNumber() {
        return clueNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_number
     *
     * @param clueNumber the value for crm_clue.clue_number
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueNumber(String clueNumber) {
        this.clueNumber = clueNumber == null ? null : clueNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.num_code
     *
     * @return the value of crm_clue.num_code
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Integer getNumCode() {
        return numCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.num_code
     *
     * @param numCode the value for crm_clue.num_code
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_source
     *
     * @return the value of crm_clue.clue_source
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Byte getClueSource() {
        return clueSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_source
     *
     * @param clueSource the value for crm_clue.clue_source
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueSource(Byte clueSource) {
        this.clueSource = clueSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_know
     *
     * @return the value of crm_clue.clue_know
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Byte getClueKnow() {
        return clueKnow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_know
     *
     * @param clueKnow the value for crm_clue.clue_know
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueKnow(Byte clueKnow) {
        this.clueKnow = clueKnow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_consult
     *
     * @return the value of crm_clue.clue_consult
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Byte getClueConsult() {
        return clueConsult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_consult
     *
     * @param clueConsult the value for crm_clue.clue_consult
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueConsult(Byte clueConsult) {
        this.clueConsult = clueConsult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_type
     *
     * @return the value of crm_clue.clue_type
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Byte getClueType() {
        return clueType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_type
     *
     * @param clueType the value for crm_clue.clue_type
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueType(Byte clueType) {
        this.clueType = clueType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_status_online
     *
     * @return the value of crm_clue.clue_status_online
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Byte getClueStatusOnline() {
        return clueStatusOnline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_status_online
     *
     * @param clueStatusOnline the value for crm_clue.clue_status_online
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueStatusOnline(Byte clueStatusOnline) {
        this.clueStatusOnline = clueStatusOnline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.clue_keyword
     *
     * @return the value of crm_clue.clue_keyword
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getClueKeyword() {
        return clueKeyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.clue_keyword
     *
     * @param clueKeyword the value for crm_clue.clue_keyword
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setClueKeyword(String clueKeyword) {
        this.clueKeyword = clueKeyword == null ? null : clueKeyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.admin_id
     *
     * @return the value of crm_clue.admin_id
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.admin_id
     *
     * @param adminId the value for crm_clue.admin_id
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.admin_name
     *
     * @return the value of crm_clue.admin_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.admin_name
     *
     * @param adminName the value for crm_clue.admin_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.owner
     *
     * @return the value of crm_clue.owner
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Long getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.owner
     *
     * @param owner the value for crm_clue.owner
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.owner_name
     *
     * @return the value of crm_clue.owner_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.owner_name
     *
     * @param ownerName the value for crm_clue.owner_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.cust_name
     *
     * @return the value of crm_clue.cust_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getCustName() {
        return custName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.cust_name
     *
     * @param custName the value for crm_clue.cust_name
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.cust_addr
     *
     * @return the value of crm_clue.cust_addr
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getCustAddr() {
        return custAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.cust_addr
     *
     * @param custAddr the value for crm_clue.cust_addr
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr == null ? null : custAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.cust_province
     *
     * @return the value of crm_clue.cust_province
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Integer getCustProvince() {
        return custProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.cust_province
     *
     * @param custProvince the value for crm_clue.cust_province
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCustProvince(Integer custProvince) {
        this.custProvince = custProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.cust_city
     *
     * @return the value of crm_clue.cust_city
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Integer getCustCity() {
        return custCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.cust_city
     *
     * @param custCity the value for crm_clue.cust_city
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCustCity(Integer custCity) {
        this.custCity = custCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.cust_area
     *
     * @return the value of crm_clue.cust_area
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Integer getCustArea() {
        return custArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.cust_area
     *
     * @param custArea the value for crm_clue.cust_area
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCustArea(Integer custArea) {
        this.custArea = custArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.is_callback
     *
     * @return the value of crm_clue.is_callback
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Boolean getIsCallback() {
        return isCallback;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.is_callback
     *
     * @param isCallback the value for crm_clue.is_callback
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setIsCallback(Boolean isCallback) {
        this.isCallback = isCallback;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.remark
     *
     * @return the value of crm_clue.remark
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.remark
     *
     * @param remark the value for crm_clue.remark
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.is_del
     *
     * @return the value of crm_clue.is_del
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.is_del
     *
     * @param isDel the value for crm_clue.is_del
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.allot_time
     *
     * @return the value of crm_clue.allot_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Date getAllotTime() {
        return allotTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.allot_time
     *
     * @param allotTime the value for crm_clue.allot_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setAllotTime(Date allotTime) {
        this.allotTime = allotTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.create_time
     *
     * @return the value of crm_clue.create_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.create_time
     *
     * @param createTime the value for crm_clue.create_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_clue.update_time
     *
     * @return the value of crm_clue.update_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_clue.update_time
     *
     * @param updateTime the value for crm_clue.update_time
     * @mbggenerated Wed Jul 22 10:16:27 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getClueSourceStr() {
        if (clueSource != null) {
            String source = ClueSourceEnum.getByCode(clueSource).getDesc();
            if (StringUtils.isNotEmpty(source)) {
                clueSourceStr = source;
            }
        }
        return clueSourceStr;
    }

    public void setClueSourceStr(String clueSourceStr) {
        this.clueSourceStr = clueSourceStr;
    }

    public String getClueKnowStr() {
        if (clueKnow != null && clueKnow > 0) {
            String clueKnows = ClueKnowEnum.getByCode(clueKnow).getDesc();
            if (StringUtils.isNotEmpty(clueKnows)) {
                clueKnowStr = clueKnows;
            }
        }
        return clueKnowStr;
    }

    public void setClueKnowStr(String clueKnowStr) {
        this.clueKnowStr = clueKnowStr;
    }

    public String getClueTypeStr() {
        if (clueType != null) {
            System.out.println(clueType);
            String clueKnows = ClueTypeEnum.getByCode(clueType).getDesc();
            if (StringUtils.isNotEmpty(clueKnows)) {
                clueTypeStr = clueKnows;
            }
        }
        return clueTypeStr;
    }

    public void setClueTypeStr(String clueTypeStr) {
        this.clueTypeStr = clueTypeStr;
    }


    public String getClueStatusOnlineStr() {
        String clueKnows = ClueStatusEnum.getByCode(clueStatusOnline).getDesc();
        if (StringUtils.isNotEmpty(clueKnows)) {
            clueStatusOnlineStr = clueKnows;
        }
        return clueStatusOnlineStr;
    }

    public void setClueStatusOnlineStr(String clueStatusOnlineStr) {
        this.clueStatusOnlineStr = clueStatusOnlineStr;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Byte getCallBargain() {
        return callBargain;
    }

    public void setCallBargain(Byte callBargain) {
        this.callBargain = callBargain;
    }

    public Date getCreateTimestart() {
        return createTimestart;
    }

    public void setCreateTimestart(Date createTimestart) {
        this.createTimestart = createTimestart;
    }

    public Date getCreateTimeend() {
        return createTimeend;
    }

    public void setCreateTimeend(Date createTimeend) {
        this.createTimeend = createTimeend;
    }

    public Date getAllotTimestart() {
        return allotTimestart;
    }

    public void setAllotTimestart(Date allotTimestart) {
        this.allotTimestart = allotTimestart;
    }

    public Date getAllotTimeend() {
        return allotTimeend;
    }

    public void setAllotTimeend(Date allotTimeend) {
        this.allotTimeend = allotTimeend;
    }

    public List<CrmProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<CrmProduct> productList) {
        this.productList = productList;
    }

    public String getReturnChangeRemark() {
        return returnChangeRemark;
    }

    public void setReturnChangeRemark(String returnChangeRemark) {
        this.returnChangeRemark = returnChangeRemark;
    }

    public Integer getOptionStatus() {
        return optionStatus;
    }

    public void setOptionStatus(Integer optionStatus) {
        this.optionStatus = optionStatus;
    }

    public String getCallBargainStr() {
        return callBargainStr;
    }

    public void setCallBargainStr(String callBargainStr) {
        this.callBargainStr = callBargainStr;
    }

    public Byte getSearchType() {
        return searchType;
    }

    public void setSearchType(Byte searchType) {
        this.searchType = searchType;
    }

    public Byte getIsDepManager() {
        return isDepManager;
    }

    public void setIsDepManager(Byte isDepManager) {
        this.isDepManager = isDepManager;
    }

    public Byte getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Byte isRepeat) {
        this.isRepeat = isRepeat;
    }

    public Long getCreateTimeLong() {
        return createTimeLong;
    }

    public void setCreateTimeLong(Long createTimeLong) {
        this.createTimeLong = createTimeLong;
    }

    public Byte getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Byte ownerType) {
        this.ownerType = ownerType;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Long getClueId() {
        return clueId;
    }

    public void setClueId(Long clueId) {
        this.clueId = clueId;
    }

    public List<Long> getOwnersList() {
        return ownersList;
    }

    public void setOwnersList(List<Long> ownersList) {
        this.ownersList = ownersList;
    }

    public Date getCallNextTime() {
        return callNextTime;
    }

    public void setCallNextTime(Date callNextTime) {
        this.callNextTime = callNextTime;
    }

    public Date getNextTimestart() {
        return nextTimestart;
    }

    public void setNextTimestart(Date nextTimestart) {
        this.nextTimestart = nextTimestart;
    }

    public Date getNextTimeend() {
        return nextTimeend;
    }

    public void setNextTimeend(Date nextTimeend) {
        this.nextTimeend = nextTimeend;
    }

    public Date getCallTimestart() {
        return callTimestart;
    }

    public void setCallTimestart(Date callTimestart) {
        this.callTimestart = callTimestart;
    }

    public Date getCallTimeend() {
        return callTimeend;
    }

    public void setCallTimeend(Date callTimeend) {
        this.callTimeend = callTimeend;
    }

    public String getContactsQQ() {
        return contactsQQ;
    }

    public void setContactsQQ(String contactsQQ) {
        this.contactsQQ = contactsQQ;
    }
}