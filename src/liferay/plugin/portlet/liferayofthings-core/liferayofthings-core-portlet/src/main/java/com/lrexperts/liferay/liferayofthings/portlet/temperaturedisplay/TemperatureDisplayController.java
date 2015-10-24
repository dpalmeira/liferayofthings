package com.lrexperts.liferay.liferayofthings.portlet.temperaturedisplay;

import com.lrexperts.liferay.portlet.core.controllers.BasePortletController;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.portlet.common.util.DataUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.util.LRoTWebKeys;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * @author Diego A. Palmeira
 */
@Controller()
@RequestMapping("VIEW")
public class TemperatureDisplayController extends BasePortletController {

	private static final Log _log = LogFactory.getLog(TemperatureDisplayController.class);

	private static final String PORTLET_PAGE_URL = "portlet/temperaturedisplay";

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
			final RenderRequest request, Model model)
					throws PortletException, SystemException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("defaultView");
		}

		final Map<String, Object> modelMap = new HashMap<String, Object>();

		final String sensorEndpoint = GetterUtil.getString(portletSetup.getValue("sensorEndpoint", StringPool.BLANK));

		if (Validator.isNotNull(sensorEndpoint)) {
			
			try {
		        Date[] dates;
		        final int year = Calendar.getInstance().get(Calendar.YEAR);
		        dates = DataUtil.getDatesForSelectedPeriod(year);
		
				long companyId = themeDisplay.getCompanyId();
				long groupId = themeDisplay.getScopeGroupId();
		
		        Sensor sensor = SensorLocalServiceUtil.getSensorByEndpoint(companyId, groupId, sensorEndpoint, Boolean.TRUE);
		        
				if (sensor!=null) {
			        final List<SensorValue> sensorValueList = SensorValueLocalServiceUtil.getSensorValues(sensor.getSensorId(), dates[0], dates[1]);
		            modelMap.put(LRoTWebKeys.LROT_THING_TEMP_GRAPH_DATA, sensorValueList);
				}
				else {
					_log.error("Sensor NOT found, or disabled! | companyId: "
							+ companyId + " | groupId: " + groupId 
							+ " | sensorEndpoint: " + sensorEndpoint);
				}
			}
			catch (final Exception e) {
				_log.error("An error occurred while retreiving data information.", e.getCause());
	        }
		}
		
		return new ModelAndView(fullViewname("view"), modelMap);
	}

}
