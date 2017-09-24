package com.vcooline.crm.common.enumutil;

/**
 * 文件类型枚举类
 * Created by xinbaojian on 15/11/11.
 */
public enum FileTypeEnum {
    CONTRACT_FILE((byte)0,"合同文件"),
    ;
    private Byte code;
    private String desc;


    FileTypeEnum(Byte code, String desc) {
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
}
