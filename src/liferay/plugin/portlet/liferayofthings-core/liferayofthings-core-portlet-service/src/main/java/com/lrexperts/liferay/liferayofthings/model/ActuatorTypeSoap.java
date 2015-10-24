package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.ActuatorTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.ActuatorTypeServiceSoap
 * @generated
 */
public class ActuatorTypeSoap implements Serializable {
    private String _uuid;
    private long _actuatorTypeId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private String _icon;

    public ActuatorTypeSoap() {
    }

    public static ActuatorTypeSoap toSoapModel(ActuatorType model) {
        ActuatorTypeSoap soapModel = new ActuatorTypeSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setActuatorTypeId(model.getActuatorTypeId());
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

    public static ActuatorTypeSoap[] toSoapModels(ActuatorType[] models) {
        ActuatorTypeSoap[] soapModels = new ActuatorTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ActuatorTypeSoap[][] toSoapModels(ActuatorType[][] models) {
        ActuatorTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ActuatorTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new ActuatorTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ActuatorTypeSoap[] toSoapModels(List<ActuatorType> models) {
        List<ActuatorTypeSoap> soapModels = new ArrayList<ActuatorTypeSoap>(models.size());

        for (ActuatorType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ActuatorTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _actuatorTypeId;
    }

    public void setPrimaryKey(long pk) {
        setActuatorTypeId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getActuatorTypeId() {
        return _actuatorTypeId;
    }

    public void setActuatorTypeId(long actuatorTypeId) {
        _actuatorTypeId = actuatorTypeId;
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
