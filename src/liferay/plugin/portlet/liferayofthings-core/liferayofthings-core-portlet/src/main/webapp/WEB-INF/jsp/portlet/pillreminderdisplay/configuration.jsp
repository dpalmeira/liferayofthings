<%@ include file="/WEB-INF/jsp/portlet/pillreminderdisplay/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%
String sensorEndpoint_cfg = GetterUtil.getString(portletPreferences.getValue("sensorEndpoint", StringPool.BLANK));
%>

<aui:form action="${configurationURL}" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:field-wrapper cssClass="lfr-user-profile-preferences">
		<aui:column>
			<aui:input name="preferences--sensorEndpoint--" type="text" value="<%= sensorEndpoint_cfg %>"
				label='<%= LanguageUtil.get(pageContext, "pillreminderdisplay.config.sensor-endpoint") %>' />
		</aui:column>
	</aui:field-wrapper>
	<br />
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
