package com.vcooline.crm.common.enumutil;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.common.pojo.EnumPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索了解方式
 * Created by xinbaojian on 15/7/17.
 */
public enum ClueKnowEnum {
    SEARCH_ENGINE((byte)1, "搜索引擎"),
    WEIBO((byte)2, "微博"),
    WEIXIN((byte)3, "微信"),
    INTERNET_NEWS((byte)4, "网络新闻媒体"),
    BLOG_BBS((byte)5, "博客空间论坛"),
    FRIENDS((byte)6, "朋友介绍"),
    DAYIN_SELLER((byte)7, "达因销售员"),
    VCOOLINE_AGENT((byte)8, "微客来代理商"),
    OTHER_SOURCE((byte)9,"其它"),
    PC((byte)10, "在线注册"),
    ;

    private Byte code;
    private String desc;

    ClueKnowEnum(Byte code, String desc) {
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


    public static ClueKnowEnum getByCode(Byte code){
        for (ClueKnowEnum clue : ClueKnowEnum.values()) {
            if (clue.getCode().equals(code)){
                return clue;
            }
        }
        return null;
    }

    public static String toJson(){
        List<EnumPojo> list = new ArrayList<>();
        EnumPojo pojo = null;
        for (ClueKnowEnum enumpojo : ClueKnowEnum.values()) {
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
        for (ClueKnowEnum enumpojo : ClueKnowEnum.values()) {
            pojo = new EnumPojo();
            pojo.setCode(enumpojo.getCode().toString());
            pojo.setDesc(enumpojo.getDesc());
            list.add(pojo);
        }
        return list;
    }
}
