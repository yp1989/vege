package com.vcooline.crm.common.pojo;

/**
 * Created by xinbaojian on 15/11/11.
 */
public class ResultBean<T> {
    private String msg;
    private Integer code;

    private T object;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public ResultBean<T> success(T t){
        this.object = t;
        this.msg = "success";
        this.code = 1;
        return this;
    }

    public ResultBean<T> error(){
        this.msg = "error";
        this.code = -1;
        return this;
    }
}
