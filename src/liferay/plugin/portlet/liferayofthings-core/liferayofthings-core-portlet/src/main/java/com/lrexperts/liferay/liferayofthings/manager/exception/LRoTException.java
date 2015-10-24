package com.lrexperts.liferay.liferayofthings.manager.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Diego A. Palmeira
 */
public class LRoTException extends PortalException {

	private static final long serialVersionUID = 804567009022383017L;
	
	public LRoTException() {
		super();
	}

	public LRoTException(String msg) {
		super(msg);
	}

	public LRoTException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LRoTException(Throwable cause) {
		super(cause);
	}

}
