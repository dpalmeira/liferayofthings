package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ActuatorType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorType
 * @generated
 */
public class ActuatorTypeWrapper implements ActuatorType,
    ModelWrapper<ActuatorType> {
    private ActuatorType _actuatorType;

    public ActuatorTypeWrapper(ActuatorType actuatorType) {
        _actuatorType = actuatorType;
    }

    @Override
    public Class<?> getModelClass() {
        return ActuatorType.class;
    }

    @Override
    public String getModelClassName() {
        return ActuatorType.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("actuatorTypeId", getActuatorTypeId());
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

        Long actuatorTypeId = (Long) attributes.get("actuatorTypeId");

        if (actuatorTypeId != null) {
            setActuatorTypeId(actuatorTypeId);
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
    * Returns the primary key of this actuator type.
    *
    * @return the primary key of this actuator type
    */
    @Override
    public long getPrimaryKey() {
        return _actuatorType.getPrimaryKey();
    }

    /**
    * Sets the primary key of this actuator type.
    *
    * @param primaryKey the primary key of this actuator type
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _actuatorType.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this actuator type.
    *
    * @return the uuid of this actuator type
    */
    @Override
    public java.lang.String getUuid() {
        return _actuatorType.getUuid();
    }

    /**
    * Sets the uuid of this actuator type.
    *
    * @param uuid the uuid of this actuator type
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _actuatorType.setUuid(uuid);
    }

    /**
    * Returns the actuator type ID of this actuator type.
    *
    * @return the actuator type ID of this actuator type
    */
    @Override
    public long getActuatorTypeId() {
        return _actuatorType.getActuatorTypeId();
    }

    /**
    * Sets the actuator type ID of this actuator type.
    *
    * @param actuatorTypeId the actuator type ID of this actuator type
    */
    @Override
    public void setActuatorTypeId(long actuatorTypeId) {
        _actuatorType.setActuatorTypeId(actuatorTypeId);
    }

    /**
    * Returns the company ID of this actuator type.
    *
    * @return the company ID of this actuator type
    */
    @Override
    public long getCompanyId() {
        return _actuatorType.getCompanyId();
    }

    /**
    * Sets the company ID of this actuator type.
    *
    * @param companyId the company ID of this actuator type
    */
    @Override
    public void setCompanyId(long companyId) {
        _actuatorType.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this actuator type.
    *
    * @return the group ID of this actuator type
    */
    @Override
    public long getGroupId() {
        return _actuatorType.getGroupId();
    }

    /**
    * Sets the group ID of this actuator type.
    *
    * @param groupId the group ID of this actuator type
    */
    @Override
    public void setGroupId(long groupId) {
        _actuatorType.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this actuator type.
    *
    * @return the user ID of this actuator type
    */
    @Override
    public long getUserId() {
        return _actuatorType.getUserId();
    }

    /**
    * Sets the user ID of this actuator type.
    *
    * @param userId the user ID of this actuator type
    */
    @Override
    public void setUserId(long userId) {
        _actuatorType.setUserId(userId);
    }

    /**
    * Returns the user uuid of this actuator type.
    *
    * @return the user uuid of this actuator type
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuatorType.getUserUuid();
    }

    /**
    * Sets the user uuid of this actuator type.
    *
    * @param userUuid the user uuid of this actuator type
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _actuatorType.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this actuator type.
    *
    * @return the user name of this actuator type
    */
    @Override
    public java.lang.String getUserName() {
        return _actuatorType.getUserName();
    }

    /**
    * Sets the user name of this actuator type.
    *
    * @param userName the user name of this actuator type
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _actuatorType.setUserName(userName);
    }

    /**
    * Returns the create date of this actuator type.
    *
    * @return the create date of this actuator type
    */
    @Override
    public java.util.Date getCreateDate() {
        return _actuatorType.getCreateDate();
    }

    /**
    * Sets the create date of this actuator type.
    *
    * @param createDate the create date of this actuator type
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _actuatorType.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this actuator type.
    *
    * @return the modified date of this actuator type
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _actuatorType.getModifiedDate();
    }

    /**
    * Sets the modified date of this actuator type.
    *
    * @param modifiedDate the modified date of this actuator type
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _actuatorType.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this actuator type.
    *
    * @return the name of this actuator type
    */
    @Override
    public java.lang.String getName() {
        return _actuatorType.getName();
    }

    /**
    * Returns the localized name of this actuator type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this actuator type
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _actuatorType.getName(locale);
    }

    /**
    * Returns the localized name of this actuator type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this actuator type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _actuatorType.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this actuator type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this actuator type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _actuatorType.getName(languageId);
    }

    /**
    * Returns the localized name of this actuator type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this actuator type
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _actuatorType.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _actuatorType.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _actuatorType.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this actuator type.
    *
    * @return the locales and localized names of this actuator type
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _actuatorType.getNameMap();
    }

    /**
    * Sets the name of this actuator type.
    *
    * @param name the name of this actuator type
    */
    @Override
    public void setName(java.lang.String name) {
        _actuatorType.setName(name);
    }

    /**
    * Sets the localized name of this actuator type in the language.
    *
    * @param name the localized name of this actuator type
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _actuatorType.setName(name, locale);
    }

    /**
    * Sets the localized name of this actuator type in the language, and sets the default locale.
    *
    * @param name the localized name of this actuator type
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _actuatorType.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _actuatorType.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this actuator type from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this actuator type
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _actuatorType.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this actuator type from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this actuator type
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _actuatorType.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this actuator type.
    *
    * @return the description of this actuator type
    */
    @Override
    public java.lang.String getDescription() {
        return _actuatorType.getDescription();
    }

    /**
    * Returns the localized description of this actuator type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this actuator type
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _actuatorType.getDescription(locale);
    }

    /**
    * Returns the localized description of this actuator type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this actuator type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _actuatorType.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this actuator type in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this actuator type
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _actuatorType.getDescription(languageId);
    }

    /**
    * Returns the localized description of this actuator type in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this actuator type
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _actuatorType.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _actuatorType.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _actuatorType.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this actuator type.
    *
    * @return the locales and localized descriptions of this actuator type
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _actuatorType.getDescriptionMap();
    }

    /**
    * Sets the description of this actuator type.
    *
    * @param description the description of this actuator type
    */
    @Override
    public void setDescription(java.lang.String description) {
        _actuatorType.setDescription(description);
    }

    /**
    * Sets the localized description of this actuator type in the language.
    *
    * @param description the localized description of this actuator type
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _actuatorType.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this actuator type in the language, and sets the default locale.
    *
    * @param description the localized description of this actuator type
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _actuatorType.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _actuatorType.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this actuator type from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this actuator type
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _actuatorType.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this actuator type from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this actuator type
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _actuatorType.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the icon of this actuator type.
    *
    * @return the icon of this actuator type
    */
    @Override
    public java.lang.String getIcon() {
        return _actuatorType.getIcon();
    }

    /**
    * Sets the icon of this actuator type.
    *
    * @param icon the icon of this actuator type
    */
    @Override
    public void setIcon(java.lang.String icon) {
        _actuatorType.setIcon(icon);
    }

    @Override
    public boolean isNew() {
        return _actuatorType.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _actuatorType.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _actuatorType.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _actuatorType.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _actuatorType.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _actuatorType.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _actuatorType.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _actuatorType.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _actuatorType.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _actuatorType.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _actuatorType.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _actuatorType.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _actuatorType.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _actuatorType.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _actuatorType.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new ActuatorTypeWrapper((ActuatorType) _actuatorType.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType) {
        return _actuatorType.compareTo(actuatorType);
    }

    @Override
    public int hashCode() {
        return _actuatorType.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.ActuatorType> toCacheModel() {
        return _actuatorType.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType toEscapedModel() {
        return new ActuatorTypeWrapper(_actuatorType.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.ActuatorType toUnescapedModel() {
        return new ActuatorTypeWrapper(_actuatorType.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _actuatorType.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _actuatorType.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _actuatorType.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ActuatorTypeWrapper)) {
            return false;
        }

        ActuatorTypeWrapper actuatorTypeWrapper = (ActuatorTypeWrapper) obj;

        if (Validator.equals(_actuatorType, actuatorTypeWrapper._actuatorType)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _actuatorType.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ActuatorType getWrappedActuatorType() {
        return _actuatorType;
    }

    @Override
    public ActuatorType getWrappedModel() {
        return _actuatorType;
    }

    @Override
    public void resetOriginalValues() {
        _actuatorType.resetOriginalValues();
    }
}
