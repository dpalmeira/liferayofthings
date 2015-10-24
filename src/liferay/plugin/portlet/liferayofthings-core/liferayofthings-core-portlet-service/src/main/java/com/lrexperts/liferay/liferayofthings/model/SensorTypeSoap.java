package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.SensorTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.SensorTypeServiceSoap
 * @generated
 */
public class SensorTypeSoap implements Serializable {
    private String _uuid;
    private long _sensorTypeId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _icon;

    public SensorTypeSoap() {
    }

    public static SensorTypeSoap toSoapModel(SensorType model) {
        SensorTypeSoap soapModel = new SensorTypeSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setSensorTypeId(model.getSensorTypeId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setIcon(model.getIcon());

        return soapModel;
    }

    public static SensorTypeSoap[] toSoapModels(SensorType[] models) {
        SensorTypeSoap[] soapModels = new SensorTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SensorTypeSoap[][] toSoapModels(SensorType[][] models) {
        SensorTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SensorTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new SensorTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SensorTypeSoap[] toSoapModels(List<SensorType> models) {
        List<SensorTypeSoap> soapModels = new ArrayList<SensorTypeSoap>(models.size());

        for (SensorType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SensorTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sensorTypeId;
    }

    public void setPrimaryKey(long pk) {
        setSensorTypeId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getSensorTypeId() {
        return _sensorTypeId;
    }

    public void setSensorTypeId(long sensorTypeId) {
        _sensorTypeId = sensorTypeId;
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

    public String getIcon() {
        return _icon;
    }

    public void setIcon(String icon) {
        _icon = icon;
    }
}
