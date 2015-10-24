package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Thing}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Thing
 * @generated
 */
public class ThingWrapper implements Thing, ModelWrapper<Thing> {
    private Thing _thing;

    public ThingWrapper(Thing thing) {
        _thing = thing;
    }

    @Override
    public Class<?> getModelClass() {
        return Thing.class;
    }

    @Override
    public String getModelClassName() {
        return Thing.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("thingId", getThingId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("thingGroupId", getThingGroupId());
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

        Long thingId = (Long) attributes.get("thingId");

        if (thingId != null) {
            setThingId(thingId);
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

        Long thingGroupId = (Long) attributes.get("thingGroupId");

        if (thingGroupId != null) {
            setThingGroupId(thingGroupId);
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
    * Returns the primary key of this thing.
    *
    * @return the primary key of this thing
    */
    @Override
    public long getPrimaryKey() {
        return _thing.getPrimaryKey();
    }

    /**
    * Sets the primary key of this thing.
    *
    * @param primaryKey the primary key of this thing
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _thing.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this thing.
    *
    * @return the uuid of this thing
    */
    @Override
    public java.lang.String getUuid() {
        return _thing.getUuid();
    }

    /**
    * Sets the uuid of this thing.
    *
    * @param uuid the uuid of this thing
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _thing.setUuid(uuid);
    }

    /**
    * Returns the thing ID of this thing.
    *
    * @return the thing ID of this thing
    */
    @Override
    public long getThingId() {
        return _thing.getThingId();
    }

    /**
    * Sets the thing ID of this thing.
    *
    * @param thingId the thing ID of this thing
    */
    @Override
    public void setThingId(long thingId) {
        _thing.setThingId(thingId);
    }

    /**
    * Returns the company ID of this thing.
    *
    * @return the company ID of this thing
    */
    @Override
    public long getCompanyId() {
        return _thing.getCompanyId();
    }

    /**
    * Sets the company ID of this thing.
    *
    * @param companyId the company ID of this thing
    */
    @Override
    public void setCompanyId(long companyId) {
        _thing.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this thing.
    *
    * @return the group ID of this thing
    */
    @Override
    public long getGroupId() {
        return _thing.getGroupId();
    }

    /**
    * Sets the group ID of this thing.
    *
    * @param groupId the group ID of this thing
    */
    @Override
    public void setGroupId(long groupId) {
        _thing.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this thing.
    *
    * @return the user ID of this thing
    */
    @Override
    public long getUserId() {
        return _thing.getUserId();
    }

    /**
    * Sets the user ID of this thing.
    *
    * @param userId the user ID of this thing
    */
    @Override
    public void setUserId(long userId) {
        _thing.setUserId(userId);
    }

    /**
    * Returns the user uuid of this thing.
    *
    * @return the user uuid of this thing
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _thing.getUserUuid();
    }

    /**
    * Sets the user uuid of this thing.
    *
    * @param userUuid the user uuid of this thing
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _thing.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this thing.
    *
    * @return the user name of this thing
    */
    @Override
    public java.lang.String getUserName() {
        return _thing.getUserName();
    }

    /**
    * Sets the user name of this thing.
    *
    * @param userName the user name of this thing
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _thing.setUserName(userName);
    }

    /**
    * Returns the create date of this thing.
    *
    * @return the create date of this thing
    */
    @Override
    public java.util.Date getCreateDate() {
        return _thing.getCreateDate();
    }

    /**
    * Sets the create date of this thing.
    *
    * @param createDate the create date of this thing
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _thing.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this thing.
    *
    * @return the modified date of this thing
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _thing.getModifiedDate();
    }

    /**
    * Sets the modified date of this thing.
    *
    * @param modifiedDate the modified date of this thing
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _thing.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the thing group ID of this thing.
    *
    * @return the thing group ID of this thing
    */
    @Override
    public long getThingGroupId() {
        return _thing.getThingGroupId();
    }

    /**
    * Sets the thing group ID of this thing.
    *
    * @param thingGroupId the thing group ID of this thing
    */
    @Override
    public void setThingGroupId(long thingGroupId) {
        _thing.setThingGroupId(thingGroupId);
    }

    /**
    * Returns the name of this thing.
    *
    * @return the name of this thing
    */
    @Override
    public java.lang.String getName() {
        return _thing.getName();
    }

    /**
    * Returns the localized name of this thing in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this thing
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _thing.getName(locale);
    }

    /**
    * Returns the localized name of this thing in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this thing. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _thing.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this thing in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this thing
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _thing.getName(languageId);
    }

    /**
    * Returns the localized name of this thing in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this thing
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _thing.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _thing.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _thing.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this thing.
    *
    * @return the locales and localized names of this thing
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _thing.getNameMap();
    }

    /**
    * Sets the name of this thing.
    *
    * @param name the name of this thing
    */
    @Override
    public void setName(java.lang.String name) {
        _thing.setName(name);
    }

    /**
    * Sets the localized name of this thing in the language.
    *
    * @param name the localized name of this thing
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _thing.setName(name, locale);
    }

    /**
    * Sets the localized name of this thing in the language, and sets the default locale.
    *
    * @param name the localized name of this thing
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _thing.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _thing.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this thing from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this thing
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _thing.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this thing from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this thing
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _thing.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this thing.
    *
    * @return the description of this thing
    */
    @Override
    public java.lang.String getDescription() {
        return _thing.getDescription();
    }

    /**
    * Returns the localized description of this thing in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this thing
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _thing.getDescription(locale);
    }

    /**
    * Returns the localized description of this thing in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this thing. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _thing.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this thing in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this thing
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _thing.getDescription(languageId);
    }

    /**
    * Returns the localized description of this thing in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this thing
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _thing.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _thing.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _thing.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this thing.
    *
    * @return the locales and localized descriptions of this thing
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _thing.getDescriptionMap();
    }

    /**
    * Sets the description of this thing.
    *
    * @param description the description of this thing
    */
    @Override
    public void setDescription(java.lang.String description) {
        _thing.setDescription(description);
    }

    /**
    * Sets the localized description of this thing in the language.
    *
    * @param description the localized description of this thing
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _thing.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this thing in the language, and sets the default locale.
    *
    * @param description the localized description of this thing
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _thing.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _thing.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this thing from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this thing
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _thing.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this thing from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this thing
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _thing.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the endpoint of this thing.
    *
    * @return the endpoint of this thing
    */
    @Override
    public java.lang.String getEndpoint() {
        return _thing.getEndpoint();
    }

    /**
    * Sets the endpoint of this thing.
    *
    * @param endpoint the endpoint of this thing
    */
    @Override
    public void setEndpoint(java.lang.String endpoint) {
        _thing.setEndpoint(endpoint);
    }

    /**
    * Returns the enabled of this thing.
    *
    * @return the enabled of this thing
    */
    @Override
    public boolean getEnabled() {
        return _thing.getEnabled();
    }

    /**
    * Returns <code>true</code> if this thing is enabled.
    *
    * @return <code>true</code> if this thing is enabled; <code>false</code> otherwise
    */
    @Override
    public boolean isEnabled() {
        return _thing.isEnabled();
    }

    /**
    * Sets whether this thing is enabled.
    *
    * @param enabled the enabled of this thing
    */
    @Override
    public void setEnabled(boolean enabled) {
        _thing.setEnabled(enabled);
    }

    /**
    * Returns the status of this thing.
    *
    * @return the status of this thing
    */
    @Override
    public int getStatus() {
        return _thing.getStatus();
    }

    /**
    * Sets the status of this thing.
    *
    * @param status the status of this thing
    */
    @Override
    public void setStatus(int status) {
        _thing.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _thing.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _thing.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _thing.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _thing.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _thing.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _thing.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _thing.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _thing.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _thing.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _thing.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _thing.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _thing.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _thing.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _thing.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _thing.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new ThingWrapper((Thing) _thing.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.Thing thing) {
        return _thing.compareTo(thing);
    }

    @Override
    public int hashCode() {
        return _thing.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.Thing> toCacheModel() {
        return _thing.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Thing toEscapedModel() {
        return new ThingWrapper(_thing.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Thing toUnescapedModel() {
        return new ThingWrapper(_thing.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _thing.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _thing.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _thing.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ThingWrapper)) {
            return false;
        }

        ThingWrapper thingWrapper = (ThingWrapper) obj;

        if (Validator.equals(_thing, thingWrapper._thing)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _thing.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Thing getWrappedThing() {
        return _thing;
    }

    @Override
    public Thing getWrappedModel() {
        return _thing;
    }

    @Override
    public void resetOriginalValues() {
        _thing.resetOriginalValues();
    }
}
