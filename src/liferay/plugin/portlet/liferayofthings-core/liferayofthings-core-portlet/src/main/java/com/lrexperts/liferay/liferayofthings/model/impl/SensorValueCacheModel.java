package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lrexperts.liferay.liferayofthings.model.SensorValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SensorValue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SensorValue
 * @generated
 */
public class SensorValueCacheModel implements CacheModel<SensorValue>,
    Externalizable {
    public String uuid;
    public long sensorValueId;
    public long companyId;
    public long groupId;
    public long sensorId;
    public String value;
    public long createDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", sensorValueId=");
        sb.append(sensorValueId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", sensorId=");
        sb.append(sensorId);
        sb.append(", value=");
        sb.append(value);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SensorValue toEntityModel() {
        SensorValueImpl sensorValueImpl = new SensorValueImpl();

        if (uuid == null) {
            sensorValueImpl.setUuid(StringPool.BLANK);
        } else {
            sensorValueImpl.setUuid(uuid);
        }

        sensorValueImpl.setSensorValueId(sensorValueId);
        sensorValueImpl.setCompanyId(companyId);
        sensorValueImpl.setGroupId(groupId);
        sensorValueImpl.setSensorId(sensorId);

        if (value == null) {
            sensorValueImpl.setValue(StringPool.BLANK);
        } else {
            sensorValueImpl.setValue(value);
        }

        if (createDate == Long.MIN_VALUE) {
            sensorValueImpl.setCreateDate(null);
        } else {
            sensorValueImpl.setCreateDate(new Date(createDate));
        }

        sensorValueImpl.resetOriginalValues();

        return sensorValueImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        sensorValueId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        sensorId = objectInput.readLong();
        value = objectInput.readUTF();
        createDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(sensorValueId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(sensorId);

        if (value == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(value);
        }

        objectOutput.writeLong(createDate);
    }
}
