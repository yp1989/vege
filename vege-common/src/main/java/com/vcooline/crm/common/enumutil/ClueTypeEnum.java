package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索类型
 * Created by xinbaojian on 15/7/17.
 */
public enum ClueTypeEnum {
    PROXY((byte) 2, "咨询代理"),
    PRODUCT((byte) 1, "咨询产品"),;

    private Byte code;
    private String desc;

    ClueTypeEnum(Byte code, String desc) {
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

    public static ClueTypeEnum getByCode(Byte code) {
        for (ClueTypeEnum clue : ClueTypeEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return ClueTypeEnum.PRODUCT;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ClueTypeEnum enumpojo : ClueTypeEnum.values()) {
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
        for (ClueTypeEnum enumpojo : ClueTypeEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
