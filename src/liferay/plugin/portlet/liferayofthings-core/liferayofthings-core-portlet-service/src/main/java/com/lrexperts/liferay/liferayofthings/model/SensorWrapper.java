package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Sensor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sensor
 * @generated
 */
public class SensorWrapper implements Sensor, ModelWrapper<Sensor> {
    private Sensor _sensor;

    public SensorWrapper(Sensor sensor) {
        _sensor = sensor;
    }

    @Override
    public Class<?> getModelClass() {
        return Sensor.class;
    }

    @Override
    public String getModelClassName() {
        return Sensor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("sensorId", getSensorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("thingId", getThingId());
        attributes.put("sensorTypeId", getSensorTypeId());
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

        Long sensorId = (Long) attributes.get("sensorId");

        if (sensorId != null) {
            setSensorId(sensorId);
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

        Long sensorTypeId = (Long) attributes.get("sensorTypeId");

        if (sensorTypeId != null) {
            setSensorTypeId(sensorTypeId);
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

    /**
    * Returns the primary key of this sensor.
    *
    * @return the primary key of this sensor
    */
    @Override
    public long getPrimaryKey() {
        return _sensor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sensor.
    *
    * @param primaryKey the primary key of this sensor
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _sensor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this sensor.
    *
    * @return the uuid of this sensor
    */
    @Override
    public java.lang.String getUuid() {
        return _sensor.getUuid();
    }

    /**
    * Sets the uuid of this sensor.
    *
    * @param uuid the uuid of this sensor
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _sensor.setUuid(uuid);
    }

    /**
    * Returns the sensor ID of this sensor.
    *
    * @return the sensor ID of this sensor
    */
    @Override
    public long getSensorId() {
        return _sensor.getSensorId();
    }

    /**
    * Sets the sensor ID of this sensor.
    *
    * @param sensorId the sensor ID of this sensor
    */
    @Override
    public void setSensorId(long sensorId) {
        _sensor.setSensorId(sensorId);
    }

    /**
    * Returns the company ID of this sensor.
    *
    * @return the company ID of this sensor
    */
    @Override
    public long getCompanyId() {
        return _sensor.getCompanyId();
    }

    /**
    * Sets the company ID of this sensor.
    *
    * @param companyId the company ID of this sensor
    */
    @Override
    public void setCompanyId(long companyId) {
        _sensor.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this sensor.
    *
    * @return the group ID of this sensor
    */
    @Override
    public long getGroupId() {
        return _sensor.getGroupId();
    }

    /**
    * Sets the group ID of this sensor.
    *
    * @param groupId the group ID of this sensor
    */
    @Override
    public void setGroupId(long groupId) {
        _sensor.setGroupId(groupId);
    }

    /**
    * Returns the thing ID of this sensor.
    *
    * @return the thing ID of this sensor
    */
    @Override
    public long getThingId() {
        return _sensor.getThingId();
    }

    /**
    * Sets the thing ID of this sensor.
    *
    * @param thingId the thing ID of this sensor
    */
    @Override
    public void setThingId(long thingId) {
        _sensor.setThingId(thingId);
    }

    /**
    * Returns the sensor type ID of this sensor.
    *
    * @return the sensor type ID of this sensor
    */
    @Override
    public long getSensorTypeId() {
        return _sensor.getSensorTypeId();
    }

    /**
    * Sets the sensor type ID of this sensor.
    *
    * @param sensorTypeId the sensor type ID of this sensor
    */
    @Override
    public void setSensorTypeId(long sensorTypeId) {
        _sensor.setSensorTypeId(sensorTypeId);
    }

    /**
    * Returns the user ID of this sensor.
    *
    * @return the user ID of this sensor
    */
    @Override
    public long getUserId() {
        return _sensor.getUserId();
    }

    /**
    * Sets the user ID of this sensor.
    *
    * @param userId the user ID of this sensor
    */
    @Override
    public void setUserId(long userId) {
        _sensor.setUserId(userId);
    }

    /**
    * Returns the user uuid of this sensor.
    *
    * @return the user uuid of this sensor
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensor.getUserUuid();
    }

    /**
    * Sets the user uuid of this sensor.
    *
    * @param userUuid the user uuid of this sensor
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _sensor.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this sensor.
    *
    * @return the user name of this sensor
    */
    @Override
    public java.lang.String getUserName() {
        return _sensor.getUserName();
    }

    /**
    * Sets the user name of this sensor.
    *
    * @param userName the user name of this sensor
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _sensor.setUserName(userName);
    }

    /**
    * Returns the create date of this sensor.
    *
    * @return the create date of this sensor
    */
    @Override
    public java.util.Date getCreateDate() {
        return _sensor.getCreateDate();
    }

    /**
    * Sets the create date of this sensor.
    *
    * @param createDate the create date of this sensor
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _sensor.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this sensor.
    *
    * @return the modified date of this sensor
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _sensor.getModifiedDate();
    }

    /**
    * Sets the modified date of this sensor.
    *
    * @param modifiedDate the modified date of this sensor
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _sensor.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this sensor.
    *
    * @return the name of this sensor
    */
    @Override
    public java.lang.String getName() {
        return _sensor.getName();
    }

    /**
    * Returns the localized name of this sensor in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this sensor
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _sensor.getName(locale);
    }

    /**
    * Returns the localized name of this sensor in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this sensor. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _sensor.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this sensor in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this sensor
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _sensor.getName(languageId);
    }

    /**
    * Returns the localized name of this sensor in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this sensor
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _sensor.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _sensor.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _sensor.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this sensor.
    *
    * @return the locales and localized names of this sensor
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _sensor.getNameMap();
    }

    /**
    * Sets the name of this sensor.
    *
    * @param name the name of this sensor
    */
    @Override
    public void setName(java.lang.String name) {
        _sensor.setName(name);
    }

    /**
    * Sets the localized name of this sensor in the language.
    *
    * @param name the localized name of this sensor
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _sensor.setName(name, locale);
    }

    /**
    * Sets the localized name of this sensor in the language, and sets the default locale.
    *
    * @param name the localized name of this sensor
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _sensor.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _sensor.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this sensor from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this sensor
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _sensor.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this sensor from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this sensor
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _sensor.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this sensor.
    *
    * @return the description of this sensor
    */
    @Override
    public java.lang.String getDescription() {
        return _sensor.getDescription();
    }

    /**
    * Returns the localized description of this sensor in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this sensor
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _sensor.getDescription(locale);
    }

    /**
    * Returns the localized description of this sensor in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this sensor. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _sensor.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this sensor in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this sensor
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _sensor.getDescription(languageId);
    }

    /**
    * Returns the localized description of this sensor in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this sensor
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _sensor.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _sensor.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _sensor.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this sensor.
    *
    * @return the locales and localized descriptions of this sensor
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _sensor.getDescriptionMap();
    }

    /**
    * Sets the description of this sensor.
    *
    * @param description the description of this sensor
    */
    @Override
    public void setDescription(java.lang.String description) {
        _sensor.setDescription(description);
    }

    /**
    * Sets the localized description of this sensor in the language.
    *
    * @param description the localized description of this sensor
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _sensor.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this sensor in the language, and sets the default locale.
    *
    * @param description the localized description of this sensor
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _sensor.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _sensor.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this sensor from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this sensor
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _sensor.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this sensor from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this sensor
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _sensor.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the endpoint of this sensor.
    *
    * @return the endpoint of this sensor
    */
    @Override
    public java.lang.String getEndpoint() {
        return _sensor.getEndpoint();
    }

    /**
    * Sets the endpoint of this sensor.
    *
    * @param endpoint the endpoint of this sensor
    */
    @Override
    public void setEndpoint(java.lang.String endpoint) {
        _sensor.setEndpoint(endpoint);
    }

    /**
    * Returns the enabled of this sensor.
    *
    * @return the enabled of this sensor
    */
    @Override
    public boolean getEnabled() {
        return _sensor.getEnabled();
    }

    /**
    * Returns <code>true</code> if this sensor is enabled.
    *
    * @return <code>true</code> if this sensor is enabled; <code>false</code> otherwise
    */
    @Override
    public boolean isEnabled() {
        return _sensor.isEnabled();
    }

    /**
    * Sets whether this sensor is enabled.
    *
    * @param enabled the enabled of this sensor
    */
    @Override
    public void setEnabled(boolean enabled) {
        _sensor.setEnabled(enabled);
    }

    /**
    * Returns the status of this sensor.
    *
    * @return the status of this sensor
    */
    @Override
    public int getStatus() {
        return _sensor.getStatus();
    }

    /**
    * Sets the status of this sensor.
    *
    * @param status the status of this sensor
    */
    @Override
    public void setStatus(int status) {
        _sensor.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _sensor.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sensor.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sensor.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sensor.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sensor.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sensor.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sensor.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sensor.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sensor.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sensor.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sensor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _sensor.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _sensor.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _sensor.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _sensor.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new SensorWrapper((Sensor) _sensor.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.Sensor sensor) {
        return _sensor.compareTo(sensor);
    }

    @Override
    public int hashCode() {
        return _sensor.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.Sensor> toCacheModel() {
        return _sensor.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Sensor toEscapedModel() {
        return new SensorWrapper(_sensor.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Sensor toUnescapedModel() {
        return new SensorWrapper(_sensor.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sensor.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sensor.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sensor.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SensorWrapper)) {
            return false;
        }

        SensorWrapper sensorWrapper = (SensorWrapper) obj;

        if (Validator.equals(_sensor, sensorWrapper._sensor)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _sensor.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Sensor getWrappedSensor() {
        return _sensor;
    }

    @Override
    public Sensor getWrappedModel() {
        return _sensor;
    }

    @Override
    public void resetOriginalValues() {
        _sensor.resetOriginalValues();
    }
}
