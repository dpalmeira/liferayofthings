package com.lrexperts.liferay.liferayofthings.portlet.fitbit.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.exception.MosquittoChannelException;
import com.lrexperts.liferay.liferayofthings.manager.broker.mosquitto.util.MosquittoConstants;
import com.lrexperts.liferay.liferayofthings.manager.util.LRoTManagerUtil;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.provider.fitbit.oauth.OAuthUtil;
import com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;

/**
 * @author Diego A. Palmeira
 */
public class FitbitSyncUtil {

	public static void syncData() {

		if (_log.isDebugEnabled()) {
			_log.debug("Fitbit starting sync data...");
		}

    	List<Company> companies;
		try {
			companies = CompanyLocalServiceUtil.getCompanies();

	    	for (Company company : companies) {
	            try {
					if (_log.isDebugEnabled()) {
						_log.debug("Processing Fitbit data for companyId: " + company.getCompanyId());
					}
					try {
						List<Group> groups = GroupLocalServiceUtil.getGroups(
								company.getCompanyId(), GroupConstants.ANY_PARENT_GROUP_ID, Boolean.TRUE);

						for (Group group : groups) {
							// TODO: Do this only for sites with "IoT enabled".
							_syncDataByGroup(group);
						}
						
					} catch (SystemException se) {
						_log.error("Error retrieving groups for companyId: " + company.getCompanyId());
						throw new MosquittoChannelException(se);
					}
	            } catch (Exception e) {
					_log.error("Error processing Fitbit data!", e);
				}
	        }

		} catch (SystemException e) {
			_log.error("Error getting companies!", e);
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug("Fitbit sync data completed!");
		}
	}

	private static void _syncDataByGroup(Group group) {

		if (_log.isDebugEnabled()) {
			_log.debug("Sync Fitbit data for groupId: " + group.getGroupId());
		}
		
		if (group.getExpandoBridge().hasAttribute("fitbit_access_token_secret") &&
				group.getExpandoBridge().hasAttribute("fitbit_access_token")) {
			/**
			https://api.fitbit.com/1/user/[user-id]/activities/date/[date].json
			**/
			//OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.fitbit.com/1/user/-/activities/date/2015-08-25.json");
			OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.fitbit.com/1/user/-/activities/steps/date/today/1d.json");

			String userAccessToken = _getGroupExpandoValue(group, "fitbit_access_token");
			String userAccessTokenSecret = _getGroupExpandoValue(group, "fitbit_access_token_secret"); 
			
			if (Validator.isNotNull(userAccessToken) && Validator.isNotNull(userAccessTokenSecret)) {
				Token accessToken = new Token(userAccessToken, userAccessTokenSecret);
				
				OAuthUtil.getOAuthService().signRequest(accessToken, request);
				Response response = request.send();

				_processJSONResponse(group, response.getBody());
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug("Skip processing. There is no token for groupId: " + group.getGroupId());
				}				
			}
		}
		
		if (_log.isDebugEnabled()) {
			_log.debug("Sync Fitbit data completed for groupId: " + group.getGroupId());
		}
	}

	private static String _getGroupExpandoValue(Group group, String column) {

		String result = StringPool.BLANK;
		try {
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(
					group.getCompanyId(), Group.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);

			ExpandoColumn expcolumn = ExpandoColumnLocalServiceUtil.getColumn(
					group.getCompanyId(), PortalUtil.getClassNameId(Group.class.getName()), table.getName(), column);
		 
			result = ExpandoValueLocalServiceUtil.getData(
					group.getCompanyId(), Group.class.getName(),
					table.getName(), expcolumn.getName(), group.getPrimaryKey(), StringPool.BLANK);

		} catch (Exception e) {
			_log.error("Error while retrieving Column: " + column, e);
		}

		return result;
	}
	 
	private static void _processJSONResponse(Group group, String json) {
		
		if (Validator.isNotNull(json)) {
			if (_log.isDebugEnabled()) {
				_log.debug(json);
			}
			try {

				// {"activities-steps":[{"dateTime":"2015-08-26","value":"4674"}]}
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);
				JSONArray jsonArray = jsonObject.getJSONArray("activities-steps");
				
				for (int i = 0, size = jsonArray.length(); i < size; i++) {
					JSONObject jsonSteps = jsonArray.getJSONObject(i);
					_publishMessage(group, jsonSteps.getString("value"));
				}

			} catch (JSONException e) {
				_log.error("Error while processing JSON response: " + json, e);
			}
		}
	}
	
	private static void _publishMessage(Group group, String message) {

		final long companyId = group.getCompanyId();
		final long groupId = group.getGroupId();
		final String endpoint = "steps";

		try {
			final Sensor sensor = SensorLocalServiceUtil.getSensorByEndpoint(companyId, groupId, endpoint, Boolean.TRUE);
			final Thing thing = ThingLocalServiceUtil.getThing(sensor.getThingId());
			
			final StringBuffer topic = new StringBuffer();
			topic.append(String.valueOf(groupId));
			topic.append(StringPool.SLASH);
			topic.append(thing.getEndpoint());
			topic.append(StringPool.SLASH);
			topic.append("sensors");
			topic.append(StringPool.SLASH);
			topic.append(sensor.getEndpoint());
			
			if (_log.isDebugEnabled()) {
				_log.debug("Sending message to : " + topic.toString() + " with value: " + message);
			}

			LRoTManagerUtil.getInstance()
					.publishMessage(
							companyId,
							topic.toString(),
							message,
							MosquittoConstants.QoS.QOS_0.toInt()
					);

		} catch (Exception e) {
			_log.error("Error sending message for groupId : " + groupId + " with value: " + message, e);
		}
	}
	
	public static void sendAlarm(long groupId, String message) {

		if (_log.isDebugEnabled()) {
			_log.debug("Sending alarm to Fitbit device. Message: " + message);
		}
		
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			if (group.getExpandoBridge().hasAttribute("fitbit_access_token_secret") &&
					group.getExpandoBridge().hasAttribute("fitbit_access_token")) {

				OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.fitbit.com/1/user/-/devices.json");
	
				String userAccessToken = _getGroupExpandoValue(group, "fitbit_access_token");
				String userAccessTokenSecret = _getGroupExpandoValue(group, "fitbit_access_token_secret"); 
				
				if (Validator.isNotNull(userAccessToken) && Validator.isNotNull(userAccessTokenSecret)) {
					Token accessToken = new Token(userAccessToken, userAccessTokenSecret);
					
					OAuthUtil.getOAuthService().signRequest(accessToken, request);
					Response response = request.send();
	
					String trackerId = _getTrackerId(group, response.getBody());
					
					if (Validator.isNotNull(trackerId)) {
						_addAlarm(accessToken, trackerId, message);
					}
					
				}
				else {
					if (_log.isDebugEnabled()) {
						_log.debug("Skip processing. There is no token for groupId: " + group.getGroupId());
					}				
				}
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Fitbit Alarm has been sent.");
			}

		} catch (Exception e) {
			_log.error("Error sending alarm for groupId : " + groupId + " with message: " + message, e);
		}
	}

	private static String _getTrackerId(Group group, String json) {
		
		String result = StringPool.BLANK;
		
		if (Validator.isNotNull(json)) {
			if (_log.isDebugEnabled()) {
				_log.debug(json);
			}
			try {

				// {"activities-steps":[{"dateTime":"2015-08-26","value":"4674"}]}
				/**
				[{
			        "battery": "High",
			        "deviceVersion": "Charge HR",
			        "id": "27072629",
			        "lastSyncTime": "2015-07-27T17:01:39.313",
			        "type": "TRACKER"
				}]
			    **/
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(json);

				if (jsonArray.length() > 0) {
					JSONObject jsonSteps = jsonArray.getJSONObject(0);
					result = jsonSteps.getString("id");
				}

			} catch (JSONException e) {
				_log.error("Error while processing JSON response: " + json, e);
			}
		}
		
		return result;
	}

	private static void _addAlarm(Token accessToken, String trackerId, String json) {
		
		if (_log.isDebugEnabled()) {
			_log.debug("Adding alarm for trackerId: " + trackerId);
		}
		try {
			
			if (_log.isDebugEnabled()) {
				_log.debug("Alarm has been sent for trackerId: " + trackerId);
			}

			String time = StringPool.BLANK;
			String day = StringPool.BLANK;
			
			try {
				//Example: {"fitbit-alarm":[{"time":"18:50+02:00","day":"THURSDAY"}]}
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);
				JSONArray jsonArray = jsonObject.getJSONArray("fitbit-alarm");
				if (jsonArray.length() > 0) {
					JSONObject jsonDatetime = jsonArray.getJSONObject(0);
					time = jsonDatetime.getString("time");
					day = jsonDatetime.getString("day");
				}
			} catch (JSONException e) {
				_log.error("Error while processing expected alarm JSON: " + json, e);
			}
			
			OAuthRequest request = new OAuthRequest(Verb.POST, "https://api.fitbit.com/1/user/-/devices/tracker/" + trackerId + "/alarms.json");
			
			request.addBodyParameter("time", time);
			request.addBodyParameter("enabled", "true");
			request.addBodyParameter("recurring", "false");
			request.addBodyParameter("weekDays", day);
			
			OAuthUtil.getOAuthService().signRequest(accessToken, request);
			Response response = request.send();
			String jsonResponse = response.getBody();

			if (_log.isDebugEnabled()) {
				_log.debug("Response of add alarm: " + jsonResponse);
			}
			
		} catch (Exception e) {
			_log.error("Error while add alarm for trackerId: " + trackerId);
		}
	}
	
	private static final Log _log = LogFactory.getLog(FitbitSyncUtil.class);
}
