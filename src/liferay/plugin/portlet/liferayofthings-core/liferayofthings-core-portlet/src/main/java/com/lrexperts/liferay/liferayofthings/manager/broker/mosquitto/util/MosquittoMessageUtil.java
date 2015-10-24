package com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Diego A. Palmeira
 */
public class MosquittoMessageUtil {

	public static String parseTopic(String topic, int topicField) {
		/**
		 * topic format: [groupId]/[thing]/["sensors"|"actuators"]/[sensor endpoint|actuator endpoint]
		 * topic e.g.: 20195/device1/actuators/light
		 */
		String[] data = topic.split(StringPool.SLASH);
		
		if (data != null && data.length == MosquittoConstants.TopicFields.values().length) {
			return data[topicField];
		}
		else {
			return null;
		}
	}

}
