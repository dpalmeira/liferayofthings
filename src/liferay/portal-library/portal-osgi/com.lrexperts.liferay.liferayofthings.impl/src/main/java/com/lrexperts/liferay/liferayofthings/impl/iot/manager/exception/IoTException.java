package com.lrexperts.liferay.liferayofthings.impl.iot.manager.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Diego A. Palmeira
 */
public class IoTException extends PortalException {

	private static final long serialVersionUID = 804567009022383017L;
	
	public IoTException() {
		super();
	}

	public IoTException(String msg) {
		super(msg);
	}

	public IoTException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IoTException(Throwable cause) {
		super(cause);
	}

}
