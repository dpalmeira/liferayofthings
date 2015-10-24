package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SensorType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorType
 * @generated
 */
public class SensorTypeWrapper implements SensorType, ModelWrapper<SensorType> {
    private SensorType _sensorType;

    public SensorTypeWrapper(SensorType sensorType) {
        _sensorType = sensorType;
    }

    @Override
    public Class<?> getModelClass() {
        return SensorType.class;
    }

    @Override
    public String getModelClassName() {
        return SensorType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("sensorTypeId", getSensorTypeId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("icon", getIcon());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long sensorTypeId = (Long) attributes.get("sensorTypeId");

        if (sensorTypeId != null) {
            setSensorTypeId(sensorTypeId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
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

        String icon = (String) attributes.get("icon");

        if (icon != null) {
            setIcon(icon);
        }
    }

    /**
    * Returns the primary key of this sensor type.
    *
    * @return the primary key of this sensor type
    */
    @Override
    public long getPrimaryKey() {
        return _sensorType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this sensor type.
    *
    * @param primaryKey the primary key of this sensor type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _sensorType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this sensor type.
    *
    * @return the uuid of this sensor type
    */
    @Override
    public java.lang.String getUuid() {
        return _sensorType.getUuid();
    }

    /**
    * Sets the uuid of this sensor type.
    *
    * @param uuid the uuid of this sensor type
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _sensorType.setUuid(uuid);
    }

    /**
    * Returns the sensor type ID of this sensor type.
    *
    * @return the sensor type ID of this sensor type
    */
    @Override
    public long getSensorTypeId() {
        return _sensorType.getSensorTypeId();
    }

    /**
    * Sets the sensor type ID of this sensor type.
    *
    * @param sensorTypeId the sensor type ID of this sensor type
    */
    @Override
    public void setSensorTypeId(long sensorTypeId) {
        _sensorType.setSensorTypeId(sensorTypeId);
    }

    /**
    * Returns the company ID of this sensor type.
    *
    * @return the company ID of this sensor type
    */
    @Override
    public long getCompanyId() {
        return _sensorType.getCompanyId();
    }

    /**
    * Sets the company ID of this sensor type.
    *
    * @param companyId the company ID of this sensor type
    */
    @Override
    public void setCompanyId(long companyId) {
        _sensorType.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this sensor type.
    *
    * @return the group ID of this sensor type
    */
    @Override
    public long getGroupId() {
        return _sensorType.getGroupId();
    }

    /**
    * Sets the group ID of this sensor type.
    *
    * @param groupId the group ID of this sensor type
    */
    @Override
    public void setGroupId(long groupId) {
        _sensorType.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this sensor type.
    *
    * @return the user ID of this sensor type
    */
    @Override
    public long getUserId() {
        return _sensorType.getUserId();
    }

    /**
    * Sets the user ID of this sensor type.
    *
    * @param userId the user ID of this sensor type
    */
    @Override
    public void setUserId(long userId) {
        _sensorType.setUserId(userId);
    }

    /**
    * Returns the user uuid of this sensor type.
    *
    * @return the user uuid of this sensor type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sensorType.getUserUuid();
    }

    /**
    * Sets the user uuid of this sensor type.
    *
    * @param userUuid the user uuid of this sensor type
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _sensorType.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this sensor type.
    *
    * @return the user name of this sensor type
    */
    @Override
    public java.lang.String getUserName() {
        return _sensorType.getUserName();
    }

    /**
    * Sets the user name of this sensor type.
    *
    * @param userName the user name of this sensor type
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _sensorType.setUserName(userName);
    }

    /**
    * Returns the create date of this sensor type.
    *
    * @return the create date of this sensor type
    */
    @Override
    public java.util.Date getCreateDate() {
        return _sensorType.getCreateDate();
    }

    /**
    * Sets the create date of this sensor type.
    *
    * @param createDate the create date of this sensor type
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _sensorType.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this sensor type.
    *
    * @return the modified date of this sensor type
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _sensorType.getModifiedDate();
    }

    /**
    * Sets the modified date of this sensor type.
    *
    * @param modifiedDate the modified date of this sensor type
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _sensorType.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this sensor type.
    *
    * @return the name of this sensor type
    */
    @Override
    public java.lang.String getName() {
        return _sensorType.getName();
    }

    /**
    * Returns the localized name of this sensor type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this sensor type
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _sensorType.getName(locale);
    }

    /**
    * Returns the localized name of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this sensor type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _sensorType.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this sensor type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this sensor type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _sensorType.getName(languageId);
    }

    /**
    * Returns the localized name of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this sensor type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _sensorType.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _sensorType.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _sensorType.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this sensor type.
    *
    * @return the locales and localized names of this sensor type
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _sensorType.getNameMap();
    }

    /**
    * Sets the name of this sensor type.
    *
    * @param name the name of this sensor type
    */
    @Override
    public void setName(java.lang.String name) {
        _sensorType.setName(name);
    }

    /**
    * Sets the localized name of this sensor type in the language.
    *
    * @param name the localized name of this sensor type
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _sensorType.setName(name, locale);
    }

    /**
    * Sets the localized name of this sensor type in the language, and sets the default locale.
    *
    * @param name the localized name of this sensor type
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _sensorType.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _sensorType.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this sensor type from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this sensor type
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _sensorType.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this sensor type from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this sensor type
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _sensorType.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this sensor type.
    *
    * @return the description of this sensor type
    */
    @Override
    public java.lang.String getDescription() {
        return _sensorType.getDescription();
    }

    /**
    * Returns the localized description of this sensor type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this sensor type
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _sensorType.getDescription(locale);
    }

    /**
    * Returns the localized description of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this sensor type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _sensorType.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this sensor type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this sensor type
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _sensorType.getDescription(languageId);
    }

    /**
    * Returns the localized description of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this sensor type
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _sensorType.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _sensorType.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _sensorType.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this sensor type.
    *
    * @return the locales and localized descriptions of this sensor type
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _sensorType.getDescriptionMap();
    }

    /**
    * Sets the description of this sensor type.
    *
    * @param description the description of this sensor type
    */
    @Override
    public void setDescription(java.lang.String description) {
        _sensorType.setDescription(description);
    }

    /**
    * Sets the localized description of this sensor type in the language.
    *
    * @param description the localized description of this sensor type
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _sensorType.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this sensor type in the language, and sets the default locale.
    *
    * @param description the localized description of this sensor type
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _sensorType.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _sensorType.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this sensor type from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this sensor type
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _sensorType.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this sensor type from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this sensor type
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _sensorType.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the icon of this sensor type.
    *
    * @return the icon of this sensor type
    */
    @Override
    public java.lang.String getIcon() {
        return _sensorType.getIcon();
    }

    /**
    * Sets the icon of this sensor type.
    *
    * @param icon the icon of this sensor type
    */
    @Override
    public void setIcon(java.lang.String icon) {
        _sensorType.setIcon(icon);
    }

    @Override
    public boolean isNew() {
        return _sensorType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _sensorType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _sensorType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _sensorType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _sensorType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _sensorType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sensorType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sensorType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _sensorType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _sensorType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sensorType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _sensorType.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _sensorType.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _sensorType.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _sensorType.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new SensorTypeWrapper((SensorType) _sensorType.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType) {
        return _sensorType.compareTo(sensorType);
    }

    @Override
    public int hashCode() {
        return _sensorType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.SensorType> toCacheModel() {
        return _sensorType.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType toEscapedModel() {
        return new SensorTypeWrapper(_sensorType.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType toUnescapedModel() {
        return new SensorTypeWrapper(_sensorType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sensorType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _sensorType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sensorType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SensorTypeWrapper)) {
            return false;
        }

        SensorTypeWrapper sensorTypeWrapper = (SensorTypeWrapper) obj;

        if (Validator.equals(_sensorType, sensorTypeWrapper._sensorType)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _sensorType.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SensorType getWrappedSensorType() {
        return _sensorType;
    }

    @Override
    public SensorType getWrappedModel() {
        return _sensorType;
    }

    @Override
    public void resetOriginalValues() {
        _sensorType.resetOriginalValues();
    }
}
