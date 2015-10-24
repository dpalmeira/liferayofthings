package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ThingGroup. This utility wraps
 * {@link com.lrexperts.liferay.liferayofthings.service.impl.ThingGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroupLocalService
 * @see com.lrexperts.liferay.liferayofthings.service.base.ThingGroupLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.impl.ThingGroupLocalServiceImpl
 * @generated
 */
public class ThingGroupLocalServiceUtil {
    private static ThingGroupLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.lrexperts.liferay.liferayofthings.service.impl.ThingGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the thing group to the database. Also notifies the appropriate model listeners.
    *
    * @param thingGroup the thing group
    * @return the thing group that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup addThingGroup(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addThingGroup(thingGroup);
    }

    /**
    * Creates a new thing group with the primary key. Does not add the thing group to the database.
    *
    * @param thingGroupId the primary key for the new thing group
    * @return the new thing group
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup createThingGroup(
        long thingGroupId) {
        return getService().createThingGroup(thingGroupId);
    }

    /**
    * Deletes the thing group with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param thingGroupId the primary key of the thing group
    * @return the thing group that was removed
    * @throws PortalException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup deleteThingGroup(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteThingGroup(thingGroupId);
    }

    /**
    * Deletes the thing group from the database. Also notifies the appropriate model listeners.
    *
    * @param thingGroup the thing group
    * @return the thing group that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup deleteThingGroup(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteThingGroup(thingGroup);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchThingGroup(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchThingGroup(thingGroupId);
    }

    /**
    * Returns the thing group with the matching UUID and company.
    *
    * @param uuid the thing group's UUID
    * @param companyId the primary key of the company
    * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchThingGroupByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchThingGroupByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the thing group matching the UUID and group.
    *
    * @param uuid the thing group's UUID
    * @param groupId the primary key of the group
    * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchThingGroupByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchThingGroupByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the thing group with the primary key.
    *
    * @param thingGroupId the primary key of the thing group
    * @return the thing group
    * @throws PortalException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup getThingGroup(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroup(thingGroupId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the thing group with the matching UUID and company.
    *
    * @param uuid the thing group's UUID
    * @param companyId the primary key of the company
    * @return the matching thing group
    * @throws PortalException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup getThingGroupByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroupByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the thing group matching the UUID and group.
    *
    * @param uuid the thing group's UUID
    * @param groupId the primary key of the group
    * @return the matching thing group
    * @throws PortalException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup getThingGroupByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroupByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the thing groups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of thing groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> getThingGroups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroups(start, end);
    }

    /**
    * Returns the number of thing groups.
    *
    * @return the number of thing groups
    * @throws SystemException if a system exception occurred
    */
    public static int getThingGroupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroupsCount();
    }

    /**
    * Updates the thing group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param thingGroup the thing group
    * @return the thing group that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup updateThingGroup(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateThingGroup(thingGroup);
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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> getThingGroups(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getThingGroups(companyId, groupId);
    }

    /**
    * CRUD *
    */
    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup addThingGroup(
        long groupId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        boolean enabled,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addThingGroup(groupId, nameMap, descriptionMap, enabled,
            serviceContext);
    }

    public static com.lrexperts.liferay.liferayofthings.model.ThingGroup updateThingGroup(
        long thingGroupId,
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        boolean enabled,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateThingGroup(thingGroupId, nameMap, descriptionMap,
            enabled, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static ThingGroupLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ThingGroupLocalService.class.getName());

            if (invokableLocalService instanceof ThingGroupLocalService) {
                _service = (ThingGroupLocalService) invokableLocalService;
            } else {
                _service = new ThingGroupLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ThingGroupLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ThingGroupLocalService service) {
    }
}
