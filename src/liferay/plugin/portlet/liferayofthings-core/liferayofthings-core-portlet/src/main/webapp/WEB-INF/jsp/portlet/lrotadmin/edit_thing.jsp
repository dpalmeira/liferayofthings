<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

Thing thing = (Thing)renderRequest.getAttribute(LRoTWebKeys.LROT_THING);

long thingId = BeanParamUtil.getLong(thing, request, "thingId");

ThingGroup thingGroup = (ThingGroup)renderRequest.getAttribute(LRoTWebKeys.LROT_THING_GROUP);

long thingGroupId = BeanParamUtil.getLong(thingGroup, request, "thingGroupId");

String title = StringPool.BLANK;

if (thingGroup != null) {
	title = LanguageUtil.format(pageContext, "thing.new-thing-for-x", thingGroup.getName(locale), false);

	if (thing != null) {
		title = thing.getName(locale) + " (" + thingGroup.getName(locale) + ")";
	}
}
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= false %>"
	title="<%= title %>"
/>

<c:if test="<%= thing == null %>">
	<div class="alert alert-info">
		<liferay-ui:message key="thing.help" />
	</div>
</c:if>

<portlet:actionURL  var="thingURL">
	<portlet:param name="action" value='<%= (thing == null) ? "addThing" : "editThing" %>' />
</portlet:actionURL>

<aui:form action="<%= thingURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="thingGroupId" type="hidden" value="<%= thingGroupId %>" />
	<aui:input name="thingId" type="hidden" value="<%= thingId %>" />

	<liferay-ui:error exception="<%= NoSuchThingException.class %>" message="thing.thing-does-not-exist" />
	<liferay-ui:error exception="<%= NoSuchThingGroupException.class %>" message="thing.group.thing-group-does-not-exist" />

	<aui:model-context bean="<%= thing %>" model="<%= Thing.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<aui:input name="description" />

		<aui:input name="endpoint" label="thing.field.endpoint" />

		<aui:input name="enabled" />
		
		<aui:input name="status" disabled="<%= true %>" />
	</aui:fieldset>

	<c:if test="<%= thing != null %>">
		<aui:fieldset>
			<c:if test="<%= SensorLocalServiceUtil.getSensorsCount(thingId) == 0 %>">
				<div class="alert alert-info">
					<liferay-ui:message key="thing.no-sensors-are-configured-for-this-thing" />
				</div>
			</c:if>

			<liferay-portlet:renderURL var="viewSensorsURL">
				<portlet:param name="action" value="viewSensors" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="thingId" value="<%= String.valueOf(thingId) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:icon
				image="manage_nodes"
				label="<%= true %>"
				message="sensor.manage-sensors"
				url="<%= viewSensorsURL.toString() %>"
			/>
		</aui:fieldset>

		<aui:fieldset>
			<c:if test="<%= ActuatorLocalServiceUtil.getActuatorsCount(thingId) == 0 %>">
				<div class="alert alert-info">
					<liferay-ui:message key="thing.no-actuators-are-configured-for-this-thing" />
				</div>
			</c:if>

			<liferay-portlet:renderURL var="viewActuatorsURL">
				<portlet:param name="action" value="viewActuators" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="thingId" value="<%= String.valueOf(thingId) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:icon
				image="manage_nodes"
				label="<%= true %>"
				message="actuator.manage-actuators"
				url="<%= viewActuatorsURL.toString() %>"
			/>
		</aui:fieldset>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>
