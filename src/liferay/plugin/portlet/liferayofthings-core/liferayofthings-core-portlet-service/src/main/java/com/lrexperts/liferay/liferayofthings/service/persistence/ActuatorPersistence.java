package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.lrexperts.liferay.liferayofthings.model.Actuator;

/**
 * The persistence interface for the actuator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorPersistenceImpl
 * @see ActuatorUtil
 * @generated
 */
public interface ActuatorPersistence extends BasePersistence<Actuator> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ActuatorUtil} to access the actuator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the actuators where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where uuid = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByUuid_PrevAndNext(
        long actuatorId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the actuator where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the number of actuators where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByUuid_C_PrevAndNext(
        long actuatorId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByCompanyId_PrevAndNext(
        long actuatorId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where groupId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByGroupId_PrevAndNext(
        long actuatorId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByC_G_PrevAndNext(
        long actuatorId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByC_G_S_PrevAndNext(
        long actuatorId, long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where thingId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param thingId the thing ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where thingId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param thingId the thing ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByThingId_First(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByThingId_First(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByThingId_Last(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByThingId_Last(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where thingId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByThingId_PrevAndNext(
        long actuatorId, long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where thingId = &#63; from the database.
    *
    * @param thingId the thing ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByThingId(long thingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByThingId(long thingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the actuators where actuatorTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param actuatorTypeId the actuator type ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @return the range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators where actuatorTypeId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param actuatorTypeId the actuator type ID
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByActuatorTypeId_First(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByActuatorTypeId_First(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByActuatorTypeId_Last(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByActuatorTypeId_Last(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuators before and after the current actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorId the primary key of the current actuator
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator[] findByActuatorTypeId_PrevAndNext(
        long actuatorId, long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Removes all the actuators where actuatorTypeId = &#63; from the database.
    *
    * @param actuatorTypeId the actuator type ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByActuatorTypeId(long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByActuatorTypeId(long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where endpoint = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param endpoint the endpoint
    * @return the matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param endpoint the endpoint
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param endpoint the endpoint
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByEndpoint(
        java.lang.String endpoint, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the actuator where endpoint = &#63; from the database.
    *
    * @param endpoint the endpoint
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator removeByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the number of actuators where endpoint = &#63;.
    *
    * @param endpoint the endpoint
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByEndpoint(java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param endpoint the endpoint
    * @param enabled the enabled
    * @return the matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param endpoint the endpoint
    * @param enabled the enabled
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param endpoint the endpoint
    * @param enabled the enabled
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint,
        boolean enabled, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param endpoint the endpoint
    * @param enabled the enabled
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator removeByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the number of actuators where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param endpoint the endpoint
    * @param enabled the enabled
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G_E_EN(long companyId, long groupId,
        java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the actuator in the entity cache if it is enabled.
    *
    * @param actuator the actuator
    */
    public void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator);

    /**
    * Caches the actuators in the entity cache if it is enabled.
    *
    * @param actuators the actuators
    */
    public void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> actuators);

    /**
    * Creates a new actuator with the primary key. Does not add the actuator to the database.
    *
    * @param actuatorId the primary key for the new actuator
    * @return the new actuator
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator create(
        long actuatorId);

    /**
    * Removes the actuator with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator remove(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    public com.lrexperts.liferay.liferayofthings.model.Actuator updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the actuator with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator findByPrimaryKey(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;

    /**
    * Returns the actuator with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator, or <code>null</code> if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Actuator fetchByPrimaryKey(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the actuators.
    *
    * @return the actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the actuators.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of actuators
    * @param end the upper bound of the range of actuators (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of actuators
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the actuators from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of actuators.
    *
    * @return the number of actuators
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
