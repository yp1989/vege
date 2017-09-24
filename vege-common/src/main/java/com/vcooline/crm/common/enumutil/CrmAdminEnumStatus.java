package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户的状态枚举类
 * Created by xinbaojian on 15/7/16.
 */
public enum CrmAdminEnumStatus {
    NORMAL((byte)1,"正常"),
    FREEZE((byte)2,"冻结"),
    CANCEL((byte)3,"注销"),
    ;

    private Byte code;
    private String desc;

    CrmAdminEnumStatus(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Byte code){
        for (CrmAdminEnumStatus adm : CrmAdminEnumStatus.values()) {
            if (adm.getCode().equals(code)){
                return adm.getDesc();
            }
        }
        return null;
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
        for (CrmAdminEnumStatus enumpojo : CrmAdminEnumStatus.values()) {
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
        for (CrmAdminEnumStatus enumpojo : CrmAdminEnumStatus.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
