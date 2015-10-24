package com.lrexperts.liferay.liferayofthings.portlet.fitbit;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth.OAuthUtil;
import com.lrexperts.liferay.portlet.core.controllers.BasePortletController;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.scribe.model.Token;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

/**
 * @author Diego A. Palmeira
 */
@Controller()
@RequestMapping("VIEW")
public class FitbitController extends BasePortletController {

	@Override
	protected String portletBaseViewName() {
		return PORTLET_PAGE_URL;
	}

	/********************************
	 * OAuth 1.0
	 ********************************/
	
	@RequestMapping
	public ModelAndView defaultView(
			final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final @ModelAttribute(PORTLET_SETUP) PortletPreferences portletSetup,
			final RenderRequest request, Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("defaultView");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();
		
		return new ModelAndView(fullViewname("view"), modelMap);
	}

	@ActionMapping(params = "action=setupOAuth")
	public void setupOAuth(
			final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
				throws PortletException, SystemException, PortalException {

		PortletSession portletSession = actionRequest.getPortletSession();
		Token requestToken = (Token)portletSession.getAttribute(Token.class.getName());

		String oAuthVerifier = ParamUtil.getString(actionRequest, "oauth_verifier");
		
		if (_log.isDebugEnabled()) {
			_log.debug("This is the oauth_verifier=" + oAuthVerifier);
		}

		Token token = OAuthUtil.extractAccessToken(requestToken, oAuthVerifier);

		if (_log.isDebugEnabled()) {
			_log.debug("This is the oauth_verifier=" + token.toString());
		}

		/** Make my wereables for users..
		User user = themeDisplay.getUser();
		if (user.getExpandoBridge().hasAttribute("fitbit_access_token_secret") &&
				user.getExpandoBridge().hasAttribute("fitbit_access_token")) {

			user.getExpandoBridge().setAttribute("fitbit_access_token_secret", token.getSecret());
			user.getExpandoBridge().setAttribute("fitbit_access_token", token.getToken());
		}
		**/
		
		Group group = themeDisplay.getScopeGroup();
		if (group.getExpandoBridge().hasAttribute("fitbit_access_token_secret") &&
				group.getExpandoBridge().hasAttribute("fitbit_access_token")) {

			group.getExpandoBridge().setAttribute("fitbit_access_token_secret", token.getSecret());
			group.getExpandoBridge().setAttribute("fitbit_access_token", token.getToken());
		}
	
	}

	private static final Log _log = LogFactory.getLog(FitbitController.class);
	private static final String PORTLET_PAGE_URL = "portlet/fitbit";

}
