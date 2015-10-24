<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Thing thing = (Thing)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editThingURL">
		<portlet:param name="action" value="thingForm" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="thingId" value="<%= String.valueOf(thing.getThingId()) %>" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editThingURL %>" />

	<portlet:renderURL var="viewSensorsURL">
		<portlet:param name="action" value="viewSensors" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="thingId" value="<%= String.valueOf(thing.getThingId()) %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="manage_nodes" message="sensor.manage-sensors" url="<%= viewSensorsURL.toString() %>" />

	<portlet:renderURL var="viewActuatorsURL">
		<portlet:param name="action" value="viewActuators" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="thingId" value="<%= String.valueOf(thing.getThingId()) %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="manage_nodes" message="actuator.manage-actuators" url="<%= viewActuatorsURL.toString() %>" />

	<portlet:actionURL var="deleteThingURL">
		<portlet:param name="action" value="deleteThing" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="thingId" value="<%= String.valueOf(thing.getThingId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteThingURL %>" />
</liferay-ui:icon-menu>
