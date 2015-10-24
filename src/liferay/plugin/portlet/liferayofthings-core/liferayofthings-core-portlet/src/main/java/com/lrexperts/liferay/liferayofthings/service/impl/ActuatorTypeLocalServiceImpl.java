package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.lrexperts.liferay.liferayofthings.model.ActuatorType;
import com.lrexperts.liferay.liferayofthings.service.base.ActuatorTypeLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the actuator type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.ActuatorTypeLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil
 */
public class ActuatorTypeLocalServiceImpl
    extends ActuatorTypeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.ActuatorTypeLocalServiceUtil} to access the actuator type local service.
     */
	
	/** FINDERS **/
	@Override
	public List<ActuatorType> getActuatorTypes(long companyId, long groupId) throws SystemException {
		return actuatorTypePersistence.findByC_G(companyId, groupId);
	}
	
}
