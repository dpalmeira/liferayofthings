<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

Sensor sensor = (Sensor)renderRequest.getAttribute(LRoTWebKeys.LROT_SENSOR);

long sensorId = BeanParamUtil.getLong(sensor, request, "sensorId");

Thing thing = (Thing)renderRequest.getAttribute(LRoTWebKeys.LROT_THING);

long thingId = BeanParamUtil.getLong(thing, request, "thingId");

String title = StringPool.BLANK;

if (thing != null) {
	title = LanguageUtil.format(pageContext, "sensor.new-sensor-for-x", thing.getName(locale), false);

	if (sensor != null) {
		title = sensor.getName(locale) + " (" + thing.getName(locale) + ")";
	}
}

List<SensorType> sensorTypeList = (List<SensorType>)renderRequest.getAttribute(LRoTWebKeys.LROT_SENSOR_TYPE_LIST);

String endpointBase = String.valueOf(groupId) + StringPool.SLASH + thing.getEndpoint() + StringPool.SLASH + "sensors" + StringPool.SLASH; 

String lastSensorValue = StringPool.BLANK;
if (sensor != null) {
	SensorValue sensorValue = SensorValueLocalServiceUtil.getLastSensorValue(sensor.getSensorId());
	lastSensorValue = (sensorValue!=null ? sensorValue.getValue() : StringPool.BLANK);
}
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= false %>"
	title="<%= title %>"
/>

<c:if test="<%= sensor == null %>">
	<div class="alert alert-info">
		<liferay-ui:message key="sensor.help" />
	</div>
</c:if>

<portlet:actionURL  var="sensorURL">
	<portlet:param name="action" value='<%= (sensor == null) ? "addSensor" : "editSensor" %>' />
</portlet:actionURL>

<aui:form action="<%= sensorURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="thingId" type="hidden" value="<%= thingId %>" />
	<aui:input name="sensorId" type="hidden" value="<%= sensorId %>" />

	<liferay-ui:error exception="<%= NoSuchSensorException.class %>" message="sensor.sensor-does-not-exist" />
	<liferay-ui:error exception="<%= NoSuchThingException.class %>" message="thing.thing-does-not-exist" />

	<aui:model-context bean="<%= sensor %>" model="<%= Sensor.class %>" />

	<aui:fieldset>
		<%
		String sensorTypeIcon = "generic-sensor.png";
		%>
		<aui:select name="sensorTypeId">
			<%
			boolean sensorTypeSelected = false;

			for (SensorType sensorType : sensorTypeList) {
				if ((sensor!=null) && (sensor.getSensorTypeId() == sensorType.getSensorTypeId())) {
					sensorTypeSelected = true;
					sensorTypeIcon = sensorType.getIcon();
				}
			%>
				<aui:option label="<%= HtmlUtil.escape(sensorType.getName(locale)) %>"
					selected="<%= sensorTypeSelected == true %>"
					value="<%= sensorType.getSensorTypeId() %>" />
			<%
			}
			%>
		</aui:select>
		<liferay-ui:icon id='<%= renderResponse.getNamespace() + "sensorTypeIcon" %>'
			src='<%= "/liferayofthings-core-portlet/img/common/icons/" + sensorTypeIcon %>' />
		
		<aui:input name="name" />

		<aui:input name="description" />

		<aui:field-wrapper cssClass="input-append input-flex-add-on input-prepend" helpMessage='<%= LanguageUtil.format(pageContext, "for-example-x", "<em>sensor1</em>") %>' label="sensor.field.endpoint" name="endpoint">
			<span class="add-on" id="<portlet:namespace />endpointBase"><%= endpointBase %></span>
			<liferay-ui:input-field bean="<%= sensor %>" field="endpoint" model="<%= Sensor.class %>" cssClass="form-control" />
		</aui:field-wrapper>

		<aui:input name="enabled" />
		
		<aui:input name="status" disabled="<%= true %>" />
		
		<label class="control-label"><%= LanguageUtil.get(pageContext, "sensor.last.data") %></label>
		<span><strong><%= lastSensorValue %></strong></span>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	<%
	StringBuffer sensorTypeSB = new StringBuffer();
	/** Format of Map: {"key1":"value1","key2":"value2"} **/ 
	sensorTypeSB.append(StringPool.OPEN_CURLY_BRACE);
	for (SensorType sensorType : sensorTypeList) {
		// Key
		sensorTypeSB.append(StringPool.APOSTROPHE);
		sensorTypeSB.append(sensorType.getSensorTypeId());
		sensorTypeSB.append(StringPool.APOSTROPHE);
		sensorTypeSB.append(StringPool.COLON);
		// Value
		sensorTypeSB.append(StringPool.APOSTROPHE);
		sensorTypeSB.append(sensorType.getIcon());
		sensorTypeSB.append(StringPool.APOSTROPHE);
		sensorTypeSB.append(StringPool.COMMA);
	}
	sensorTypeSB.deleteCharAt(sensorTypeSB.length()-1);
	sensorTypeSB.append(StringPool.CLOSE_CURLY_BRACE);
	%>
	
	var sensorTypeMap = <%= sensorTypeSB.toString() %>;

	A.one("#<portlet:namespace/>sensorTypeId").on('change',function() {
		A.one("#<portlet:namespace />sensorTypeIcon").attr('src', '/liferayofthings-core-portlet/img/common/icons/' + sensorTypeMap[this.get("value")]);
	})	
</aui:script>
