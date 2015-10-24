package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ThingGroupActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ThingGroupActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ThingGroupLocalServiceUtil.getService());
        setClass(ThingGroup.class);

        setClassLoader(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("thingGroupId");
    }
}
