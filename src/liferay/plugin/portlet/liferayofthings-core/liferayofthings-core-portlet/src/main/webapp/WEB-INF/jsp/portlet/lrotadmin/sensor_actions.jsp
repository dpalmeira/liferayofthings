<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Sensor sensor = (Sensor)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editSensorURL">
		<portlet:param name="action" value="sensorForm" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="sensorId" value="<%= String.valueOf(sensor.getSensorId()) %>" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editSensorURL %>" />

	<portlet:actionURL var="deleteSensorURL">
		<portlet:param name="action" value="deleteSensor" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="sensorId" value="<%= String.valueOf(sensor.getSensorId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteSensorURL %>" />
</liferay-ui:icon-menu>
