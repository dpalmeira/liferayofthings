package com.lrexperts.liferay.portlet.core.controllers;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The Class BasePortletControllerTest.
 * 
 * @author Diego A. Palmeira
 */
public class BasePortletControllerTest {

	/**
	 * Test full viewname.
	 */
	@Test
	public void testFullViewname() {
		BasePortletController controller = new BasePortletController() {
			@Override
			protected String portletBaseViewName() {
				return "test";
			}
		};
		Assert.assertEquals("test/test", controller.fullViewname("test"));
	}

}