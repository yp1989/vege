package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索咨询方式
 * Created by xinbaojian on 15/7/17.
 */
public enum ClueConsultEnum {
    FREE((byte)1,"免费申请"),
    QQ((byte)2,"QQ"),
    PHONE_400((byte)3,"400电话"),
    OTHERS((byte)4,"其他"),
    ;

    private Byte code;
    private String desc;

    ClueConsultEnum(Byte code, String desc) {
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

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ClueConsultEnum enumpojo : ClueConsultEnum.values()) {
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
        for (ClueConsultEnum enumpojo : ClueConsultEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
