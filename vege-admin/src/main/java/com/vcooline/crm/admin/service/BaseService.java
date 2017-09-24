package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.constant.GlobalConstants;
import com.vcooline.crm.common.model.CrmAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseService {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		return request;
	}

	protected HttpSession getSession() {
		HttpServletRequest request = getRequest();

		return request.getSession();
	}

	/**
	 * 得到用户
	 * @return
	 */
	protected CrmAdmin getUser(){
		CrmAdmin admin = (CrmAdmin)getRequest().getSession().getAttribute(GlobalConstants.USER);
		return admin;
	}

}
