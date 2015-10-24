package com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util;

/**
 * @author Diego A. Palmeira
 */
public interface MosquittoConstants {

	public static final String BROKER = "tcp://localhost:1883";
	
	public static final String CLIENT_PREFIX = "client_";

	public static final int KEEP_ALIVE_INTERVAL = 30;
	
	public enum QoS {
		QOS_0(0), QOS_1(1), QOS_2(2);
		
		private final int value;
 
		private QoS(int value) {
			this.value = value;
		}
		
	    public int toInt() {
	        return value;
	    }
	}
	
	public enum TopicFields {
		TOPIC_FIELD_GROUPID(0),
		TOPIC_FIELD_THING(1),
		TOPIC_FIELD_TYPE_S_A(2),
		TOPIC_FIELD_ENDPOINT(3);
		
		private final int value;
 
		private TopicFields(int value) {
			this.value = value;
		}
		
	    public int toInt() {
	        return value;
	    }
	}
}
