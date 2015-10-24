package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.Actuator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Actuator in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Actuator
 * @generated
 */
public class ActuatorCacheModel implements CacheModel<Actuator>, Externalizable {
    public String uuid;
    public long actuatorId;
    public long companyId;
    public long groupId;
    public long thingId;
    public long actuatorTypeId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public String endpoint;
    public boolean enabled;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", actuatorId=");
        sb.append(actuatorId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", thingId=");
        sb.append(thingId);
        sb.append(", actuatorTypeId=");
        sb.append(actuatorTypeId);
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
        sb.append(", endpoint=");
        sb.append(endpoint);
        sb.append(", enabled=");
        sb.append(enabled);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Actuator toEntityModel() {
        ActuatorImpl actuatorImpl = new ActuatorImpl();

        if (uuid == null) {
            actuatorImpl.setUuid(StringPool.BLANK);
        } else {
            actuatorImpl.setUuid(uuid);
        }

        actuatorImpl.setActuatorId(actuatorId);
        actuatorImpl.setCompanyId(companyId);
        actuatorImpl.setGroupId(groupId);
        actuatorImpl.setThingId(thingId);
        actuatorImpl.setActuatorTypeId(actuatorTypeId);
        actuatorImpl.setUserId(userId);

        if (userName == null) {
            actuatorImpl.setUserName(StringPool.BLANK);
        } else {
            actuatorImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            actuatorImpl.setCreateDate(null);
        } else {
            actuatorImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            actuatorImpl.setModifiedDate(null);
        } else {
            actuatorImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            actuatorImpl.setName(StringPool.BLANK);
        } else {
            actuatorImpl.setName(name);
        }

        if (description == null) {
            actuatorImpl.setDescription(StringPool.BLANK);
        } else {
            actuatorImpl.setDescription(description);
        }

        if (endpoint == null) {
            actuatorImpl.setEndpoint(StringPool.BLANK);
        } else {
            actuatorImpl.setEndpoint(endpoint);
        }

        actuatorImpl.setEnabled(enabled);
        actuatorImpl.setStatus(status);

        actuatorImpl.resetOriginalValues();

        return actuatorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        actuatorId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        thingId = objectInput.readLong();
        actuatorTypeId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        endpoint = objectInput.readUTF();
        enabled = objectInput.readBoolean();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(actuatorId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(thingId);
        objectOutput.writeLong(actuatorTypeId);
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

        if (endpoint == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(endpoint);
        }

        objectOutput.writeBoolean(enabled);
        objectOutput.writeInt(status);
    }
}
