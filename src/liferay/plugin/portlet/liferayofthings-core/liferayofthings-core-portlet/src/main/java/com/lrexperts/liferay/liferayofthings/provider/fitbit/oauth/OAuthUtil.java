package com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth;

import com.liferay.util.portlet.PortletProps;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class OAuthUtil {

	public static Token extractAccessToken(
			Token requestToken, String oAuthVerifier) {

		Verifier verifier = new Verifier(oAuthVerifier);
		OAuthService oAuthService = getOAuthService();

		return oAuthService.getAccessToken(requestToken, verifier);
	}

	public static String getAuthorizeURL(Token requestToken) {
			return getOAuthService().getAuthorizationUrl(requestToken);
	}

	public static OAuthService getOAuthService() {
		return getOAuthService(null);
	}

	public static OAuthService getOAuthService(String callbackURL) {

		if (_oAuthService == null) {
			ServiceBuilder oAuthServiceBuilder = new ServiceBuilder();
			oAuthServiceBuilder.provider(FitbitApi.class);
			oAuthServiceBuilder.apiKey(
					PortletProps.get(OAuthConstants.PORTLET_CONFIG_OAUTH_CONSUMER_KEY));
			oAuthServiceBuilder.apiSecret(PortletProps.get(
					OAuthConstants.PORTLET_CONFIG_OAUTH_CONSUMER_SECRET));
			if (callbackURL != null) {
				oAuthServiceBuilder.callback(callbackURL);
			}
			oAuthServiceBuilder.debug(); // Debug mode, remove after tests... or put it inside isDebug block.
			_oAuthService = oAuthServiceBuilder.build();
		}

		return _oAuthService;
	}

	public static Token getRequestToken(String callbackURL) {
		_oAuthService = null;
		OAuthService oAuthService = getOAuthService(callbackURL);
		return oAuthService.getRequestToken();
	}

	private static OAuthService _oAuthService;

}
