package com.lrexperts.liferay.portal.core.portal;

import com.lrexperts.liferay.portal.core.model.CustomPortalUser;
import com.liferay.portal.model.User;

import java.io.Serializable;

/**
 * The Class LiferayCustomPortalUser.
 * 
 * @author Diego A. Palmeira
 */
public class LiferayCustomPortalUser implements CustomPortalUser, Serializable {

    /** The liferay user. */
    private User liferayUser;

    /**
     * Instantiates a new liferay custom portal user.
     *
     * @param liferayUser the liferay user
     */
    public LiferayCustomPortalUser(User liferayUser) {
        this.liferayUser = liferayUser;
    }

    @Override
    public long getId() {
        return liferayUser.getUserId();
    }

    @Override
    public boolean isAnonymous() {
        return liferayUser.isDefaultUser();
    }

    @Override
    public String getScreenName() {
        return liferayUser.getScreenName();
    }

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2005301539878241755L;
}
