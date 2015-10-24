package com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class FitbitApi extends DefaultApi10a {

	@Override
	public String getAccessTokenEndpoint() {
		if (Validator.isNull(_accessTokenEndpoint)) {
			_accessTokenEndpoint =
					PortletProps.get(OAuthConstants.PORTLET_CONFIG_OAUTH_ACCESS_TOKEN_URI);
		}
		return _accessTokenEndpoint;
	}

	@Override
	public String getRequestTokenEndpoint() {
		if (Validator.isNull(_requestTokenEndpoint)) {
			_requestTokenEndpoint =
					PortletProps.get(OAuthConstants.PORTLET_CONFIG_OAUTH_REQUEST_TOKEN_URI);
		}
		return _requestTokenEndpoint;
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return String.format(
				PortletProps.get(OAuthConstants.PORTLET_CONFIG_OAUTH_AUTHORIZE_URI),
				requestToken.getToken());
	}

	private String _accessTokenEndpoint;
	private String _requestTokenEndpoint;
}
