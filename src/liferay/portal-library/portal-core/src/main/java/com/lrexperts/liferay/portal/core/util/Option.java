package com.lrexperts.liferay.portal.core.util;

import java.io.Serializable;

/**
 * Each <option> in a form <select>.
 * 
 * @author Diego A. Palmeira
 */

public class Option implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The code. */
	private String code;
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new option.
	 */
	public Option() {
		super();
	}
	
	/**
	 * Instantiates a new option.
	 *
	 * @param code the code
	 * @param value the value
	 */
	public Option(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Option [code=" + code + ", value=" + value + "]";
	}

}
