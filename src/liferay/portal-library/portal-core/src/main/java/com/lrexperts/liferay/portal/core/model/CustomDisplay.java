package com.lrexperts.liferay.portal.core.model;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class CustomDisplay.
 * 
 * @author Diego A. Palmeira
 */
public class CustomDisplay implements Serializable {

	/** The log. */
	private static Log _log = LogFactory.getLog(CustomDisplay.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5493165172347418843L;
	
	/** The Constant CUSTOM_SHARED. */
	public static final String CUSTOM_SHARED = "CUSTOM_SHARED_";
	
	/** The Constant CUSTOM_DISPLAY. */
	public static final String CUSTOM_DISPLAY = CUSTOM_SHARED + "CUSTOM_DISPLAY";
	
	/** The Constant USER_AREA. */
	public static final String USER_AREA = CUSTOM_SHARED + "userArea";
	
	/** The Constant USER_AREA_URL. */
	public static final String USER_AREA_URL = CUSTOM_SHARED + "userAreaURL";
	
	/** The Constant USER_AREA_CATEGORY. */
	public static final String USER_AREA_CATEGORY = CUSTOM_SHARED + "userAreaCategory";
	
	/** The Constant ARTICLE_TYPE. */
	public static final String ARTICLE_TYPE = CUSTOM_SHARED + "articleType";
	
	/** The Constant MAIN_RSS_URL. */
	public static final String MAIN_RSS_URL = CUSTOM_SHARED + "mainRssURL";
//	public static final String MY_PLACES_PORTLET_ID = "49";

//	public String getCommunityDefaultUrl(HttpServletRequest request) throws Exception {
//		
//		String communityDefaultUrl = StringPool.BLANK;
//		String communityDefaultPublicUrl = StringPool.BLANK;
//		String communityDefaultPrivateUrl = StringPool.BLANK;
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		Long groupId = themeDisplay.getLayout().getGroupId();
//		
//		PortletURL myPlacesPortetURL = PortletURLFactoryUtil.create(request, MY_PLACES_PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
//		myPlacesPortetURL.setWindowState(LiferayWindowState.NORMAL);
//		myPlacesPortetURL.setPortletMode(PortletMode.VIEW);
//
//		myPlacesPortetURL.setParameter("struts_action", "/my_places/view");
//		myPlacesPortetURL.setParameter("groupId", groupId.toString());
//		myPlacesPortetURL.setParameter("privateLayout", "false");
//
//		communityDefaultPublicUrl = HtmlUtil.escape(myPlacesPortetURL.toString());
//
//		myPlacesPortetURL.setParameter("privateLayout", "true");
//
//		communityDefaultPrivateUrl = HtmlUtil.escape(myPlacesPortetURL.toString());
//
//		communityDefaultUrl = communityDefaultPublicUrl;
//		
//		if (themeDisplay.getLayout().isPrivateLayout()) {
//			communityDefaultUrl = communityDefaultPrivateUrl;
//		}
//
//		return communityDefaultUrl;
//	}
//
//	public String getCommunityDefaultPublicUrl(HttpServletRequest request) throws Exception {
//		
//		String communityDefaultPublicUrl = StringPool.BLANK;
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		Long groupId = themeDisplay.getLayout().getGroupId();
//		
//		PortletURL myPlacesPortetURL = PortletURLFactoryUtil.create(request, MY_PLACES_PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
//		myPlacesPortetURL.setWindowState(LiferayWindowState.NORMAL);
//		myPlacesPortetURL.setPortletMode(PortletMode.VIEW);
//
//		myPlacesPortetURL.setParameter("struts_action", "/my_places/view");
//		myPlacesPortetURL.setParameter("groupId", groupId.toString());
//		myPlacesPortetURL.setParameter("privateLayout", "false");
//
//		communityDefaultPublicUrl = HtmlUtil.escape(myPlacesPortetURL.toString());
//
//		return communityDefaultPublicUrl;
//	}
//
//	public String getCommunityDefaultPrivateUrl(HttpServletRequest request) throws Exception {
//		
//		String communityDefaultPrivateUrl = StringPool.BLANK;
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		Long groupId = themeDisplay.getLayout().getGroupId();
//		
//		PortletURL myPlacesPortetURL = PortletURLFactoryUtil.create(request, MY_PLACES_PORTLET_ID, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
//		myPlacesPortetURL.setWindowState(LiferayWindowState.NORMAL);
//		myPlacesPortetURL.setPortletMode(PortletMode.VIEW);
//
//		myPlacesPortetURL.setParameter("struts_action", "/my_places/view");
//		myPlacesPortetURL.setParameter("groupId", groupId.toString());
//
//		myPlacesPortetURL.setParameter("privateLayout", "true");
//
//		communityDefaultPrivateUrl = HtmlUtil.escape(myPlacesPortetURL.toString());
//
//		return communityDefaultPrivateUrl;
//	}
	
	/**
 * Gets the user area.
 *
 * @param request the request
 * @return the user area
 * @throws Exception the exception
 */
public String getUserArea(HttpServletRequest request) throws Exception {
		/*
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = themeDisplay.getCompanyId();
		User user = themeDisplay.getUser();
		 */
		return (String)request.getSession().getAttribute(USER_AREA);
	}

	/**
	 * Gets the user area url.
	 *
	 * @param request the request
	 * @return the user area url
	 * @throws Exception the exception
	 */
	public String getUserAreaURL(HttpServletRequest request) throws Exception {
		return (String)request.getSession().getAttribute(USER_AREA_URL);
	}

	/**
	 * Gets the user area category.
	 *
	 * @param request the request
	 * @return the user area category
	 * @throws Exception the exception
	 */
	public String getUserAreaCategory(HttpServletRequest request) throws Exception {
		return (String)request.getSession().getAttribute(USER_AREA_CATEGORY);
	}

	/**
	 * Gets the article type.
	 *
	 * @param request the request
	 * @return the article type
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> getArticleType(HttpServletRequest request) throws Exception {
		return (Map<String,String>)request.getSession().getAttribute(ARTICLE_TYPE);
	}

	/**
	 * Gets the main rss url.
	 *
	 * @param request the request
	 * @return the main rss url
	 * @throws Exception the exception
	 */
	public String getMainRssURL(HttpServletRequest request) throws Exception {
		return (String)request.getSession().getAttribute(MAIN_RSS_URL);
	}

}
