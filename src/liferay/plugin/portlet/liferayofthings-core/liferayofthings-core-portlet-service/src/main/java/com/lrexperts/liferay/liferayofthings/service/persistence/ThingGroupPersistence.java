package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.lrexperts.liferay.liferayofthings.model.ThingGroup;

/**
 * The persistence interface for the thing group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroupPersistenceImpl
 * @see ThingGroupUtil
 * @generated
 */
public interface ThingGroupPersistence extends BasePersistence<ThingGroup> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ThingGroupUtil} to access the thing group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the thing groups where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the thing groups where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing group in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the first thing group in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing group in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the last thing group in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing groups before and after the current thing group in the ordered set where uuid = &#63;.
    *
    * @param thingGroupId the primary key of the current thing group
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup[] findByUuid_PrevAndNext(
        long thingGroupId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Removes all the thing groups where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing group where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the thing group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the thing group where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the thing group that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the number of thing groups where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the thing groups where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the thing groups where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing group in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the first thing group in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing group in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the last thing group in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing groups before and after the current thing group in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param thingGroupId the primary key of the current thing group
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup[] findByUuid_C_PrevAndNext(
        long thingGroupId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Removes all the thing groups where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the thing groups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the thing groups where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing group in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the first thing group in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing group in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the last thing group in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing groups before and after the current thing group in the ordered set where companyId = &#63;.
    *
    * @param thingGroupId the primary key of the current thing group
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup[] findByCompanyId_PrevAndNext(
        long thingGroupId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Removes all the thing groups where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the thing groups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the thing groups where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing group in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the first thing group in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing group in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the last thing group in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing groups before and after the current thing group in the ordered set where groupId = &#63;.
    *
    * @param thingGroupId the primary key of the current thing group
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup[] findByGroupId_PrevAndNext(
        long thingGroupId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Removes all the thing groups where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the thing groups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the thing groups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @return the range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first thing group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the first thing group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByC_G_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last thing group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the last thing group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByC_G_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing groups before and after the current thing group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param thingGroupId the primary key of the current thing group
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup[] findByC_G_PrevAndNext(
        long thingGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Removes all the thing groups where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the thing group in the entity cache if it is enabled.
    *
    * @param thingGroup the thing group
    */
    public void cacheResult(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup);

    /**
    * Caches the thing groups in the entity cache if it is enabled.
    *
    * @param thingGroups the thing groups
    */
    public void cacheResult(
        java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> thingGroups);

    /**
    * Creates a new thing group with the primary key. Does not add the thing group to the database.
    *
    * @param thingGroupId the primary key for the new thing group
    * @return the new thing group
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup create(
        long thingGroupId);

    /**
    * Removes the thing group with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param thingGroupId the primary key of the thing group
    * @return the thing group that was removed
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup remove(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    public com.lrexperts.liferay.liferayofthings.model.ThingGroup updateImpl(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the thing group with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException} if it could not be found.
    *
    * @param thingGroupId the primary key of the thing group
    * @return the thing group
    * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup findByPrimaryKey(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;

    /**
    * Returns the thing group with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param thingGroupId the primary key of the thing group
    * @return the thing group, or <code>null</code> if a thing group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup fetchByPrimaryKey(
        long thingGroupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the thing groups.
    *
    * @return the thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the thing groups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of thing groups
    * @param end the upper bound of the range of thing groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of thing groups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.lrexperts.liferay.liferayofthings.model.ThingGroup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the thing groups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of thing groups.
    *
    * @return the number of thing groups
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
