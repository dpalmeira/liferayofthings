package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.ActuatorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.ActuatorServiceSoap
 * @generated
 */
public class ActuatorSoap implements Serializable {
    private String _uuid;
    private long _actuatorId;
    private long _companyId;
    private long _groupId;
    private long _thingId;
    private long _actuatorTypeId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _endpoint;
    private boolean _enabled;
    private int _status;

    public ActuatorSoap() {
    }

    public static ActuatorSoap toSoapModel(Actuator model) {
        ActuatorSoap soapModel = new ActuatorSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setActuatorId(model.getActuatorId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setThingId(model.getThingId());
        soapModel.setActuatorTypeId(model.getActuatorTypeId());
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

    public static ActuatorSoap[] toSoapModels(Actuator[] models) {
        ActuatorSoap[] soapModels = new ActuatorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ActuatorSoap[][] toSoapModels(Actuator[][] models) {
        ActuatorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ActuatorSoap[models.length][models[0].length];
        } else {
            soapModels = new ActuatorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ActuatorSoap[] toSoapModels(List<Actuator> models) {
        List<ActuatorSoap> soapModels = new ArrayList<ActuatorSoap>(models.size());

        for (Actuator model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ActuatorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _actuatorId;
    }

    public void setPrimaryKey(long pk) {
        setActuatorId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getActuatorId() {
        return _actuatorId;
    }

    public void setActuatorId(long actuatorId) {
        _actuatorId = actuatorId;
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

    public long getActuatorTypeId() {
        return _actuatorTypeId;
    }

    public void setActuatorTypeId(long actuatorTypeId) {
        _actuatorTypeId = actuatorTypeId;
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
