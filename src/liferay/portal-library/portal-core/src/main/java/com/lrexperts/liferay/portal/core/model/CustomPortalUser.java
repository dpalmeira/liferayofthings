package com.lrexperts.liferay.portal.core.model;

/**
 * The Interface CustomPortalUser.
 * 
 * @author Diego A. Palmeira
 */

public interface CustomPortalUser {
	
	/**
	 * Checks if is anonymous.
	 *
	 * @return true, if is anonymous
	 */
	public boolean isAnonymous();
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId();
	
	/**
	 * Gets the screen name.
	 *
	 * @return the screen name
	 */
	public String getScreenName();

}
