<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

String redirect = searchContainer.getIteratorURL().toString();

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ThingGroup thingGroup = (ThingGroup)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editThingGroupURL">
		<portlet:param name="action" value="thingGroupForm" />
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroup.getThingGroupId()) %>" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editThingGroupURL %>" />

	<portlet:renderURL var="viewThingsURL">
		<portlet:param name="action" value="viewThings" />
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroup.getThingGroupId()) %>" />
		<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="manage_nodes" message="thing.manage-things" url="<%= viewThingsURL.toString() %>" />

	<portlet:actionURL var="deleteThingGroupURL">
		<portlet:param name="action" value="deleteThingGroup" />
		<portlet:param name="redirect" value="<%= redirect %>" />
		<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroup.getThingGroupId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteThingGroupURL %>" />
</liferay-ui:icon-menu>
