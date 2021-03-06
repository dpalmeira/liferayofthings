package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.lrexperts.liferay.liferayofthings.model.SensorType;
import com.lrexperts.liferay.liferayofthings.service.SensorTypeLocalServiceUtil;

/**
 * The extended model base implementation for the SensorType service. Represents a row in the &quot;LRoT_SensorType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SensorTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorTypeImpl
 * @see com.lrexperts.liferay.liferayofthings.model.SensorType
 * @generated
 */
public abstract class SensorTypeBaseImpl extends SensorTypeModelImpl
    implements SensorType {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a sensor type model instance should use the {@link SensorType} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SensorTypeLocalServiceUtil.addSensorType(this);
        } else {
            SensorTypeLocalServiceUtil.updateSensorType(this);
        }
    }
}
