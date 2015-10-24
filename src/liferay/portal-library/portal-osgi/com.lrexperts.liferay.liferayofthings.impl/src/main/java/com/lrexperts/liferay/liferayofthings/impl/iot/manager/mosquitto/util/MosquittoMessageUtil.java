package com.lrexperts.liferay.liferayofthings.impl.iot.manager.mosquitto.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Diego A. Palmeira
 */
public class MosquittoMessageUtil {

	private static Log _log = LogFactoryUtil.getLog(MosquittoMessageUtil.class);

//	public static long parseGroupId(String topic) {
//		/**
//		 * topic format: [groupId]/[thing]/["sensors"|"actuators"]/[sensor|actuator]
//		 * topic e.g.: 20195/device1/actuators/light
//		 */
//		
//		String value = StringUtil.extractFirst(topic, StringPool.SLASH);
//		
//		if (value != null) {
//			return Long.valueOf(value);	
//		}
//		else {
//			return 0L;
//		}
//	}

	public static String parseTopic(String topic, int topicField) {
		/**
		 * topic format: [groupId]/[thing]/["sensors"|"actuators"]/[sensor|actuator]
		 * topic e.g.: 20195/device1/actuators/light
		 */
		String[] data = topic.split(StringPool.SLASH);
		
		if (data != null && data.length == Constants.TopicFields.values().length) {
			return data[topicField];
		}
		else {
			return null;
		}
	}

}
