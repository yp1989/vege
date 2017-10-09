package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 上级状态
 * Created by xinbaojian on 15/7/28.
 */
public enum BusinessStatusEnum {
    AUDIT((byte) 1, "审核中"),
    CLOSED((byte) 0, "已关闭"),
    RETURN_CHANGE((byte) 2, "退回修改"),
    ACTIVE((byte) 3, "活动商机"),
    CREATE_CONTRACT((byte) 4, "生成合同"),;
    private Byte code;
    private String desc;

    BusinessStatusEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BusinessStatusEnum getByCode(Byte code) {
        for (BusinessStatusEnum clue : BusinessStatusEnum.values()) {
            if (clue.getCode() == null)
                continue;
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return null;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (BusinessStatusEnum enumpojo : BusinessStatusEnum.values()) {
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
        for (BusinessStatusEnum enumpojo : BusinessStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode() == null ? null : enumpojo.getCode().toString());
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
