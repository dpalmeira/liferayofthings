/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.rule.steps;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SampleRuleCategory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Brian Chan
 */
@Component(immediate = true, service = Rule.class)
public class StepsRule extends BaseRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		boolean result = Boolean.FALSE;
		
		// Insert logic that retrieves the value you stored in the type settings, using the processRule method. 
		final JSONObject jsonObj = JSONFactoryUtil.createJSONObject(ruleInstance.getTypeSettings());
		
		try {
			final long moreStepsThan = Long.parseLong(jsonObj.getString("moreStepsThan"));

			// TODO: use the user "my wereables".
			final long companyId = PortalUtil.getCompanyId(request);
			final long groupId = PortalUtil.getScopeGroupId(request);
			final String endpoint = "steps";
			
			Sensor sensor = SensorLocalServiceUtil.getSensorByEndpoint(companyId, groupId, endpoint, Boolean.TRUE);

			if (_log.isDebugEnabled()) {
				_log.debug("Sensor found ? " + (sensor!=null)
					+ " | companyId: " + companyId
					+ " | groupId: " + groupId
					+ " | endpoint: " + endpoint
					);
			}
			if (sensor!=null) {
				SensorValue sensorValue = SensorValueLocalServiceUtil.getLastSensorValue(sensor.getSensorId());
				final long lastData = Long.parseLong(sensorValue.getValue());
				result = (lastData >= moreStepsThan);
			}
			else {
				_log.error("Sensor NOT found, or disabled!"
						+ " | companyId: " + companyId
						+ " | groupId: " + groupId
						+ " | endpoint: " + endpoint);
			}
			
		} catch (Exception ex) {
			_log.error("Please check moreStepsThan value!");
		}
		return result;
	}

	@Override
	public String getIcon() {
		return "icon-male";
	}

	@Override
	public String getRuleCategoryKey() {
		return SampleRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return LanguageUtil.get(locale, ruleInstance.getTypeSettings());
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		String moreStepsThan = GetterUtil.getString(values.get("moreStepsThan"));
		
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		
		jsonObj.put("moreStepsThan", moreStepsThan);
		
		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {
		
	    String moreStepsThan = "0";

	    if (!values.isEmpty()) {
	    	moreStepsThan = values.get("moreStepsThan");
	    }
	    else if (ruleInstance != null) {
	    	try{
	    		moreStepsThan = JSONFactoryUtil.createJSONObject(ruleInstance.getTypeSettings()).getString("moreStepsThan");
	    	} catch (Exception ex) {
	    		// 
	    	}
	    }
	    
	    context.put("moreStepsThan", moreStepsThan);
	}

	private static final Log _log = LogFactoryUtil.getLog(StepsRule.class);

}