package com.lrexperts.liferay.portal.core.portal;

import com.lrexperts.liferay.portal.core.model.CustomPortalUser;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import javax.portlet.PortletRequest;

/**
 * The Class LiferayPortalUserProvider.
 * 
 * @author Diego A. Palmeira
 */
public class LiferayPortalUserProvider implements PortalUserProvider {

    /** The theme display factory. */
    private ThemeDisplayFactory themeDisplayFactory;

    /**
     * Instantiates a new liferay portal user provider.
     *
     * @param themeDisplayFactory the theme display factory
     */
    public LiferayPortalUserProvider(ThemeDisplayFactory themeDisplayFactory) {
        this.themeDisplayFactory = themeDisplayFactory;
    }

    @Override
    public CustomPortalUser getCurrentUser(PortletRequest request) throws PortalException {
        User liferayUser = (User) request.getAttribute(WebKeys.USER);
        try {
            if (liferayUser == null)
                liferayUser = UserLocalServiceUtil.getDefaultUser(getCompanyId(request));
            return (CustomPortalUser) new LiferayCustomPortalUser(liferayUser);
        } catch (Exception e) {
            throw new PortalException(e);
        }
    }

    /**
     * Gets the company id.
     *
     * @param request the request
     * @return the company id
     */
    private long getCompanyId(PortletRequest request) {
        return getThemeDisplayFactory().getThemeDisplay(request).getCompanyId();
    }

    /**
     * Gets the theme display factory.
     *
     * @return the theme display factory
     */
    private ThemeDisplayFactory getThemeDisplayFactory() {
        return themeDisplayFactory;
    }

}
