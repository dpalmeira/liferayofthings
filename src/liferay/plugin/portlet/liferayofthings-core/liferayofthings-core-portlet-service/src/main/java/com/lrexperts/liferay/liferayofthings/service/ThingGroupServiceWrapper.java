package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ThingGroupService}.
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroupService
 * @generated
 */
public class ThingGroupServiceWrapper implements ThingGroupService,
    ServiceWrapper<ThingGroupService> {
    private ThingGroupService _thingGroupService;

    public ThingGroupServiceWrapper(ThingGroupService thingGroupService) {
        _thingGroupService = thingGroupService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _thingGroupService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _thingGroupService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _thingGroupService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ThingGroupService getWrappedThingGroupService() {
        return _thingGroupService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedThingGroupService(ThingGroupService thingGroupService) {
        _thingGroupService = thingGroupService;
    }

    @Override
    public ThingGroupService getWrappedService() {
        return _thingGroupService;
    }

    @Override
    public void setWrappedService(ThingGroupService thingGroupService) {
        _thingGroupService = thingGroupService;
    }
}
