<%@ include file="/WEB-INF/jsp/portlet/lrotadmin/init.jsp"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("action", "view");
portletURL.setParameter("groupId", String.valueOf(groupId));
%>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
	<aui:input name="thingGroupIds" type="hidden" />

	<aui:nav-bar>
		<liferay-portlet:renderURL var="addThingGroupURL">
			<portlet:param name="action" value="thingGroupForm" />
			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="backURL" value="<%= portletURL.toString() %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
		</liferay-portlet:renderURL>

		<aui:nav>
			<aui:nav-item href="<%= addThingGroupURL %>" iconCssClass="icon-plus" label="lrotadmin.add-thing-group" />
		</aui:nav>
	</aui:nav-bar>
	
	<%
	RowChecker rowChecker = new com.liferay.portal.kernel.dao.search.RowChecker(renderResponse);
	%>
	
	<liferay-ui:search-container
		delta="20"
		emptyResultsMessage="<%= LanguageUtil.get(pageContext, \"lrotadmin.no-results\") %>"
		rowChecker="<%= rowChecker %>">

		<liferay-ui:search-container-results >
			<%
		    List<ThingGroup> thingGroups = (List<ThingGroup>)request.getAttribute(LRoTWebKeys.LROT_THING_GROUP_LIST);
		    results = ListUtil.subList(thingGroups, searchContainer.getStart(), searchContainer.getEnd());
		    total = thingGroups.size();
		
		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
		
	    <liferay-ui:search-container-row
	            className="com.lrexperts.liferay.liferayofthings.model.ThingGroup"
	            keyProperty="primaryKey"
	            modelVar="thingGroup">

			<liferay-portlet:renderURL var="rowURL">
				<portlet:param name="action" value="thingGroupForm" />
				<portlet:param name="thingGroupId" value="<%= String.valueOf(thingGroup.getThingGroupId()) %>" />
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				<portlet:param name="backURL" value="<%= portletURL.toString() %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
			</liferay-portlet:renderURL>

			<%@ include file="thing_group_columns.jspf" %>
	    </liferay-ui:search-container-row>
		
		<aui:button-row>
			<aui:button cssClass="delete-button" disabled="<%= true %>" name="delete" onClick='<%= renderResponse.getNamespace() + "deleteThingGroups();" %>' value="delete" />
		</aui:button-row>

		<div class="separator"><!-- --></div>

		<liferay-ui:search-iterator type="more" />
		
	</liferay-ui:search-container>

</aui:form>

<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />delete', '#<portlet:namespace /><%= searchContainerReference.getId() %>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

	Liferay.provide(
		window,
		'<portlet:namespace />deleteThingGroups',
		function() {
			if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-delete-this") %>')) {
				document.<portlet:namespace />fm.method = "post";
				document.<portlet:namespace />fm.<portlet:namespace />thingGroupIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="action" value="deleteThingGroup" /></portlet:actionURL>");
			}
		},
		['liferay-util-list-fields']
	);
</aui:script>
