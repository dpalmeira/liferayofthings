package com.lrexperts.liferay.liferayofthings.manager.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.exception.MosquittoChannelException;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util.MosquittoManagerUtil;
import com.lrexperts.liferay.liferayofthings.manager.exception.LRoTException;

/**
 * @author Diego A. Palmeira
 */
public class LRoTManagerUtil {

	private static Log _log = LogFactoryUtil.getLog(LRoTManagerUtil.class);

	private static LRoTManagerUtil instance;
	
	private LRoTManagerUtil() {
	}

	public static LRoTManagerUtil getInstance() {
		if (instance == null) {
			instance = new LRoTManagerUtil();
		}
		return instance;
	}
	
	public void connect(long companyId) throws LRoTException {
		if (_log.isDebugEnabled()) {
			_log.debug("Creating channel hub " + companyId);
		}

		try {
			MosquittoManagerUtil.createChannels(GetterUtil.getLong(companyId));

		} catch (MosquittoChannelException mce) {
	    	throw new LRoTException(
					"Error creating Mosquitto channels.", mce);
		}
	}

	public void disconnect(long companyId) throws LRoTException {
		if (_log.isDebugEnabled()) {
			_log.debug("Destroying channel hub " + companyId);
		}

		try {
			MosquittoManagerUtil.destroyChannels(companyId);

		} catch (MosquittoChannelException mce) {
	    	throw new LRoTException(
					"Error destroying Mosquitto channels.", mce);
		}
	}

	public void publishMessage(long companyId, String topic,
			String message, int qos) throws LRoTException {
		
		if (_log.isDebugEnabled()) {
			_log.debug("Publishing message at: "
					+ "companyId" + companyId + " | "
					+ "topic" + topic + " | "
					+ "message" + message + " | "
					+ "qos" + qos
				);
		}
		
		try {
			MosquittoManagerUtil.publishMessage(companyId, topic, message, qos);

		} catch (MosquittoChannelException mce) {
	    	throw new LRoTException(
					"Error publishing message on Mosquitto server.", mce);
		}
	}

}
