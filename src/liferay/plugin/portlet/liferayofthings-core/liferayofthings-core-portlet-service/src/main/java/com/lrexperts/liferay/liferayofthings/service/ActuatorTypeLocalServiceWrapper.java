package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActuatorTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorTypeLocalService
 * @generated
 */
public class ActuatorTypeLocalServiceWrapper implements ActuatorTypeLocalService,
    ServiceWrapper<ActuatorTypeLocalService> {
    private ActuatorTypeLocalService _actuatorTypeLocalService;

    public ActuatorTypeLocalServiceWrapper(
        ActuatorTypeLocalService actuatorTypeLocalService) {
        _actuatorTypeLocalService = actuatorTypeLocalService;
    }

    /**
    * Adds the actuator type to the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorType the actuator type
    * @return the actuator type that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType addActuatorType(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.addActuatorType(actuatorType);
    }

    /**
    * Creates a new actuator type with the primary key. Does not add the actuator type to the database.
    *
    * @param actuatorTypeId the primary key for the new actuator type
    * @return the new actuator type
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType createActuatorType(
        long actuatorTypeId) {
        return _actuatorTypeLocalService.createActuatorType(actuatorTypeId);
    }

    /**
    * Deletes the actuator type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorTypeId the primary key of the actuator type
    * @return the actuator type that was removed
    * @throws PortalException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType deleteActuatorType(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.deleteActuatorType(actuatorTypeId);
    }

    /**
    * Deletes the actuator type from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorType the actuator type
    * @return the actuator type that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType deleteActuatorType(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.deleteActuatorType(actuatorType);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _actuatorTypeLocalService.dynamicQuery();
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
        return _actuatorTypeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _actuatorTypeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _actuatorTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _actuatorTypeLocalService.dynamicQueryCount(dynamicQuery);
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
        return _actuatorTypeLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchActuatorType(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.fetchActuatorType(actuatorTypeId);
    }

    /**
    * Returns the actuator type with the matching UUID and company.
    *
    * @param uuid the actuator type's UUID
    * @param companyId the primary key of the company
    * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchActuatorTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.fetchActuatorTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the actuator type matching the UUID and group.
    *
    * @param uuid the actuator type's UUID
    * @param groupId the primary key of the group
    * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchActuatorTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.fetchActuatorTypeByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the actuator type with the primary key.
    *
    * @param actuatorTypeId the primary key of the actuator type
    * @return the actuator type
    * @throws PortalException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType getActuatorType(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorType(actuatorTypeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the actuator type with the matching UUID and company.
    *
    * @param uuid the actuator type's UUID
    * @param companyId the primary key of the company
    * @return the matching actuator type
    * @throws PortalException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType getActuatorTypeByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorTypeByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the actuator type matching the UUID and group.
    *
    * @param uuid the actuator type's UUID
    * @param groupId the primary key of the group
    * @return the matching actuator type
    * @throws PortalException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType getActuatorTypeByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorTypeByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the actuator types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of actuator types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> getActuatorTypes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorTypes(start, end);
    }

    /**
    * Returns the number of actuator types.
    *
    * @return the number of actuator types
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getActuatorTypesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorTypesCount();
    }

    /**
    * Updates the actuator type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param actuatorType the actuator type
    * @return the actuator type that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType updateActuatorType(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.updateActuatorType(actuatorType);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _actuatorTypeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _actuatorTypeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _actuatorTypeLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * FINDERS
    */
    @Override
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> getActuatorTypes(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorTypeLocalService.getActuatorTypes(companyId, groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ActuatorTypeLocalService getWrappedActuatorTypeLocalService() {
        return _actuatorTypeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedActuatorTypeLocalService(
        ActuatorTypeLocalService actuatorTypeLocalService) {
        _actuatorTypeLocalService = actuatorTypeLocalService;
    }

    @Override
    public ActuatorTypeLocalService getWrappedService() {
        return _actuatorTypeLocalService;
    }

    @Override
    public void setWrappedService(
        ActuatorTypeLocalService actuatorTypeLocalService) {
        _actuatorTypeLocalService = actuatorTypeLocalService;
    }
}
