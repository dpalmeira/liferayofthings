package com.lrexperts.liferay.liferayofthings.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Thing service. Represents a row in the &quot;LRoT_Thing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Thing
 * @see com.lrexperts.liferay.liferayofthings.model.impl.ThingImpl
 * @see com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl
 * @generated
 */
public interface ThingModel extends BaseModel<Thing>, StagedGroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a thing model instance should use the {@link Thing} interface instead.
     */

    /**
     * Returns the primary key of this thing.
     *
     * @return the primary key of this thing
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this thing.
     *
     * @param primaryKey the primary key of this thing
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this thing.
     *
     * @return the uuid of this thing
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this thing.
     *
     * @param uuid the uuid of this thing
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the thing ID of this thing.
     *
     * @return the thing ID of this thing
     */
    public long getThingId();

    /**
     * Sets the thing ID of this thing.
     *
     * @param thingId the thing ID of this thing
     */
    public void setThingId(long thingId);

    /**
     * Returns the company ID of this thing.
     *
     * @return the company ID of this thing
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this thing.
     *
     * @param companyId the company ID of this thing
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this thing.
     *
     * @return the group ID of this thing
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this thing.
     *
     * @param groupId the group ID of this thing
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the user ID of this thing.
     *
     * @return the user ID of this thing
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this thing.
     *
     * @param userId the user ID of this thing
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this thing.
     *
     * @return the user uuid of this thing
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this thing.
     *
     * @param userUuid the user uuid of this thing
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this thing.
     *
     * @return the user name of this thing
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this thing.
     *
     * @param userName the user name of this thing
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this thing.
     *
     * @return the create date of this thing
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this thing.
     *
     * @param createDate the create date of this thing
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this thing.
     *
     * @return the modified date of this thing
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this thing.
     *
     * @param modifiedDate the modified date of this thing
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the thing group ID of this thing.
     *
     * @return the thing group ID of this thing
     */
    public long getThingGroupId();

    /**
     * Sets the thing group ID of this thing.
     *
     * @param thingGroupId the thing group ID of this thing
     */
    public void setThingGroupId(long thingGroupId);

    /**
     * Returns the name of this thing.
     *
     * @return the name of this thing
     */
    public String getName();

    /**
     * Returns the localized name of this thing in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized name of this thing
     */
    @AutoEscape
    public String getName(Locale locale);

    /**
     * Returns the localized name of this thing in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this thing. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getName(Locale locale, boolean useDefault);

    /**
     * Returns the localized name of this thing in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized name of this thing
     */
    @AutoEscape
    public String getName(String languageId);

    /**
     * Returns the localized name of this thing in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this thing
     */
    @AutoEscape
    public String getName(String languageId, boolean useDefault);

    @AutoEscape
    public String getNameCurrentLanguageId();

    @AutoEscape
    public String getNameCurrentValue();

    /**
     * Returns a map of the locales and localized names of this thing.
     *
     * @return the locales and localized names of this thing
     */
    public Map<Locale, String> getNameMap();

    /**
     * Sets the name of this thing.
     *
     * @param name the name of this thing
     */
    public void setName(String name);

    /**
     * Sets the localized name of this thing in the language.
     *
     * @param name the localized name of this thing
     * @param locale the locale of the language
     */
    public void setName(String name, Locale locale);

    /**
     * Sets the localized name of this thing in the language, and sets the default locale.
     *
     * @param name the localized name of this thing
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setName(String name, Locale locale, Locale defaultLocale);

    public void setNameCurrentLanguageId(String languageId);

    /**
     * Sets the localized names of this thing from the map of locales and localized names.
     *
     * @param nameMap the locales and localized names of this thing
     */
    public void setNameMap(Map<Locale, String> nameMap);

    /**
     * Sets the localized names of this thing from the map of locales and localized names, and sets the default locale.
     *
     * @param nameMap the locales and localized names of this thing
     * @param defaultLocale the default locale
     */
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

    /**
     * Returns the description of this thing.
     *
     * @return the description of this thing
     */
    public String getDescription();

    /**
     * Returns the localized description of this thing in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized description of this thing
     */
    @AutoEscape
    public String getDescription(Locale locale);

    /**
     * Returns the localized description of this thing in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this thing. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getDescription(Locale locale, boolean useDefault);

    /**
     * Returns the localized description of this thing in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized description of this thing
     */
    @AutoEscape
    public String getDescription(String languageId);

    /**
     * Returns the localized description of this thing in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this thing
     */
    @AutoEscape
    public String getDescription(String languageId, boolean useDefault);

    @AutoEscape
    public String getDescriptionCurrentLanguageId();

    @AutoEscape
    public String getDescriptionCurrentValue();

    /**
     * Returns a map of the locales and localized descriptions of this thing.
     *
     * @return the locales and localized descriptions of this thing
     */
    public Map<Locale, String> getDescriptionMap();

    /**
     * Sets the description of this thing.
     *
     * @param description the description of this thing
     */
    public void setDescription(String description);

    /**
     * Sets the localized description of this thing in the language.
     *
     * @param description the localized description of this thing
     * @param locale the locale of the language
     */
    public void setDescription(String description, Locale locale);

    /**
     * Sets the localized description of this thing in the language, and sets the default locale.
     *
     * @param description the localized description of this thing
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setDescription(String description, Locale locale,
        Locale defaultLocale);

    public void setDescriptionCurrentLanguageId(String languageId);

    /**
     * Sets the localized descriptions of this thing from the map of locales and localized descriptions.
     *
     * @param descriptionMap the locales and localized descriptions of this thing
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap);

    /**
     * Sets the localized descriptions of this thing from the map of locales and localized descriptions, and sets the default locale.
     *
     * @param descriptionMap the locales and localized descriptions of this thing
     * @param defaultLocale the default locale
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale);

    /**
     * Returns the endpoint of this thing.
     *
     * @return the endpoint of this thing
     */
    @AutoEscape
    public String getEndpoint();

    /**
     * Sets the endpoint of this thing.
     *
     * @param endpoint the endpoint of this thing
     */
    public void setEndpoint(String endpoint);

    /**
     * Returns the enabled of this thing.
     *
     * @return the enabled of this thing
     */
    public boolean getEnabled();

    /**
     * Returns <code>true</code> if this thing is enabled.
     *
     * @return <code>true</code> if this thing is enabled; <code>false</code> otherwise
     */
    public boolean isEnabled();

    /**
     * Sets whether this thing is enabled.
     *
     * @param enabled the enabled of this thing
     */
    public void setEnabled(boolean enabled);

    /**
     * Returns the status of this thing.
     *
     * @return the status of this thing
     */
    public int getStatus();

    /**
     * Sets the status of this thing.
     *
     * @param status the status of this thing
     */
    public void setStatus(int status);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public String[] getAvailableLanguageIds();

    public String getDefaultLanguageId();

    public void prepareLocalizedFieldsForImport() throws LocaleException;

    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException;

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.lrexperts.liferay.liferayofthings.model.Thing thing);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.lrexperts.liferay.liferayofthings.model.Thing> toCacheModel();

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Thing toEscapedModel();

    @Override
    public com.lrexperts.liferay.liferayofthings.model.Thing toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
