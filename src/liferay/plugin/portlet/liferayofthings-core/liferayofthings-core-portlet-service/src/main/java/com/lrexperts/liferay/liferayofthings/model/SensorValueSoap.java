package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.SensorValueServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.SensorValueServiceSoap
 * @generated
 */
public class SensorValueSoap implements Serializable {
    private String _uuid;
    private long _sensorValueId;
    private long _companyId;
    private long _groupId;
    private long _sensorId;
    private String _value;
    private Date _createDate;

    public SensorValueSoap() {
    }

    public static SensorValueSoap toSoapModel(SensorValue model) {
        SensorValueSoap soapModel = new SensorValueSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setSensorValueId(model.getSensorValueId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setSensorId(model.getSensorId());
        soapModel.setValue(model.getValue());
        soapModel.setCreateDate(model.getCreateDate());

        return soapModel;
    }

    public static SensorValueSoap[] toSoapModels(SensorValue[] models) {
        SensorValueSoap[] soapModels = new SensorValueSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SensorValueSoap[][] toSoapModels(SensorValue[][] models) {
        SensorValueSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SensorValueSoap[models.length][models[0].length];
        } else {
            soapModels = new SensorValueSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SensorValueSoap[] toSoapModels(List<SensorValue> models) {
        List<SensorValueSoap> soapModels = new ArrayList<SensorValueSoap>(models.size());

        for (SensorValue model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SensorValueSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sensorValueId;
    }

    public void setPrimaryKey(long pk) {
        setSensorValueId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getSensorValueId() {
        return _sensorValueId;
    }

    public void setSensorValueId(long sensorValueId) {
        _sensorValueId = sensorValueId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getSensorId() {
        return _sensorId;
    }

    public void setSensorId(long sensorId) {
        _sensorId = sensorId;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }
}
