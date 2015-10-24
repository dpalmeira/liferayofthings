package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ThingService}.
 *
 * @author Brian Wing Shun Chan
 * @see ThingService
 * @generated
 */
public class ThingServiceWrapper implements ThingService,
    ServiceWrapper<ThingService> {
    private ThingService _thingService;

    public ThingServiceWrapper(ThingService thingService) {
        _thingService = thingService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _thingService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _thingService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _thingService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ThingService getWrappedThingService() {
        return _thingService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedThingService(ThingService thingService) {
        _thingService = thingService;
    }

    @Override
    public ThingService getWrappedService() {
        return _thingService;
    }

    @Override
    public void setWrappedService(ThingService thingService) {
        _thingService = thingService;
    }
}
