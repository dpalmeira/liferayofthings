package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.base.ThingGroupLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the thing group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.ThingGroupLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalServiceUtil
 */
public class ThingGroupLocalServiceImpl extends ThingGroupLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.ThingGroupLocalServiceUtil} to access the thing group local service.
     */

	/** FINDERS **/
	@Override
	public List<ThingGroup> getThingGroups(long companyId, long groupId) throws SystemException {
		return thingGroupPersistence.findByC_G(companyId, groupId);
	}

	/** CRUD **/
	@Override
	public ThingGroup addThingGroup(
			long groupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean enabled,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		Date now = new Date();

		long thingGroupId = counterLocalService.increment();

		ThingGroup thingGroup = createThingGroup(thingGroupId);

		thingGroup.setUuid(serviceContext.getUuid());
		thingGroup.setGroupId(groupId);
		thingGroup.setCompanyId(serviceContext.getCompanyId());
		thingGroup.setUserId(user.getUserId());
		thingGroup.setUserName(user.getFullName());
		thingGroup.setCreateDate(serviceContext.getCreateDate(now));
		thingGroup.setModifiedDate(serviceContext.getModifiedDate(now));
		thingGroup.setNameMap(nameMap);
		thingGroup.setDescriptionMap(descriptionMap);
		thingGroup.setEnabled(enabled);

		return updateThingGroup(thingGroup);
	}

	@Override
	public ThingGroup updateThingGroup(
			long thingGroupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean enabled,
			ServiceContext serviceContext) throws PortalException, SystemException {

		ThingGroup thingGroup = thingGroupPersistence.findByPrimaryKey(thingGroupId);

		thingGroup.setModifiedDate(serviceContext.getModifiedDate(null));
		thingGroup.setNameMap(nameMap);
		thingGroup.setDescriptionMap(descriptionMap);
		thingGroup.setEnabled(enabled);

		thingGroupPersistence.update(thingGroup);
		
		// Update Things
		List<Thing> thingList = thingPersistence.findByThingGroupId(thingGroupId); 
		
		for (Thing thing : thingList) {
			thing.setModifiedDate(thingGroup.getModifiedDate());
			thing.setEnabled(thingGroup.getEnabled());
			thingPersistence.update(thing);
			
			// Update Sensors
			List<Sensor> sensorList = sensorPersistence.findByThingId(thing.getThingId()); 
			
			for (Sensor sensor : sensorList) {
				sensor.setModifiedDate(thing.getModifiedDate());
				sensor.setEnabled(thing.getEnabled());
				sensorPersistence.update(sensor);
			}

			// Update Actuators
			List<Actuator> actuatorList = actuatorPersistence.findByThingId(thing.getThingId());
			
			for (Actuator actuator : actuatorList) {
				actuator.setModifiedDate(thing.getModifiedDate());
				actuator.setEnabled(thing.getEnabled());
				actuatorPersistence.update(actuator);
			}
		}

		return thingGroup;
	}
	
}
