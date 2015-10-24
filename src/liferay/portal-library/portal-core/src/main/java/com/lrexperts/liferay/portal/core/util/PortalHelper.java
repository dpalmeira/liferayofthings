package com.lrexperts.liferay.portal.core.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class PortalHelper.
 * 
 * @author Diego A. Palmeira
 */
public class PortalHelper {

	/** The Constant log. */
	private static final Log log = LogFactory.getLog(PortalHelper.class);

	/**
	 * Gets the members emails.
	 * 
	 * @param groupId
	 *            the group id
	 * @return the members emails
	 * @throws SystemException
	 *             the system exception
	 */
	public static Set<String> getMembersEmails(Long groupId)
			throws SystemException {

		Set<String> toUserEmails = new HashSet<String>();

        /** Get web site Users members **/
        List<User> userList = UserLocalServiceUtil.getGroupUsers(groupId);


		if (log.isDebugEnabled()) {
			log.debug("Users for this WebSite: " + userList.size());
		}

		for (User user : userList) {
			if (log.isDebugEnabled()) {
				log.debug("User: " + user.getFullName() + " | UserId: "
						+ user.getUserId() + " | Email: "
						+ user.getEmailAddress());
			}
			toUserEmails.add(user.getEmailAddress());
		}

		/** Get UserGroups members **/
		long companyId = CompanyThreadLocal.getCompanyId();
		LinkedHashMap<String, Object> userGroupParams = new LinkedHashMap<String, Object>();
		userGroupParams.put("userGroupsGroups", groupId);

		List<UserGroup> userGroupList = UserGroupLocalServiceUtil.search(
				companyId, null, userGroupParams, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, (OrderByComparator) null);
		if (log.isDebugEnabled()) {
			log.debug("UserGroups for this WebSite: " + userGroupList.size());
		}

		for (UserGroup userGroup : userGroupList) {
			if (log.isDebugEnabled()) {
				log.debug("UserGroup: " + userGroup.getName());
			}

			userList = UserLocalServiceUtil.getUserGroupUsers(userGroup
					.getUserGroupId());
			if (log.isDebugEnabled()) {
				log.debug("Users for UserGroup " + userGroup.getName() + ": "
						+ userList.size());
			}

			for (User user : userList) {
				if (log.isDebugEnabled()) {
					log.debug("User: " + user.getFullName() + " | UserId: "
							+ user.getUserId() + " | Email: "
							+ user.getEmailAddress());
				}
				toUserEmails.add(user.getEmailAddress());
			}
		}

		/** Get Organizations members **/
        List<Organization> organizationList = OrganizationLocalServiceUtil.getOrganizations(companyId, OrganizationConstants.ANY_PARENT_ORGANIZATION_ID);

		if (log.isDebugEnabled()) {
			log.debug("Organizations for this WebSite: "
					+ organizationList.size());
		}

		for (Organization organization : organizationList) {
			if (log.isDebugEnabled()) {
				log.debug("Organization: " + organization.getName());
			}

			userList = UserLocalServiceUtil.getOrganizationUsers(organization
					.getOrganizationId());
			if (log.isDebugEnabled()) {
				log.debug("Users for Organization " + organization.getName()
						+ ": " + userList.size());
			}

			for (User user : userList) {
				if (log.isDebugEnabled()) {
					log.debug("User: " + user.getFullName() + " | UserId: "
							+ user.getUserId() + " | Email: "
							+ user.getEmailAddress());
				}
				toUserEmails.add(user.getEmailAddress());
			}
		}

		return toUserEmails;
	}

	public static Set<User> getMembers(Long groupId) throws SystemException {

		Set<User> usersMembers = new HashSet<User>();

		/** Get web site Users members **/
		List<User> userList = UserLocalServiceUtil.getGroupUsers(groupId);

		if (log.isDebugEnabled()) {
			log.debug("Users for this WebSite: " + userList.size());
		}

		for (User user : userList) {
			if (log.isDebugEnabled()) {
				log.debug("User: " + user.getFullName() + " | UserId: "
						+ user.getUserId() + " | Email: "
						+ user.getEmailAddress());
			}
			usersMembers.add(user);
		}

		/** Get UserGroups members **/
		long companyId = CompanyThreadLocal.getCompanyId();
		LinkedHashMap<String, Object> userGroupParams = new LinkedHashMap<String, Object>();
		userGroupParams.put("userGroupsGroups", groupId);

		List<UserGroup> userGroupList = UserGroupLocalServiceUtil.search(
				companyId, null, userGroupParams, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, (OrderByComparator) null);
		if (log.isDebugEnabled()) {
			log.debug("UserGroups for this WebSite: " + userGroupList.size());
		}

		for (UserGroup userGroup : userGroupList) {
			if (log.isDebugEnabled()) {
				log.debug("UserGroup: " + userGroup.getName());
			}

			userList = UserLocalServiceUtil.getUserGroupUsers(userGroup
					.getUserGroupId());
			if (log.isDebugEnabled()) {
				log.debug("Users for UserGroup " + userGroup.getName() + ": "
						+ userList.size());
			}

			for (User user : userList) {
				if (log.isDebugEnabled()) {
					log.debug("User: " + user.getFullName() + " | UserId: "
							+ user.getUserId() + " | Email: "
							+ user.getEmailAddress());
				}
				usersMembers.add(user);
			}
		}

		/** Get Organizations members **/

		List<Organization> organizationList = OrganizationLocalServiceUtil.getOrganizations(companyId,OrganizationConstants.ANY_PARENT_ORGANIZATION_ID);

		if (log.isDebugEnabled()) {
			log.debug("Organizations for this WebSite: "
					+ organizationList.size());
		}

		for (Organization organization : organizationList) {
			if (log.isDebugEnabled()) {
				log.debug("Organization: " + organization.getName());
			}

			userList = UserLocalServiceUtil.getOrganizationUsers(organization
					.getOrganizationId());
			if (log.isDebugEnabled()) {
				log.debug("Users for Organization " + organization.getName()
						+ ": " + userList.size());
			}

			for (User user : userList) {
				if (log.isDebugEnabled()) {
					log.debug("User: " + user.getFullName() + " | UserId: "
							+ user.getUserId() + " | Email: "
							+ user.getEmailAddress());
				}
				usersMembers.add(user);
			}
		}

		return usersMembers;
	}

	public static Set<String> getTargetMailsByTeamId(long teamId, long companyId)
			throws SystemException {
		Set<String> emailMembers = new HashSet<String>();
		LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
		userParams.put("usersTeams", teamId);

		List<User> teamUsers = UserLocalServiceUtil.search(companyId, null,
				WorkflowConstants.STATUS_ANY, userParams, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, (OrderByComparator) null);
		for (User user : teamUsers) {
			emailMembers.add(user.getEmailAddress());
		}
		return emailMembers;
	}

	public static Set<String> getTargetMailsByRoleId(long roleId, long groupId)
			throws SystemException, PortalException {
		Role role = RoleLocalServiceUtil.getRole(roleId);
		Set<String> emailMembers = new HashSet<String>();
		for (User usuario : UserLocalServiceUtil.getGroupUsers(groupId)) {
			if (usuario.getRoles().contains(role)) {
				emailMembers.add(usuario.getEmailAddress());
			}
			if (RoleLocalServiceUtil.getUserGroupRoles(usuario.getUserId(),
					groupId).contains(role)) {
				emailMembers.add(usuario.getEmailAddress());
			}
		}
		return emailMembers;
	}

	public static Set<String> getTargetMailsByUserGroupId(long userGroupId,
			long groupId) throws SystemException, PortalException {
		Group grupo = GroupLocalServiceUtil.getGroup(groupId);
		Set<String> emailMembers = new HashSet<String>();
		for (User user : UserLocalServiceUtil.getUserGroupUsers(userGroupId)) {
			if (user.getGroups().contains(grupo)) {
				emailMembers.add(user.getEmailAddress());
			}
		}
		return emailMembers;
	}

	/**
	 * Gets the theme display.
	 * 
	 * @param request
	 *            the request
	 * @return the theme display
	 */
	public static ThemeDisplay getThemeDisplay(HttpServletRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Gets the theme display.
	 * 
	 * @param portletRequest
	 *            the portlet request
	 * @return the theme display
	 */
	public static ThemeDisplay getThemeDisplay(PortletRequest portletRequest) {
		return getThemeDisplay(PortalUtil.getHttpServletRequest(portletRequest));
	}

	/**
	 * Gets the portlet config.
	 * 
	 * @param portletRequest
	 *            the portlet request
	 * @return the portlet config
	 */
	public static PortletConfig getPortletConfig(PortletRequest portletRequest) {
		return (PortletConfig) portletRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	}

	/**
	 * Gets the web site pages.
	 * 
	 * @param request
	 *            the request
	 * @return the web site pages
	 */
	public static List<Option> getWebSitePages(PortletRequest request) {
		List<Option> webSitePages = new ArrayList<Option>();
		Map<Long, String> pagesMap = getWebSitePagesMap(request);
		for (Entry<Long, String> page : pagesMap.entrySet()) {
			webSitePages.add(new Option(String.valueOf(page.getKey()), page
					.getValue()));
		}
		return webSitePages;
	}

	/**
	 * Gets the web site pages map. This method has been implemented as the jsp
	 * file draws the pages in
	 * portal-web/docroot/html/portal/layout/edit/portlet.jsp
	 * 
	 * @param portletRequest
	 *            the request
	 * @return the web site pages map
	 */
	public static Map<Long, String> getWebSitePagesMap(
			PortletRequest portletRequest) {

		Map<Long, String> webSitePages = new LinkedHashMap<Long, String>();
		try {
			ThemeDisplay td = getThemeDisplay(portletRequest);
			Group group = td.getScopeGroup();

			if (group.hasPublicLayouts()) {
				addPages(webSitePages, group.getGroupId(), false,
						group.getDescriptiveName(), td.getLocale());
			}

			if (group.hasPrivateLayouts()) {
				addPages(webSitePages, group.getGroupId(), true,
						group.getDescriptiveName(), td.getLocale());
			}
		} catch (PortalException e) {
			log.error("Error getting layout lister", e);
		} catch (SystemException e) {
			log.error("Error getting layout lister", e);
		}

		return webSitePages;
	}

	/**
	 * Adds the pages.
	 * 
	 * @param webSitePages
	 *            the web site pages
	 * @param groupId
	 *            the group id
	 * @param isPrivate
	 *            the is private
	 * @param rootNode
	 *            the root node
	 * @param locale
	 *            the locale
	 * @throws PortalException
	 *             the portal exception
	 * @throws SystemException
	 *             the system exception
	 */
	private static void addPages(Map<Long, String> webSitePages, long groupId,
			boolean isPrivate, String rootNode, Locale locale)
			throws PortalException, SystemException {

		LayoutView layoutView = new LayoutLister().getLayoutView(groupId,
				isPrivate, rootNode, locale);

		List<String> layoutList = layoutView.getList();

		String type = isPrivate ? " (priv)" : " (pub)";

		for (int i = 0; i < layoutList.size(); i++) {

			// id | parentId | ls | obj id | name | img | depth

			if (i == 0) {

			}

			String layoutDesc = (String) layoutList.get(i);

			String[] nodeValues = StringUtil.split(layoutDesc, "|");

			long objId = GetterUtil.getLong(nodeValues[3]);
			String name = nodeValues[4];

			int depth = 0;

			if (i != 0) {
				depth = GetterUtil.getInteger(nodeValues[6]);
			}

			name = HtmlUtil.escape(name);

			for (int j = 0; j < depth; j++) {
				name = "-" + name;
			}

			Layout copiableLayout = null;

			try {
				copiableLayout = LayoutLocalServiceUtil.getLayout(objId);
			} catch (Exception e) {
			}

			if (copiableLayout != null) {

				webSitePages.put(copiableLayout.getLayoutId(), name + type);

			}
		}
	}

    /**
     *
     * Gets the portal url.
     *
     * @return the portal url
     */
    public static String getPortalURL(long groupId) {
        try {
            Group group = GroupLocalServiceUtil.getGroup(groupId);
            long companyId = group.getCompanyId();
            Company company = CompanyLocalServiceUtil.getCompany(companyId);
            return company.getPortalURL(groupId);
        } catch (PortalException e) {
            log.error("Error getting portal url for group "+groupId,e);
        } catch (SystemException e) {
            log.error("Error getting portal url for group "+groupId,e);
        }
        return "";
    }

	/**
	 * Gets the Website default public url.
	 * 
	 * @return the default public url.
	 */
	public static String getWebsiteDefaultPublicURL(
			PortletRequest portletRequest, Group group) {
		return getWebsiteDefaultURL(portletRequest, group, Boolean.FALSE);
	}

	/**
	 * Gets the Website default private url.
	 * 
	 * @return the default private url.
	 */
	public static String getWebsiteDefaultPrivateURL(
			PortletRequest portletRequest, Group group) {
		return getWebsiteDefaultURL(portletRequest, group, Boolean.TRUE);
	}

	/**
	 * Gets the Website default public/private url.
	 * 
	 * @return the default public/private url.
	 */
	private static String getWebsiteDefaultURL(PortletRequest portletRequest,
			Group group, boolean privateLayout) {
		String siteDefaultURL = StringPool.BLANK;
		try {
			long defaultPlid = privateLayout ? group.getDefaultPrivatePlid()
					: group.getDefaultPublicPlid();
			LiferayPortletURL mySitesPortletURL = PortletURLFactoryUtil.create(
					portletRequest, "49", defaultPlid, "ACTION_PHASE");
			mySitesPortletURL.setWindowState(LiferayWindowState.NORMAL);
			mySitesPortletURL.setPortletMode(LiferayPortletMode.VIEW);

			mySitesPortletURL.setParameter("struts_action", "/my_sites/view");
			mySitesPortletURL.setParameter("groupId",
					String.valueOf(group.getGroupId()));
			mySitesPortletURL.setParameter("privateLayout",
					String.valueOf(privateLayout));

			siteDefaultURL = HtmlUtil.escape(mySitesPortletURL.toString());

		} catch (WindowStateException e) {
			log.error("WindowState error: ", e);
		} catch (PortletModeException e) {
			log.error("Portlet Mode error: ", e);
		}
		return siteDefaultURL;
	}

	/**
	 * Gets the layout.
	 * 
	 * @param layoutId
	 *            the layout id
	 * @param groupId
	 *            the group id
	 * @return the layout
	 */
	public static Layout getLayout(long layoutId, long groupId) {
		Layout layout = null;
		// try to find the layout, first in privateGroup, and then in
		// publicGroup
		try {
			layout = LayoutLocalServiceUtil.getLayout(groupId, true, layoutId);
			log.debug("layout is private, layoutId/groupId " + layoutId + "/"
					+ groupId);
		} catch (Exception e) {
			// try to find the layout in the public group
			try {
				layout = LayoutLocalServiceUtil.getLayout(groupId, false,
						layoutId);
				log.debug("layout is public, layoutId/groupId " + layoutId
						+ "/" + groupId);
			} catch (Exception e1) {
				log.debug("layoutId not found in public group, layoutId/groupId "
						+ layoutId + "/" + groupId);
			}
		}
		return layout;

	}

	/**
	 * Gets the element value.
	 * 
	 * @param content
	 *            the content
	 * @param elName
	 *            the el name
	 * @param attName
	 *            the att name
	 * @return the element value
	 */
	public static String getJournalArticleElementValue(String content,
			String elName, String attName) {
		Document doc;
		try {
			doc = SAXReaderUtil.read(content);
		} catch (DocumentException e) {
			return null;
		}
		XPath xpathSelector = SAXReaderUtil
				.createXPath("//dynamic-element[@name='" + elName + "']");
		List<Node> results = xpathSelector.selectNodes(doc);
		if (results.size() > 0) {
			Element el = (Element) results.get(0);
			if (Validator.isNull(attName))
				content = el.elementText("dynamic-content");
			else
				content = el.attributeValue(attName);
		} else
			return null;

		return content;
	}

	public static User getPortalAdminUser(long companyId)
			throws PortalException, SystemException {

		String adminScreenName = PropsUtil
				.get(PropsKeys.DEFAULT_ADMIN_SCREEN_NAME);
		return UserLocalServiceUtil.getUserByScreenName(companyId,
				adminScreenName);
	}

}
