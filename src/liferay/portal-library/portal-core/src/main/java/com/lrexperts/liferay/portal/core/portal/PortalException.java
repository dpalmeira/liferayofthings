package com.lrexperts.liferay.portal.core.portal;

/**
 * The Class PortalException.
 * 
 * @author Diego A. Palmeira
 */
public class PortalException extends RuntimeException {

	/**
	 * Instantiates a new portal exception.
	 */
	public PortalException() {
		super();
	}

	/**
	 * Instantiates a new portal exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public PortalException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new portal exception.
	 *
	 * @param message the message
	 */
	public PortalException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new portal exception.
	 *
	 * @param cause the cause
	 */
	public PortalException(Throwable cause) {
		super(cause);
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1681793191193316771L;

}
