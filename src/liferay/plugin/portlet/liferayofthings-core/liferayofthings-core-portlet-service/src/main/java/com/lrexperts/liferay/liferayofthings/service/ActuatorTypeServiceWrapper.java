package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActuatorTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorTypeService
 * @generated
 */
public class ActuatorTypeServiceWrapper implements ActuatorTypeService,
    ServiceWrapper<ActuatorTypeService> {
    private ActuatorTypeService _actuatorTypeService;

    public ActuatorTypeServiceWrapper(ActuatorTypeService actuatorTypeService) {
        _actuatorTypeService = actuatorTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _actuatorTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _actuatorTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _actuatorTypeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ActuatorTypeService getWrappedActuatorTypeService() {
        return _actuatorTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedActuatorTypeService(
        ActuatorTypeService actuatorTypeService) {
        _actuatorTypeService = actuatorTypeService;
    }

    @Override
    public ActuatorTypeService getWrappedService() {
        return _actuatorTypeService;
    }

    @Override
    public void setWrappedService(ActuatorTypeService actuatorTypeService) {
        _actuatorTypeService = actuatorTypeService;
    }
}
