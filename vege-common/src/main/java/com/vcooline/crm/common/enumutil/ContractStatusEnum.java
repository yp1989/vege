package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

public enum ContractStatusEnum {

    AUDIT((byte) 1, "审核中"),

    PASS((byte) 2, "合同通过"),

    CANCEL((byte) 3, "合同作废"),;
    private Byte code;
    private String desc;

    ContractStatusEnum(Byte code, String desc) {
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

    public static ContractStatusEnum getByCode(Byte code) {
        for (ContractStatusEnum clue : ContractStatusEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return null;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ContractStatusEnum enumpojo : ContractStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(pojo.getDesc());
            list.add(pojo);
        }
        return JSONObject.toJSONString(list);
    }

    public static List<EnumPojo> toList() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ContractStatusEnum enumpojo : ContractStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }

}
