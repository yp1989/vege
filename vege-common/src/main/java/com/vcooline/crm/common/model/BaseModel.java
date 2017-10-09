package com.vcooline.crm.common.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = 4233954290183742956L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    //删除标识
    private int is_del;

    //创建时间
    private Date create_time;

    //修改时间
    private Date update_time;

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


}
