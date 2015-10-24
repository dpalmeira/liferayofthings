<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<%@ taglib prefix="aui"  uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="liferay-portlet"  uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security"  %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"  %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util"  %>

<%@ page import="com.liferay.portal.NoSuchUserException" %>

<%@ page import="com.liferay.portal.kernel.configuration.Filter" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.*" %>

<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>

<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageWrapper" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>


<%@ page import="com.liferay.portal.kernel.util.*" %>

<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.model.*" %>
<%@ page import="com.liferay.portal.model.impl.*" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.security.permission.PermissionThreadLocal" %>

<%@ page import="com.liferay.portal.service.*" %>

<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.LayoutPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.LayoutPrototypePermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.LayoutSetPrototypePermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>

<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.liferay.portal.util.*" %>

<%@ page import="com.liferay.portlet.*" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portlet.PortletConfigFactoryUtil" %>
<%@ page import="com.liferay.portlet.PortletInstanceFactoryUtil" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>

<%@ page import="com.liferay.util.*" %>

<%@ page import="java.io.Serializable" %>


<%@ page import="java.net.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.PortletConfig" %>
<%@ page import="javax.portlet.PortletContext" %>
<%@ page import="javax.portlet.PortletException" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.ResourceURL" %>
<%@ page import="javax.portlet.UnavailableException" %>
<%@ page import="javax.portlet.ValidatorException" %>
<%@ page import="javax.portlet.WindowState" %>

<%@ page import="org.springframework.context.MessageSource" %>

<%@ page import="org.joda.time.DateTime" %>

<%@ page import="com.lrexperts.liferay.liferayofthings.util.LRoTWebKeys" %>

<liferay-theme:defineObjects />
<%-- 
defineObjectes define the next objects list:

themeDisplay
company=themeDisplay.getCompany()
account=themeDisplay.getAccount()
user=themeDisplay.getUser()
realUser=themeDisplay.getRealUser()
contact=themeDisplay.getContact()
layout=themeDisplay.getLayout()
layouts=themeDisplay.getLayouts()
plid=new Long(themeDisplay.getPlid())
layoutTypePortlet=themeDisplay.getLayoutTypePortlet()
scopeGroupId=new Long(themeDisplay.getScopeGroupId())
permissionChecker=themeDisplay.getPermissionChecker()
locale=themeDisplay.getLocale()
timeZone=themeDisplay.getTimeZone()
theme=themeDisplay.getTheme()
colorScheme=themeDisplay.getColorScheme()
portletDisplay=themeDisplay.getPortletDisplay()
portletGroupId=new Long(themeDisplay.getScopeGroupId())
 --%>
<portlet:defineObjects/>