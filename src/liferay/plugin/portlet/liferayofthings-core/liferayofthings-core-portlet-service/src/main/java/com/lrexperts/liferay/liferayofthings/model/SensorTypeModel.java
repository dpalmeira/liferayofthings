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
 * The base model interface for the SensorType service. Represents a row in the &quot;LRoT_SensorType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorType
 * @see com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeImpl
 * @see com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeModelImpl
 * @generated
 */
public interface SensorTypeModel extends BaseModel<SensorType>,
    StagedGroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a sensor type model instance should use the {@link SensorType} interface instead.
     */

    /**
     * Returns the primary key of this sensor type.
     *
     * @return the primary key of this sensor type
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this sensor type.
     *
     * @param primaryKey the primary key of this sensor type
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this sensor type.
     *
     * @return the uuid of this sensor type
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this sensor type.
     *
     * @param uuid the uuid of this sensor type
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the sensor type ID of this sensor type.
     *
     * @return the sensor type ID of this sensor type
     */
    public long getSensorTypeId();

    /**
     * Sets the sensor type ID of this sensor type.
     *
     * @param sensorTypeId the sensor type ID of this sensor type
     */
    public void setSensorTypeId(long sensorTypeId);

    /**
     * Returns the company ID of this sensor type.
     *
     * @return the company ID of this sensor type
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this sensor type.
     *
     * @param companyId the company ID of this sensor type
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this sensor type.
     *
     * @return the group ID of this sensor type
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this sensor type.
     *
     * @param groupId the group ID of this sensor type
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the user ID of this sensor type.
     *
     * @return the user ID of this sensor type
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this sensor type.
     *
     * @param userId the user ID of this sensor type
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this sensor type.
     *
     * @return the user uuid of this sensor type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this sensor type.
     *
     * @param userUuid the user uuid of this sensor type
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this sensor type.
     *
     * @return the user name of this sensor type
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this sensor type.
     *
     * @param userName the user name of this sensor type
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this sensor type.
     *
     * @return the create date of this sensor type
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this sensor type.
     *
     * @param createDate the create date of this sensor type
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this sensor type.
     *
     * @return the modified date of this sensor type
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this sensor type.
     *
     * @param modifiedDate the modified date of this sensor type
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the name of this sensor type.
     *
     * @return the name of this sensor type
     */
    public String getName();

    /**
     * Returns the localized name of this sensor type in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized name of this sensor type
     */
    @AutoEscape
    public String getName(Locale locale);

    /**
     * Returns the localized name of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this sensor type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getName(Locale locale, boolean useDefault);

    /**
     * Returns the localized name of this sensor type in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized name of this sensor type
     */
    @AutoEscape
    public String getName(String languageId);

    /**
     * Returns the localized name of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this sensor type
     */
    @AutoEscape
    public String getName(String languageId, boolean useDefault);

    @AutoEscape
    public String getNameCurrentLanguageId();

    @AutoEscape
    public String getNameCurrentValue();

    /**
     * Returns a map of the locales and localized names of this sensor type.
     *
     * @return the locales and localized names of this sensor type
     */
    public Map<Locale, String> getNameMap();

    /**
     * Sets the name of this sensor type.
     *
     * @param name the name of this sensor type
     */
    public void setName(String name);

    /**
     * Sets the localized name of this sensor type in the language.
     *
     * @param name the localized name of this sensor type
     * @param locale the locale of the language
     */
    public void setName(String name, Locale locale);

    /**
     * Sets the localized name of this sensor type in the language, and sets the default locale.
     *
     * @param name the localized name of this sensor type
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setName(String name, Locale locale, Locale defaultLocale);

    public void setNameCurrentLanguageId(String languageId);

    /**
     * Sets the localized names of this sensor type from the map of locales and localized names.
     *
     * @param nameMap the locales and localized names of this sensor type
     */
    public void setNameMap(Map<Locale, String> nameMap);

    /**
     * Sets the localized names of this sensor type from the map of locales and localized names, and sets the default locale.
     *
     * @param nameMap the locales and localized names of this sensor type
     * @param defaultLocale the default locale
     */
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

    /**
     * Returns the description of this sensor type.
     *
     * @return the description of this sensor type
     */
    public String getDescription();

    /**
     * Returns the localized description of this sensor type in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized description of this sensor type
     */
    @AutoEscape
    public String getDescription(Locale locale);

    /**
     * Returns the localized description of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this sensor type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getDescription(Locale locale, boolean useDefault);

    /**
     * Returns the localized description of this sensor type in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized description of this sensor type
     */
    @AutoEscape
    public String getDescription(String languageId);

    /**
     * Returns the localized description of this sensor type in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this sensor type
     */
    @AutoEscape
    public String getDescription(String languageId, boolean useDefault);

    @AutoEscape
    public String getDescriptionCurrentLanguageId();

    @AutoEscape
    public String getDescriptionCurrentValue();

    /**
     * Returns a map of the locales and localized descriptions of this sensor type.
     *
     * @return the locales and localized descriptions of this sensor type
     */
    public Map<Locale, String> getDescriptionMap();

    /**
     * Sets the description of this sensor type.
     *
     * @param description the description of this sensor type
     */
    public void setDescription(String description);

    /**
     * Sets the localized description of this sensor type in the language.
     *
     * @param description the localized description of this sensor type
     * @param locale the locale of the language
     */
    public void setDescription(String description, Locale locale);

    /**
     * Sets the localized description of this sensor type in the language, and sets the default locale.
     *
     * @param description the localized description of this sensor type
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setDescription(String description, Locale locale,
        Locale defaultLocale);

    public void setDescriptionCurrentLanguageId(String languageId);

    /**
     * Sets the localized descriptions of this sensor type from the map of locales and localized descriptions.
     *
     * @param descriptionMap the locales and localized descriptions of this sensor type
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap);

    /**
     * Sets the localized descriptions of this sensor type from the map of locales and localized descriptions, and sets the default locale.
     *
     * @param descriptionMap the locales and localized descriptions of this sensor type
     * @param defaultLocale the default locale
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale);

    /**
     * Returns the icon of this sensor type.
     *
     * @return the icon of this sensor type
     */
    @AutoEscape
    public String getIcon();

    /**
     * Sets the icon of this sensor type.
     *
     * @param icon the icon of this sensor type
     */
    public void setIcon(String icon);

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
        com.lrexperts.liferay.liferayofthings.model.SensorType sensorType);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.lrexperts.liferay.liferayofthings.model.SensorType> toCacheModel();

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType toEscapedModel();

    @Override
    public com.lrexperts.liferay.liferayofthings.model.SensorType toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}