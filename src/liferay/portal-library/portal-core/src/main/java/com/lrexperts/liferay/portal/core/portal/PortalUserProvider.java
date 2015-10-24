package com.lrexperts.liferay.portal.core.portal;

import com.lrexperts.liferay.portal.core.model.CustomPortalUser;

import javax.portlet.PortletRequest;

/**
 * The Interface PortalUserProvider.
 * 
 * @author Diego A. Palmeira
 */
public interface PortalUserProvider {

	/**
	 * Gets the current user.
	 *
	 * @param request the request
	 * @return the current user
	 * @throws PortalException the portal exception
	 */
	public CustomPortalUser getCurrentUser(PortletRequest request) throws PortalException;
}
