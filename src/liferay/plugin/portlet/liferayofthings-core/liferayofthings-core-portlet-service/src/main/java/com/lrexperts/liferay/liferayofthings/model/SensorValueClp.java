package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.lrexperts.liferay.liferayofthings.service.ClpSerializer;
import com.lrexperts.liferay.liferayofthings.service.SensorValueLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SensorValueClp extends BaseModelImpl<SensorValue>
    implements SensorValue {
    private String _uuid;
    private long _sensorValueId;
    private long _companyId;
    private long _groupId;
    private long _sensorId;
    private String _value;
    private Date _createDate;
    private BaseModel<?> _sensorValueRemoteModel;
    private Class<?> _clpSerializerClass = com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class;

    public SensorValueClp() {
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
    public long getPrimaryKey() {
        return _sensorValueId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSensorValueId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _sensorValueId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_sensorValueRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSensorValueId() {
        return _sensorValueId;
    }

    @Override
    public void setSensorValueId(long sensorValueId) {
        _sensorValueId = sensorValueId;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setSensorValueId", long.class);

                method.invoke(_sensorValueRemoteModel, sensorValueId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_sensorValueRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_sensorValueRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSensorId() {
        return _sensorId;
    }

    @Override
    public void setSensorId(long sensorId) {
        _sensorId = sensorId;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setSensorId", long.class);

                method.invoke(_sensorValueRemoteModel, sensorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getValue() {
        return _value;
    }

    @Override
    public void setValue(String value) {
        _value = value;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setValue", String.class);

                method.invoke(_sensorValueRemoteModel, value);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_sensorValueRemoteModel != null) {
            try {
                Class<?> clazz = _sensorValueRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_sensorValueRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSensorValueRemoteModel() {
        return _sensorValueRemoteModel;
    }

    public void setSensorValueRemoteModel(BaseModel<?> sensorValueRemoteModel) {
        _sensorValueRemoteModel = sensorValueRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _sensorValueRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_sensorValueRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SensorValueLocalServiceUtil.addSensorValue(this);
        } else {
            SensorValueLocalServiceUtil.updateSensorValue(this);
        }
    }

    @Override
    public SensorValue toEscapedModel() {
        return (SensorValue) ProxyUtil.newProxyInstance(SensorValue.class.getClassLoader(),
            new Class[] { SensorValue.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SensorValueClp clone = new SensorValueClp();

        clone.setUuid(getUuid());
        clone.setSensorValueId(getSensorValueId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setSensorId(getSensorId());
        clone.setValue(getValue());
        clone.setCreateDate(getCreateDate());

        return clone;
    }

    @Override
    public int compareTo(SensorValue sensorValue) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), sensorValue.getCreateDate());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SensorValueClp)) {
            return false;
        }

        SensorValueClp sensorValue = (SensorValueClp) obj;

        long primaryKey = sensorValue.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", sensorValueId=");
        sb.append(getSensorValueId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", sensorId=");
        sb.append(getSensorId());
        sb.append(", value=");
        sb.append(getValue());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.lrexperts.liferay.liferayofthings.model.SensorValue");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sensorValueId</column-name><column-value><![CDATA[");
        sb.append(getSensorValueId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sensorId</column-name><column-value><![CDATA[");
        sb.append(getSensorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
