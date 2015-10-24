package com.lrexperts.liferay.liferayofthings.portlet.lrotadmin;

import com.lrexperts.liferay.portlet.core.controllers.BasePortletController;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util.MosquittoConstants;
import com.lrexperts.liferay.liferayofthings.manager.util.LRoTManagerUtil;
import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.model.ActuatorType;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.SensorType;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.util.LRoTWebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author Diego A. Palmeira
 */
@Controller()
@RequestMapping("VIEW")
public class LRoTAdminController extends BasePortletController {

	private static final Log _log = LogFactory.getLog(LRoTAdminController.class);

	private static final String PORTLET_PAGE_URL = "portlet/lrotadmin";

	@Override
	protected String portletBaseViewName() {
		return PORTLET_PAGE_URL;
	}

	/********************************
	 * Thing Group 
	 ********************************/
	
	@RequestMapping
	public ModelAndView defaultView(
			final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final @ModelAttribute(PORTLET_SETUP) PortletPreferences portletSetup,
			final RenderRequest request,
			final Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("defaultView");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long companyId = themeDisplay.getCompanyId();
		final long groupId = themeDisplay.getScopeGroupId();
		
		final List<ThingGroup> thingGroupList = ThingGroupLocalServiceUtil.getThingGroups(companyId, groupId);
		modelMap.put(LRoTWebKeys.LROT_THING_GROUP_LIST, thingGroupList);

		return new ModelAndView(fullViewname("view"), modelMap);
	}

	@RenderMapping(params = "action=thingGroupForm")
	public ModelAndView thingGroupForm(final RenderRequest renderRequest, final Model model)
			throws SystemException, PortalException {

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long thingGroupId = ParamUtil.getLong(renderRequest, "thingGroupId");

		// TODO: Use ThingGroupServiceUtil and implement permissions.
		final ThingGroup thingGroup = ThingGroupLocalServiceUtil.fetchThingGroup(thingGroupId);

		renderRequest.setAttribute(LRoTWebKeys.LROT_THING_GROUP, thingGroup);
		
		return new ModelAndView(fullViewname("edit_thing_group"), modelMap);
	}

	@ActionMapping(params = "action=addThingGroup")
	public void addThingGroup(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
				throws PortletException, SystemException, PortalException {

		try {
			final ThingGroup thingGroup = updateThingGroup(actionRequest);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "thingGroupForm");
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}

	@ActionMapping(params = "action=editThingGroup")
	public void editThingGroup(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {

		try {
			final ThingGroup thingGroup = updateThingGroup(actionRequest);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "thingGroupForm");				
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}
	
	@ActionMapping(params = "action=deleteThingGroup")
	public void deleteThingGroup(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {
		
		long[] deleteThingGroupIds = null;

		final long thingGroupId = ParamUtil.getLong(actionRequest, "thingGroupId");

		if (thingGroupId > 0) {
			deleteThingGroupIds = new long[] {thingGroupId};
		}
		else {
			deleteThingGroupIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "thingGroupIds"), 0L);
		}

		for (long deleteThingGroupId : deleteThingGroupIds) {
			ThingGroupLocalServiceUtil.deleteThingGroup(deleteThingGroupId);
		}		
		
	}
	
	protected ThingGroup updateThingGroup(final ActionRequest actionRequest) throws Exception {

		final long thingGroupId = ParamUtil.getLong(actionRequest, "thingGroupId");

		final long groupId = ParamUtil.getLong(actionRequest, "groupId");
			
		final Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		final Map<Locale, String> descriptionMap = 
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		final boolean enabled = ParamUtil.getBoolean(actionRequest, "enabled"); 

		final ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		ThingGroup thingGroup = null;

		if (thingGroupId <= 0) {
			thingGroup = ThingGroupLocalServiceUtil.addThingGroup(
				groupId, nameMap, descriptionMap, enabled, serviceContext);
		}
		else {
			thingGroup = ThingGroupLocalServiceUtil.updateThingGroup(
					thingGroupId, nameMap, descriptionMap, enabled, serviceContext);
		}

		return thingGroup;
	}

	/********************************
	 * Thing 
	 ********************************/

	@RequestMapping(params = "action=viewThings")
	public ModelAndView viewThings(
			final @ModelAttribute(PORTLET_SETUP) PortletPreferences portletSetup,
			final RenderRequest renderRequest,
			final Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("viewThings");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long thingGroupId = ParamUtil.getLong(renderRequest, "thingGroupId");

		// TODO: Use ThingGroupServiceUtil and implement permissions.
		final ThingGroup thingGroup = ThingGroupLocalServiceUtil.fetchThingGroup(thingGroupId);

		renderRequest.setAttribute(LRoTWebKeys.LROT_THING_GROUP, thingGroup);
		
		return new ModelAndView(fullViewname("view_things"), modelMap);
	}
	
	@RenderMapping(params = "action=thingForm")
	public ModelAndView thingForm(final RenderRequest renderRequest, final Model model)
			throws SystemException, PortalException {

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long thingId = ParamUtil.getLong(renderRequest, "thingId");
		final Thing thing = ThingLocalServiceUtil.fetchThing(thingId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_THING, thing);

		final long thingGroupId = BeanParamUtil.getLong(thing, renderRequest, "thingGroupId");
		final ThingGroup thingGroup = ThingGroupLocalServiceUtil.getThingGroup(thingGroupId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_THING_GROUP, thingGroup);
		
		return new ModelAndView(fullViewname("edit_thing"), modelMap);
	}

	@ActionMapping(params = "action=addThing")
	public void addThing(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
				throws PortletException, SystemException, PortalException {

		try {
			final Thing thing = updateThing(actionRequest);

			actionResponse.setRenderParameter("thingGroupId", String.valueOf(thing.getThingGroupId()));
			actionResponse.setRenderParameter("action", "viewThings");			
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "thingForm");				
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}

	@ActionMapping(params = "action=editThing")
	public void editThing(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {

		try {
			final Thing thing = updateThing(actionRequest);

			actionResponse.setRenderParameter("thingGroupId", String.valueOf(thing.getThingGroupId()));
			actionResponse.setRenderParameter("action", "viewThings");				
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "thingForm");
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}

	}
	
	@ActionMapping(params = "action=deleteThing")
	public void deleteThing(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {
		
		long[] deleteThingIds = null;

		final long thingId = ParamUtil.getLong(actionRequest, "thingId");

		if (thingId > 0) {
			deleteThingIds = new long[] {thingId};
		}
		else {
			deleteThingIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "thingIds"), 0L);
		}

		Thing thing = null; 

		for (long deleteThingId : deleteThingIds) {
			thing = ThingLocalServiceUtil.deleteThing(deleteThingId);
		}		

		actionResponse.setRenderParameter("thingGroupId", String.valueOf(thing.getThingGroupId()));
		actionResponse.setRenderParameter("action", "viewThings");
	}
	
	protected Thing updateThing(final ActionRequest actionRequest) throws Exception {

		final long thingId = ParamUtil.getLong(actionRequest, "thingId");

		final long thingGroupId = ParamUtil.getLong(actionRequest, "thingGroupId");
		
		final Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		final Map<Locale, String> descriptionMap = 
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		final String endpoint = ParamUtil.getString(actionRequest, "endpoint");
		
		final boolean enabled = ParamUtil.getBoolean(actionRequest, "enabled"); 

		final int status = ParamUtil.getInteger(actionRequest, "status"); 

		final ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		Thing thing = null;

		if (thingId <= 0) {
			thing = ThingLocalServiceUtil.addThing(
					thingGroupId, nameMap, descriptionMap, endpoint, enabled, status, serviceContext);
		}
		else {
			thing = ThingLocalServiceUtil.updateThing(
					thingId, nameMap, descriptionMap, endpoint, enabled, status, serviceContext);
		}

		return thing;
	}

	/********************************
	 * Sensor 
	 ********************************/

	@RequestMapping(params = "action=viewSensors")
	public ModelAndView viewSensors(
			final @ModelAttribute(PORTLET_SETUP) PortletPreferences portletSetup,
			final RenderRequest renderRequest,
			final Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("viewSensors");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long thingId = ParamUtil.getLong(renderRequest, "thingId");

		// TODO: Use ThingServiceUtil and implement permissions.
		final Thing thing = ThingLocalServiceUtil.fetchThing(thingId);

		renderRequest.setAttribute(LRoTWebKeys.LROT_THING, thing);
		
		return new ModelAndView(fullViewname("view_sensors"), modelMap);
	}
	
	@RenderMapping(params = "action=sensorForm")
	public ModelAndView sensorForm(final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final RenderRequest renderRequest,
			final Model model)
					throws SystemException, PortalException {

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long sensorId = ParamUtil.getLong(renderRequest, "sensorId");
		final Sensor sensor = SensorLocalServiceUtil.fetchSensor(sensorId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_SENSOR, sensor);

		final long thingId = BeanParamUtil.getLong(sensor, renderRequest, "thingId");
		final Thing thing = ThingLocalServiceUtil.getThing(thingId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_THING, thing);

		final long companyId = themeDisplay.getCompanyId();
		final long groupId = themeDisplay.getScopeGroupId();

		final List<SensorType> sensorTypeList = SensorTypeLocalServiceUtil.getSensorTypes(companyId, groupId);
		modelMap.put(LRoTWebKeys.LROT_SENSOR_TYPE_LIST, sensorTypeList);
				
		return new ModelAndView(fullViewname("edit_sensor"), modelMap);
	}

	@ActionMapping(params = "action=addSensor")
	public void addSensor(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
				throws PortletException, SystemException, PortalException {

		try {
			final Sensor sensor = updateSensor(actionRequest);

			actionResponse.setRenderParameter("thingId", String.valueOf(sensor.getThingId()));
			actionResponse.setRenderParameter("action", "viewSensors");	
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "sensorForm");				
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}

	@ActionMapping(params = "action=editSensor")
	public void editSensor(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {

		try {
			final Sensor sensor = updateSensor(actionRequest);

			actionResponse.setRenderParameter("thingId", String.valueOf(sensor.getThingId()));
			actionResponse.setRenderParameter("action", "viewSensors");
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "sensorForm");
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}
	
	@ActionMapping(params = "action=deleteSensor")
	public void deleteSensor(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {
		
		long[] deleteSensorIds = null;

		final long sensorId = ParamUtil.getLong(actionRequest, "sensorId");

		if (sensorId > 0) {
			deleteSensorIds = new long[] {sensorId};
		}
		else {
			deleteSensorIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "sensorIds"), 0L);
		}

		Sensor sensor = null;

		for (long deleteSensorId : deleteSensorIds) {
			sensor = SensorLocalServiceUtil.deleteSensor(deleteSensorId);
		}		

		actionResponse.setRenderParameter("thingId", String.valueOf(sensor.getThingId()));
		actionResponse.setRenderParameter("action", "viewSensors");
	}
	
	protected Sensor updateSensor(final ActionRequest actionRequest) throws Exception {

		final long sensorId = ParamUtil.getLong(actionRequest, "sensorId");

		final long thingId = ParamUtil.getLong(actionRequest, "thingId");
		
		final long sensorTypeId = ParamUtil.getLong(actionRequest, "sensorTypeId");
		
		final Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		final Map<Locale, String> descriptionMap = 
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		final String endpoint = ParamUtil.getString(actionRequest, "endpoint");
		
		final boolean enabled = ParamUtil.getBoolean(actionRequest, "enabled"); 

		final int status = ParamUtil.getInteger(actionRequest, "status"); 

		final ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		Sensor sensor = null;

		if (sensorId <= 0) {
			sensor = SensorLocalServiceUtil.addSensor(
					thingId, sensorTypeId, nameMap, descriptionMap,
					endpoint, enabled, status, serviceContext);
		}
		else {
			sensor = SensorLocalServiceUtil.updateSensor(
					sensorId, sensorTypeId, nameMap, descriptionMap,
					endpoint, enabled, status, serviceContext);
		}

		return sensor;
	}

	/********************************
	 * Actuator 
	 ********************************/

	@RequestMapping(params = "action=viewActuators")
	public ModelAndView viewActuators(
			final @ModelAttribute(PORTLET_SETUP) PortletPreferences portletSetup,
			final RenderRequest renderRequest,
			final Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("viewActuators");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long thingId = ParamUtil.getLong(renderRequest, "thingId");

		// TODO: Use ThingServiceUtil and implement permissions.
		final Thing thing = ThingLocalServiceUtil.fetchThing(thingId);

		renderRequest.setAttribute(LRoTWebKeys.LROT_THING, thing);

		return new ModelAndView(fullViewname("view_actuators"), modelMap);
	}
	
	@RenderMapping(params = "action=actuatorForm")
	public ModelAndView actuatorForm(final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final RenderRequest renderRequest, final Model model)
			throws SystemException, PortalException {

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long actuatorId = ParamUtil.getLong(renderRequest, "actuatorId");
		final Actuator actuator = ActuatorLocalServiceUtil.fetchActuator(actuatorId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_ACTUATOR, actuator);

		final long thingId = BeanParamUtil.getLong(actuator, renderRequest, "thingId");
		final Thing thing = ThingLocalServiceUtil.getThing(thingId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_THING, thing);

		final long companyId = themeDisplay.getCompanyId();
		final long groupId = themeDisplay.getScopeGroupId();

		final List<ActuatorType> actuatorTypeList = ActuatorTypeLocalServiceUtil.getActuatorTypes(companyId, groupId);
		modelMap.put(LRoTWebKeys.LROT_ACTUATOR_TYPE_LIST, actuatorTypeList);

		return new ModelAndView(fullViewname("edit_actuator"), modelMap);
	}

	@ActionMapping(params = "action=addActuator")
	public void addActuator(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
				throws PortletException, SystemException, PortalException {

		try {
			final Actuator actuator = updateActuator(actionRequest);

			actionResponse.setRenderParameter("thingId", String.valueOf(actuator.getThingId()));
			actionResponse.setRenderParameter("action", "viewActuators");	
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "actuatorForm");				
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}

	@ActionMapping(params = "action=editActuator")
	public void editActuator(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {

		try {
			final Actuator actuator = updateActuator(actionRequest);

			actionResponse.setRenderParameter("thingId", String.valueOf(actuator.getThingId()));
			actionResponse.setRenderParameter("action", "viewActuators");
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "actuatorForm");
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}
	}
	
	@ActionMapping(params = "action=deleteActuator")
	public void deleteActuator(final ActionRequest actionRequest,
			final ActionResponse actionResponse, final Model model)
					throws PortletException, SystemException, PortalException {
		
		long[] deleteActuatorIds = null;

		final long actuatorId = ParamUtil.getLong(actionRequest, "actuatorId");

		if (actuatorId > 0) {
			deleteActuatorIds = new long[] {actuatorId};
		}
		else {
			deleteActuatorIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "actuatorIds"), 0L);
		}

		Actuator actuator = null;

		for (long deleteActuatorId : deleteActuatorIds) {
			actuator = ActuatorLocalServiceUtil.deleteActuator(deleteActuatorId);
		}		

		actionResponse.setRenderParameter("thingId", String.valueOf(actuator.getThingId()));
		actionResponse.setRenderParameter("action", "viewActuators");
	}
	
	protected Actuator updateActuator(final ActionRequest actionRequest) throws Exception {

		final long actuatorId = ParamUtil.getLong(actionRequest, "actuatorId");

		final long thingId = ParamUtil.getLong(actionRequest, "thingId");

		final long actuatorTypeId = ParamUtil.getLong(actionRequest, "actuatorTypeId");
					
		final Map<Locale, String> nameMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "name");
		
		final Map<Locale, String> descriptionMap = 
				LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		final String endpoint = ParamUtil.getString(actionRequest, "endpoint");

		final boolean enabled = ParamUtil.getBoolean(actionRequest, "enabled"); 

		final int status = ParamUtil.getInteger(actionRequest, "status"); 

		final ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		Actuator actuator = null;

		if (actuatorId <= 0) {
			actuator = ActuatorLocalServiceUtil.addActuator(
					thingId, actuatorTypeId, nameMap, descriptionMap,
					endpoint, enabled, status, serviceContext);
		}
		else {
			actuator = ActuatorLocalServiceUtil.updateActuator(
					actuatorId, actuatorTypeId, nameMap, descriptionMap,
					endpoint, enabled, status, serviceContext);
		}

		return actuator;
	}

	@RenderMapping(params = "action=pushMessageActuatorForm")
	public ModelAndView pushMessageActuatorForm(
			final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final RenderRequest renderRequest, final Model model)
					throws SystemException, PortalException {

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final long actuatorId = ParamUtil.getLong(renderRequest, "actuatorId");
		final Actuator actuator = ActuatorLocalServiceUtil.fetchActuator(actuatorId);
		renderRequest.setAttribute(LRoTWebKeys.LROT_ACTUATOR, actuator);

		return new ModelAndView(fullViewname("push_message_actuator"), modelMap);
	}

	@ActionMapping(params = "action=pushMessageActuator")
	public void pushMessageActuator(
			final @ModelAttribute(THEME_DISPLAY) ThemeDisplay themeDisplay,
			final ActionRequest actionRequest,
			final ActionResponse actionResponse,
			final Model model)
					throws PortletException, SystemException, PortalException {

		try {
			final String message = ParamUtil.getString(actionRequest, "message");
			final long actuatorId = ParamUtil.getLong(actionRequest, "actuatorId");

			final long companyId = themeDisplay.getCompanyId();
			final long groupId = themeDisplay.getScopeGroupId();

			final Actuator actuator = ActuatorLocalServiceUtil.getActuator(actuatorId);
			final Thing thing = ThingLocalServiceUtil.getThing(actuator.getThingId());

			final StringBuffer topic = new StringBuffer();
			topic.append(String.valueOf(groupId));
			topic.append(StringPool.SLASH);
			topic.append(thing.getEndpoint());
			topic.append(StringPool.SLASH);
			topic.append("actuators");
			topic.append(StringPool.SLASH);
			topic.append(actuator.getEndpoint());
			
			_log.info("Sending message to : " + topic.toString());

			LRoTManagerUtil.getInstance()
					.publishMessage(
							companyId,
							topic.toString(),
							message,
							MosquittoConstants.QoS.QOS_0.toInt()
					);
			
			actionResponse.setRenderParameter("thingId", String.valueOf(actuator.getThingId()));
			actionResponse.setRenderParameter("action", "viewActuators");
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass());

                actionResponse.setRenderParameter("action", "pushMessageActuatorForm");
			}
			else if (e instanceof NoSuchThingGroupException) {
				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}

	}
	
	/** JUST FOR ADD RECORDS
	private void AddSensorType() {
		
		try {
			long sensorTypeId = CounterLocalServiceUtil.increment(SensorType.class.getName());
			SensorType sensorType = SensorTypeLocalServiceUtil.createSensorType(sensorTypeId);
			
//			String name = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Name language-id=\"en_US\">Temperature</Name><Name language-id=\"es_ES\">Temperatura</Name></root>";
//			String description = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Description language-id=\"en_US\">Temperature sensor.</Description><Description language-id=\"es_ES\">Sensor de temperatura.</Description></root>";
			
			String name = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Name language-id=\"en_US\">Generic</Name><Name language-id=\"es_ES\">Genérico</Name></root>";
			String description = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Description language-id=\"en_US\">Generic sensor.</Description><Description language-id=\"es_ES\">Sensor genérico.</Description></root>";

			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(name, false);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(description, false);
			
			sensorType.setGroupId(20182);
			sensorType.setCompanyId(20155);
			sensorType.setUserId(20199);
			sensorType.setUserName("Administrador Liferay");
			sensorType.setCreateDate(new Date());
			sensorType.setModifiedDate(sensorType.getCreateDate());
			sensorType.setNameMap(nameMap);
			sensorType.setDescriptionMap(descriptionMap);			
			sensorType.setIcon("");
		
			SensorTypeLocalServiceUtil.addSensorType(sensorType);

		} catch (SystemException e) {
			e.printStackTrace();
		}

	}
	
	private void AddActuatorType() {
		
		try {
			long actuatorTypeId = CounterLocalServiceUtil.increment(ActuatorType.class.getName());
			ActuatorType actuatorType = ActuatorTypeLocalServiceUtil.createActuatorType(actuatorTypeId);
			
			String name = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Name language-id=\"en_US\">Switch</Name><Name language-id=\"es_ES\">Interruptor</Name></root>";
			String description = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"es_ES,en_US,\" default-locale=\"es_ES\"><Description language-id=\"en_US\">Switch actuator.</Description><Description language-id=\"es_ES\">Actuador de interruptor.</Description></root>";

			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(name, false);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(description, false);
			
			actuatorType.setGroupId(20182);
			actuatorType.setCompanyId(20155);
			actuatorType.setUserId(20199);
			actuatorType.setUserName("Administrador Liferay");
			actuatorType.setCreateDate(new Date());
			actuatorType.setModifiedDate(actuatorType.getCreateDate());
			actuatorType.setNameMap(nameMap);
			actuatorType.setDescriptionMap(descriptionMap);			
			actuatorType.setIcon("");
		
			ActuatorTypeLocalServiceUtil.addActuatorType(actuatorType);

		} catch (SystemException e) {
			e.printStackTrace();
		}

	}
	**/
}
