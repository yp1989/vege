package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分配类型 枚举类
 * Created by xinbaojian on 15/7/24.
 */
public enum ReleTypeEnum {
    CLUE_TYPE((byte)1,"线索"),
    BUSINESS_TYPE((byte)2,"商机"),
    CONTRACT((byte)3,"合同"),
    ;

    private Byte code;
    private String desc;

    ReleTypeEnum(Byte code, String desc) {
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


    public static ReleTypeEnum getByCode(Byte code){
        for (ReleTypeEnum clue : ReleTypeEnum.values()) {
            if (clue.getCode().equals(code)){
                return clue;
            }
        }
        return null;
    }

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ReleTypeEnum enumpojo : ReleTypeEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(pojo.getDesc());
            list.add(pojo);
        }
        return JSONObject.toJSONString(list);
    }

    public static List<EnumPojo> toList(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ReleTypeEnum enumpojo : ReleTypeEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
