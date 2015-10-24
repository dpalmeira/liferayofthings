package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.Thing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Thing in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Thing
 * @generated
 */
public class ThingCacheModel implements CacheModel<Thing>, Externalizable {
    public String uuid;
    public long thingId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public long thingGroupId;
    public String name;
    public String description;
    public String endpoint;
    public boolean enabled;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", thingId=");
        sb.append(thingId);
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
        sb.append(", thingGroupId=");
        sb.append(thingGroupId);
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
    public Thing toEntityModel() {
        ThingImpl thingImpl = new ThingImpl();

        if (uuid == null) {
            thingImpl.setUuid(StringPool.BLANK);
        } else {
            thingImpl.setUuid(uuid);
        }

        thingImpl.setThingId(thingId);
        thingImpl.setCompanyId(companyId);
        thingImpl.setGroupId(groupId);
        thingImpl.setUserId(userId);

        if (userName == null) {
            thingImpl.setUserName(StringPool.BLANK);
        } else {
            thingImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            thingImpl.setCreateDate(null);
        } else {
            thingImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            thingImpl.setModifiedDate(null);
        } else {
            thingImpl.setModifiedDate(new Date(modifiedDate));
        }

        thingImpl.setThingGroupId(thingGroupId);

        if (name == null) {
            thingImpl.setName(StringPool.BLANK);
        } else {
            thingImpl.setName(name);
        }

        if (description == null) {
            thingImpl.setDescription(StringPool.BLANK);
        } else {
            thingImpl.setDescription(description);
        }

        if (endpoint == null) {
            thingImpl.setEndpoint(StringPool.BLANK);
        } else {
            thingImpl.setEndpoint(endpoint);
        }

        thingImpl.setEnabled(enabled);
        thingImpl.setStatus(status);

        thingImpl.resetOriginalValues();

        return thingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        thingId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        thingGroupId = objectInput.readLong();
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

        objectOutput.writeLong(thingId);
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
        objectOutput.writeLong(thingGroupId);

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
