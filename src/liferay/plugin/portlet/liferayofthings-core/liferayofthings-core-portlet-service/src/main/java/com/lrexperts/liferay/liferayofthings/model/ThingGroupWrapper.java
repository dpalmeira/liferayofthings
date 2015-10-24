package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ThingGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroup
 * @generated
 */
public class ThingGroupWrapper implements ThingGroup, ModelWrapper<ThingGroup> {
    private ThingGroup _thingGroup;

    public ThingGroupWrapper(ThingGroup thingGroup) {
        _thingGroup = thingGroup;
    }

    @Override
    public Class<?> getModelClass() {
        return ThingGroup.class;
    }

    @Override
    public String getModelClassName() {
        return ThingGroup.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("thingGroupId", getThingGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("enabled", getEnabled());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long thingGroupId = (Long) attributes.get("thingGroupId");

        if (thingGroupId != null) {
            setThingGroupId(thingGroupId);
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

        Boolean enabled = (Boolean) attributes.get("enabled");

        if (enabled != null) {
            setEnabled(enabled);
        }
    }

    /**
    * Returns the primary key of this thing group.
    *
    * @return the primary key of this thing group
    */
    @Override
    public long getPrimaryKey() {
        return _thingGroup.getPrimaryKey();
    }

    /**
    * Sets the primary key of this thing group.
    *
    * @param primaryKey the primary key of this thing group
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _thingGroup.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this thing group.
    *
    * @return the uuid of this thing group
    */
    @Override
    public java.lang.String getUuid() {
        return _thingGroup.getUuid();
    }

    /**
    * Sets the uuid of this thing group.
    *
    * @param uuid the uuid of this thing group
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _thingGroup.setUuid(uuid);
    }

    /**
    * Returns the thing group ID of this thing group.
    *
    * @return the thing group ID of this thing group
    */
    @Override
    public long getThingGroupId() {
        return _thingGroup.getThingGroupId();
    }

    /**
    * Sets the thing group ID of this thing group.
    *
    * @param thingGroupId the thing group ID of this thing group
    */
    @Override
    public void setThingGroupId(long thingGroupId) {
        _thingGroup.setThingGroupId(thingGroupId);
    }

    /**
    * Returns the company ID of this thing group.
    *
    * @return the company ID of this thing group
    */
    @Override
    public long getCompanyId() {
        return _thingGroup.getCompanyId();
    }

    /**
    * Sets the company ID of this thing group.
    *
    * @param companyId the company ID of this thing group
    */
    @Override
    public void setCompanyId(long companyId) {
        _thingGroup.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this thing group.
    *
    * @return the group ID of this thing group
    */
    @Override
    public long getGroupId() {
        return _thingGroup.getGroupId();
    }

    /**
    * Sets the group ID of this thing group.
    *
    * @param groupId the group ID of this thing group
    */
    @Override
    public void setGroupId(long groupId) {
        _thingGroup.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this thing group.
    *
    * @return the user ID of this thing group
    */
    @Override
    public long getUserId() {
        return _thingGroup.getUserId();
    }

    /**
    * Sets the user ID of this thing group.
    *
    * @param userId the user ID of this thing group
    */
    @Override
    public void setUserId(long userId) {
        _thingGroup.setUserId(userId);
    }

    /**
    * Returns the user uuid of this thing group.
    *
    * @return the user uuid of this thing group
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _thingGroup.getUserUuid();
    }

    /**
    * Sets the user uuid of this thing group.
    *
    * @param userUuid the user uuid of this thing group
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _thingGroup.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this thing group.
    *
    * @return the user name of this thing group
    */
    @Override
    public java.lang.String getUserName() {
        return _thingGroup.getUserName();
    }

    /**
    * Sets the user name of this thing group.
    *
    * @param userName the user name of this thing group
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _thingGroup.setUserName(userName);
    }

    /**
    * Returns the create date of this thing group.
    *
    * @return the create date of this thing group
    */
    @Override
    public java.util.Date getCreateDate() {
        return _thingGroup.getCreateDate();
    }

    /**
    * Sets the create date of this thing group.
    *
    * @param createDate the create date of this thing group
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _thingGroup.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this thing group.
    *
    * @return the modified date of this thing group
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _thingGroup.getModifiedDate();
    }

    /**
    * Sets the modified date of this thing group.
    *
    * @param modifiedDate the modified date of this thing group
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _thingGroup.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this thing group.
    *
    * @return the name of this thing group
    */
    @Override
    public java.lang.String getName() {
        return _thingGroup.getName();
    }

    /**
    * Returns the localized name of this thing group in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this thing group
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _thingGroup.getName(locale);
    }

    /**
    * Returns the localized name of this thing group in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this thing group. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _thingGroup.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this thing group in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this thing group
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _thingGroup.getName(languageId);
    }

    /**
    * Returns the localized name of this thing group in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this thing group
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _thingGroup.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _thingGroup.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _thingGroup.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this thing group.
    *
    * @return the locales and localized names of this thing group
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _thingGroup.getNameMap();
    }

    /**
    * Sets the name of this thing group.
    *
    * @param name the name of this thing group
    */
    @Override
    public void setName(java.lang.String name) {
        _thingGroup.setName(name);
    }

    /**
    * Sets the localized name of this thing group in the language.
    *
    * @param name the localized name of this thing group
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _thingGroup.setName(name, locale);
    }

    /**
    * Sets the localized name of this thing group in the language, and sets the default locale.
    *
    * @param name the localized name of this thing group
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _thingGroup.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _thingGroup.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this thing group from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this thing group
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _thingGroup.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this thing group from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this thing group
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _thingGroup.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the description of this thing group.
    *
    * @return the description of this thing group
    */
    @Override
    public java.lang.String getDescription() {
        return _thingGroup.getDescription();
    }

    /**
    * Returns the localized description of this thing group in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this thing group
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _thingGroup.getDescription(locale);
    }

    /**
    * Returns the localized description of this thing group in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this thing group. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _thingGroup.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this thing group in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this thing group
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _thingGroup.getDescription(languageId);
    }

    /**
    * Returns the localized description of this thing group in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this thing group
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _thingGroup.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _thingGroup.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _thingGroup.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this thing group.
    *
    * @return the locales and localized descriptions of this thing group
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _thingGroup.getDescriptionMap();
    }

    /**
    * Sets the description of this thing group.
    *
    * @param description the description of this thing group
    */
    @Override
    public void setDescription(java.lang.String description) {
        _thingGroup.setDescription(description);
    }

    /**
    * Sets the localized description of this thing group in the language.
    *
    * @param description the localized description of this thing group
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _thingGroup.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this thing group in the language, and sets the default locale.
    *
    * @param description the localized description of this thing group
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _thingGroup.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _thingGroup.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this thing group from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this thing group
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _thingGroup.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this thing group from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this thing group
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _thingGroup.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * Returns the enabled of this thing group.
    *
    * @return the enabled of this thing group
    */
    @Override
    public boolean getEnabled() {
        return _thingGroup.getEnabled();
    }

    /**
    * Returns <code>true</code> if this thing group is enabled.
    *
    * @return <code>true</code> if this thing group is enabled; <code>false</code> otherwise
    */
    @Override
    public boolean isEnabled() {
        return _thingGroup.isEnabled();
    }

    /**
    * Sets whether this thing group is enabled.
    *
    * @param enabled the enabled of this thing group
    */
    @Override
    public void setEnabled(boolean enabled) {
        _thingGroup.setEnabled(enabled);
    }

    @Override
    public boolean isNew() {
        return _thingGroup.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _thingGroup.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _thingGroup.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _thingGroup.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _thingGroup.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _thingGroup.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _thingGroup.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _thingGroup.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _thingGroup.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _thingGroup.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _thingGroup.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _thingGroup.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _thingGroup.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _thingGroup.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _thingGroup.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new ThingGroupWrapper((ThingGroup) _thingGroup.clone());
    }

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup) {
        return _thingGroup.compareTo(thingGroup);
    }

    @Override
    public int hashCode() {
        return _thingGroup.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.lrexperts.liferay.liferayofthings.model.ThingGroup> toCacheModel() {
        return _thingGroup.toCacheModel();
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup toEscapedModel() {
        return new ThingGroupWrapper(_thingGroup.toEscapedModel());
    }

    @Override
    public com.lrexperts.liferay.liferayofthings.model.ThingGroup toUnescapedModel() {
        return new ThingGroupWrapper(_thingGroup.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _thingGroup.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _thingGroup.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _thingGroup.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ThingGroupWrapper)) {
            return false;
        }

        ThingGroupWrapper thingGroupWrapper = (ThingGroupWrapper) obj;

        if (Validator.equals(_thingGroup, thingGroupWrapper._thingGroup)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _thingGroup.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ThingGroup getWrappedThingGroup() {
        return _thingGroup;
    }

    @Override
    public ThingGroup getWrappedModel() {
        return _thingGroup;
    }

    @Override
    public void resetOriginalValues() {
        _thingGroup.resetOriginalValues();
    }
}
