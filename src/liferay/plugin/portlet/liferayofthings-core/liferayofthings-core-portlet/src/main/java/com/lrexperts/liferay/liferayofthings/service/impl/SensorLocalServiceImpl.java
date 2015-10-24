package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.service.base.SensorLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the sensor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.SensorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.SensorLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil
 */
public class SensorLocalServiceImpl extends SensorLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.SensorLocalServiceUtil} to access the sensor local service.
     */

	/** FINDERS **/
	@Override
	public int getSensorsCount(long thingId) throws SystemException {
		return sensorPersistence.countByThingId(thingId);
	}

	@Override
	public List<Sensor> getSensors(long thingId) throws SystemException {
		return sensorPersistence.findByThingId(thingId);
	}

	@Override
	public List<Sensor> getSensors(long thingId, int start, int end) throws SystemException {
		return sensorPersistence.findByThingId(thingId, start, end);
	}

	@Override
	public Sensor getSensorByEndpoint(long companyId, long groupId, String endpoint, boolean enabled) throws SystemException {
		return sensorPersistence.fetchByC_G_E_EN(companyId, groupId, endpoint, enabled);
	}

	/** CRUD **/
	@Override
	public Sensor addSensor(
			long thingId, long sensorTypeId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		Thing thing = thingPersistence.findByPrimaryKey(thingId);
		ThingGroup thingGroup = thingGroupPersistence.findByPrimaryKey(thing.getThingGroupId());

		Date now = new Date();

		long sensorId = counterLocalService.increment();

		Sensor sensor = createSensor(sensorId);

		sensor.setUuid(serviceContext.getUuid());
		sensor.setThingId(thingId);
		sensor.setGroupId(thing.getGroupId());
		sensor.setCompanyId(serviceContext.getCompanyId());
		sensor.setUserId(user.getUserId());
		sensor.setUserName(user.getFullName());
		sensor.setCreateDate(serviceContext.getCreateDate(now));
		sensor.setModifiedDate(serviceContext.getModifiedDate(now));
		sensor.setSensorTypeId(sensorTypeId);
		sensor.setNameMap(nameMap);
		sensor.setDescriptionMap(descriptionMap);
		sensor.setEndpoint(endpoint);
		sensor.setEnabled(enabled);
		sensor.setStatus(status);
		
		sensor = updateSensor(sensor);

		return sensor;
	}

	@Override
	public Sensor updateSensor(
			long sensorId, long sensorTypeId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String endpoint, boolean enabled, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {

		Sensor sensor = sensorPersistence.findByPrimaryKey(sensorId);

		sensor.setModifiedDate(serviceContext.getModifiedDate(null));
		sensor.setSensorTypeId(sensorTypeId);
		sensor.setNameMap(nameMap);
		sensor.setDescriptionMap(descriptionMap);
		sensor.setEndpoint(endpoint);
		sensor.setEnabled(enabled);
		sensor.setStatus(status);

		sensor = sensorPersistence.update(sensor);
		
		return sensor;
	}

}
