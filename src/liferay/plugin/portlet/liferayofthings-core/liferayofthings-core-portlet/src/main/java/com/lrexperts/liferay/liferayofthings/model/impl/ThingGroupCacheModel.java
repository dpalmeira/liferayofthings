package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.ThingGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ThingGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroup
 * @generated
 */
public class ThingGroupCacheModel implements CacheModel<ThingGroup>,
    Externalizable {
    public String uuid;
    public long thingGroupId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public boolean enabled;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", thingGroupId=");
        sb.append(thingGroupId);
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
        sb.append(", enabled=");
        sb.append(enabled);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ThingGroup toEntityModel() {
        ThingGroupImpl thingGroupImpl = new ThingGroupImpl();

        if (uuid == null) {
            thingGroupImpl.setUuid(StringPool.BLANK);
        } else {
            thingGroupImpl.setUuid(uuid);
        }

        thingGroupImpl.setThingGroupId(thingGroupId);
        thingGroupImpl.setCompanyId(companyId);
        thingGroupImpl.setGroupId(groupId);
        thingGroupImpl.setUserId(userId);

        if (userName == null) {
            thingGroupImpl.setUserName(StringPool.BLANK);
        } else {
            thingGroupImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            thingGroupImpl.setCreateDate(null);
        } else {
            thingGroupImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            thingGroupImpl.setModifiedDate(null);
        } else {
            thingGroupImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            thingGroupImpl.setName(StringPool.BLANK);
        } else {
            thingGroupImpl.setName(name);
        }

        if (description == null) {
            thingGroupImpl.setDescription(StringPool.BLANK);
        } else {
            thingGroupImpl.setDescription(description);
        }

        thingGroupImpl.setEnabled(enabled);

        thingGroupImpl.resetOriginalValues();

        return thingGroupImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        thingGroupId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        enabled = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(thingGroupId);
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

        objectOutput.writeBoolean(enabled);
    }
}
