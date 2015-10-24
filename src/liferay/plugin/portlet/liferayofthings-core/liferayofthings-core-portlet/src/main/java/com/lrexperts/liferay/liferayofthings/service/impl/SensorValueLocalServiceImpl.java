package com.lrexperts.liferay.liferayofthings.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.base.SensorValueLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the sensor value local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lrexperts.liferay.liferayofthings.service.SensorValueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.base.SensorValueLocalServiceBaseImpl
 * @see com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil
 */
public class SensorValueLocalServiceImpl extends SensorValueLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil} to access the sensor value local service.
     */

	/** FINDERS **/
	
	@Override
	public List<SensorValue> getSensorValues(long sensorId, Date dateFrom, Date dateTo) throws SystemException {
		
		DynamicQuery  sensorValueOrderCriteriaQuery = 
				DynamicQueryFactoryUtil.forClass(SensorValue.class,
						PortletClassLoaderUtil.getClassLoader());
		
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("sensorId", sensorId);
		criterion = RestrictionsFactoryUtil.and(criterion,
				RestrictionsFactoryUtil.between("createDate", dateFrom, dateTo));
		
		sensorValueOrderCriteriaQuery.add(criterion);
		sensorValueOrderCriteriaQuery.addOrder(OrderFactoryUtil.asc("createDate"));
		
		return SensorValueLocalServiceUtil.dynamicQuery(sensorValueOrderCriteriaQuery);
	}

	@Override
	public SensorValue getLastSensorValue(long sensorId) throws SystemException {
		
		DynamicQuery sensorValueOrderCriteriaQuery = 
				DynamicQueryFactoryUtil.forClass(SensorValue.class,
						PortletClassLoaderUtil.getClassLoader());
		
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("sensorId", sensorId);
		sensorValueOrderCriteriaQuery.add(criterion);
		sensorValueOrderCriteriaQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		
		List<SensorValue> sensorValueList = SensorValueLocalServiceUtil.dynamicQuery(sensorValueOrderCriteriaQuery);
		
		if(sensorValueList != null && sensorValueList.size() > 0) {
			return sensorValueList.get(0);
		}
		else {
			return null;	
		}
	}
	
}
