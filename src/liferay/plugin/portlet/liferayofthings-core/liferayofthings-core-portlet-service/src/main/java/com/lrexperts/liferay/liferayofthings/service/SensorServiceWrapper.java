package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SensorService}.
 *
 * @author Brian Wing Shun Chan
 * @see SensorService
 * @generated
 */
public class SensorServiceWrapper implements SensorService,
    ServiceWrapper<SensorService> {
    private SensorService _sensorService;

    public SensorServiceWrapper(SensorService sensorService) {
        _sensorService = sensorService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sensorService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sensorService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sensorService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SensorService getWrappedSensorService() {
        return _sensorService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSensorService(SensorService sensorService) {
        _sensorService = sensorService;
    }

    @Override
    public SensorService getWrappedService() {
        return _sensorService;
    }

    @Override
    public void setWrappedService(SensorService sensorService) {
        _sensorService = sensorService;
    }
}
