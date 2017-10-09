package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 代理商级别
 * Created by xinbaojian on 15/8/4.
 */
public enum AgentLevelEnum {
    PU_DAI((byte) 1, "普代"),
    ZONG_DAI((byte) 2, "总代"),
    SAN_FANG_DAI_LI((byte) 3, "三方代理"),
    WEI_KE_LIFE((byte) 4, "微客生活"),
    SHI_XING((byte) 5, "试行"),;
    private Byte code;
    private String desc;

    AgentLevelEnum(Byte code, String desc) {
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

    public static AgentLevelEnum getByCode(Byte code) {
        for (AgentLevelEnum clue : AgentLevelEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return null;
    }

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (AgentLevelEnum enumpojo : AgentLevelEnum.values()) {
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
        for (AgentLevelEnum enumpojo : AgentLevelEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
