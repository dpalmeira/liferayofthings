package com.lrexperts.liferay.portal.core.portal;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletRequest;

/**
 * A factory for creating ThemeDisplay objects.
 * 
 * @author Diego A. Palmeira
 */
public class ThemeDisplayFactory {

	/**
	 * Gets the theme display.
	 *
	 * @param request the request
	 * @return the theme display
	 */
	public ThemeDisplay getThemeDisplay(PortletRequest request) {
		return ((ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY));
	}

}
