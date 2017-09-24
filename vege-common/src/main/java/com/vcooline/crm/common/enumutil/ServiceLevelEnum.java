package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务级别
 * Created by xinbaojian on 15/8/4.
 */
public enum ServiceLevelEnum {
    GENERAL((byte)1,"普通"),
    BRONZE_MEDAL((byte)2,"铜牌"),
    SILVER_MEDAL((byte)3,"银牌"),
    GOLD_MEDAL((byte)4,"金牌"),
    NEW_AGENT((byte)5,"新代理"),
    DORMANCY((byte)6,"休眠"),
    STOP((byte)7,"终止"),
    DISPUTE_AGENCY((byte)8,"纠纷代理"),
    ;

    private Byte code;
    private String desc;

    ServiceLevelEnum(Byte code, String desc) {
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

    public static ServiceLevelEnum getByCode(Byte code){
        for (ServiceLevelEnum clue : ServiceLevelEnum.values()) {
            if (clue.getCode().equals(code)){
                return clue;
            }
        }
        return null;
    }

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ServiceLevelEnum enumpojo : ServiceLevelEnum.values()) {
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
        for (ServiceLevelEnum enumpojo : ServiceLevelEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
