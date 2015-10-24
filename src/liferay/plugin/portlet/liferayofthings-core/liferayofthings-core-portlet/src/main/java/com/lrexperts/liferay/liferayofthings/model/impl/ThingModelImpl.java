package com.lrexperts.liferay.liferayofthings.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.ThingModel;
import com.lrexperts.liferay.liferayofthings.model.ThingSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the Thing service. Represents a row in the &quot;LRoT_Thing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.lrexperts.liferay.liferayofthings.model.ThingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ThingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingImpl
 * @see com.lrexperts.liferay.liferayofthings.model.Thing
 * @see com.lrexperts.liferay.liferayofthings.model.ThingModel
 * @generated
 */
@JSON(strict = true)
public class ThingModelImpl extends BaseModelImpl<Thing> implements ThingModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a thing model instance should use the {@link com.lrexperts.liferay.liferayofthings.model.Thing} interface instead.
     */
    public static final String TABLE_NAME = "LRoT_Thing";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "thingId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "thingGroupId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "endpoint", Types.VARCHAR },
            { "enabled", Types.BOOLEAN },
            { "status", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table LRoT_Thing (uuid_ VARCHAR(75) null,thingId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,thingGroupId LONG,name STRING null,description STRING null,endpoint VARCHAR(255) null,enabled BOOLEAN,status INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table LRoT_Thing";
    public static final String ORDER_BY_JPQL = " ORDER BY thing.name ASC";
    public static final String ORDER_BY_SQL = " ORDER BY LRoT_Thing.name ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.lrexperts.liferay.liferayofthings.model.Thing"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.lrexperts.liferay.liferayofthings.model.Thing"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.lrexperts.liferay.liferayofthings.model.Thing"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long STATUS_COLUMN_BITMASK = 4L;
    public static long THINGGROUPID_COLUMN_BITMASK = 8L;
    public static long UUID_COLUMN_BITMASK = 16L;
    public static long NAME_COLUMN_BITMASK = 32L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.lrexperts.liferay.liferayofthings.model.Thing"));
    private static ClassLoader _classLoader = Thing.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Thing.class };
    private String _uuid;
    private String _originalUuid;
    private long _thingId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _thingGroupId;
    private long _originalThingGroupId;
    private boolean _setOriginalThingGroupId;
    private String _name;
    private String _nameCurrentLanguageId;
    private String _description;
    private String _descriptionCurrentLanguageId;
    private String _endpoint;
    private boolean _enabled;
    private int _status;
    private int _originalStatus;
    private boolean _setOriginalStatus;
    private long _columnBitmask;
    private Thing _escapedModel;

    public ThingModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Thing toModel(ThingSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Thing model = new ThingImpl();

        model.setUuid(soapModel.getUuid());
        model.setThingId(soapModel.getThingId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setGroupId(soapModel.getGroupId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setThingGroupId(soapModel.getThingGroupId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setEndpoint(soapModel.getEndpoint());
        model.setEnabled(soapModel.getEnabled());
        model.setStatus(soapModel.getStatus());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Thing> toModels(ThingSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Thing> models = new ArrayList<Thing>(soapModels.length);

        for (ThingSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _thingId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setThingId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _thingId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getThingId() {
        return _thingId;
    }

    @Override
    public void setThingId(long thingId) {
        _thingId = thingId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public long getThingGroupId() {
        return _thingGroupId;
    }

    @Override
    public void setThingGroupId(long thingGroupId) {
        _columnBitmask |= THINGGROUPID_COLUMN_BITMASK;

        if (!_setOriginalThingGroupId) {
            _setOriginalThingGroupId = true;

            _originalThingGroupId = _thingGroupId;
        }

        _thingGroupId = thingGroupId;
    }

    public long getOriginalThingGroupId() {
        return _originalThingGroupId;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
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

    @JSON
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
        _columnBitmask = -1L;

        _name = name;
    }

    @Override
    public void setName(String name, Locale locale) {
        setName(name, locale, LocaleUtil.getSiteDefault());
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
        setNameMap(nameMap, LocaleUtil.getSiteDefault());
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
        if (nameMap == null) {
            return;
        }

        setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
                LocaleUtil.toLanguageId(defaultLocale)));
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
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

    @JSON
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
    }

    @Override
    public void setDescription(String description, Locale locale) {
        setDescription(description, locale, LocaleUtil.getSiteDefault());
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
        setDescriptionMap(descriptionMap, LocaleUtil.getSiteDefault());
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale) {
        if (descriptionMap == null) {
            return;
        }

        setDescription(LocalizationUtil.updateLocalization(descriptionMap,
                getDescription(), "Description",
                LocaleUtil.toLanguageId(defaultLocale)));
    }

    @JSON
    @Override
    public String getEndpoint() {
        if (_endpoint == null) {
            return StringPool.BLANK;
        } else {
            return _endpoint;
        }
    }

    @Override
    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
    }

    @JSON
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
    }

    @JSON
    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _columnBitmask |= STATUS_COLUMN_BITMASK;

        if (!_setOriginalStatus) {
            _setOriginalStatus = true;

            _originalStatus = _status;
        }

        _status = status;
    }

    public int getOriginalStatus() {
        return _originalStatus;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Thing.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Thing.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
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
    public Thing toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Thing) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ThingImpl thingImpl = new ThingImpl();

        thingImpl.setUuid(getUuid());
        thingImpl.setThingId(getThingId());
        thingImpl.setCompanyId(getCompanyId());
        thingImpl.setGroupId(getGroupId());
        thingImpl.setUserId(getUserId());
        thingImpl.setUserName(getUserName());
        thingImpl.setCreateDate(getCreateDate());
        thingImpl.setModifiedDate(getModifiedDate());
        thingImpl.setThingGroupId(getThingGroupId());
        thingImpl.setName(getName());
        thingImpl.setDescription(getDescription());
        thingImpl.setEndpoint(getEndpoint());
        thingImpl.setEnabled(getEnabled());
        thingImpl.setStatus(getStatus());

        thingImpl.resetOriginalValues();

        return thingImpl;
    }

    @Override
    public int compareTo(Thing thing) {
        int value = 0;

        value = getName().compareTo(thing.getName());

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

        if (!(obj instanceof Thing)) {
            return false;
        }

        Thing thing = (Thing) obj;

        long primaryKey = thing.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ThingModelImpl thingModelImpl = this;

        thingModelImpl._originalUuid = thingModelImpl._uuid;

        thingModelImpl._originalCompanyId = thingModelImpl._companyId;

        thingModelImpl._setOriginalCompanyId = false;

        thingModelImpl._originalGroupId = thingModelImpl._groupId;

        thingModelImpl._setOriginalGroupId = false;

        thingModelImpl._originalThingGroupId = thingModelImpl._thingGroupId;

        thingModelImpl._setOriginalThingGroupId = false;

        thingModelImpl._originalStatus = thingModelImpl._status;

        thingModelImpl._setOriginalStatus = false;

        thingModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Thing> toCacheModel() {
        ThingCacheModel thingCacheModel = new ThingCacheModel();

        thingCacheModel.uuid = getUuid();

        String uuid = thingCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            thingCacheModel.uuid = null;
        }

        thingCacheModel.thingId = getThingId();

        thingCacheModel.companyId = getCompanyId();

        thingCacheModel.groupId = getGroupId();

        thingCacheModel.userId = getUserId();

        thingCacheModel.userName = getUserName();

        String userName = thingCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            thingCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            thingCacheModel.createDate = createDate.getTime();
        } else {
            thingCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            thingCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            thingCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        thingCacheModel.thingGroupId = getThingGroupId();

        thingCacheModel.name = getName();

        String name = thingCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            thingCacheModel.name = null;
        }

        thingCacheModel.description = getDescription();

        String description = thingCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            thingCacheModel.description = null;
        }

        thingCacheModel.endpoint = getEndpoint();

        String endpoint = thingCacheModel.endpoint;

        if ((endpoint != null) && (endpoint.length() == 0)) {
            thingCacheModel.endpoint = null;
        }

        thingCacheModel.enabled = getEnabled();

        thingCacheModel.status = getStatus();

        return thingCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", thingId=");
        sb.append(getThingId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", thingGroupId=");
        sb.append(getThingGroupId());
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
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.lrexperts.liferay.liferayofthings.model.Thing");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>thingId</column-name><column-value><![CDATA[");
        sb.append(getThingId());
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
            "<column><column-name>thingGroupId</column-name><column-value><![CDATA[");
        sb.append(getThingGroupId());
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