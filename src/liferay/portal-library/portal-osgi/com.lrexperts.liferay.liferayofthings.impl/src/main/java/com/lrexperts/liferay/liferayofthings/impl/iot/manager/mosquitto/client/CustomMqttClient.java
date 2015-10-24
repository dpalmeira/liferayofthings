package com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.client;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.exception.MosquittoChannelException;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.util.Constants;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.util.MosquittoMessageUtil;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.model.Thing;
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
//import org.osgi.service.component.annotations.Reference;
//import org.osgi.service.component.annotations.ReferenceCardinality;
//import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Diego A. Palmeira
 */
public class CustomMqttClient implements MqttCallback {

	private static Log _log = LogFactoryUtil.getLog(CustomMqttClient.class);
//	private SensorValueLocalServiceUtil sensorValueLocalServiceUtil;
	private Long companyId;
	private MqttClient mqttClient;

	/**
    @Reference(
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.STATIC,
            unbind = "removeSensorValueLocalServiceUtil"
    )
	public void addSensorValueLocalServiceUtil(SensorValueLocalServiceUtil sensorValueLocalServiceUtil) {
		this.sensorValueLocalServiceUtil = sensorValueLocalServiceUtil;
	}

	public void removeSensorValueLocalServiceUtil(SensorValueLocalServiceUtil sensorValueLocalServiceUtil) {
		this.sensorValueLocalServiceUtil = null;
	}
**/
	public Long getCompanyId() {
		return companyId;
	}
	
	public MqttClient getMqttClient() {
		return mqttClient;
	}

	public CustomMqttClient(Long companyId) {
		this.companyId = companyId;
	}
	
	public void connect() throws MosquittoChannelException {

		try {
			String clientId = Constants.CLIENT_PREFIX + this.companyId;
		    MemoryPersistence persistence = new MemoryPersistence();
	
	        this.mqttClient = new MqttClient(Constants.BROKER, clientId, persistence);
	        this.mqttClient.setCallback(this);
	        
	        MqttConnectOptions connOpts = new MqttConnectOptions();
	        connOpts.setCleanSession(true);
			connOpts.setKeepAliveInterval(Constants.KEEP_ALIVE_INTERVAL);
			
			// TODO: Set authentication
			//	connOpts.setUserName(M2MIO_USERNAME);
			//	connOpts.setPassword(M2MIO_PASSWORD_MD5.toCharArray());	        
			_log.info("Connecting to broker: " + Constants.BROKER);
			mqttClient.connect(connOpts);
			_log.info("Connected for companyId: " + this.companyId);

		} catch (MqttException me) {
			_log.error("Error connecting to Mosquitto Server. "
					+ "Broker: " + Constants.BROKER + " | "
					+ "companyId: " + this.companyId + " | "
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
			
			StringBuffer topic = new StringBuffer();
			topic.append(String.valueOf(groupId));
			topic.append(StringPool.SLASH);
			
			for (Thing thing : thingList) {
				_log.info("Subscribing device: " + thing.getEndpoint());
				topic.append(thing.getEndpoint());
				topic.append(StringPool.SLASH);
				topic.append("sensors");
				topic.append(StringPool.SLASH);
				topic.append("#");
				
				subscribe(topic.toString(), Constants.QoS.QOS_0.toInt());
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

				unsubscribe(topic.toString());
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
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		_log.info("Message arrived! | " + arg0 + " | " + arg1);

		String groupIdAux = MosquittoMessageUtil.parseTopic(arg0,
				Constants.TopicFields.TOPIC_FIELD_GROUPID.toInt());
		
		String endpoint = MosquittoMessageUtil.parseTopic(arg0,
				Constants.TopicFields.TOPIC_FIELD_ENDPOINT.toInt());

		if (groupIdAux == null || endpoint == null) {
			_log.info("Cannot parse received message! | " + arg0 + " | " + arg1);
			return;
		}
		
		long groupId = GetterUtil.getLong(groupIdAux, 0);
		
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
			sensorValue.setValue(arg1.toString());
			sensorValue.setCreateDate(new Date());

			SensorValueLocalServiceUtil.addSensorValue(sensorValue);
		}
		else {
			_log.error("Sensor NOT found, or disabled! | " + arg0 + " | " + arg1);
		}
	}

	private void subscribe(String topic, int qos) throws MosquittoChannelException {
		try {
			_log.info("Subscribe topic: " + topic + " | with QoS: " + qos);
			this.mqttClient.subscribe(topic, qos);
			
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

	private void unsubscribe(String topic) throws MosquittoChannelException {
		try {
			_log.info("Unsubscribe topic: " + topic);
			this.mqttClient.unsubscribe(topic);
			
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

}
