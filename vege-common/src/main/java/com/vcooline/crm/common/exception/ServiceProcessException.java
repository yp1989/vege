package com.vcooline.crm.common.exception;

import java.io.Serializable;

/**
 * 功能描述：业务处理异常
 * @author caohuan
 */
public class ServiceProcessException  extends Exception implements Serializable{
  
	private static final long serialVersionUID = 1771211490096170754L;

	public ServiceProcessException() {

		super();
	}

	public ServiceProcessException(String message) {

		super(message);
	}

	public ServiceProcessException(String message, Throwable cause) {

		super(message, cause);
	}

	public ServiceProcessException(Throwable cause) {

		super(cause);
	}

}
