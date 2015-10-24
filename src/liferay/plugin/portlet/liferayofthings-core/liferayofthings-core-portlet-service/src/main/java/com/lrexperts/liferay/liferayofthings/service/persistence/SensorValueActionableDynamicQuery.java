package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class SensorValueActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SensorValueActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SensorValueLocalServiceUtil.getService());
        setClass(SensorValue.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("sensorValueId");
    }
}
