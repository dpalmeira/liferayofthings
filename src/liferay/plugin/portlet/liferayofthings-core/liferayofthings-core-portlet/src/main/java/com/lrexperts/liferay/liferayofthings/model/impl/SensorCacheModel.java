package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.Sensor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sensor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Sensor
 * @generated
 */
public class SensorCacheModel implements CacheModel<Sensor>, Externalizable {
    public String uuid;
    public long sensorId;
    public long companyId;
    public long groupId;
    public long thingId;
    public long sensorTypeId;
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
        sb.append(", sensorId=");
        sb.append(sensorId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", thingId=");
        sb.append(thingId);
        sb.append(", sensorTypeId=");
        sb.append(sensorTypeId);
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
    public Sensor toEntityModel() {
        SensorImpl sensorImpl = new SensorImpl();

        if (uuid == null) {
            sensorImpl.setUuid(StringPool.BLANK);
        } else {
            sensorImpl.setUuid(uuid);
        }

        sensorImpl.setSensorId(sensorId);
        sensorImpl.setCompanyId(companyId);
        sensorImpl.setGroupId(groupId);
        sensorImpl.setThingId(thingId);
        sensorImpl.setSensorTypeId(sensorTypeId);
        sensorImpl.setUserId(userId);

        if (userName == null) {
            sensorImpl.setUserName(StringPool.BLANK);
        } else {
            sensorImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            sensorImpl.setCreateDate(null);
        } else {
            sensorImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            sensorImpl.setModifiedDate(null);
        } else {
            sensorImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            sensorImpl.setName(StringPool.BLANK);
        } else {
            sensorImpl.setName(name);
        }

        if (description == null) {
            sensorImpl.setDescription(StringPool.BLANK);
        } else {
            sensorImpl.setDescription(description);
        }

        if (endpoint == null) {
            sensorImpl.setEndpoint(StringPool.BLANK);
        } else {
            sensorImpl.setEndpoint(endpoint);
        }

        sensorImpl.setEnabled(enabled);
        sensorImpl.setStatus(status);

        sensorImpl.resetOriginalValues();

        return sensorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        sensorId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        thingId = objectInput.readLong();
        sensorTypeId = objectInput.readLong();
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

        objectOutput.writeLong(sensorId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(thingId);
        objectOutput.writeLong(sensorTypeId);
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
