package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.base.ActuatorLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the actuator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.ActuatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.ActuatorLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil
 */
public class ActuatorLocalServiceImpl extends ActuatorLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil} to access the actuator local service.
     */

	/** FINDERS **/
	@Override
	public int getActuatorsCount(long thingId) throws SystemException {
		return actuatorPersistence.countByThingId(thingId);
	}

	@Override
	public List<Actuator> getActuators(long thingId) throws SystemException {
		return actuatorPersistence.findByThingId(thingId);
	}

	@Override
	public List<Actuator> getActuators(long thingId, int start, int end) throws SystemException {
		return actuatorPersistence.findByThingId(thingId, start, end);
	}
	
	@Override
	public Actuator getActuatorByEndpoint(String endpoint) throws SystemException {
		return actuatorPersistence.fetchByEndpoint(endpoint);
	}

	/** CRUD **/
	@Override
	public Actuator addActuator(
			long thingId, long actuatorTypeId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		Thing thing = thingPersistence.findByPrimaryKey(thingId);
		ThingGroup thingGroup = thingGroupPersistence.findByPrimaryKey(thing.getThingGroupId());

		Date now = new Date();

		long actuatorId = counterLocalService.increment();

		Actuator actuator = createActuator(actuatorId);

		actuator.setUuid(serviceContext.getUuid());
		actuator.setThingId(thingId);
		actuator.setGroupId(thing.getGroupId());
		actuator.setCompanyId(serviceContext.getCompanyId());
		actuator.setUserId(user.getUserId());
		actuator.setUserName(user.getFullName());
		actuator.setCreateDate(serviceContext.getCreateDate(now));
		actuator.setModifiedDate(serviceContext.getModifiedDate(now));
		actuator.setActuatorTypeId(actuatorTypeId);
		actuator.setNameMap(nameMap);
		actuator.setDescriptionMap(descriptionMap);
		actuator.setEndpoint(endpoint);
		actuator.setEnabled(enabled);
		actuator.setStatus(status);
		
		actuator = updateActuator(actuator);
		
		return actuator;
	}

	@Override
	public Actuator updateActuator(
			long actuatorId, long actuatorTypeId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		Actuator actuator = actuatorPersistence.findByPrimaryKey(actuatorId);

		actuator.setModifiedDate(serviceContext.getModifiedDate(null));
		actuator.setActuatorTypeId(actuatorTypeId);
		actuator.setNameMap(nameMap);
		actuator.setDescriptionMap(descriptionMap);
		actuator.setEndpoint(endpoint);
		actuator.setEnabled(enabled);
		actuator.setStatus(status);

		actuator = actuatorPersistence.update(actuator);
		
		return actuator;
	}

}
