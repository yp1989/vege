package com.vcooline.crm.common.serializer;

public enum LongSerializer {
    INSTANCE;

    public byte[] serialize(Long aLong) {
        if (null != aLong) {
            return aLong.toString().getBytes();
        } else {
            return new byte[0];
        }
    }

    public Long deserialize(byte[] bytes) {
        if (bytes.length > 0) {
            return Long.parseLong(new String(bytes));
        } else {
            return null;
        }
    }
}