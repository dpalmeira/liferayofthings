package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.ActuatorType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActuatorType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorType
 * @generated
 */
public class ActuatorTypeCacheModel implements CacheModel<ActuatorType>,
    Externalizable {
    public String uuid;
    public long actuatorTypeId;
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
        sb.append(", actuatorTypeId=");
        sb.append(actuatorTypeId);
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
    public ActuatorType toEntityModel() {
        ActuatorTypeImpl actuatorTypeImpl = new ActuatorTypeImpl();

        if (uuid == null) {
            actuatorTypeImpl.setUuid(StringPool.BLANK);
        } else {
            actuatorTypeImpl.setUuid(uuid);
        }

        actuatorTypeImpl.setActuatorTypeId(actuatorTypeId);
        actuatorTypeImpl.setCompanyId(companyId);
        actuatorTypeImpl.setGroupId(groupId);
        actuatorTypeImpl.setUserId(userId);

        if (userName == null) {
            actuatorTypeImpl.setUserName(StringPool.BLANK);
        } else {
            actuatorTypeImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            actuatorTypeImpl.setCreateDate(null);
        } else {
            actuatorTypeImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            actuatorTypeImpl.setModifiedDate(null);
        } else {
            actuatorTypeImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            actuatorTypeImpl.setName(StringPool.BLANK);
        } else {
            actuatorTypeImpl.setName(name);
        }

        if (description == null) {
            actuatorTypeImpl.setDescription(StringPool.BLANK);
        } else {
            actuatorTypeImpl.setDescription(description);
        }

        if (icon == null) {
            actuatorTypeImpl.setIcon(StringPool.BLANK);
        } else {
            actuatorTypeImpl.setIcon(icon);
        }

        actuatorTypeImpl.resetOriginalValues();

        return actuatorTypeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        actuatorTypeId = objectInput.readLong();
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

        objectOutput.writeLong(actuatorTypeId);
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
