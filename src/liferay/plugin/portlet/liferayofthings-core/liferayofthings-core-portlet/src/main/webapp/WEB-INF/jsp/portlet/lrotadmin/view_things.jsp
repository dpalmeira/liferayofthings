<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL");

if (Validator.isNull(redirect) && Validator.isNull(backURL)) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("groupId", String.valueOf(groupId));

	backURL = portletURL.toString();
}

ThingGroup thingGroup = (ThingGroup)renderRequest.getAttribute(LRoTWebKeys.LROT_THING_GROUP);

long thingGroupId = BeanParamUtil.getLong(thingGroup, request, "thingGroupId");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("action", "viewThings");
portletURL.setParameter("thingGroupId", String.valueOf(thingGroupId));
portletURL.setParameter("groupId", String.valueOf(groupId));
portletURL.setParameter("redirect", redirect);
%>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<aui:input name="thingIds" type="hidden" />

	<liferay-ui:header
		backURL="<%= backURL %>"
		localizeTitle="<%= false %>"
		title='<%= LanguageUtil.format(pageContext, "thing.things-for-x", thingGroup.getName(locale), false) %>'
	/>
	
	<aui:nav-bar>
		<aui:nav>
			<liferay-portlet:renderURL var="addThingURL">
				<portlet:param name="action" value="thingForm" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroupId) %>" />
			</liferay-portlet:renderURL>
	
			<aui:nav-item href="<%= addThingURL %>" iconCssClass="icon-plus" label="thing.add-thing" />
		</aui:nav>
	</aui:nav-bar>
	
	<%
	RowChecker rowChecker = new com.liferay.portal.kernel.dao.search.RowChecker(renderResponse);
	%>
	
	<liferay-ui:search-container
		delta="20"
		deltaConfigurable="<%= false %>"
		emptyResultsMessage="thing.no-things-are-configured-for-this-thing-group"
		iteratorURL="<%= portletURL %>"
		total="<%= ThingLocalServiceUtil.getThingsCount(thingGroupId) %>"
		rowChecker="<%= rowChecker %>">
	
		<liferay-ui:search-container-results
			results="<%= ThingLocalServiceUtil.getThings(thingGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>
	
		<liferay-ui:search-container-row
			className="com.lrexperts.liferay.liferayofthings.model.Thing"
			escapedModel="<%= true %>"
			keyProperty="thingId"
			modelVar="thing">

			<liferay-portlet:renderURL var="rowURL">
				<portlet:param name="action" value="thingForm" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="thingId" value="<%= String.valueOf(thing.getThingId()) %>" />
			</liferay-portlet:renderURL>
	
			<%@ include file="thing_columns.jspf" %>
		</liferay-ui:search-container-row>
	
		<aui:button-row>
			<aui:button cssClass="delete-button" disabled="<%= true %>" name="delete" onClick='<%= renderResponse.getNamespace() + "deleteThings();" %>' value="delete" />
		</aui:button-row>

		<div class="separator"><!-- --></div>
	
		<liferay-ui:search-iterator type="more" />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />delete', '#<portlet:namespace /><%= searchContainerReference.getId() %>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

	Liferay.provide(
		window,
		'<portlet:namespace />deleteThings',
		function() {
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
				document.<portlet:namespace />fm.method = "post";
				document.<portlet:namespace />fm.<portlet:namespace />thingIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL><portlet:param name="action" value="deleteThing" /></portlet:actionURL>');
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>
