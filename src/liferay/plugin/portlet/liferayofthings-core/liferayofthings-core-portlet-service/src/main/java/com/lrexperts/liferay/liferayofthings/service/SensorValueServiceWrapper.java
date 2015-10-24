package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SensorValueService}.
 *
 * @author Brian Wing Shun Chan
 * @see SensorValueService
 * @generated
 */
public class SensorValueServiceWrapper implements SensorValueService,
    ServiceWrapper<SensorValueService> {
    private SensorValueService _sensorValueService;

    public SensorValueServiceWrapper(SensorValueService sensorValueService) {
        _sensorValueService = sensorValueService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sensorValueService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sensorValueService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sensorValueService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SensorValueService getWrappedSensorValueService() {
        return _sensorValueService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSensorValueService(
        SensorValueService sensorValueService) {
        _sensorValueService = sensorValueService;
    }

    @Override
    public SensorValueService getWrappedService() {
        return _sensorValueService;
    }

    @Override
    public void setWrappedService(SensorValueService sensorValueService) {
        _sensorValueService = sensorValueService;
    }
}
