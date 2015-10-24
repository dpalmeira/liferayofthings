<%@ include file="/WEB-INF/jsp/portlet/fitbit/init.jsp"%>

<portlet:actionURL var="setupOAuthURL">
	<portlet:param name="action" value="setupOAuth" />
</portlet:actionURL>

<%
Token requestToken = OAuthUtil.getRequestToken(setupOAuthURL);

portletSession.setAttribute(Token.class.getName(), requestToken);
%>
<div class="button-container"%>
	<a class="lcs-portal-link" href="<%= OAuthUtil.getAuthorizeURL(requestToken) %>"><liferay-ui:message key="fitbit.authorize-access"/></a>
	<%--
	<br/><br/>
	<a class="lcs-portal-link" href="<%= setupOAuthURL %>"><liferay-ui:message key="save"/></a>
	--%>
</div>
