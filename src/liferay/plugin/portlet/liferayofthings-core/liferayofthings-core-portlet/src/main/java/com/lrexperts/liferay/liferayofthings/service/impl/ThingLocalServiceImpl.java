package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.base.ThingLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the thing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.ThingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.ThingLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil
 */
public class ThingLocalServiceImpl extends ThingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.ThingLocalServiceUtil} to access the thing local service.
     */

	/** FINDERS **/
	@Override
	public int getThingsCount(long thingGroupId) throws SystemException {
		return thingPersistence.countByThingGroupId(thingGroupId);
	}
	
	@Override
	public List<Thing> getThings(long thingGroupId) throws SystemException {
		return thingPersistence.findByThingGroupId(thingGroupId);
	}

	@Override
	public List<Thing> getThingsByGroupId(long groupId) throws SystemException {
		return thingPersistence.findByGroupId(groupId);
	}

	@Override
	public List<Thing> getThings(long thingGroupId, int start, int end)
		throws SystemException {

		return thingPersistence.findByThingGroupId(thingGroupId, start, end);
	}

	/** CRUD **/
	@Override
	public Thing addThing(
			long thingGroupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		ThingGroup thingGroup = thingGroupPersistence.findByPrimaryKey(thingGroupId);

		Date now = new Date();

		long thingId = counterLocalService.increment();

		Thing thing = createThing(thingId);

		thing.setUuid(serviceContext.getUuid());
		thing.setThingGroupId(thingGroupId);
		thing.setGroupId(thingGroup.getGroupId());
		thing.setCompanyId(serviceContext.getCompanyId());
		thing.setUserId(user.getUserId());
		thing.setUserName(user.getFullName());
		thing.setCreateDate(serviceContext.getCreateDate(now));
		thing.setModifiedDate(serviceContext.getModifiedDate(now));
		thing.setNameMap(nameMap);
		thing.setDescriptionMap(descriptionMap);
		thing.setEndpoint(endpoint);
		thing.setEnabled(enabled);
		thing.setStatus(status);
		
		thing = updateThing(thing);

		return thing;
	}

	@Override
	public Thing updateThing(
			long thingId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		Thing thing = thingPersistence.findByPrimaryKey(thingId);

		thing.setModifiedDate(serviceContext.getModifiedDate(null));
		thing.setNameMap(nameMap);
		thing.setDescriptionMap(descriptionMap);
		thing.setEndpoint(endpoint);
		thing.setEnabled(enabled);
		thing.setStatus(status);

		thing = thingPersistence.update(thing);

		// Update Sensors
		List<Sensor> sensorList = sensorPersistence.findByThingId(thingId); 
		
		for (Sensor sensor : sensorList) {
			sensor.setModifiedDate(thing.getModifiedDate());
			sensor.setEnabled(thing.getEnabled());
			sensorPersistence.update(sensor);
		}

		// Update Actuators
		List<Actuator> actuatorList = actuatorPersistence.findByThingId(thingId); 
		
		for (Actuator actuator : actuatorList) {
			actuator.setModifiedDate(thing.getModifiedDate());
			actuator.setEnabled(thing.getEnabled());
			actuatorPersistence.update(actuator);
		}

		return thing;
	}
	
}
