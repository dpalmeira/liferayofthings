package com.lrexperts.liferay.liferayofthings.portlet.lrotadmin;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * @author Diego A. Palmeira
 */
public class LRoTAdminPanelEntry extends BaseControlPanelEntry {

	@Override
	protected boolean hasAccessPermissionDenied(
			PermissionChecker permissionChecker, Group group, Portlet portlet)
		throws Exception {

		if (group.isUser() || group.isLayoutSetPrototype() ||
			!GroupPermissionUtil.contains(
				permissionChecker, group.getGroupId(), ActionKeys.UPDATE)) {

			return true;
		}

		return false;
	}

}
