<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL");

if (Validator.isNull(redirect) && Validator.isNull(backURL)) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("groupId", String.valueOf(groupId));

	backURL = portletURL.toString();
}

Thing thing = (Thing)renderRequest.getAttribute(LRoTWebKeys.LROT_THING);

long thingId = BeanParamUtil.getLong(thing, request, "thingId");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("action", "viewActuators");
portletURL.setParameter("thingId", String.valueOf(thingId));
portletURL.setParameter("groupId", String.valueOf(groupId));
portletURL.setParameter("redirect", redirect);
%>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<aui:input name="actuatorIds" type="hidden" />

	<liferay-ui:header
		backURL="<%= backURL %>"
		localizeTitle="<%= false %>"
		title='<%= LanguageUtil.format(pageContext, "actuator.actuators-for-x", thing.getName(locale), false) %>'
	/>
	
	<aui:nav-bar>
		<aui:nav>
			<liferay-portlet:renderURL var="addActuatorURL">
				<portlet:param name="action" value="actuatorForm" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				<portlet:param name="thingId" value="<%= String.valueOf(thingId) %>" />
			</liferay-portlet:renderURL>
	
			<aui:nav-item href="<%= addActuatorURL %>" iconCssClass="icon-plus" label="actuator.add-actuator" />
		</aui:nav>
	</aui:nav-bar>
	
	<%
	RowChecker rowChecker = new com.liferay.portal.kernel.dao.search.RowChecker(renderResponse);
	%>
	
	<liferay-ui:search-container
		delta="20"
		deltaConfigurable="<%= false %>"
		emptyResultsMessage="actuator.no-actuators-are-configured-for-this-thing"
		iteratorURL="<%= portletURL %>"
		total="<%= ActuatorLocalServiceUtil.getActuatorsCount(thingId) %>"
		rowChecker="<%= rowChecker %>">
	
		<liferay-ui:search-container-results
			results="<%= ActuatorLocalServiceUtil.getActuators(thingId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>
	
		<liferay-ui:search-container-row
			className="com.lrexperts.liferay.liferayofthings.model.Actuator"
			escapedModel="<%= true %>"
			keyProperty="actuatorId"
			modelVar="actuator"
		>
			<liferay-portlet:renderURL var="rowURL">
				<portlet:param name="action" value="actuatorForm" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="actuatorId" value="<%= String.valueOf(actuator.getActuatorId()) %>" />
			</liferay-portlet:renderURL>
	
			<%@ include file="actuator_columns.jspf" %>
		</liferay-ui:search-container-row>
	
		<aui:button-row>
			<aui:button cssClass="delete-button" disabled="<%= true %>" name="delete" onClick='<%= renderResponse.getNamespace() + "deleteActuators();" %>' value="delete" />
		</aui:button-row>

		<div class="separator"><!-- --></div>
	
		<liferay-ui:search-iterator type="more" />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />delete', '#<portlet:namespace /><%= searchContainerReference.getId() %>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

	Liferay.provide(
		window,
		'<portlet:namespace />deleteActuators',
		function() {
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
				document.<portlet:namespace />fm.method = "post";
				document.<portlet:namespace />fm.<portlet:namespace />actuatorIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="action" value="deleteActuator" /></portlet:actionURL>");
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>
