package com.vcooline.crm.common.enumutil;

/**
 * Created by xinbaojian on 15/9/17.
 */
public enum ClueOwnerTypeEnum {

    USER((byte) 0, "用户"),
    AGENT((byte) 1, "代理商"),;

    private Byte code;
    private String desc;

    ClueOwnerTypeEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ClueOwnerTypeEnum getByCode(Byte code) {
        for (ClueOwnerTypeEnum clue : ClueOwnerTypeEnum.values()) {
            if (clue.getCode().equals(code)) {
                return clue;
            }
        }
        return ClueOwnerTypeEnum.USER;
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
