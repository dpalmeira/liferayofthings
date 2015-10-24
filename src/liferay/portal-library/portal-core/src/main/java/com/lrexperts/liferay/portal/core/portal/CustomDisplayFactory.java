package com.lrexperts.liferay.portal.core.portal;

import com.lrexperts.liferay.portal.core.model.CustomDisplay;

import javax.portlet.PortletRequest;


/**
 * A factory for creating CustomDisplay objects.
 * 
 * @author Diego A. Palmeira
 */
public class CustomDisplayFactory {

	/**
	 * Gets the custom display.
	 *
	 * @param request the request
	 * @return the custom display
	 */
	public CustomDisplay getCustomDisplay(PortletRequest request) {
		CustomDisplay customDisplay = new CustomDisplay();
		return customDisplay;
	}

}
