package com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.exception;

import com.lrexperts.liferay.liferayofthings.impl.iot.manager.exception.IoTException;

/**
 * @author Diego A. Palmeira
 */
public class MosquittoChannelException extends IoTException {

	private static final long serialVersionUID = 590795194649566843L;

	public MosquittoChannelException() {
		super();
	}

	public MosquittoChannelException(String msg) {
		super(msg);
	}

	public MosquittoChannelException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MosquittoChannelException(Throwable cause) {
		super(cause);
	}

}
