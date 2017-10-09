package com.vcooline.crm.common.interceptor;

import com.vcooline.crm.common.model.Page;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;

/**
 * 适用于mysql 的 mybatis分页拦截器
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}))
public class MySQLPageInterceptor extends MybatisPageInterceptor {

    @Override
    protected String getPageSql(Page<?> page, String sql) {
        if (page == null)
            return sql;

        int offset = (page.getPageNo() - 1) * page.getPageSize();
        sql += " limit " + offset + "," + page.getPageSize();
        return sql;
    }

    @Override
    protected String getCountSql(String sql) {
        return " select count(0) from (" + sql + ") as total ";
    }
}
