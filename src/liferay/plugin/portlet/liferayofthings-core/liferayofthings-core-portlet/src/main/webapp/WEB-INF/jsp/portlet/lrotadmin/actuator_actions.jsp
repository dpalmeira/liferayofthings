<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Actuator actuator = (Actuator)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editActuatorURL">
		<portlet:param name="action" value="actuatorForm" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="actuatorId" value="<%= String.valueOf(actuator.getActuatorId()) %>" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editActuatorURL %>" />

	<portlet:actionURL var="deleteActuatorURL">
		<portlet:param name="action" value="deleteActuator" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="actuatorId" value="<%= String.valueOf(actuator.getActuatorId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteActuatorURL %>" />

	<liferay-portlet:renderURL var="pushMessageActuatorFormURL">
		<portlet:param name="action" value="pushMessageActuatorForm" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="backURL" value="<%= currentURL %>" />
		<portlet:param name="actuatorId" value="<%= String.valueOf(actuator.getActuatorId()) %>" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon src="/liferayofthings-core-portlet/img/common/icons/push-message.png"
		url="<%= pushMessageActuatorFormURL %>"
		message='<%= LanguageUtil.get(pageContext, "actuator.push-message") %>'/>
</liferay-ui:icon-menu>
