package com.lrexperts.liferay.liferayofthings.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lrexperts.liferay.liferayofthings.service.http.ThingGroupServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.lrexperts.liferay.liferayofthings.service.http.ThingGroupServiceSoap
 * @generated
 */
public class ThingGroupSoap implements Serializable {
    private String _uuid;
    private long _thingGroupId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _description;
    private boolean _enabled;

    public ThingGroupSoap() {
    }

    public static ThingGroupSoap toSoapModel(ThingGroup model) {
        ThingGroupSoap soapModel = new ThingGroupSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setThingGroupId(model.getThingGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setEnabled(model.getEnabled());

        return soapModel;
    }

    public static ThingGroupSoap[] toSoapModels(ThingGroup[] models) {
        ThingGroupSoap[] soapModels = new ThingGroupSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ThingGroupSoap[][] toSoapModels(ThingGroup[][] models) {
        ThingGroupSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ThingGroupSoap[models.length][models[0].length];
        } else {
            soapModels = new ThingGroupSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ThingGroupSoap[] toSoapModels(List<ThingGroup> models) {
        List<ThingGroupSoap> soapModels = new ArrayList<ThingGroupSoap>(models.size());

        for (ThingGroup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ThingGroupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _thingGroupId;
    }

    public void setPrimaryKey(long pk) {
        setThingGroupId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getThingGroupId() {
        return _thingGroupId;
    }

    public void setThingGroupId(long thingGroupId) {
        _thingGroupId = thingGroupId;
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

    public boolean getEnabled() {
        return _enabled;
    }

    public boolean isEnabled() {
        return _enabled;
    }

    public void setEnabled(boolean enabled) {
        _enabled = enabled;
    }
}
