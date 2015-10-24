package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SensorValue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorValue
 * @generated
 */
public class SensorValueWrapper implements SensorValue,
    ModelWrapper<SensorValue> {
    private SensorValue _sensorValue;

    public SensorValueWrapper(SensorValue sensorValue) {
        _sensorValue = sensorValue;
    }

    @Override
    public Class<?> getModelClass() {
        return SensorValue.class;
    }

    @Override
    public String getModelClassName() {
        return SensorValue.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("sensorValueId", getSensorValueId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("sensorId", getSensorId());
        attributes.put("value", getValue());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long sensorValueId = (Long) attributes.get("sensorValueId");

        if (sensorValueId != null) {
            setSensorValueId(sensorValueId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long sensorId = (Long) attributes.get("sensorId");

        if (sensorId != null) {
            setSensorId(sensorId);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }
    }

    /**
    * Returns the primary key of this sensor value.
    *
    * @return the primary key of this sensor value
    */
    @Override
    public long getPrimaryKey() {
        return _sensorValue.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sensor value.
    *
    * @param primaryKey the primary key of this sensor value
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _sensorValue.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this sensor value.
    *
    * @return the uuid of this sensor value
    */
    @Override
    public java.lang.String getUuid() {
        return _sensorValue.getUuid();
    }

    /**
    * Sets the uuid of this sensor value.
    *
    * @param uuid the uuid of this sensor value
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _sensorValue.setUuid(uuid);
    }

    /**
    * Returns the sensor value ID of this sensor value.
    *
    * @return the sensor value ID of this sensor value
    */
    @Override
    public long getSensorValueId() {
        return _sensorValue.getSensorValueId();
    }

    /**
    * Sets the sensor value ID of this sensor value.
    *
    * @param sensorValueId the sensor value ID of this sensor value
    */
    @Override
    public void setSensorValueId(long sensorValueId) {
        _sensorValue.setSensorValueId(sensorValueId);
    }

    /**
    * Returns the company ID of this sensor value.
    *
    * @return the company ID of this sensor value
    */
    @Override
    public long getCompanyId() {
        return _sensorValue.getCompanyId();
    }

    /**
    * Sets the company ID of this sensor value.
    *
    * @param companyId the company ID of this sensor value
    */
    @Override
    public void setCompanyId(long companyId) {
        _sensorValue.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this sensor value.
    *
    * @return the group ID of this sensor value
    */
    @Override
    public long getGroupId() {
        return _sensorValue.getGroupId();
    }

    /**
    * Sets the group ID of this sensor value.
    *
    * @param groupId the group ID of this sensor value
    */
    @Override
    public void setGroupId(long groupId) {
        _sensorValue.setGroupId(groupId);
    }

    /**
    * Returns the sensor ID of this sensor value.
    *
    * @return the sensor ID of this sensor value
    */
    @Override
    public long getSensorId() {
        return _sensorValue.getSensorId();
    }

    /**
    * Sets the sensor ID of this sensor value.
    *
    * @param sensorId the sensor ID of this sensor value
    */
    @Override
    public void setSensorId(long sensorId) {
        _sensorValue.setSensorId(sensorId);
    }

    /**
    * Returns the value of this sensor value.
    *
    * @return the value of this sensor value
    */
    @Override
    public java.lang.String getValue() {
        return _sensorValue.getValue();
    }

    /**
    * Sets the value of this sensor value.
    *
    * @param value the value of this sensor value
    */
    @Override
    public void setValue(java.lang.String value) {
        _sensorValue.setValue(value);
    }

    /**
    * Returns the create date of this sensor value.
    *
    * @return the create date of this sensor value
    */
    @Override
    public java.util.Date getCreateDate() {
        return _sensorValue.getCreateDate();
    }

    /**
    * Sets the create date of this sensor value.
    *
    * @param createDate the create date of this sensor value
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _sensorValue.setCreateDate(createDate);
    }

    @Override
    public boolean isNew() {
        return _sensorValue.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sensorValue.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sensorValue.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sensorValue.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sensorValue.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sensorValue.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sensorValue.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sensorValue.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sensorValue.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sensorValue.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sensorValue.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SensorValueWrapper((SensorValue) _sensorValue.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.SensorValue sensorValue) {
        return _sensorValue.compareTo(sensorValue);
    }

    @Override
    public int hashCode() {
        return _sensorValue.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.SensorValue> toCacheModel() {
        return _sensorValue.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue toEscapedModel() {
        return new SensorValueWrapper(_sensorValue.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorValue toUnescapedModel() {
        return new SensorValueWrapper(_sensorValue.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sensorValue.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sensorValue.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sensorValue.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SensorValueWrapper)) {
            return false;
        }

        SensorValueWrapper sensorValueWrapper = (SensorValueWrapper) obj;

        if (Validator.equals(_sensorValue, sensorValueWrapper._sensorValue)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SensorValue getWrappedSensorValue() {
        return _sensorValue;
    }

    @Override
    public SensorValue getWrappedModel() {
        return _sensorValue;
    }

    @Override
    public void resetOriginalValues() {
        _sensorValue.resetOriginalValues();
    }
}
