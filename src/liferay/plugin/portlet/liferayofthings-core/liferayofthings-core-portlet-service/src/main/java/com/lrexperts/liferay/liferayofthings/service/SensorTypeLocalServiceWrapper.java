package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SensorTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SensorTypeLocalService
 * @generated
 */
public class SensorTypeLocalServiceWrapper implements SensorTypeLocalService,
    ServiceWrapper<SensorTypeLocalService> {
    private SensorTypeLocalService _sensorTypeLocalService;

    public SensorTypeLocalServiceWrapper(
        SensorTypeLocalService sensorTypeLocalService) {
        _sensorTypeLocalService = sensorTypeLocalService;
    }

    /**
    * Adds the sensor type to the database. Also notifies the appropriate model listeners.
    *
    * @param sensorType the sensor type
    * @return the sensor type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType addSensorType(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.addSensorType(sensorType);
    }

    /**
    * Creates a new sensor type with the primary key. Does not add the sensor type to the database.
    *
    * @param sensorTypeId the primary key for the new sensor type
    * @return the new sensor type
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType createSensorType(
        long sensorTypeId) {
        return _sensorTypeLocalService.createSensorType(sensorTypeId);
    }

    /**
    * Deletes the sensor type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type that was removed
    * @throws PortalException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType deleteSensorType(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.deleteSensorType(sensorTypeId);
    }

    /**
    * Deletes the sensor type from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorType the sensor type
    * @return the sensor type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType deleteSensorType(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.deleteSensorType(sensorType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sensorTypeLocalService.dynamicQuery();
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
        return _sensorTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sensorTypeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _sensorTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _sensorTypeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _sensorTypeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchSensorType(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.fetchSensorType(sensorTypeId);
    }

    /**
    * Returns the sensor type with the matching UUID and company.
    *
    * @param uuid the sensor type's UUID
    * @param companyId the primary key of the company
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchSensorTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.fetchSensorTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the sensor type matching the UUID and group.
    *
    * @param uuid the sensor type's UUID
    * @param groupId the primary key of the group
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchSensorTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.fetchSensorTypeByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the sensor type with the primary key.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type
    * @throws PortalException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType getSensorType(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorType(sensorTypeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the sensor type with the matching UUID and company.
    *
    * @param uuid the sensor type's UUID
    * @param companyId the primary key of the company
    * @return the matching sensor type
    * @throws PortalException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType getSensorTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the sensor type matching the UUID and group.
    *
    * @param uuid the sensor type's UUID
    * @param groupId the primary key of the group
    * @return the matching sensor type
    * @throws PortalException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType getSensorTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorTypeByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the sensor types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of sensor types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> getSensorTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorTypes(start, end);
    }

    /**
    * Returns the number of sensor types.
    *
    * @return the number of sensor types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getSensorTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorTypesCount();
    }

    /**
    * Updates the sensor type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sensorType the sensor type
    * @return the sensor type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType updateSensorType(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.updateSensorType(sensorType);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _sensorTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sensorTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sensorTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * FINDERS
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> getSensorTypes(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorTypeLocalService.getSensorTypes(companyId, groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public SensorTypeLocalService getWrappedSensorTypeLocalService() {
        return _sensorTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedSensorTypeLocalService(
        SensorTypeLocalService sensorTypeLocalService) {
        _sensorTypeLocalService = sensorTypeLocalService;
    }

    @Override
    public SensorTypeLocalService getWrappedService() {
        return _sensorTypeLocalService;
    }

    @Override
    public void setWrappedService(SensorTypeLocalService sensorTypeLocalService) {
        _sensorTypeLocalService = sensorTypeLocalService;
    }
}
