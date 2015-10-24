package com.lrexperts.liferay.liferayofthings.impl.iot.manager.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.exception.IoTException;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.exception.MosquittoChannelException;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.util.MosquittoManagerUtil;

/**
 * @author Diego A. Palmeira
 */
public class IoTManagerUtil {

	private static Log _log = LogFactoryUtil.getLog(IoTManagerUtil.class);

	private static IoTManagerUtil instance;
	
	private IoTManagerUtil() {
	}

	public static IoTManagerUtil getInstance() {
		if (instance == null) {
			instance = new IoTManagerUtil();
		}
		return instance;
	}
	
	public void connect(long companyId) throws IoTException {
		if (_log.isDebugEnabled()) {
			_log.debug("Creating channel hub " + companyId);
		}

		try {
			MosquittoManagerUtil.createChannels(GetterUtil.getLong(companyId));

		} catch (MosquittoChannelException mce) {
	    	throw new IoTException(
					"Error creating Mosquitto channels.", mce);
		}
	}

	public void disconnect(long companyId) throws IoTException {
		if (_log.isDebugEnabled()) {
			_log.debug("Destroying channel hub " + companyId);
		}

		try {
			MosquittoManagerUtil.destroyChannels(companyId);

		} catch (MosquittoChannelException mce) {
	    	throw new IoTException(
					"Error destroying Mosquitto channels.", mce);
		}
	}

	public void publishMessage(long companyId, long groupId, String topic,
			String message, int qos) throws IoTException {
		
		if (_log.isDebugEnabled()) {
			_log.debug("Publishing message at: "
					+ "companyId" + companyId + " | "
					+ "groupId" + groupId + " | "
					+ "topic" + topic + " | "
					+ "message" + message + " | "
					+ "qos" + qos
				);
		}
		
		try {
			MosquittoManagerUtil.publishMessage(companyId, groupId, topic, message, qos);

		} catch (MosquittoChannelException mce) {
	    	throw new IoTException(
					"Error publishing message on Mosquitto server.", mce);
		}
	}

}
