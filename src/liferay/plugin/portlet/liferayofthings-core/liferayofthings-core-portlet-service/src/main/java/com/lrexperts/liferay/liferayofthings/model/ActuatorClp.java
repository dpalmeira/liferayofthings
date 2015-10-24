package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ActuatorClp extends BaseModelImpl<Actuator> implements Actuator {
    private String _uuid;
    private long _actuatorId;
    private long _companyId;
    private long _groupId;
    private long _thingId;
    private long _actuatorTypeId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _nameCurrentLanguageId;
    private String _description;
    private String _descriptionCurrentLanguageId;
    private String _endpoint;
    private boolean _enabled;
    private int _status;
    private BaseModel<?> _actuatorRemoteModel;
    private Class<?> _clpSerializerClass = com.lrexperts.liferay.liferayofthings.service.ClpSerializer.class;

    public ActuatorClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Actuator.class;
    }

    @Override
    public String getModelClassName() {
        return Actuator.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _actuatorId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setActuatorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _actuatorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("actuatorId", getActuatorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("thingId", getThingId());
        attributes.put("actuatorTypeId", getActuatorTypeId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("endpoint", getEndpoint());
        attributes.put("enabled", getEnabled());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long actuatorId = (Long) attributes.get("actuatorId");

        if (actuatorId != null) {
            setActuatorId(actuatorId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long thingId = (Long) attributes.get("thingId");

        if (thingId != null) {
            setThingId(thingId);
        }

        Long actuatorTypeId = (Long) attributes.get("actuatorTypeId");

        if (actuatorTypeId != null) {
            setActuatorTypeId(actuatorTypeId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String endpoint = (String) attributes.get("endpoint");

        if (endpoint != null) {
            setEndpoint(endpoint);
        }

        Boolean enabled = (Boolean) attributes.get("enabled");

        if (enabled != null) {
            setEnabled(enabled);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_actuatorRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getActuatorId() {
        return _actuatorId;
    }

    @Override
    public void setActuatorId(long actuatorId) {
        _actuatorId = actuatorId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setActuatorId", long.class);

                method.invoke(_actuatorRemoteModel, actuatorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_actuatorRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_actuatorRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getThingId() {
        return _thingId;
    }

    @Override
    public void setThingId(long thingId) {
        _thingId = thingId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setThingId", long.class);

                method.invoke(_actuatorRemoteModel, thingId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getActuatorTypeId() {
        return _actuatorTypeId;
    }

    @Override
    public void setActuatorTypeId(long actuatorTypeId) {
        _actuatorTypeId = actuatorTypeId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setActuatorTypeId", long.class);

                method.invoke(_actuatorRemoteModel, actuatorTypeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_actuatorRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_actuatorRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_actuatorRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_actuatorRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getName(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId);
    }

    @Override
    public String getName(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId, useDefault);
    }

    @Override
    public String getName(String languageId) {
        return LocalizationUtil.getLocalization(getName(), languageId);
    }

    @Override
    public String getName(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getName(), languageId,
            useDefault);
    }

    @Override
    public String getNameCurrentLanguageId() {
        return _nameCurrentLanguageId;
    }

    @Override
    public String getNameCurrentValue() {
        Locale locale = getLocale(_nameCurrentLanguageId);

        return getName(locale);
    }

    @Override
    public Map<Locale, String> getNameMap() {
        return LocalizationUtil.getLocalizationMap(getName());
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_actuatorRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setName(String name, Locale locale) {
        setName(name, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setName(String name, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(name)) {
            setName(LocalizationUtil.updateLocalization(getName(), "Name",
                    name, languageId, defaultLanguageId));
        } else {
            setName(LocalizationUtil.removeLocalization(getName(), "Name",
                    languageId));
        }
    }

    @Override
    public void setNameCurrentLanguageId(String languageId) {
        _nameCurrentLanguageId = languageId;
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap) {
        setNameMap(nameMap, LocaleUtil.getDefault());
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
        if (nameMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setName(LocalizationUtil.updateLocalization(nameMap, getName(),
                    "Name", LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public String getDescription(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId);
    }

    @Override
    public String getDescription(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId, useDefault);
    }

    @Override
    public String getDescription(String languageId) {
        return LocalizationUtil.getLocalization(getDescription(), languageId);
    }

    @Override
    public String getDescription(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getDescription(), languageId,
            useDefault);
    }

    @Override
    public String getDescriptionCurrentLanguageId() {
        return _descriptionCurrentLanguageId;
    }

    @Override
    public String getDescriptionCurrentValue() {
        Locale locale = getLocale(_descriptionCurrentLanguageId);

        return getDescription(locale);
    }

    @Override
    public Map<Locale, String> getDescriptionMap() {
        return LocalizationUtil.getLocalizationMap(getDescription());
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_actuatorRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setDescription(String description, Locale locale) {
        setDescription(description, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setDescription(String description, Locale locale,
        Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(description)) {
            setDescription(LocalizationUtil.updateLocalization(
                    getDescription(), "Description", description, languageId,
                    defaultLanguageId));
        } else {
            setDescription(LocalizationUtil.removeLocalization(
                    getDescription(), "Description", languageId));
        }
    }

    @Override
    public void setDescriptionCurrentLanguageId(String languageId) {
        _descriptionCurrentLanguageId = languageId;
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap) {
        setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale) {
        if (descriptionMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setDescription(LocalizationUtil.updateLocalization(descriptionMap,
                    getDescription(), "Description",
                    LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public String getEndpoint() {
        return _endpoint;
    }

    @Override
    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setEndpoint", String.class);

                method.invoke(_actuatorRemoteModel, endpoint);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getEnabled() {
        return _enabled;
    }

    @Override
    public boolean isEnabled() {
        return _enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        _enabled = enabled;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setEnabled", boolean.class);

                method.invoke(_actuatorRemoteModel, enabled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_actuatorRemoteModel != null) {
            try {
                Class<?> clazz = _actuatorRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_actuatorRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Actuator.class.getName()));
    }

    public BaseModel<?> getActuatorRemoteModel() {
        return _actuatorRemoteModel;
    }

    public void setActuatorRemoteModel(BaseModel<?> actuatorRemoteModel) {
        _actuatorRemoteModel = actuatorRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _actuatorRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_actuatorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ActuatorLocalServiceUtil.addActuator(this);
        } else {
            ActuatorLocalServiceUtil.updateActuator(this);
        }
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> nameMap = getNameMap();

        for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        Map<Locale, String> descriptionMap = getDescriptionMap();

        for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
    }

    @Override
    public String getDefaultLanguageId() {
        String xml = getName();

        if (xml == null) {
            return StringPool.BLANK;
        }

        Locale defaultLocale = LocaleUtil.getSiteDefault();

        return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
    }

    @Override
    public void prepareLocalizedFieldsForImport() throws LocaleException {
        prepareLocalizedFieldsForImport(null);
    }

    @Override
    @SuppressWarnings("unused")
    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException {
        Locale defaultLocale = LocaleUtil.getSiteDefault();

        String modelDefaultLanguageId = getDefaultLanguageId();

        String name = getName(defaultLocale);

        if (Validator.isNull(name)) {
            setName(getName(modelDefaultLanguageId), defaultLocale);
        } else {
            setName(getName(defaultLocale), defaultLocale, defaultLocale);
        }

        String description = getDescription(defaultLocale);

        if (Validator.isNull(description)) {
            setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
        } else {
            setDescription(getDescription(defaultLocale), defaultLocale,
                defaultLocale);
        }
    }

    @Override
    public Actuator toEscapedModel() {
        return (Actuator) ProxyUtil.newProxyInstance(Actuator.class.getClassLoader(),
            new Class[] { Actuator.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ActuatorClp clone = new ActuatorClp();

        clone.setUuid(getUuid());
        clone.setActuatorId(getActuatorId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setThingId(getThingId());
        clone.setActuatorTypeId(getActuatorTypeId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setEndpoint(getEndpoint());
        clone.setEnabled(getEnabled());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(Actuator actuator) {
        int value = 0;

        value = getName().compareTo(actuator.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ActuatorClp)) {
            return false;
        }

        ActuatorClp actuator = (ActuatorClp) obj;

        long primaryKey = actuator.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(31);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", actuatorId=");
        sb.append(getActuatorId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", thingId=");
        sb.append(getThingId());
        sb.append(", actuatorTypeId=");
        sb.append(getActuatorTypeId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", endpoint=");
        sb.append(getEndpoint());
        sb.append(", enabled=");
        sb.append(getEnabled());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(49);

        sb.append("<model><model-name>");
        sb.append("com.lrexperts.liferay.liferayofthings.model.Actuator");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>actuatorId</column-name><column-value><![CDATA[");
        sb.append(getActuatorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>thingId</column-name><column-value><![CDATA[");
        sb.append(getThingId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>actuatorTypeId</column-name><column-value><![CDATA[");
        sb.append(getActuatorTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endpoint</column-name><column-value><![CDATA[");
        sb.append(getEndpoint());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enabled</column-name><column-value><![CDATA[");
        sb.append(getEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
