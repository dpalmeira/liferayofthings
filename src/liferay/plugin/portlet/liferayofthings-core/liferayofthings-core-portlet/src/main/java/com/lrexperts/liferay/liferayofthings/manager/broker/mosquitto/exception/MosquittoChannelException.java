package com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.exception;

import com.lrexperts.liferay.liferayofthings.manager.exception.LRoTException;

/**
 * @author Diego A. Palmeira
 */
public class MosquittoChannelException extends LRoTException {

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
