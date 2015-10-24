/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.report.user.segment.content.service.persistence;

import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user segment content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentPersistenceImpl
 * @see UserSegmentContentUtil
 * @generated
 */
public interface UserSegmentContentPersistence extends BasePersistence<UserSegmentContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSegmentContentUtil} to access the user segment content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user segment contents where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user segment contents where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user segment contents where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentContentId the primary key of the current user segment content
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent[] findByUserSegmentId_PrevAndNext(
		long userSegmentContentId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user segment contents where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user segment contents where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @return the matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_GtD_First(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_GtD_First(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_GtD_Last(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_GtD_Last(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentContentId the primary key of the current user segment content
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent[] findByC_GtD_PrevAndNext(
		long userSegmentContentId, long userSegmentId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException} if it could not be found.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the user segment content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent removeByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user segment contents where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_E(long userSegmentId, java.lang.String className,
		long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user segment content in the entity cache if it is enabled.
	*
	* @param userSegmentContent the user segment content
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent);

	/**
	* Caches the user segment contents in the entity cache if it is enabled.
	*
	* @param userSegmentContents the user segment contents
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> userSegmentContents);

	/**
	* Creates a new user segment content with the primary key. Does not add the user segment content to the database.
	*
	* @param userSegmentContentId the primary key for the new user segment content
	* @return the new user segment content
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent create(
		long userSegmentContentId);

	/**
	* Removes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content that was removed
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent remove(
		long userSegmentContentId)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent updateImpl(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment content with the primary key or throws a {@link com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException} if it could not be found.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByPrimaryKey(
		long userSegmentContentId)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user segment content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content, or <code>null</code> if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByPrimaryKey(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user segment contents.
	*
	* @return the user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user segment contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user segment contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user segment contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user segment contents.
	*
	* @return the number of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}