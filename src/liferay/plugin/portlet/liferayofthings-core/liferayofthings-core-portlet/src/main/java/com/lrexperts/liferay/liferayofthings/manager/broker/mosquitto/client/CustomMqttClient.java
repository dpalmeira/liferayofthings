package com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.client;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.exception.MosquittoChannelException;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util.MosquittoConstants;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util.MosquittoMessageUtil;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.portlet.fitbit.util.FitbitSyncUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author Diego A. Palmeira
 */
public class CustomMqttClient implements MqttCallback {

	public Long getCompanyId() {
		return _companyId;
	}
	
	public MqttClient getMqttClient() {
		return _mqttClient;
	}

	public CustomMqttClient(Long companyId) {
		_companyId = companyId;
	}
	
	public void connect() throws MosquittoChannelException {

		try {
			String clientId = MosquittoConstants.CLIENT_PREFIX + _companyId;
		    MemoryPersistence persistence = new MemoryPersistence();
	
	        _mqttClient = new MqttClient(MosquittoConstants.BROKER, clientId, persistence);
	        _mqttClient.setCallback(this);
	        
	        MqttConnectOptions connOpts = new MqttConnectOptions();
	        connOpts.setCleanSession(true);
			connOpts.setKeepAliveInterval(MosquittoConstants.KEEP_ALIVE_INTERVAL);
			
			// TODO: Set authentication
			//	connOpts.setUserName(M2MIO_USERNAME);
			//	connOpts.setPassword(M2MIO_PASSWORD_MD5.toCharArray());	        
			_log.info("Connecting to broker: " + MosquittoConstants.BROKER);
			_mqttClient.connect(connOpts);
			_log.info("Connected for companyId: " + _companyId);

		} catch (MqttException me) {
			_log.error("Error connecting to Mosquitto Server. "
					+ "Broker: " + MosquittoConstants.BROKER + " | "
					+ "companyId: " + _companyId + " | "
					+ "Reason: " + me.getReasonCode() + " | "
					+ "Msg: " + me.getMessage() + " | "
					+ "Loc: " + me.getLocalizedMessage() + " | "
					+ "Cause: " + me.getCause()
			);
			throw new MosquittoChannelException(me);
		}			
	}

	public void subscribeDevices(long groupId) {
		_log.info("Subscribe devices for groupId: " + groupId);

		try {
			List<Thing> thingList = ThingLocalServiceUtil.getThingsByGroupId(groupId);
			_log.info("Devices count: " + thingList.size());
			
			
			for (Thing thing : thingList) {
				_log.info("Subscribing device: " + thing.getEndpoint());

				/** Sensors **/
				StringBuffer topic = new StringBuffer();
				topic.append(String.valueOf(groupId));
				topic.append(StringPool.SLASH);
				topic.append(thing.getEndpoint());
				topic.append(StringPool.SLASH);
				topic.append("sensors");
				topic.append(StringPool.SLASH);
				topic.append("#");
				
				_subscribe(topic.toString(), MosquittoConstants.QoS.QOS_0.toInt());
				
				/** Actuators **/
				topic = new StringBuffer();
				topic.append(String.valueOf(groupId));
				topic.append(StringPool.SLASH);
				topic.append(thing.getEndpoint());
				topic.append(StringPool.SLASH);
				topic.append("actuators");
				topic.append(StringPool.SLASH);
				topic.append("#");
				
				_subscribe(topic.toString(), MosquittoConstants.QoS.QOS_0.toInt());
			}
        
		} catch (MosquittoChannelException | SystemException e) {
			_log.error("Error subscribing devices for groupId: " + groupId, e);
		}			
	}
	
	public void unsubscribeDevices(long groupId) {
		_log.info("Unsubscribe devices for groupId: " + groupId);

		try {
			List<Thing> thingList = ThingLocalServiceUtil.getThings(groupId);
			
			StringBuffer topic = new StringBuffer();
			topic.append(String.valueOf(groupId));
			topic.append(StringPool.SLASH);

			for (Thing thing : thingList) {
				topic.append(thing.getEndpoint());
				topic.append(StringPool.SLASH);
				topic.append("sensors");
				topic.append(StringPool.SLASH);
				topic.append("#");

				_unsubscribe(topic.toString());
			}
        
		} catch (MosquittoChannelException | SystemException e) {
			_log.error("Error unsubscribing devices for groupId: " + groupId, e);
		}			
	}

	@Override
	public void connectionLost(Throwable arg0) {
		_log.error("Connection lost.", arg0);
		// TODO Auto-generated method stub
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		_log.info("Delivery complete! | " + arg0);
		// TODO Auto-generated method stub
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

		_log.info("Message arrived! | " + topic + " | " + message);

		String groupIdAux = MosquittoMessageUtil.parseTopic(topic,
				MosquittoConstants.TopicFields.TOPIC_FIELD_GROUPID.toInt());

		String type = MosquittoMessageUtil.parseTopic(topic,
				MosquittoConstants.TopicFields.TOPIC_FIELD_TYPE_S_A.toInt());

		String endpoint = MosquittoMessageUtil.parseTopic(topic,
				MosquittoConstants.TopicFields.TOPIC_FIELD_ENDPOINT.toInt());

		if (groupIdAux == null || endpoint == null || type == null) {
			_log.info("Cannot parse received message! | " + topic + " | " + message);
			return;
		}
		
		long groupId = GetterUtil.getLong(groupIdAux, 0);

		if (type.equals("sensors")) {

			Sensor sensor = SensorLocalServiceUtil.getSensorByEndpoint(getCompanyId().longValue(), groupId, endpoint, Boolean.TRUE);

			if (_log.isDebugEnabled()) {
				_log.debug("Sensor found ? " + (sensor!=null));
				_log.debug("groupId: " + groupId);
				_log.debug("endpoint: " + endpoint);
			}
			
			if (sensor!=null) {
				long sensorValueId = CounterLocalServiceUtil.increment(SensorValue.class.getName());
				
				SensorValue sensorValue = SensorValueLocalServiceUtil.createSensorValue(sensorValueId);
				
				sensorValue.setSensorId(sensor.getSensorId());
				sensorValue.setValue(message.toString());
				sensorValue.setCreateDate(new Date());

				SensorValueLocalServiceUtil.addSensorValue(sensorValue);
			}
			else {
				_log.error("Sensor NOT found, or disabled! | " + topic + " | " + message);
			}
		}
		else if (type.equals("actuators")) {

			if (message.toString().contains("fitbit-alarm")) {
				FitbitSyncUtil.sendAlarm(groupId, message.toString());
			}
		}
	}

	private void _subscribe(String topic, int qos) throws MosquittoChannelException {

		try {
			_log.info("Subscribe topic: " + topic + " | with QoS: " + qos);
			_mqttClient.subscribe(topic, qos);
			
		} catch (MqttException me) {
			_log.error("Error subscribing. "
					+ "Topic: " + topic + " | "
					+ "QoS: " + qos + " | "
					+ "Reason: " + me.getReasonCode() + " | "
					+ "Msg: " + me.getMessage() + " | "
					+ "Loc: " + me.getLocalizedMessage() + " | "
					+ "Cause: " + me.getCause()
			);
			throw new MosquittoChannelException(me);
		}			
	}

	private void _unsubscribe(String topic) throws MosquittoChannelException {
		try {
			_log.info("Unsubscribe topic: " + topic);
			_mqttClient.unsubscribe(topic);
			
		} catch (MqttException me) {
			_log.error("Error unsubscribing. "
					+ "Topic: " + topic + " | "
					+ "Reason: " + me.getReasonCode() + " | "
					+ "Msg: " + me.getMessage() + " | "
					+ "Loc: " + me.getLocalizedMessage() + " | "
					+ "Cause: " + me.getCause()
			);
			throw new MosquittoChannelException(me);
		}			
	}

	private static Log _log = LogFactoryUtil.getLog(CustomMqttClient.class);
	private Long _companyId;
	private MqttClient _mqttClient;
}
