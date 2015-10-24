package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.lrexperts.liferay.liferayofthings.model.Actuator;

import java.util.List;

/**
 * The persistence utility for the actuator service. This utility wraps {@link ActuatorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorPersistence
 * @see ActuatorPersistenceImpl
 * @generated
 */
public class ActuatorUtil {
    private static ActuatorPersistence _persistence;

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
    public static void clearCache(Actuator actuator) {
        getPersistence().clearCache(actuator);
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
    public static List<Actuator> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Actuator> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Actuator> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Actuator update(Actuator actuator) throws SystemException {
        return getPersistence().update(actuator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Actuator update(Actuator actuator,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(actuator, serviceContext);
    }

    /**
    * Returns all the actuators where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByUuid_PrevAndNext(
        long actuatorId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByUuid_PrevAndNext(actuatorId, uuid, orderByComparator);
    }

    /**
    * Removes all the actuators where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of actuators where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the actuator where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of actuators where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the actuators where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByUuid_C_PrevAndNext(
        long actuatorId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(actuatorId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the actuators where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of actuators where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the actuators where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByCompanyId_PrevAndNext(
        long actuatorId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(actuatorId, companyId,
            orderByComparator);
    }

    /**
    * Removes all the actuators where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Returns the number of actuators where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns all the actuators where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByGroupId_PrevAndNext(
        long actuatorId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(actuatorId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the actuators where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of actuators where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the actuators where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G(companyId, groupId, start, end, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_First(companyId, groupId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_Last(companyId, groupId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByC_G_PrevAndNext(
        long actuatorId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_PrevAndNext(actuatorId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the actuators where companyId = &#63; and groupId = &#63; from the database.
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
    * Returns the number of actuators where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G(companyId, groupId);
    }

    /**
    * Returns all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G_S(companyId, groupId, status);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_S(companyId, groupId, status, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByC_G_S(
        long companyId, long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_S(companyId, groupId, status, start, end,
            orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_S_First(companyId, groupId, status,
            orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_S_First(companyId, groupId, status,
            orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_S_Last(companyId, groupId, status,
            orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_S_Last(companyId, groupId, status,
            orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByC_G_S_PrevAndNext(
        long actuatorId, long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_S_PrevAndNext(actuatorId, companyId, groupId,
            status, orderByComparator);
    }

    /**
    * Removes all the actuators where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_G_S(companyId, groupId, status);
    }

    /**
    * Returns the number of actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G_S(companyId, groupId, status);
    }

    /**
    * Returns all the actuators where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByThingId(thingId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByThingId(thingId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByThingId(
        long thingId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByThingId(thingId, start, end, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByThingId_First(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByThingId_First(thingId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByThingId_First(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByThingId_First(thingId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByThingId_Last(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByThingId_Last(thingId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByThingId_Last(
        long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByThingId_Last(thingId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByThingId_PrevAndNext(
        long actuatorId, long thingId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByThingId_PrevAndNext(actuatorId, thingId,
            orderByComparator);
    }

    /**
    * Removes all the actuators where thingId = &#63; from the database.
    *
    * @param thingId the thing ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByThingId(long thingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByThingId(thingId);
    }

    /**
    * Returns the number of actuators where thingId = &#63;.
    *
    * @param thingId the thing ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByThingId(long thingId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByThingId(thingId);
    }

    /**
    * Returns all the actuators where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @return the matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActuatorTypeId(actuatorTypeId);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActuatorTypeId(actuatorTypeId, start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findByActuatorTypeId(
        long actuatorTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActuatorTypeId(actuatorTypeId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByActuatorTypeId_First(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByActuatorTypeId_First(actuatorTypeId, orderByComparator);
    }

    /**
    * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByActuatorTypeId_First(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActuatorTypeId_First(actuatorTypeId,
            orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByActuatorTypeId_Last(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByActuatorTypeId_Last(actuatorTypeId, orderByComparator);
    }

    /**
    * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByActuatorTypeId_Last(
        long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActuatorTypeId_Last(actuatorTypeId, orderByComparator);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator[] findByActuatorTypeId_PrevAndNext(
        long actuatorId, long actuatorTypeId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByActuatorTypeId_PrevAndNext(actuatorId,
            actuatorTypeId, orderByComparator);
    }

    /**
    * Removes all the actuators where actuatorTypeId = &#63; from the database.
    *
    * @param actuatorTypeId the actuator type ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActuatorTypeId(long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActuatorTypeId(actuatorTypeId);
    }

    /**
    * Returns the number of actuators where actuatorTypeId = &#63;.
    *
    * @param actuatorTypeId the actuator type ID
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByActuatorTypeId(long actuatorTypeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActuatorTypeId(actuatorTypeId);
    }

    /**
    * Returns the actuator where endpoint = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param endpoint the endpoint
    * @return the matching actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByEndpoint(endpoint);
    }

    /**
    * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param endpoint the endpoint
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEndpoint(endpoint);
    }

    /**
    * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param endpoint the endpoint
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByEndpoint(
        java.lang.String endpoint, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEndpoint(endpoint, retrieveFromCache);
    }

    /**
    * Removes the actuator where endpoint = &#63; from the database.
    *
    * @param endpoint the endpoint
    * @return the actuator that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator removeByEndpoint(
        java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().removeByEndpoint(endpoint);
    }

    /**
    * Returns the number of actuators where endpoint = &#63;.
    *
    * @param endpoint the endpoint
    * @return the number of matching actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countByEndpoint(java.lang.String endpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEndpoint(endpoint);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .findByC_G_E_EN(companyId, groupId, endpoint, enabled);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_E_EN(companyId, groupId, endpoint, enabled);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint,
        boolean enabled, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_E_EN(companyId, groupId, endpoint, enabled,
            retrieveFromCache);
    }

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
    public static com.lrexperts.liferay.liferayofthings.model.Actuator removeByC_G_E_EN(
        long companyId, long groupId, java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence()
                   .removeByC_G_E_EN(companyId, groupId, endpoint, enabled);
    }

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
    public static int countByC_G_E_EN(long companyId, long groupId,
        java.lang.String endpoint, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByC_G_E_EN(companyId, groupId, endpoint, enabled);
    }

    /**
    * Caches the actuator in the entity cache if it is enabled.
    *
    * @param actuator the actuator
    */
    public static void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator) {
        getPersistence().cacheResult(actuator);
    }

    /**
    * Caches the actuators in the entity cache if it is enabled.
    *
    * @param actuators the actuators
    */
    public static void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> actuators) {
        getPersistence().cacheResult(actuators);
    }

    /**
    * Creates a new actuator with the primary key. Does not add the actuator to the database.
    *
    * @param actuatorId the primary key for the new actuator
    * @return the new actuator
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator create(
        long actuatorId) {
        return getPersistence().create(actuatorId);
    }

    /**
    * Removes the actuator with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator remove(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().remove(actuatorId);
    }

    public static com.lrexperts.liferay.liferayofthings.model.Actuator updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(actuator);
    }

    /**
    * Returns the actuator with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator findByPrimaryKey(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchActuatorException {
        return getPersistence().findByPrimaryKey(actuatorId);
    }

    /**
    * Returns the actuator with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param actuatorId the primary key of the actuator
    * @return the actuator, or <code>null</code> if a actuator with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.lrexperts.liferay.liferayofthings.model.Actuator fetchByPrimaryKey(
        long actuatorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(actuatorId);
    }

    /**
    * Returns all the actuators.
    *
    * @return the actuators
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.lrexperts.liferay.liferayofthings.model.Actuator> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the actuators from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of actuators.
    *
    * @return the number of actuators
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ActuatorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ActuatorPersistence) PortletBeanLocatorUtil.locate(com.lrexperts.liferay.liferayofthings.service.ClpSerializer.getServletContextName(),
                    ActuatorPersistence.class.getName());

            ReferenceRegistry.registerReference(ActuatorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ActuatorPersistence persistence) {
    }
}
