package com.lrexperts.liferay.portal.core.portal;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * The Class LiferayPreferencesProvider.
 * 
 * @author Diego A. Palmeira
 */
public class LiferayPreferencesProvider implements PortalPreferencesProvider {
	
	/** The Constant PORTLET_ID. */
	private static final String PORTLET_ID = "PORTLET_ID";

	@Override
	public PortletPreferences getPortletSetup(PortletRequest request,
			PortletConfig portletConfig) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Layout layout = themeDisplay.getLayout();
        PortletDisplay pd = themeDisplay.getPortletDisplay();
        String portletId = (String) request.getAttribute(PORTLET_ID);
        if(isEmpty(portletId)){
            portletId = pd.getId();
            if(isEmpty(portletId)){
                try {
                    portletId=  (String)PropertyUtils.getProperty(portletConfig, "portletId");
                } catch (Exception e) {}
            }
        }
        try {
			return PortletPreferencesFactoryUtil.getPortletSetup(layout, portletId,null);
		} catch (SystemException e) {
			throw new PortalException(e);
		}
	}

	/**
	 * Checks if is empty.
	 *
	 * @param string the string
	 * @return true, if is empty
	 */
	private boolean isEmpty(String string) {
		return string==null || string.isEmpty();
	}

}
