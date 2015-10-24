package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ThingActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ThingActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ThingLocalServiceUtil.getService());
        setClass(Thing.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("thingId");
    }
}
