package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.SensorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.SensorServiceSoap
 * @generated
 */
public class SensorSoap implements Serializable {
    private String _uuid;
    private long _sensorId;
    private long _companyId;
    private long _groupId;
    private long _thingId;
    private long _sensorTypeId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _endpoint;
    private boolean _enabled;
    private int _status;

    public SensorSoap() {
    }

    public static SensorSoap toSoapModel(Sensor model) {
        SensorSoap soapModel = new SensorSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setSensorId(model.getSensorId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setThingId(model.getThingId());
        soapModel.setSensorTypeId(model.getSensorTypeId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setEndpoint(model.getEndpoint());
        soapModel.setEnabled(model.getEnabled());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static SensorSoap[] toSoapModels(Sensor[] models) {
        SensorSoap[] soapModels = new SensorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SensorSoap[][] toSoapModels(Sensor[][] models) {
        SensorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SensorSoap[models.length][models[0].length];
        } else {
            soapModels = new SensorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SensorSoap[] toSoapModels(List<Sensor> models) {
        List<SensorSoap> soapModels = new ArrayList<SensorSoap>(models.size());

        for (Sensor model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SensorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sensorId;
    }

    public void setPrimaryKey(long pk) {
        setSensorId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getSensorId() {
        return _sensorId;
    }

    public void setSensorId(long sensorId) {
        _sensorId = sensorId;
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

    public long getThingId() {
        return _thingId;
    }

    public void setThingId(long thingId) {
        _thingId = thingId;
    }

    public long getSensorTypeId() {
        return _sensorTypeId;
    }

    public void setSensorTypeId(long sensorTypeId) {
        _sensorTypeId = sensorTypeId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
    }

    public boolean getEnabled() {
        return _enabled;
    }

    public boolean isEnabled() {
        return _enabled;
    }

    public void setEnabled(boolean enabled) {
        _enabled = enabled;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }
}
