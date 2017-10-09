package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作类型
 * Created by xinbaojian on 15/7/27.
 */
public enum OptionTypeEnum {
    CLOSE((byte) 0, "关闭"),
    EDIT((byte) 1, "编辑"),;

    private Byte code;
    private String desc;

    OptionTypeEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static OptionTypeEnum getByCode(Byte code) {
        for (OptionTypeEnum clue : OptionTypeEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return null;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (OptionTypeEnum enumpojo : OptionTypeEnum.values()) {
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
        for (OptionTypeEnum enumpojo : OptionTypeEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
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
}
