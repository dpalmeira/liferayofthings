package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActuatorService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorService
 * @generated
 */
public class ActuatorServiceWrapper implements ActuatorService,
    ServiceWrapper<ActuatorService> {
    private ActuatorService _actuatorService;

    public ActuatorServiceWrapper(ActuatorService actuatorService) {
        _actuatorService = actuatorService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _actuatorService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _actuatorService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _actuatorService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ActuatorService getWrappedActuatorService() {
        return _actuatorService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedActuatorService(ActuatorService actuatorService) {
        _actuatorService = actuatorService;
    }

    @Override
    public ActuatorService getWrappedService() {
        return _actuatorService;
    }

    @Override
    public void setWrappedService(ActuatorService actuatorService) {
        _actuatorService = actuatorService;
    }
}
