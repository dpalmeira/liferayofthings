package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.SensorType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SensorType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SensorType
 * @generated
 */
public class SensorTypeCacheModel implements CacheModel<SensorType>,
    Externalizable {
    public String uuid;
    public long sensorTypeId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public String icon;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", sensorTypeId=");
        sb.append(sensorTypeId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", icon=");
        sb.append(icon);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SensorType toEntityModel() {
        SensorTypeImpl sensorTypeImpl = new SensorTypeImpl();

        if (uuid == null) {
            sensorTypeImpl.setUuid(StringPool.BLANK);
        } else {
            sensorTypeImpl.setUuid(uuid);
        }

        sensorTypeImpl.setSensorTypeId(sensorTypeId);
        sensorTypeImpl.setCompanyId(companyId);
        sensorTypeImpl.setGroupId(groupId);
        sensorTypeImpl.setUserId(userId);

        if (userName == null) {
            sensorTypeImpl.setUserName(StringPool.BLANK);
        } else {
            sensorTypeImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            sensorTypeImpl.setCreateDate(null);
        } else {
            sensorTypeImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            sensorTypeImpl.setModifiedDate(null);
        } else {
            sensorTypeImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            sensorTypeImpl.setName(StringPool.BLANK);
        } else {
            sensorTypeImpl.setName(name);
        }

        if (description == null) {
            sensorTypeImpl.setDescription(StringPool.BLANK);
        } else {
            sensorTypeImpl.setDescription(description);
        }

        if (icon == null) {
            sensorTypeImpl.setIcon(StringPool.BLANK);
        } else {
            sensorTypeImpl.setIcon(icon);
        }

        sensorTypeImpl.resetOriginalValues();

        return sensorTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        sensorTypeId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        icon = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(sensorTypeId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (icon == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(icon);
        }
    }
}
