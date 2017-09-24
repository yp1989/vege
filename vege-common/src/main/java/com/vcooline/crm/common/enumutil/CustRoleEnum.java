package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户联系人角色类型
 * Created by xinbaojian on 15/7/17.
 */
public enum CustRoleEnum {
    CONTACT_PERSON((byte)1,"联系人"),
    REPORTER((byte)2,"汇报人"),
    DECISION_MAKER((byte)3,"决策人"),
    ;

    private Byte code;
    private String desc;

    CustRoleEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CustRoleEnum getByCode(Byte code){
        for (CustRoleEnum clue : CustRoleEnum.values()) {
            if (clue.getCode().equals(code)){
                return clue;
            }
        }
        return null;
    }

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (CustRoleEnum roleEnum : CustRoleEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(roleEnum.getCode().toString());
            pojo.setDesc(roleEnum.getDesc());
            list.add(pojo);
        }
        return JSONObject.toJSONString(list);
    }

    public static List<EnumPojo> toList(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (CustRoleEnum roleEnum : CustRoleEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(roleEnum.getCode().toString());
            pojo.setDesc(roleEnum.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
