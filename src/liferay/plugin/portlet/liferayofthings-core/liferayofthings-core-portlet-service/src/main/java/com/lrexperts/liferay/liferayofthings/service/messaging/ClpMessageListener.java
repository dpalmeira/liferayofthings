package com.lrexperts.liferay.liferayofthings.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ActuatorServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ActuatorTypeServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ClpSerializer;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorTypeServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorValueServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingGroupServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ActuatorLocalServiceUtil.clearService();

            ActuatorServiceUtil.clearService();
            ActuatorTypeLocalServiceUtil.clearService();

            ActuatorTypeServiceUtil.clearService();
            SensorLocalServiceUtil.clearService();

            SensorServiceUtil.clearService();
            SensorTypeLocalServiceUtil.clearService();

            SensorTypeServiceUtil.clearService();
            SensorValueLocalServiceUtil.clearService();

            SensorValueServiceUtil.clearService();
            ThingLocalServiceUtil.clearService();

            ThingServiceUtil.clearService();
            ThingGroupLocalServiceUtil.clearService();

            ThingGroupServiceUtil.clearService();
        }
    }
}
