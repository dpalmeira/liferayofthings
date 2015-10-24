<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

Actuator actuator = (Actuator)renderRequest.getAttribute(LRoTWebKeys.LROT_ACTUATOR);

long actuatorId = BeanParamUtil.getLong(actuator, request, "actuatorId");

String title = LanguageUtil.get(pageContext, "actuator.push-message") + " (" + actuator.getName(locale) + ")";
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

<portlet:actionURL  var="pushMessageActuatorURL">
	<portlet:param name="action" value="pushMessageActuator"/>
</portlet:actionURL>

<aui:form action="<%= pushMessageActuatorURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="actuatorId" type="hidden" value="<%= actuatorId %>" />

	<liferay-ui:error exception="<%= NoSuchActuatorException.class %>" message="actuator.actuator-does-not-exist" />

	<aui:fieldset>
		<aui:input name="message" type="textarea" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="actuator.push-message" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>
