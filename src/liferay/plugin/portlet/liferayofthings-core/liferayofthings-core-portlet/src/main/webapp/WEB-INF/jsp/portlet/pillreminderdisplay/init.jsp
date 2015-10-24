<%@ include file="/WEB-INF/jsp/portlet/init.jsp" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.model.Sensor" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.SensorType" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.SensorValue" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil" %>

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

<%
String sensorEndpoint = GetterUtil.getString(portletPreferences.getValue("sensorEndpoint", StringPool.BLANK));
%>