<%@ include file="/WEB-INF/jsp/portlet/init.jsp" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth.OAuthUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth.OAuthConstants" %>
<%@ page import="org.scribe.model.Token" %>

<%
PortletMode portletMode = liferayPortletRequest.getPortletMode();
WindowState windowState = liferayPortletRequest.getWindowState();

PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);

String currentURL = currentURLObj.toString();
%>

<%
long groupId = ParamUtil.getLong(request, "groupId");

if (groupId == 0) {
	groupId = themeDisplay.getSiteGroupId();
}
%>
