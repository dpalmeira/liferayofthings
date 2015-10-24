package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.SensorType;
import com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SensorTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SensorTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SensorTypeLocalServiceUtil.getService());
        setClass(SensorType.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("sensorTypeId");
    }
}
