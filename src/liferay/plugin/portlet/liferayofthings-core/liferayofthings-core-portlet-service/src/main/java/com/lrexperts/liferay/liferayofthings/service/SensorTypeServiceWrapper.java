package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SensorTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see SensorTypeService
 * @generated
 */
public class SensorTypeServiceWrapper implements SensorTypeService,
    ServiceWrapper<SensorTypeService> {
    private SensorTypeService _sensorTypeService;

    public SensorTypeServiceWrapper(SensorTypeService sensorTypeService) {
        _sensorTypeService = sensorTypeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sensorTypeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sensorTypeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sensorTypeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SensorTypeService getWrappedSensorTypeService() {
        return _sensorTypeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSensorTypeService(SensorTypeService sensorTypeService) {
        _sensorTypeService = sensorTypeService;
    }

    @Override
    public SensorTypeService getWrappedService() {
        return _sensorTypeService;
    }

    @Override
    public void setWrappedService(SensorTypeService sensorTypeService) {
        _sensorTypeService = sensorTypeService;
    }
}
