package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SensorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SensorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SensorLocalServiceUtil.getService());
        setClass(Sensor.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("sensorId");
    }
}
