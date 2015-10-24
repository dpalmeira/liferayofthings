package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ActuatorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ActuatorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ActuatorLocalServiceUtil.getService());
        setClass(Actuator.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("actuatorId");
    }
}
