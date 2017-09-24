package com.vcooline.crm.common.enumutil;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

public enum UnGatheringEnum {
    ZERO((byte)1,"0"),
	
    ZERO_FIFTYTHOUSAND((byte)2,"0-50000"),
    
    FIFTYTHOUSAND_HUNDREDTHOUSAND((byte)3,"50000-100000"),
    
    HUNDREDTHOUSAND((byte)4,"100000以上"),
    ;
    
    private Byte code;
    private String desc;

    UnGatheringEnum(Byte code, String desc) {
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

    public static UnGatheringEnum getByCode(Byte code){
        for (UnGatheringEnum clue : UnGatheringEnum.values()) {
            if (clue.getCode().equals(code)){
                return clue;
            }
        }
        return null;
    }

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (UnGatheringEnum enumpojo : UnGatheringEnum.values()) {
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
        for (UnGatheringEnum enumpojo : UnGatheringEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
