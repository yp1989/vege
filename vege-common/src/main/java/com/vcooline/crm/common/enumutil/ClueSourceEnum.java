package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索来源枚举
 * Created by xinbaojian on 15/7/17.
 */
public enum ClueSourceEnum {
    SYS_SPLIT((byte) 1, "系统分单"),
    FRIENDS_INTRODUCE((byte) 2, "朋友介绍"),
    STRANGE_VISIT((byte) 3, "陌生拜访"),
    LEADER_SPLIT((byte) 4, "领导分单"),
    OLD_CLIENT_INTRODUCE((byte) 5, "老客户介绍"),
    COLLEAGUE_SPLIT((byte) 6, "同事分单"),
    EMPLOYEE_TURNOVER_INTRODUCE((byte) 7, "离职员工介绍"),;

    private Byte code;
    private String desc;

    ClueSourceEnum(Byte code, String desc) {
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


    public static ClueSourceEnum getByCode(Byte code) {
        for (ClueSourceEnum clue : ClueSourceEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return null;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ClueSourceEnum enumpojo : ClueSourceEnum.values()) {
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
        for (ClueSourceEnum enumpojo : ClueSourceEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
