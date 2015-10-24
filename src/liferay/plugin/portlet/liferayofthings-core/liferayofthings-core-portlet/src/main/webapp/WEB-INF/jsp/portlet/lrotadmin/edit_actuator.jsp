<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

Actuator actuator = (Actuator)renderRequest.getAttribute(LRoTWebKeys.LROT_ACTUATOR);

long actuatorId = BeanParamUtil.getLong(actuator, request, "actuatorId");

Thing thing = (Thing)renderRequest.getAttribute(LRoTWebKeys.LROT_THING);

long thingId = BeanParamUtil.getLong(thing, request, "thingId");

String title = StringPool.BLANK;

if (thing != null) {
	title = LanguageUtil.format(pageContext, "actuator.new-actuator-for-x", thing.getName(locale), false);

	if (actuator != null) {
		title = actuator.getName(locale) + " (" + thing.getName(locale) + ")";
	}
}

List<ActuatorType> actuatorTypeList = (List<ActuatorType>)renderRequest.getAttribute(LRoTWebKeys.LROT_ACTUATOR_TYPE_LIST);

String endpointBase = String.valueOf(groupId) + StringPool.SLASH + thing.getEndpoint() + StringPool.SLASH + "actuators" + StringPool.SLASH; 
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= false %>"
	title="<%= title %>"
/>

<c:if test="<%= actuator == null %>">
	<div class="alert alert-info">
		<liferay-ui:message key="actuator.help" />
	</div>
</c:if>

<portlet:actionURL  var="actuatorURL">
	<portlet:param name="action" value='<%= (actuator == null) ? "addActuator" : "editActuator" %>' />
</portlet:actionURL>

<aui:form action="<%= actuatorURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="thingId" type="hidden" value="<%= thingId %>" />
	<aui:input name="actuatorId" type="hidden" value="<%= actuatorId %>" />

	<liferay-ui:error exception="<%= NoSuchActuatorException.class %>" message="actuator.actuator-does-not-exist" />
	<liferay-ui:error exception="<%= NoSuchThingException.class %>" message="thing.thing-does-not-exist" />

	<aui:model-context bean="<%= actuator %>" model="<%= Actuator.class %>" />

	<aui:fieldset>
		<%
		String actuatorTypeIcon = "generic-actuator.png";
		%>
		<aui:select name="actuatorTypeId">
			<%
			boolean actuatorTypeSelected = false;

			for (ActuatorType actuatorType : actuatorTypeList) {
				if ((actuator!=null) && (actuator.getActuatorTypeId() == actuatorType.getActuatorTypeId())) {
					actuatorTypeSelected = true;
					actuatorTypeIcon = actuatorType.getIcon();
				}
			%>
				<aui:option label="<%= HtmlUtil.escape(actuatorType.getName(locale)) %>"
					selected="<%= actuatorTypeSelected == true %>"
					value="<%= actuatorType.getActuatorTypeId() %>" />
			<%
			}
			%>
		</aui:select>
		<liferay-ui:icon id='<%= renderResponse.getNamespace() + "actuatorTypeIcon" %>'
			src='<%= "/liferayofthings-core-portlet/img/common/icons/" + actuatorTypeIcon %>' />

		<aui:input name="name" />

		<aui:input name="description" />
		
		<aui:field-wrapper cssClass="input-append input-flex-add-on input-prepend" helpMessage='<%= LanguageUtil.format(pageContext, "for-example-x", "<em>actuator1</em>") %>' label="actuator.field.endpoint" name="endpoint">
			<span class="add-on" id="<portlet:namespace />endpointBase"><%= endpointBase %></span>
			<liferay-ui:input-field bean="<%= actuator %>" field="endpoint" model="<%= Actuator.class %>" cssClass="form-control" />
		</aui:field-wrapper>

		<aui:input name="enabled" />
		
		<aui:input name="status" disabled="<%= true %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	<%
	StringBuffer actuatorTypeSB = new StringBuffer();
	/** Format of Map: {"key1":"value1","key2":"value2"} **/ 
	actuatorTypeSB.append(StringPool.OPEN_CURLY_BRACE);
	for (ActuatorType actuatorType : actuatorTypeList) {
		// Key
		actuatorTypeSB.append(StringPool.APOSTROPHE);
		actuatorTypeSB.append(actuatorType.getActuatorTypeId());
		actuatorTypeSB.append(StringPool.APOSTROPHE);
		actuatorTypeSB.append(StringPool.COLON);
		// Value
		actuatorTypeSB.append(StringPool.APOSTROPHE);
		actuatorTypeSB.append(actuatorType.getIcon());
		actuatorTypeSB.append(StringPool.APOSTROPHE);
		actuatorTypeSB.append(StringPool.COMMA);
	}
	actuatorTypeSB.deleteCharAt(actuatorTypeSB.length()-1);
	actuatorTypeSB.append(StringPool.CLOSE_CURLY_BRACE);
	%>
	
	var actuatorTypeMap = <%= actuatorTypeSB.toString() %>;

	A.one("#<portlet:namespace/>actuatorTypeId").on('change',function() {
		A.one("#<portlet:namespace />actuatorTypeIcon").attr('src', '/liferayofthings-core-portlet/img/common/icons/' + actuatorTypeMap[this.get("value")]);
	})	
</aui:script>
