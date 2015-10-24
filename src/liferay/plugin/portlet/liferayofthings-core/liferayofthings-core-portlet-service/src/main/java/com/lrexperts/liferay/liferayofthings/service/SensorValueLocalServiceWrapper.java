package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SensorValueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SensorValueLocalService
 * @generated
 */
public class SensorValueLocalServiceWrapper implements SensorValueLocalService,
    ServiceWrapper<SensorValueLocalService> {
    private SensorValueLocalService _sensorValueLocalService;

    public SensorValueLocalServiceWrapper(
        SensorValueLocalService sensorValueLocalService) {
        _sensorValueLocalService = sensorValueLocalService;
    }

    /**
    * Adds the sensor value to the database. Also notifies the appropriate model listeners.
    *
    * @param sensorValue the sensor value
    * @return the sensor value that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue addSensorValue(
        com.lrexperts.liferay.liferayofthings.model.SensorValue sensorValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.addSensorValue(sensorValue);
    }

    /**
    * Creates a new sensor value with the primary key. Does not add the sensor value to the database.
    *
    * @param sensorValueId the primary key for the new sensor value
    * @return the new sensor value
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue createSensorValue(
        long sensorValueId) {
        return _sensorValueLocalService.createSensorValue(sensorValueId);
    }

    /**
    * Deletes the sensor value with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorValueId the primary key of the sensor value
    * @return the sensor value that was removed
    * @throws PortalException if a sensor value with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue deleteSensorValue(
        long sensorValueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.deleteSensorValue(sensorValueId);
    }

    /**
    * Deletes the sensor value from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorValue the sensor value
    * @return the sensor value that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue deleteSensorValue(
        com.lrexperts.liferay.liferayofthings.model.SensorValue sensorValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.deleteSensorValue(sensorValue);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sensorValueLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue fetchSensorValue(
        long sensorValueId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.fetchSensorValue(sensorValueId);
    }

    /**
    * Returns the sensor value with the matching UUID and company.
    *
    * @param uuid the sensor value's UUID
    * @param companyId the primary key of the company
    * @return the matching sensor value, or <code>null</code> if a matching sensor value could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue fetchSensorValueByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.fetchSensorValueByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the sensor value matching the UUID and group.
    *
    * @param uuid the sensor value's UUID
    * @param groupId the primary key of the group
    * @return the matching sensor value, or <code>null</code> if a matching sensor value could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue fetchSensorValueByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.fetchSensorValueByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the sensor value with the primary key.
    *
    * @param sensorValueId the primary key of the sensor value
    * @return the sensor value
    * @throws PortalException if a sensor value with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue getSensorValue(
        long sensorValueId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValue(sensorValueId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the sensor value with the matching UUID and company.
    *
    * @param uuid the sensor value's UUID
    * @param companyId the primary key of the company
    * @return the matching sensor value
    * @throws PortalException if a matching sensor value could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue getSensorValueByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValueByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the sensor value matching the UUID and group.
    *
    * @param uuid the sensor value's UUID
    * @param groupId the primary key of the group
    * @return the matching sensor value
    * @throws PortalException if a matching sensor value could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue getSensorValueByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValueByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the sensor values.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sensor values
    * @param end the upper bound of the range of sensor values (not inclusive)
    * @return the range of sensor values
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorValue> getSensorValues(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValues(start, end);
    }

    /**
    * Returns the number of sensor values.
    *
    * @return the number of sensor values
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSensorValuesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValuesCount();
    }

    /**
    * Updates the sensor value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sensorValue the sensor value
    * @return the sensor value that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue updateSensorValue(
        com.lrexperts.liferay.liferayofthings.model.SensorValue sensorValue)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.updateSensorValue(sensorValue);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sensorValueLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sensorValueLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sensorValueLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * FINDERS
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorValue> getSensorValues(
        long sensorId, java.util.Date dateFrom, java.util.Date dateTo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getSensorValues(sensorId, dateFrom,
            dateTo);
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue getLastSensorValue(
        long sensorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorValueLocalService.getLastSensorValue(sensorId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SensorValueLocalService getWrappedSensorValueLocalService() {
        return _sensorValueLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSensorValueLocalService(
        SensorValueLocalService sensorValueLocalService) {
        _sensorValueLocalService = sensorValueLocalService;
    }

    @Override
    public SensorValueLocalService getWrappedService() {
        return _sensorValueLocalService;
    }

    @Override
    public void setWrappedService(
        SensorValueLocalService sensorValueLocalService) {
        _sensorValueLocalService = sensorValueLocalService;
    }
}
