package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Actuator}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Actuator
 * @generated
 */
public class ActuatorWrapper implements Actuator, ModelWrapper<Actuator> {
    private Actuator _actuator;

    public ActuatorWrapper(Actuator actuator) {
        _actuator = actuator;
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

    /**
    * Returns the primary key of this actuator.
    *
    * @return the primary key of this actuator
    */
    @Override
    public long getPrimaryKey() {
        return _actuator.getPrimaryKey();
    }

    /**
    * Sets the primary key of this actuator.
    *
    * @param primaryKey the primary key of this actuator
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _actuator.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this actuator.
    *
    * @return the uuid of this actuator
    */
    @Override
    public java.lang.String getUuid() {
        return _actuator.getUuid();
    }

    /**
    * Sets the uuid of this actuator.
    *
    * @param uuid the uuid of this actuator
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _actuator.setUuid(uuid);
    }

    /**
    * Returns the actuator ID of this actuator.
    *
    * @return the actuator ID of this actuator
    */
    @Override
    public long getActuatorId() {
        return _actuator.getActuatorId();
    }

    /**
    * Sets the actuator ID of this actuator.
    *
    * @param actuatorId the actuator ID of this actuator
    */
    @Override
    public void setActuatorId(long actuatorId) {
        _actuator.setActuatorId(actuatorId);
    }

    /**
    * Returns the company ID of this actuator.
    *
    * @return the company ID of this actuator
    */
    @Override
    public long getCompanyId() {
        return _actuator.getCompanyId();
    }

    /**
    * Sets the company ID of this actuator.
    *
    * @param companyId the company ID of this actuator
    */
    @Override
    public void setCompanyId(long companyId) {
        _actuator.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this actuator.
    *
    * @return the group ID of this actuator
    */
    @Override
    public long getGroupId() {
        return _actuator.getGroupId();
    }

    /**
    * Sets the group ID of this actuator.
    *
    * @param groupId the group ID of this actuator
    */
    @Override
    public void setGroupId(long groupId) {
        _actuator.setGroupId(groupId);
    }

    /**
    * Returns the thing ID of this actuator.
    *
    * @return the thing ID of this actuator
    */
    @Override
    public long getThingId() {
        return _actuator.getThingId();
    }

    /**
    * Sets the thing ID of this actuator.
    *
    * @param thingId the thing ID of this actuator
    */
    @Override
    public void setThingId(long thingId) {
        _actuator.setThingId(thingId);
    }

    /**
    * Returns the actuator type ID of this actuator.
    *
    * @return the actuator type ID of this actuator
    */
    @Override
    public long getActuatorTypeId() {
        return _actuator.getActuatorTypeId();
    }

    /**
    * Sets the actuator type ID of this actuator.
    *
    * @param actuatorTypeId the actuator type ID of this actuator
    */
    @Override
    public void setActuatorTypeId(long actuatorTypeId) {
        _actuator.setActuatorTypeId(actuatorTypeId);
    }

    /**
    * Returns the user ID of this actuator.
    *
    * @return the user ID of this actuator
    */
    @Override
    public long getUserId() {
        return _actuator.getUserId();
    }

    /**
    * Sets the user ID of this actuator.
    *
    * @param userId the user ID of this actuator
    */
    @Override
    public void setUserId(long userId) {
        _actuator.setUserId(userId);
    }

    /**
    * Returns the user uuid of this actuator.
    *
    * @return the user uuid of this actuator
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _actuator.getUserUuid();
    }

    /**
    * Sets the user uuid of this actuator.
    *
    * @param userUuid the user uuid of this actuator
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _actuator.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this actuator.
    *
    * @return the user name of this actuator
    */
    @Override
    public java.lang.String getUserName() {
        return _actuator.getUserName();
    }

    /**
    * Sets the user name of this actuator.
    *
    * @param userName the user name of this actuator
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _actuator.setUserName(userName);
    }

    /**
    * Returns the create date of this actuator.
    *
    * @return the create date of this actuator
    */
    @Override
    public java.util.Date getCreateDate() {
        return _actuator.getCreateDate();
    }

    /**
    * Sets the create date of this actuator.
    *
    * @param createDate the create date of this actuator
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _actuator.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this actuator.
    *
    * @return the modified date of this actuator
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _actuator.getModifiedDate();
    }

    /**
    * Sets the modified date of this actuator.
    *
    * @param modifiedDate the modified date of this actuator
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _actuator.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this actuator.
    *
    * @return the name of this actuator
    */
    @Override
    public java.lang.String getName() {
        return _actuator.getName();
    }

    /**
    * Returns the localized name of this actuator in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this actuator
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _actuator.getName(locale);
    }

    /**
    * Returns the localized name of this actuator in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this actuator. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _actuator.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this actuator in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this actuator
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _actuator.getName(languageId);
    }

    /**
    * Returns the localized name of this actuator in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this actuator
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _actuator.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _actuator.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _actuator.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this actuator.
    *
    * @return the locales and localized names of this actuator
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _actuator.getNameMap();
    }

    /**
    * Sets the name of this actuator.
    *
    * @param name the name of this actuator
    */
    @Override
    public void setName(java.lang.String name) {
        _actuator.setName(name);
    }

    /**
    * Sets the localized name of this actuator in the language.
    *
    * @param name the localized name of this actuator
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _actuator.setName(name, locale);
    }

    /**
    * Sets the localized name of this actuator in the language, and sets the default locale.
    *
    * @param name the localized name of this actuator
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _actuator.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _actuator.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this actuator from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this actuator
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _actuator.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this actuator from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this actuator
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _actuator.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this actuator.
    *
    * @return the description of this actuator
    */
    @Override
    public java.lang.String getDescription() {
        return _actuator.getDescription();
    }

    /**
    * Returns the localized description of this actuator in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this actuator
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _actuator.getDescription(locale);
    }

    /**
    * Returns the localized description of this actuator in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this actuator. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _actuator.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this actuator in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this actuator
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _actuator.getDescription(languageId);
    }

    /**
    * Returns the localized description of this actuator in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this actuator
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _actuator.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _actuator.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _actuator.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this actuator.
    *
    * @return the locales and localized descriptions of this actuator
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _actuator.getDescriptionMap();
    }

    /**
    * Sets the description of this actuator.
    *
    * @param description the description of this actuator
    */
    @Override
    public void setDescription(java.lang.String description) {
        _actuator.setDescription(description);
    }

    /**
    * Sets the localized description of this actuator in the language.
    *
    * @param description the localized description of this actuator
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _actuator.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this actuator in the language, and sets the default locale.
    *
    * @param description the localized description of this actuator
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _actuator.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _actuator.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this actuator from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this actuator
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _actuator.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this actuator from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this actuator
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _actuator.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the endpoint of this actuator.
    *
    * @return the endpoint of this actuator
    */
    @Override
    public java.lang.String getEndpoint() {
        return _actuator.getEndpoint();
    }

    /**
    * Sets the endpoint of this actuator.
    *
    * @param endpoint the endpoint of this actuator
    */
    @Override
    public void setEndpoint(java.lang.String endpoint) {
        _actuator.setEndpoint(endpoint);
    }

    /**
    * Returns the enabled of this actuator.
    *
    * @return the enabled of this actuator
    */
    @Override
    public boolean getEnabled() {
        return _actuator.getEnabled();
    }

    /**
    * Returns <code>true</code> if this actuator is enabled.
    *
    * @return <code>true</code> if this actuator is enabled; <code>false</code> otherwise
    */
    @Override
    public boolean isEnabled() {
        return _actuator.isEnabled();
    }

    /**
    * Sets whether this actuator is enabled.
    *
    * @param enabled the enabled of this actuator
    */
    @Override
    public void setEnabled(boolean enabled) {
        _actuator.setEnabled(enabled);
    }

    /**
    * Returns the status of this actuator.
    *
    * @return the status of this actuator
    */
    @Override
    public int getStatus() {
        return _actuator.getStatus();
    }

    /**
    * Sets the status of this actuator.
    *
    * @param status the status of this actuator
    */
    @Override
    public void setStatus(int status) {
        _actuator.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _actuator.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _actuator.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _actuator.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _actuator.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _actuator.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _actuator.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _actuator.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _actuator.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _actuator.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _actuator.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _actuator.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _actuator.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _actuator.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _actuator.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _actuator.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new ActuatorWrapper((Actuator) _actuator.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator) {
        return _actuator.compareTo(actuator);
    }

    @Override
    public int hashCode() {
        return _actuator.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.Actuator> toCacheModel() {
        return _actuator.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Actuator toEscapedModel() {
        return new ActuatorWrapper(_actuator.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Actuator toUnescapedModel() {
        return new ActuatorWrapper(_actuator.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _actuator.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _actuator.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _actuator.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ActuatorWrapper)) {
            return false;
        }

        ActuatorWrapper actuatorWrapper = (ActuatorWrapper) obj;

        if (Validator.equals(_actuator, actuatorWrapper._actuator)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _actuator.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Actuator getWrappedActuator() {
        return _actuator;
    }

    @Override
    public Actuator getWrappedModel() {
        return _actuator;
    }

    @Override
    public void resetOriginalValues() {
        _actuator.resetOriginalValues();
    }
}
