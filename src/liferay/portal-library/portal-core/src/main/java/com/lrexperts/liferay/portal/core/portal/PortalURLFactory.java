package com.lrexperts.liferay.portal.core.portal;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.PortletURLFactoryUtil;

import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * A factory for creating PortalURL objects.
 * 
 * @author Diego A. Palmeira
 */
public class PortalURLFactory {
	
	/** The Constant PORTLET_ID. */
	private static final String PORTLET_ID = "PORTLET_ID";
	
	/**
	 * Render url.
	 *
	 * @param portletRequest the portlet request
	 * @return the string
	 */
	public String renderUrl(PortletRequest portletRequest) {
		LiferayPortletURL portletUrl = renderUrlImpl(portletRequest);
		return portletUrl.toString();
	}
	
	/**
	 * Render url.
	 *
	 * @param portletRequest the portlet request
	 * @param params the params
	 * @return the string
	 */
	public String renderUrl(PortletRequest portletRequest, Map<String, String> params) {
		LiferayPortletURL portletUrl = renderUrlImpl(portletRequest);
		setParameters(portletUrl, params);
		return portletUrl.toString();
	}

	/**
	 * Render url impl.
	 *
	 * @param portletRequest the portlet request
	 * @return the liferay portlet url
	 */
	public LiferayPortletURL renderUrlImpl(PortletRequest portletRequest) {
		String lifecyclePhase = PortletRequest.RENDER_PHASE;
		LiferayPortletURL portletUrl = portletUrl(portletRequest, lifecyclePhase);
		return portletUrl;
	}
	
	/**
	 * Action url.
	 *
	 * @param portletRequest the portlet request
	 * @param params the params
	 * @return the string
	 */
	public String actionUrl(PortletRequest portletRequest, Map<String,String> params) {
		LiferayPortletURL portletUrl = actionUrlImpl(portletRequest);
		setParameters(portletUrl, params);
		return portletUrl.toString();
	}

	/**
	 * Action url impl.
	 *
	 * @param portletRequest the portlet request
	 * @return the liferay portlet url
	 */
	public LiferayPortletURL actionUrlImpl(PortletRequest portletRequest) {
		String lifecyclePhase = PortletRequest.ACTION_PHASE;
		LiferayPortletURL portletUrl = portletUrl(portletRequest, lifecyclePhase);
		return portletUrl;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param portletUrl the portlet url
	 * @param params the params
	 */
	private void setParameters(LiferayPortletURL portletUrl,
			Map<String, String> params) {
		for (Entry<String, String> paramEntry : params.entrySet()) {
			portletUrl.setParameter(paramEntry.getKey(), paramEntry.getValue());
		}
	}
	
	/**
	 * Portlet url.
	 *
	 * @param portletRequest the portlet request
	 * @param lifecyclePhase the lifecycle phase
	 * @return the liferay portlet url
	 */
	private LiferayPortletURL portletUrl(PortletRequest portletRequest, String lifecyclePhase) {
		return PortletURLFactoryUtil.create(convertToHttpServletRequest(portletRequest),
				(String) portletRequest.getAttribute(PORTLET_ID), ((Layout) portletRequest.getAttribute(WebKeys.LAYOUT)).getPlid(), lifecyclePhase);
	}
	
	/**
	 * Convert to http servlet request.
	 *
	 * @param request the request
	 * @return the http servlet request
	 */
	public HttpServletRequest convertToHttpServletRequest(PortletRequest request) {
       	try {
			return (HttpServletRequest) PropertyUtils.getNestedProperty(request,"httpServletRequest");
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot access to getHttpServletRequest from this PortletRequest["+request+"]",e);
        }
    }
	
}
