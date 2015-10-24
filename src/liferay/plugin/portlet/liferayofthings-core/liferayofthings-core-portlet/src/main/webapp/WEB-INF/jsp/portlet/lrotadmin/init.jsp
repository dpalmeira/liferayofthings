<%@ include file="/WEB-INF/jsp/portlet/init.jsp" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.model.ThingGroup" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.Thing" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.Sensor" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.Actuator" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.SensorType" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.ActuatorType" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.model.SensorValue" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.NoSuchThingException" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.NoSuchSensorException" %>
<%@ page import="com.lrexperts.liferay.liferayofthings.NoSuchActuatorException" %>

<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>

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
