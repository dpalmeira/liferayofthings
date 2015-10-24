package com.lrexperts.liferay.portal.core.portal;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * The Interface PortalPreferencesProvider.
 * 
 * @author Diego A. Palmeira
 */
public interface PortalPreferencesProvider {
	
	/**
	 * Gets the portlet setup.
	 *
	 * @param request the request
	 * @param portletConfig the portlet config
	 * @return the portlet setup
	 * @throws PortalException the portal exception
	 */
	public PortletPreferences getPortletSetup(PortletRequest request, PortletConfig portletConfig)
		throws PortalException;
}