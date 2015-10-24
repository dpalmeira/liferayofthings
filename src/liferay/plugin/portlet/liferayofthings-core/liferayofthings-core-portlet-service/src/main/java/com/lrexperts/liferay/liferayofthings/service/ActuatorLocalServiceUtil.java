package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Actuator. This utility wraps
 * {@link com.lrexperts.liferay.liferayofthings.service.impl.ActuatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorLocalService
 * @see com.lrexperts.liferay.liferayofthings.service.base.ActuatorLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.impl.ActuatorLocalServiceImpl
 * @generated
 */
public class ActuatorLocalServiceUtil {
    private static ActuatorLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.lrexperts.liferay.liferayofthings.service.impl.ActuatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the actuator to the database. Also notifies the appropriate model listeners.
    *
    * @param actuator the actuator
    * @return the actuator that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator addActuator(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addActuator(actuator);
    }

    /**
    * Creates a new actuator with the primary key. Does not add the actuator to the database.
    *
    * @param actuatorId the primary key for the new actuator
    * @return the new actuator
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator createActuator(
        long actuatorId) {
        return getService().createActuator(actuatorId);
    }

    /**
    * Deletes the actuator with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator that was removed
    * @throws PortalException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator deleteActuator(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteActuator(actuatorId);
    }

    /**
    * Deletes the actuator from the database. Also notifies the appropriate model listeners.
    *
    * @param actuator the actuator
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator deleteActuator(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteActuator(actuator);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchActuator(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchActuator(actuatorId);
    }

    /**
    * Returns the actuator with the matching UUID and company.
    *
    * @param uuid the actuator's UUID
    * @param companyId the primary key of the company
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchActuatorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchActuatorByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the actuator matching the UUID and group.
    *
    * @param uuid the actuator's UUID
    * @param groupId the primary key of the group
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchActuatorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchActuatorByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the actuator with the primary key.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator
    * @throws PortalException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator getActuator(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuator(actuatorId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the actuator with the matching UUID and company.
    *
    * @param uuid the actuator's UUID
    * @param companyId the primary key of the company
    * @return the matching actuator
    * @throws PortalException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator getActuatorByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuatorByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the actuator matching the UUID and group.
    *
    * @param uuid the actuator's UUID
    * @param groupId the primary key of the group
    * @return the matching actuator
    * @throws PortalException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator getActuatorByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuatorByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the actuators.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> getActuators(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuators(start, end);
    }

    /**
    * Returns the number of actuators.
    *
    * @return the number of actuators
    * @throws SystemException if a system exception occurred
    */
    public static int getActuatorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuatorsCount();
    }

    /**
    * Updates the actuator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param actuator the actuator
    * @return the actuator that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator updateActuator(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateActuator(actuator);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * FINDERS
    */
    public static int getActuatorsCount(long thingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuatorsCount(thingId);
    }

    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> getActuators(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuators(thingId);
    }

    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> getActuators(
        long thingId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuators(thingId, start, end);
    }

    public static com.lrexperts.liferay.liferayofthings.model.Actuator getActuatorByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getActuatorByEndpoint(endpoint);
    }

    /**
    * CRUD *
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator addActuator(
        long thingId, long actuatorTypeId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.lang.String endpoint, boolean enabled, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addActuator(thingId, actuatorTypeId, nameMap,
            descriptionMap, endpoint, enabled, status, serviceContext);
    }

    public static com.lrexperts.liferay.liferayofthings.model.Actuator updateActuator(
        long actuatorId, long actuatorTypeId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.lang.String endpoint, boolean enabled, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateActuator(actuatorId, actuatorTypeId, nameMap,
            descriptionMap, endpoint, enabled, status, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static ActuatorLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ActuatorLocalService.class.getName());

            if (invokableLocalService instanceof ActuatorLocalService) {
                _service = (ActuatorLocalService) invokableLocalService;
            } else {
                _service = new ActuatorLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ActuatorLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ActuatorLocalService service) {
    }
}
