package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.lrexperts.liferay.liferayofthings.model.Thing;

/**
 * The persistence interface for the thing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingPersistenceImpl
 * @see ThingUtil
 * @generated
 */
public interface ThingPersistence extends BasePersistence<Thing> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ThingUtil} to access the thing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the things where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where uuid = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByUuid_PrevAndNext(
        long thingId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the thing where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the thing that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the number of things where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByUuid_C_PrevAndNext(
        long thingId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where companyId = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByCompanyId_PrevAndNext(
        long thingId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where groupId = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByGroupId_PrevAndNext(
        long thingId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByC_G_PrevAndNext(
        long thingId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G_S(
        long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G_S(
        long companyId, long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByC_G_S(
        long companyId, long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByC_G_S_First(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByC_G_S_Last(
        long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByC_G_S_PrevAndNext(
        long thingId, long companyId, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where companyId = &#63; and groupId = &#63; and status = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G_S(long companyId, long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @return the matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByThingGroupId(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things where thingGroupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param thingGroupId the thing group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByThingGroupId(
        long thingGroupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things where thingGroupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param thingGroupId the thing group ID
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findByThingGroupId(
        long thingGroupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing in the ordered set where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByThingGroupId_First(
        long thingGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the first thing in the ordered set where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByThingGroupId_First(
        long thingGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing in the ordered set where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByThingGroupId_Last(
        long thingGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the last thing in the ordered set where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing, or <code>null</code> if a matching thing could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByThingGroupId_Last(
        long thingGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the things before and after the current thing in the ordered set where thingGroupId = &#63;.
    *
    * @param thingId the primary key of the current thing
    * @param thingGroupId the thing group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing[] findByThingGroupId_PrevAndNext(
        long thingId, long thingGroupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Removes all the things where thingGroupId = &#63; from the database.
    *
    * @param thingGroupId the thing group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByThingGroupId(long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things where thingGroupId = &#63;.
    *
    * @param thingGroupId the thing group ID
    * @return the number of matching things
    * @throws SystemException if a system exception occurred
    */
    public int countByThingGroupId(long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the thing in the entity cache if it is enabled.
    *
    * @param thing the thing
    */
    public void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.Thing thing);

    /**
    * Caches the things in the entity cache if it is enabled.
    *
    * @param things the things
    */
    public void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> things);

    /**
    * Creates a new thing with the primary key. Does not add the thing to the database.
    *
    * @param thingId the primary key for the new thing
    * @return the new thing
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing create(
        long thingId);

    /**
    * Removes the thing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param thingId the primary key of the thing
    * @return the thing that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing remove(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    public com.lrexperts.liferay.liferayofthings.model.Thing updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Thing thing)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingException} if it could not be found.
    *
    * @param thingId the primary key of the thing
    * @return the thing
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing findByPrimaryKey(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingException;

    /**
    * Returns the thing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param thingId the primary key of the thing
    * @return the thing, or <code>null</code> if a thing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.Thing fetchByPrimaryKey(
        long thingId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the things.
    *
    * @return the things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the things.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @return the range of things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the things.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of things
    * @param end the upper bound of the range of things (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of things
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.Thing> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the things from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of things.
    *
    * @return the number of things
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
