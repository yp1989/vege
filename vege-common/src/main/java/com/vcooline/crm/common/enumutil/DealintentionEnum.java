package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 成交意向
 * Created by xinbaojian on 15/7/22.
 */
public enum DealintentionEnum {
    DEAL_PENDING((byte) 1, "无人接听"),
    DEAL_ONE_WEEK((byte) 2, "长期跟进"),
    DEAL_UNSURE((byte) 3, "短期跟进"),
    DEAL_NOT((byte) 4, "不会成交"),
    DEALT((byte) 5, "已成交"),;
    private Byte code;
    private String desc;

    DealintentionEnum(Byte code, String desc) {
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


    public static DealintentionEnum getByCode(Byte code) {
        for (DealintentionEnum clue : DealintentionEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return DealintentionEnum.DEAL_PENDING;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (DealintentionEnum enumpojo : DealintentionEnum.values()) {
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
        for (DealintentionEnum enumpojo : DealintentionEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
