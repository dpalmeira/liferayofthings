package com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.client.CustomMqttClient;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.exception.MosquittoChannelException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author Diego A. Palmeira
 */
public class MosquittoManagerUtil {

	private static Log _log = LogFactoryUtil.getLog(MosquittoManagerUtil.class);

	private static List<CustomMqttClient> customMqttClientList = new ArrayList<CustomMqttClient>();
    
	public static List<CustomMqttClient> getCustomMqttClientList() {
		return customMqttClientList;
	}

	public static void createChannels(long companyId) throws MosquittoChannelException {
		_log.info("Creating Mosquitto channels for companyId: " + companyId);

		try {
			CustomMqttClient customMqttClient = new CustomMqttClient(companyId);
			customMqttClient.connect();

			List<Group> groups = GroupLocalServiceUtil.getGroups(
					companyId, GroupConstants.ANY_PARENT_GROUP_ID, Boolean.TRUE);

			for (Group group : groups) {
				// TODO: Do this only for sites with "IoT enabled".
				customMqttClient.subscribeDevices(group.getGroupId());
				customMqttClientList.add(customMqttClient);
			}
			
		} catch (SystemException se) {
			_log.error("Error retrieving groups for companyId: " + companyId);
			throw new MosquittoChannelException(se);
		}
	}

	public static void destroyChannels(long companyId) throws MosquittoChannelException {
		_log.info("Destroying Mosquitto channels for companyId: " + companyId);

		try {
			for (CustomMqttClient customMqttClient : customMqttClientList) {
				try {
					// Unsubscribe devices
					List<Group> groups = GroupLocalServiceUtil.getGroups(
							companyId, GroupConstants.ANY_PARENT_GROUP_ID, Boolean.TRUE);
	
					for (Group group : groups) {
						customMqttClient.unsubscribeDevices(group.getGroupId());
					}
				} catch (SystemException se) {
					_log.error("Error retrieving groups for companyId: " + companyId);
				}				

				customMqttClient.getMqttClient().disconnect();
			}
			_log.info("Disconnected for companyId: " + companyId);

		} catch (MqttException me) {
			_log.error("Error destroying Mosquitto channels. "
					+ "Reason: " + me.getReasonCode() + " | "
					+ "Msg: " + me.getMessage() + " | "
					+ "Loc: " + me.getLocalizedMessage() + " | "
					+ "Cause: " + me.getCause()
			);
			throw new MosquittoChannelException(me);
		}
	}

	public static void publishMessage(long companyId, String topic, String message, int qos) throws MosquittoChannelException {
		
		CustomMqttClient customMqttClient = null;
		
		for (CustomMqttClient cmc : MosquittoManagerUtil.getCustomMqttClientList()) {
			if (cmc.getCompanyId().equals(companyId)) {
				customMqttClient = cmc;
				break;
			}
		}
		
		if (Validator.isNull(customMqttClient)) {
			throw new MosquittoChannelException(
					"Error publishing message to Mosquitto server. "
							+ "companyId: " + customMqttClient.getCompanyId() + " | "
							+ "topic: " + topic + " | "
							+ "Message: " + message + " | "
							+ "QoS: " + qos
					);
		}
		
		publishMessage(customMqttClient, topic, message, qos);
	}
	
	public static void publishMessage(CustomMqttClient customMqttClient, String topic, String message, int qos) throws MosquittoChannelException {

		if (_log.isDebugEnabled()) {
			_log.debug("Publishing companyId: " + customMqttClient.getCompanyId() + " | "
					+ "topic: " + topic + " | "
					+ "Message: " + message + " | "
					+ "QoS: " + qos
			);
		}

		try {
			if (Validator.isNotNull(customMqttClient.getMqttClient()) && customMqttClient.getMqttClient().isConnected()) {
				MqttMessage mqttMessage = new MqttMessage(message.getBytes());
				mqttMessage.setQos(qos);
				customMqttClient.getMqttClient().publish(topic, mqttMessage);
			} else {
				throw new MosquittoChannelException("Error publishing message. MqttClient is not connected!");
			}
			
		} catch (MqttException me) {
			_log.error("Error publishing message to Mosquitto server. "
					+ "Reason: " + me.getReasonCode() + " | "
					+ "Msg: " + me.getMessage() + " | "
					+ "Loc: " + me.getLocalizedMessage() + " | "
					+ "Cause: " + me.getCause()
			);
			throw new MosquittoChannelException(me);
		}
	}

}
