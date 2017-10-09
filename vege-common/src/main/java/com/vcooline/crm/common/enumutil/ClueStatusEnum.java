package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索状态
 * Created by xinbaojian on 15/7/17.
 */
public enum ClueStatusEnum {
    NOT_ALLOCATED((byte) 0, "未分配"),
    ALLOCATED((byte) 1, "已分配"),
    CLOSED((byte) 2, "已关闭"),
    RETURN_CHANGE((byte) 3, "退回修改"),
    DONE_CLOSED((byte) 4, "生成商机"),;

    private Byte code;
    private String desc;

    ClueStatusEnum(Byte code, String desc) {
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

    public static ClueStatusEnum getByCode(Byte code) {
        if (code == null) {
            return ClueStatusEnum.NOT_ALLOCATED;
        }

        for (ClueStatusEnum clue : ClueStatusEnum.values()) {
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
        for (ClueStatusEnum enumpojo : ClueStatusEnum.values()) {
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
        for (ClueStatusEnum enumpojo : ClueStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode() == null ? null : enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
