package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinbaojian on 15/7/17.
 */
public enum CrmProductStatusEnum {

    /**
     * 产品下架
     */
    PRODUCT_SHELF((byte) 0, "产品下架"),
    /**
     * 产品上架
     */
    PRODUCT_SHELVES((byte) 1, "产品上架"),;

    private Byte code;
    private String desc;

    CrmProductStatusEnum(Byte code, String desc) {
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

    public static String toJson() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (CrmProductStatusEnum pro : CrmProductStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(pro.getCode().toString());
            pojo.setDesc(pojo.getDesc());
            list.add(pojo);
        }
        return JSONObject.toJSONString(list);
    }

    public static List<EnumPojo> toList() {
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (CrmProductStatusEnum pro : CrmProductStatusEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(pro.getCode().toString());
            pojo.setDesc(pro.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
