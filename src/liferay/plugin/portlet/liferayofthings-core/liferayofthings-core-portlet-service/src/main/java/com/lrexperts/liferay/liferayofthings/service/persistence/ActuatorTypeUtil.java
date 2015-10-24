package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.lrexperts.liferay.liferayofthings.model.ActuatorType;

import java.util.List;

/**
 * The persistence utility for the actuator type service. This utility wraps {@link ActuatorTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorTypePersistence
 * @see ActuatorTypePersistenceImpl
 * @generated
 */
public class ActuatorTypeUtil {
    private static ActuatorTypePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ActuatorType actuatorType) {
        getPersistence().clearCache(actuatorType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ActuatorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ActuatorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ActuatorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ActuatorType update(ActuatorType actuatorType)
        throws SystemException {
        return getPersistence().update(actuatorType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ActuatorType update(ActuatorType actuatorType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(actuatorType, serviceContext);
    }

    /**
    * Returns all the actuator types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the actuator types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the actuator types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the actuator types before and after the current actuator type in the ordered set where uuid = &#63;.
    *
    * @param actuatorTypeId the primary key of the current actuator type
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType[] findByUuid_PrevAndNext(
        long actuatorTypeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByUuid_PrevAndNext(actuatorTypeId, uuid,
            orderByComparator);
    }

    /**
    * Removes all the actuator types where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of actuator types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the actuator type where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the actuator type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the actuator type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the actuator type where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the actuator type that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of actuator types where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the actuator types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the actuator types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the actuator types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the actuator types before and after the current actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param actuatorTypeId the primary key of the current actuator type
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType[] findByUuid_C_PrevAndNext(
        long actuatorTypeId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(actuatorTypeId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the actuator types where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of actuator types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the actuator types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the actuator types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the actuator types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the actuator types before and after the current actuator type in the ordered set where companyId = &#63;.
    *
    * @param actuatorTypeId the primary key of the current actuator type
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType[] findByCompanyId_PrevAndNext(
        long actuatorTypeId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(actuatorTypeId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the actuator types where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of actuator types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the actuator types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the actuator types where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the actuator types where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the actuator types before and after the current actuator type in the ordered set where groupId = &#63;.
    *
    * @param actuatorTypeId the primary key of the current actuator type
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType[] findByGroupId_PrevAndNext(
        long actuatorTypeId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(actuatorTypeId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the actuator types where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of actuator types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the actuator types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId);
    }

    /**
    * Returns a range of all the actuator types where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @return the range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the actuator types where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G(companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the actuator types before and after the current actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param actuatorTypeId the primary key of the current actuator type
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType[] findByC_G_PrevAndNext(
        long actuatorTypeId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence()
                   .findByC_G_PrevAndNext(actuatorTypeId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the actuator types where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_G(companyId, groupId);
    }

    /**
    * Returns the number of actuator types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G(companyId, groupId);
    }

    /**
    * Caches the actuator type in the entity cache if it is enabled.
    *
    * @param actuatorType the actuator type
    */
    public static void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType) {
        getPersistence().cacheResult(actuatorType);
    }

    /**
    * Caches the actuator types in the entity cache if it is enabled.
    *
    * @param actuatorTypes the actuator types
    */
    public static void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> actuatorTypes) {
        getPersistence().cacheResult(actuatorTypes);
    }

    /**
    * Creates a new actuator type with the primary key. Does not add the actuator type to the database.
    *
    * @param actuatorTypeId the primary key for the new actuator type
    * @return the new actuator type
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType create(
        long actuatorTypeId) {
        return getPersistence().create(actuatorTypeId);
    }

    /**
    * Removes the actuator type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorTypeId the primary key of the actuator type
    * @return the actuator type that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType remove(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().remove(actuatorTypeId);
    }

    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType updateImpl(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(actuatorType);
    }

    /**
    * Returns the actuator type with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException} if it could not be found.
    *
    * @param actuatorTypeId the primary key of the actuator type
    * @return the actuator type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType findByPrimaryKey(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException {
        return getPersistence().findByPrimaryKey(actuatorTypeId);
    }

    /**
    * Returns the actuator type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param actuatorTypeId the primary key of the actuator type
    * @return the actuator type, or <code>null</code> if a actuator type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.ActuatorType fetchByPrimaryKey(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(actuatorTypeId);
    }

    /**
    * Returns all the actuator types.
    *
    * @return the actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the actuator types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of actuator types
    * @param end the upper bound of the range of actuator types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of actuator types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.ActuatorType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the actuator types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of actuator types.
    *
    * @return the number of actuator types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ActuatorTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ActuatorTypePersistence) PortletBeanLocatorUtil.locate(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.getServletContextName(),
                    ActuatorTypePersistence.class.getName());

            ReferenceRegistry.registerReference(ActuatorTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ActuatorTypePersistence persistence) {
    }
}
