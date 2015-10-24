package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.ActuatorType;
import com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ActuatorTypeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ActuatorTypeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ActuatorTypeLocalServiceUtil.getService());
        setClass(ActuatorType.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("actuatorTypeId");
    }
}
