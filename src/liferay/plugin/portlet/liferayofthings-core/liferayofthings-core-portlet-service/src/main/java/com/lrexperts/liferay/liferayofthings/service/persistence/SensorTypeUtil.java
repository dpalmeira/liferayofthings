package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.lrexperts.liferay.liferayofthings.model.SensorType;

import java.util.List;

/**
 * The persistence utility for the sensor type service. This utility wraps {@link SensorTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorTypePersistence
 * @see SensorTypePersistenceImpl
 * @generated
 */
public class SensorTypeUtil {
    private static SensorTypePersistence _persistence;

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
    public static void clearCache(SensorType sensorType) {
        getPersistence().clearCache(sensorType);
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
    public static List<SensorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SensorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SensorType> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static SensorType update(SensorType sensorType)
        throws SystemException {
        return getPersistence().update(sensorType);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static SensorType update(SensorType sensorType,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sensorType, serviceContext);
    }

    /**
    * Returns all the sensor types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the sensor types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the sensor types where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the sensor types before and after the current sensor type in the ordered set where uuid = &#63;.
    *
    * @param sensorTypeId the primary key of the current sensor type
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType[] findByUuid_PrevAndNext(
        long sensorTypeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByUuid_PrevAndNext(sensorTypeId, uuid, orderByComparator);
    }

    /**
    * Removes all the sensor types where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of sensor types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the sensor type where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the sensor type that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of sensor types where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the sensor types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the sensor types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the sensor types where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the sensor types before and after the current sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param sensorTypeId the primary key of the current sensor type
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType[] findByUuid_C_PrevAndNext(
        long sensorTypeId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(sensorTypeId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the sensor types where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of sensor types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the sensor types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the sensor types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the sensor types where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the sensor types before and after the current sensor type in the ordered set where companyId = &#63;.
    *
    * @param sensorTypeId the primary key of the current sensor type
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType[] findByCompanyId_PrevAndNext(
        long sensorTypeId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(sensorTypeId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the sensor types where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of sensor types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the sensor types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the sensor types where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the sensor types where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the sensor types before and after the current sensor type in the ordered set where groupId = &#63;.
    *
    * @param sensorTypeId the primary key of the current sensor type
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType[] findByGroupId_PrevAndNext(
        long sensorTypeId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(sensorTypeId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the sensor types where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of sensor types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the sensor types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId);
    }

    /**
    * Returns a range of all the sensor types where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @return the range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the sensor types where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G(companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the sensor types before and after the current sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param sensorTypeId the primary key of the current sensor type
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType[] findByC_G_PrevAndNext(
        long sensorTypeId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence()
                   .findByC_G_PrevAndNext(sensorTypeId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the sensor types where companyId = &#63; and groupId = &#63; from the database.
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
    * Returns the number of sensor types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G(companyId, groupId);
    }

    /**
    * Caches the sensor type in the entity cache if it is enabled.
    *
    * @param sensorType the sensor type
    */
    public static void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType) {
        getPersistence().cacheResult(sensorType);
    }

    /**
    * Caches the sensor types in the entity cache if it is enabled.
    *
    * @param sensorTypes the sensor types
    */
    public static void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> sensorTypes) {
        getPersistence().cacheResult(sensorTypes);
    }

    /**
    * Creates a new sensor type with the primary key. Does not add the sensor type to the database.
    *
    * @param sensorTypeId the primary key for the new sensor type
    * @return the new sensor type
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType create(
        long sensorTypeId) {
        return getPersistence().create(sensorTypeId);
    }

    /**
    * Removes the sensor type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType remove(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().remove(sensorTypeId);
    }

    public static com.lrexperts.liferay.liferayofthings.model.SensorType updateImpl(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sensorType);
    }

    /**
    * Returns the sensor type with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException} if it could not be found.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType findByPrimaryKey(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException {
        return getPersistence().findByPrimaryKey(sensorTypeId);
    }

    /**
    * Returns the sensor type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type, or <code>null</code> if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.SensorType fetchByPrimaryKey(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(sensorTypeId);
    }

    /**
    * Returns all the sensor types.
    *
    * @return the sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the sensor types.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of sensor types
    * @param end the upper bound of the range of sensor types (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of sensor types
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the sensor types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of sensor types.
    *
    * @return the number of sensor types
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SensorTypePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SensorTypePersistence) PortletBeanLocatorUtil.locate(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.getServletContextName(),
                    SensorTypePersistence.class.getName());

            ReferenceRegistry.registerReference(SensorTypeUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(SensorTypePersistence persistence) {
    }
}
