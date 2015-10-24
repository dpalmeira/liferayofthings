package com.lrexperts.liferay.portlet.core.controllers;

import com.liferay.portal.theme.ThemeDisplay;
import com.lrexperts.liferay.portal.core.model.CustomDisplay;
import com.lrexperts.liferay.portal.core.model.CustomPortalUser;
import com.lrexperts.liferay.portal.core.portal.CustomDisplayFactory;
import com.lrexperts.liferay.portal.core.portal.PortalException;
import com.lrexperts.liferay.portal.core.portal.PortalPreferencesProvider;
import com.lrexperts.liferay.portal.core.portal.PortalURLFactory;
import com.lrexperts.liferay.portal.core.portal.PortalUserProvider;
import com.lrexperts.liferay.portal.core.portal.ThemeDisplayFactory;

import java.text.MessageFormat;
import java.util.Properties;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.portlet.context.PortletConfigAware;

/**
 * The Class BasePortletController.
 * 
 * @author Diego A. Palmeira
 */
@Controller
public abstract class BasePortletController implements PortletConfigAware {

	/** The Constant PORTLET_SETUP. */
	protected final static String PORTLET_SETUP = "portletSetup";
	
	/** The Constant THEME_DISPLAY. */
	protected final static String THEME_DISPLAY = "themeDisplay";
	
	/** The Constant CUSTOM_DISPLAY. */
	protected final static String CUSTOM_DISPLAY = "customDisplay";
	
	/** The Constant USER. */
	protected final static String USER = "portalUser";
	
	/** The Constant ACTION. */
	protected static final String ACTION = "action";
	
	/** The view name format. */
	private MessageFormat viewNameFormat = new MessageFormat("{0}/{1}");
	
	/** The portlet config. */
	private PortletConfig portletConfig;
	
	/** The configuration. */
	private Properties configuration;
	
	/** The theme display factory. */
	private ThemeDisplayFactory themeDisplayFactory;
	
	/** The custom display factory. */
	private CustomDisplayFactory customDisplayFactory;
	
	/** The portal preferences provider. */
	private PortalPreferencesProvider portalPreferencesProvider;
	
	/** The portal user provider. */
	private PortalUserProvider portalUserProvider;
	
	/** The portal url factory. */
	private PortalURLFactory portalURLFactory;
	
	/** The message source. */
	private MessageSource messageSource;

	/**
	 * Gets the portlet setup.
	 *
	 * @param request the request
	 * @return the portlet setup
	 * @throws PortalException the portal exception
	 */
	@ModelAttribute(PORTLET_SETUP)
	public PortletPreferences getPortletSetup(PortletRequest request) throws PortalException {
		return portalPreferencesProvider.getPortletSetup(request, portletConfig);
	}
	
	/**
	 * Gets the theme display.
	 *
	 * @param request the request
	 * @return the theme display
	 */
	@ModelAttribute(THEME_DISPLAY)
	public ThemeDisplay getThemeDisplay(PortletRequest request) {
		return getThemeDisplayFactory().getThemeDisplay(request);
	}
	
	/**
	 * Gets the custom display.
	 *
	 * @param request the request
	 * @return the custom display
	 */
	@ModelAttribute(CUSTOM_DISPLAY)
	public CustomDisplay getCustomDisplay(PortletRequest request) {
		return getCustomDisplayFactory().getCustomDisplay(request);
	}

	/**
	 * Gets the user.
	 *
	 * @param request the request
	 * @return the user
	 * @throws PortalException the portal exception
	 */
	@ModelAttribute(USER)
	public CustomPortalUser getUser(PortletRequest request) throws PortalException {
		return getPortalUserProvider().getCurrentUser(request);
	}
	
	/**
	 * Full view name.
	 *
	 * @param viewName the view name
	 * @return the string
	 */
	protected String fullViewname(String viewName) {
		return viewNameFormat.format(new Object[]{portletBaseViewName(), viewName});
	}

    public void setPortletConfig(PortletConfig portletConfig) {
        this.portletConfig = portletConfig;
    }
    
    /**
     * Gets the portlet config.
     *
     * @return the portlet config
     */
    protected PortletConfig getPortletConfig() {
        return this.portletConfig;
    }

	/**
	 * Portlet base view name.
	 *
	 * @return the string
	 */
	protected abstract String portletBaseViewName();
	
	

	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 */
	public Properties getConfiguration() {
		return configuration;
	}
	
	/**
	 * Sets the configuration.
	 *
	 * @param configuration the new configuration
	 */
	public void setConfiguration(Properties configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * Gets the portal preferences provider.
	 *
	 * @return the portal preferences provider
	 */
	public PortalPreferencesProvider getPortalPreferencesProvider() {
		return portalPreferencesProvider;
	}
	
	/**
	 * Sets the portal preferences provider.
	 *
	 * @param portalPreferencesProvider the new portal preferences provider
	 */
	public void setPortalPreferencesProvider(
			PortalPreferencesProvider portalPreferencesProvider) {
		this.portalPreferencesProvider = portalPreferencesProvider;
	}
	
	/**
	 * Gets the message source.
	 *
	 * @return the message source
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	/**
	 * Sets the message source.
	 *
	 * @param messageSource the new message source
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * Gets the portal user provider.
	 *
	 * @return the portal user provider
	 */
	public PortalUserProvider getPortalUserProvider() {
		return portalUserProvider;
	}

	/**
	 * Sets the portal user provider.
	 *
	 * @param portalUserProvider the new portal user provider
	 */
	public void setPortalUserProvider(PortalUserProvider portalUserProvider) {
		this.portalUserProvider = portalUserProvider;
	}

	/**
	 * Gets the portal url factory.
	 *
	 * @return the portal url factory
	 */
	public PortalURLFactory getPortalURLFactory() {
		return portalURLFactory;
	}

	/**
	 * Sets the portal url factory.
	 *
	 * @param portalURLFactory the new portal url factory
	 */
	public void setPortalURLFactory(PortalURLFactory portalURLFactory) {
		this.portalURLFactory = portalURLFactory;
	}

	/**
	 * Gets the theme display factory.
	 *
	 * @return the theme display factory
	 */
	public ThemeDisplayFactory getThemeDisplayFactory() {
		return themeDisplayFactory;
	}

	/**
	 * Sets the theme display factory.
	 *
	 * @param themeDisplayFactory the new theme display factory
	 */
	public void setThemeDisplayFactory(ThemeDisplayFactory themeDisplayFactory) {
		this.themeDisplayFactory = themeDisplayFactory;
	}

	/**
	 * Gets the custom display factory.
	 *
	 * @return the custom display factory
	 */
	public CustomDisplayFactory getCustomDisplayFactory() {
		return customDisplayFactory;
	}

	/**
	 * Sets the custom display factory.
	 *
	 * @param customDisplayFactory the new custom display factory
	 */
	public void setCustomDisplayFactory(CustomDisplayFactory customDisplayFactory) {
		this.customDisplayFactory = customDisplayFactory;
	}

}
