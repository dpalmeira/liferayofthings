<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

ThingGroup thingGroup = (ThingGroup)renderRequest.getAttribute(LRoTWebKeys.LROT_THING_GROUP);

long thingGroupId = BeanParamUtil.getLong(thingGroup, request, "thingGroupId");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= (thingGroup == null) %>"
	title='<%= (thingGroup == null) ? "lrotadmin.new-thing-group" : thingGroup.getName(locale) %>'
/>

<c:if test="<%= thingGroup == null %>">
	<div class="alert alert-info">
		<liferay-ui:message key="thing.group.help" />
	</div>
</c:if>

<portlet:actionURL  var="thingGroupURL">
	<portlet:param name="action" value='<%= (thingGroup == null) ? "addThingGroup" : "editThingGroup" %>' />
</portlet:actionURL>

<aui:form action="<%= thingGroupURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="thingGroupId" type="hidden" value="<%= thingGroupId %>" />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />

	<liferay-ui:error exception="<%= NoSuchThingGroupException.class %>" message="thing.group.thing-group-does-not-exist" />

	<aui:model-context bean="<%= thingGroup %>" model="<%= ThingGroup.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<aui:input name="description" />

		<aui:input name="enabled" />
	</aui:fieldset>

	<c:if test="<%= thingGroup != null %>">
		<aui:fieldset>
			<c:if test="<%= ThingLocalServiceUtil.getThingsCount(thingGroupId) == 0 %>">
				<div class="alert alert-info">
					<liferay-ui:message key="thing.group.no-things-are-configured-for-this-thing-group" />
				</div>
			</c:if>

			<liferay-portlet:renderURL var="viewThingsURL">
				<portlet:param name="action" value="viewThings" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroupId) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:icon
				image="manage_nodes"
				label="<%= true %>"
				message="thing.manage-things"
				url="<%= viewThingsURL.toString() %>"
			/>
		</aui:fieldset>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>
