package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.lrexperts.liferay.liferayofthings.model.SensorType;
import com.lrexperts.liferay.liferayofthings.service.base.SensorTypeLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the sensor type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.SensorTypeLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil
 */
public class SensorTypeLocalServiceImpl extends SensorTypeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil} to access the sensor type local service.
     */
	
	/** FINDERS **/
	@Override
	public List<SensorType> getSensorTypes(long companyId, long groupId) throws SystemException {
		return sensorTypePersistence.findByC_G(companyId, groupId);
	}

}
