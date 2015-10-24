package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.lrexperts.liferay.liferayofthings.model.SensorType;

/**
 * The persistence interface for the sensor type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorTypePersistenceImpl
 * @see SensorTypeUtil
 * @generated
 */
public interface SensorTypePersistence extends BasePersistence<SensorType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SensorTypeUtil} to access the sensor type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the sensor types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType[] findByUuid_PrevAndNext(
        long sensorTypeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Removes all the sensor types where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the sensor type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the sensor type where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the sensor type that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the number of sensor types where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sensor types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the first sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the last sensor type in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType[] findByUuid_C_PrevAndNext(
        long sensorTypeId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Removes all the sensor types where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sensor types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType[] findByCompanyId_PrevAndNext(
        long sensorTypeId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Removes all the sensor types where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sensor types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the first sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the last sensor type in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType[] findByGroupId_PrevAndNext(
        long sensorTypeId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Removes all the sensor types where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sensor types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the first sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the last sensor type in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching sensor type, or <code>null</code> if a matching sensor type could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.lrexperts.liferay.liferayofthings.model.SensorType[] findByC_G_PrevAndNext(
        long sensorTypeId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Removes all the sensor types where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the sensor type in the entity cache if it is enabled.
    *
    * @param sensorType the sensor type
    */
    public void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType);

    /**
    * Caches the sensor types in the entity cache if it is enabled.
    *
    * @param sensorTypes the sensor types
    */
    public void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> sensorTypes);

    /**
    * Creates a new sensor type with the primary key. Does not add the sensor type to the database.
    *
    * @param sensorTypeId the primary key for the new sensor type
    * @return the new sensor type
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType create(
        long sensorTypeId);

    /**
    * Removes the sensor type with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType remove(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    public com.lrexperts.liferay.liferayofthings.model.SensorType updateImpl(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the sensor type with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException} if it could not be found.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType findByPrimaryKey(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException;

    /**
    * Returns the sensor type with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param sensorTypeId the primary key of the sensor type
    * @return the sensor type, or <code>null</code> if a sensor type with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.SensorType fetchByPrimaryKey(
        long sensorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the sensor types.
    *
    * @return the sensor types
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.SensorType> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the sensor types from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of sensor types.
    *
    * @return the number of sensor types
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
