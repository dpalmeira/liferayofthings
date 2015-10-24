package com.lrexperts.liferay.liferayofthings.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.lrexperts.liferay.liferayofthings.NoSuchSensorException;
import com.lrexperts.liferay.liferayofthings.model.Sensor;
import com.lrexperts.liferay.liferayofthings.model.impl.SensorImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.SensorPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the sensor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorPersistence
 * @see SensorUtil
 * @generated
 */
public class SensorPersistenceImpl extends BasePersistenceImpl<Sensor>
    implements SensorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SensorUtil} to access the sensor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SensorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            SensorModelImpl.UUID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "sensor.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "sensor.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sensor.uuid IS NULL OR sensor.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            SensorModelImpl.UUID_COLUMN_BITMASK |
            SensorModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "sensor.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "sensor.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(sensor.uuid IS NULL OR sensor.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "sensor.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            SensorModelImpl.UUID_COLUMN_BITMASK |
            SensorModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "sensor.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "sensor.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(sensor.uuid IS NULL OR sensor.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "sensor.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            SensorModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "sensor.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            SensorModelImpl.GROUPID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sensor.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            SensorModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorModelImpl.GROUPID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "sensor.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "sensor.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            SensorModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorModelImpl.GROUPID_COLUMN_BITMASK |
            SensorModelImpl.STATUS_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 = "sensor.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 = "sensor.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_STATUS_2 = "sensor.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THINGID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThingId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThingId",
            new String[] { Long.class.getName() },
            SensorModelImpl.THINGID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_THINGID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThingId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_THINGID_THINGID_2 = "sensor.thingId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SENSORTYPEID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySensorTypeId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORTYPEID =
        new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySensorTypeId",
            new String[] { Long.class.getName() },
            SensorModelImpl.SENSORTYPEID_COLUMN_BITMASK |
            SensorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SENSORTYPEID = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySensorTypeId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SENSORTYPEID_SENSORTYPEID_2 = "sensor.sensorTypeId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_ENDPOINT = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByEndpoint",
            new String[] { String.class.getName() },
            SensorModelImpl.ENDPOINT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ENDPOINT = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEndpoint",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_1 = "sensor.endpoint IS NULL";
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_2 = "sensor.endpoint = ?";
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_3 = "(sensor.endpoint IS NULL OR sensor.endpoint = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_C_G_E_EN = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, SensorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByC_G_E_EN",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName(), Boolean.class.getName()
            },
            SensorModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorModelImpl.GROUPID_COLUMN_BITMASK |
            SensorModelImpl.ENDPOINT_COLUMN_BITMASK |
            SensorModelImpl.ENABLED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_E_EN = new FinderPath(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_E_EN",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName(), Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_E_EN_COMPANYID_2 = "sensor.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_GROUPID_2 = "sensor.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_1 = "sensor.endpoint IS NULL AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_2 = "sensor.endpoint = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_3 = "(sensor.endpoint IS NULL OR sensor.endpoint = '') AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENABLED_2 = "sensor.enabled = ?";
    private static final String _SQL_SELECT_SENSOR = "SELECT sensor FROM Sensor sensor";
    private static final String _SQL_SELECT_SENSOR_WHERE = "SELECT sensor FROM Sensor sensor WHERE ";
    private static final String _SQL_COUNT_SENSOR = "SELECT COUNT(sensor) FROM Sensor sensor";
    private static final String _SQL_COUNT_SENSOR_WHERE = "SELECT COUNT(sensor) FROM Sensor sensor WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sensor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sensor exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Sensor exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SensorPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Sensor _nullSensor = new SensorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Sensor> toCacheModel() {
                return _nullSensorCacheModel;
            }
        };

    private static CacheModel<Sensor> _nullSensorCacheModel = new CacheModel<Sensor>() {
            @Override
            public Sensor toEntityModel() {
                return _nullSensor;
            }
        };

    public SensorPersistenceImpl() {
        setModelClass(Sensor.class);
    }

    /**
     * Returns all the sensors where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if (!Validator.equals(uuid, sensor.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByUuid_First(uuid, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByUuid_Last(uuid, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where uuid = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByUuid_PrevAndNext(long sensorId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByUuid_PrevAndNext(session, sensor, uuid,
                    orderByComparator, true);

            array[1] = sensor;

            array[2] = getByUuid_PrevAndNext(session, sensor, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByUuid_PrevAndNext(Session session, Sensor sensor,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Sensor sensor : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the sensor where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByUUID_G(String uuid, long groupId)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByUUID_G(uuid, groupId);

        if (sensor == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSensorException(msg.toString());
        }

        return sensor;
    }

    /**
     * Returns the sensor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the sensor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Sensor) {
            Sensor sensor = (Sensor) result;

            if (!Validator.equals(uuid, sensor.getUuid()) ||
                    (groupId != sensor.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Sensor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Sensor sensor = list.get(0);

                    result = sensor;

                    cacheResult(sensor);

                    if ((sensor.getUuid() == null) ||
                            !sensor.getUuid().equals(uuid) ||
                            (sensor.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, sensor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Sensor) result;
        }
    }

    /**
     * Removes the sensor where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the sensor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor removeByUUID_G(String uuid, long groupId)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByUUID_G(uuid, groupId);

        return remove(sensor);
    }

    /**
     * Returns the number of sensors where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if (!Validator.equals(uuid, sensor.getUuid()) ||
                        (companyId != sensor.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByUuid_C_PrevAndNext(long sensorId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, sensor, uuid,
                    companyId, orderByComparator, true);

            array[1] = sensor;

            array[2] = getByUuid_C_PrevAndNext(session, sensor, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByUuid_C_PrevAndNext(Session session, Sensor sensor,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Sensor sensor : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the sensors where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((companyId != sensor.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByCompanyId_First(companyId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByCompanyId_Last(companyId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where companyId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByCompanyId_PrevAndNext(long sensorId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, sensor, companyId,
                    orderByComparator, true);

            array[1] = sensor;

            array[2] = getByCompanyId_PrevAndNext(session, sensor, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByCompanyId_PrevAndNext(Session session, Sensor sensor,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Sensor sensor : findByCompanyId(companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyId(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((groupId != sensor.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByGroupId_First(groupId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByGroupId_Last(groupId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where groupId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByGroupId_PrevAndNext(long sensorId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, sensor, groupId,
                    orderByComparator, true);

            array[1] = sensor;

            array[2] = getByGroupId_PrevAndNext(session, sensor, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByGroupId_PrevAndNext(Session session, Sensor sensor,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Sensor sensor : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G(long companyId, long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] { companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] {
                    companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((companyId != sensor.getCompanyId()) ||
                        (groupId != sensor.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByC_G_First(companyId, groupId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByC_G(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByC_G_Last(companyId, groupId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByC_G_PrevAndNext(long sensorId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByC_G_PrevAndNext(session, sensor, companyId,
                    groupId, orderByComparator, true);

            array[1] = sensor;

            array[2] = getByC_G_PrevAndNext(session, sensor, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByC_G_PrevAndNext(Session session, Sensor sensor,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (Sensor sensor : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_G(long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

        Object[] finderArgs = new Object[] { companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        return findByC_G_S(companyId, groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G_S(long companyId, long groupId, int status,
        int start, int end) throws SystemException {
        return findByC_G_S(companyId, groupId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByC_G_S(long companyId, long groupId, int status,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S;
            finderArgs = new Object[] { companyId, groupId, status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S;
            finderArgs = new Object[] {
                    companyId, groupId, status,
                    
                    start, end, orderByComparator
                };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((companyId != sensor.getCompanyId()) ||
                        (groupId != sensor.getGroupId()) ||
                        (status != sensor.getStatus())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByC_G_S_First(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByC_G_S_First(companyId, groupId, status,
                orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_S_First(long companyId, long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByC_G_S(companyId, groupId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByC_G_S_Last(companyId, groupId, status,
                orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G_S(companyId, groupId, status);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByC_G_S(companyId, groupId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByC_G_S_PrevAndNext(long sensorId, long companyId,
        long groupId, int status, OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByC_G_S_PrevAndNext(session, sensor, companyId,
                    groupId, status, orderByComparator, true);

            array[1] = sensor;

            array[2] = getByC_G_S_PrevAndNext(session, sensor, companyId,
                    groupId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByC_G_S_PrevAndNext(Session session, Sensor sensor,
        long companyId, long groupId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

        query.append(_FINDER_COLUMN_C_G_S_STATUS_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        for (Sensor sensor : findByC_G_S(companyId, groupId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_S;

        Object[] finderArgs = new Object[] { companyId, groupId, status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_S_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(status);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByThingId(long thingId) throws SystemException {
        return findByThingId(thingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where thingId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingId the thing ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByThingId(long thingId, int start, int end)
        throws SystemException {
        return findByThingId(thingId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where thingId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingId the thing ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findByThingId(long thingId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID;
            finderArgs = new Object[] { thingId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THINGID;
            finderArgs = new Object[] { thingId, start, end, orderByComparator };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((thingId != sensor.getThingId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_THINGID_THINGID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(thingId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByThingId_First(long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByThingId_First(thingId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingId=");
        msg.append(thingId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByThingId_First(long thingId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findByThingId(thingId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByThingId_Last(long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByThingId_Last(thingId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingId=");
        msg.append(thingId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByThingId_Last(long thingId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByThingId(thingId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findByThingId(thingId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where thingId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findByThingId_PrevAndNext(long sensorId, long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getByThingId_PrevAndNext(session, sensor, thingId,
                    orderByComparator, true);

            array[1] = sensor;

            array[2] = getByThingId_PrevAndNext(session, sensor, thingId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getByThingId_PrevAndNext(Session session, Sensor sensor,
        long thingId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_THINGID_THINGID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(thingId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where thingId = &#63; from the database.
     *
     * @param thingId the thing ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByThingId(long thingId) throws SystemException {
        for (Sensor sensor : findByThingId(thingId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByThingId(long thingId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_THINGID;

        Object[] finderArgs = new Object[] { thingId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_THINGID_THINGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(thingId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the sensors where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @return the matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findBySensorTypeId(long sensorTypeId)
        throws SystemException {
        return findBySensorTypeId(sensorTypeId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors where sensorTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sensorTypeId the sensor type ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findBySensorTypeId(long sensorTypeId, int start, int end)
        throws SystemException {
        return findBySensorTypeId(sensorTypeId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors where sensorTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sensorTypeId the sensor type ID
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findBySensorTypeId(long sensorTypeId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORTYPEID;
            finderArgs = new Object[] { sensorTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SENSORTYPEID;
            finderArgs = new Object[] {
                    sensorTypeId,
                    
                    start, end, orderByComparator
                };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Sensor sensor : list) {
                if ((sensorTypeId != sensor.getSensorTypeId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_SENSORTYPEID_SENSORTYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sensorTypeId);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first sensor in the ordered set where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findBySensorTypeId_First(long sensorTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchBySensorTypeId_First(sensorTypeId,
                orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sensorTypeId=");
        msg.append(sensorTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the first sensor in the ordered set where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchBySensorTypeId_First(long sensorTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Sensor> list = findBySensorTypeId(sensorTypeId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor in the ordered set where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findBySensorTypeId_Last(long sensorTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchBySensorTypeId_Last(sensorTypeId, orderByComparator);

        if (sensor != null) {
            return sensor;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sensorTypeId=");
        msg.append(sensorTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorException(msg.toString());
    }

    /**
     * Returns the last sensor in the ordered set where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchBySensorTypeId_Last(long sensorTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySensorTypeId(sensorTypeId);

        if (count == 0) {
            return null;
        }

        List<Sensor> list = findBySensorTypeId(sensorTypeId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensors before and after the current sensor in the ordered set where sensorTypeId = &#63;.
     *
     * @param sensorId the primary key of the current sensor
     * @param sensorTypeId the sensor type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor[] findBySensorTypeId_PrevAndNext(long sensorId,
        long sensorTypeId, OrderByComparator orderByComparator)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByPrimaryKey(sensorId);

        Session session = null;

        try {
            session = openSession();

            Sensor[] array = new SensorImpl[3];

            array[0] = getBySensorTypeId_PrevAndNext(session, sensor,
                    sensorTypeId, orderByComparator, true);

            array[1] = sensor;

            array[2] = getBySensorTypeId_PrevAndNext(session, sensor,
                    sensorTypeId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Sensor getBySensorTypeId_PrevAndNext(Session session,
        Sensor sensor, long sensorTypeId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSOR_WHERE);

        query.append(_FINDER_COLUMN_SENSORTYPEID_SENSORTYPEID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(SensorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(sensorTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensor);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Sensor> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensors where sensorTypeId = &#63; from the database.
     *
     * @param sensorTypeId the sensor type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySensorTypeId(long sensorTypeId)
        throws SystemException {
        for (Sensor sensor : findBySensorTypeId(sensorTypeId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors where sensorTypeId = &#63;.
     *
     * @param sensorTypeId the sensor type ID
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySensorTypeId(long sensorTypeId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SENSORTYPEID;

        Object[] finderArgs = new Object[] { sensorTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_SENSORTYPEID_SENSORTYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sensorTypeId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the sensor where endpoint = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorException} if it could not be found.
     *
     * @param endpoint the endpoint
     * @return the matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByEndpoint(String endpoint)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByEndpoint(endpoint);

        if (sensor == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("endpoint=");
            msg.append(endpoint);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSensorException(msg.toString());
        }

        return sensor;
    }

    /**
     * Returns the sensor where endpoint = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param endpoint the endpoint
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByEndpoint(String endpoint) throws SystemException {
        return fetchByEndpoint(endpoint, true);
    }

    /**
     * Returns the sensor where endpoint = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param endpoint the endpoint
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByEndpoint(String endpoint, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { endpoint };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                    finderArgs, this);
        }

        if (result instanceof Sensor) {
            Sensor sensor = (Sensor) result;

            if (!Validator.equals(endpoint, sensor.getEndpoint())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SENSOR_WHERE);

            boolean bindEndpoint = false;

            if (endpoint == null) {
                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_1);
            } else if (endpoint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_3);
            } else {
                bindEndpoint = true;

                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEndpoint) {
                    qPos.add(endpoint);
                }

                List<Sensor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                        finderArgs, list);
                } else {
                    Sensor sensor = list.get(0);

                    result = sensor;

                    cacheResult(sensor);

                    if ((sensor.getEndpoint() == null) ||
                            !sensor.getEndpoint().equals(endpoint)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                            finderArgs, sensor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Sensor) result;
        }
    }

    /**
     * Removes the sensor where endpoint = &#63; from the database.
     *
     * @param endpoint the endpoint
     * @return the sensor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor removeByEndpoint(String endpoint)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByEndpoint(endpoint);

        return remove(sensor);
    }

    /**
     * Returns the number of sensors where endpoint = &#63;.
     *
     * @param endpoint the endpoint
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEndpoint(String endpoint) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ENDPOINT;

        Object[] finderArgs = new Object[] { endpoint };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            boolean bindEndpoint = false;

            if (endpoint == null) {
                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_1);
            } else if (endpoint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_3);
            } else {
                bindEndpoint = true;

                query.append(_FINDER_COLUMN_ENDPOINT_ENDPOINT_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEndpoint) {
                    qPos.add(endpoint);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the sensor where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorException} if it could not be found.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the matching sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByC_G_E_EN(long companyId, long groupId, String endpoint,
        boolean enabled) throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByC_G_E_EN(companyId, groupId, endpoint, enabled);

        if (sensor == null) {
            StringBundler msg = new StringBundler(10);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(", endpoint=");
            msg.append(endpoint);

            msg.append(", enabled=");
            msg.append(enabled);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchSensorException(msg.toString());
        }

        return sensor;
    }

    /**
     * Returns the sensor where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled) throws SystemException {
        return fetchByC_G_E_EN(companyId, groupId, endpoint, enabled, true);
    }

    /**
     * Returns the sensor where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching sensor, or <code>null</code> if a matching sensor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, groupId, endpoint, enabled };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                    finderArgs, this);
        }

        if (result instanceof Sensor) {
            Sensor sensor = (Sensor) result;

            if ((companyId != sensor.getCompanyId()) ||
                    (groupId != sensor.getGroupId()) ||
                    !Validator.equals(endpoint, sensor.getEndpoint()) ||
                    (enabled != sensor.getEnabled())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_SELECT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_E_EN_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_E_EN_GROUPID_2);

            boolean bindEndpoint = false;

            if (endpoint == null) {
                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_1);
            } else if (endpoint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_3);
            } else {
                bindEndpoint = true;

                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_2);
            }

            query.append(_FINDER_COLUMN_C_G_E_EN_ENABLED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindEndpoint) {
                    qPos.add(endpoint);
                }

                qPos.add(enabled);

                List<Sensor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                        finderArgs, list);
                } else {
                    Sensor sensor = list.get(0);

                    result = sensor;

                    cacheResult(sensor);

                    if ((sensor.getCompanyId() != companyId) ||
                            (sensor.getGroupId() != groupId) ||
                            (sensor.getEndpoint() == null) ||
                            !sensor.getEndpoint().equals(endpoint) ||
                            (sensor.getEnabled() != enabled)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                            finderArgs, sensor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Sensor) result;
        }
    }

    /**
     * Removes the sensor where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the sensor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor removeByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = findByC_G_E_EN(companyId, groupId, endpoint, enabled);

        return remove(sensor);
    }

    /**
     * Returns the number of sensors where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the number of matching sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_G_E_EN(long companyId, long groupId, String endpoint,
        boolean enabled) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_E_EN;

        Object[] finderArgs = new Object[] { companyId, groupId, endpoint, enabled };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_SENSOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_E_EN_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_E_EN_GROUPID_2);

            boolean bindEndpoint = false;

            if (endpoint == null) {
                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_1);
            } else if (endpoint.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_3);
            } else {
                bindEndpoint = true;

                query.append(_FINDER_COLUMN_C_G_E_EN_ENDPOINT_2);
            }

            query.append(_FINDER_COLUMN_C_G_E_EN_ENABLED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindEndpoint) {
                    qPos.add(endpoint);
                }

                qPos.add(enabled);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the sensor in the entity cache if it is enabled.
     *
     * @param sensor the sensor
     */
    @Override
    public void cacheResult(Sensor sensor) {
        EntityCacheUtil.putResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorImpl.class, sensor.getPrimaryKey(), sensor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { sensor.getUuid(), sensor.getGroupId() }, sensor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
            new Object[] { sensor.getEndpoint() }, sensor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
            new Object[] {
                sensor.getCompanyId(), sensor.getGroupId(), sensor.getEndpoint(),
                sensor.getEnabled()
            }, sensor);

        sensor.resetOriginalValues();
    }

    /**
     * Caches the sensors in the entity cache if it is enabled.
     *
     * @param sensors the sensors
     */
    @Override
    public void cacheResult(List<Sensor> sensors) {
        for (Sensor sensor : sensors) {
            if (EntityCacheUtil.getResult(
                        SensorModelImpl.ENTITY_CACHE_ENABLED, SensorImpl.class,
                        sensor.getPrimaryKey()) == null) {
                cacheResult(sensor);
            } else {
                sensor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all sensors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SensorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SensorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the sensor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Sensor sensor) {
        EntityCacheUtil.removeResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorImpl.class, sensor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(sensor);
    }

    @Override
    public void clearCache(List<Sensor> sensors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Sensor sensor : sensors) {
            EntityCacheUtil.removeResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
                SensorImpl.class, sensor.getPrimaryKey());

            clearUniqueFindersCache(sensor);
        }
    }

    protected void cacheUniqueFindersCache(Sensor sensor) {
        if (sensor.isNew()) {
            Object[] args = new Object[] { sensor.getUuid(), sensor.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, sensor);

            args = new Object[] { sensor.getEndpoint() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENDPOINT, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT, args,
                sensor);

            args = new Object[] {
                    sensor.getCompanyId(), sensor.getGroupId(),
                    sensor.getEndpoint(), sensor.getEnabled()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args,
                sensor);
        } else {
            SensorModelImpl sensorModelImpl = (SensorModelImpl) sensor;

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensor.getUuid(), sensor.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    sensor);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ENDPOINT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { sensor.getEndpoint() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENDPOINT, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT, args,
                    sensor);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_C_G_E_EN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensor.getCompanyId(), sensor.getGroupId(),
                        sensor.getEndpoint(), sensor.getEnabled()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args,
                    sensor);
            }
        }
    }

    protected void clearUniqueFindersCache(Sensor sensor) {
        SensorModelImpl sensorModelImpl = (SensorModelImpl) sensor;

        Object[] args = new Object[] { sensor.getUuid(), sensor.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((sensorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    sensorModelImpl.getOriginalUuid(),
                    sensorModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }

        args = new Object[] { sensor.getEndpoint() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINT, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENDPOINT, args);

        if ((sensorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ENDPOINT.getColumnBitmask()) != 0) {
            args = new Object[] { sensorModelImpl.getOriginalEndpoint() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINT, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENDPOINT, args);
        }

        args = new Object[] {
                sensor.getCompanyId(), sensor.getGroupId(), sensor.getEndpoint(),
                sensor.getEnabled()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args);

        if ((sensorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_C_G_E_EN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    sensorModelImpl.getOriginalCompanyId(),
                    sensorModelImpl.getOriginalGroupId(),
                    sensorModelImpl.getOriginalEndpoint(),
                    sensorModelImpl.getOriginalEnabled()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args);
        }
    }

    /**
     * Creates a new sensor with the primary key. Does not add the sensor to the database.
     *
     * @param sensorId the primary key for the new sensor
     * @return the new sensor
     */
    @Override
    public Sensor create(long sensorId) {
        Sensor sensor = new SensorImpl();

        sensor.setNew(true);
        sensor.setPrimaryKey(sensorId);

        String uuid = PortalUUIDUtil.generate();

        sensor.setUuid(uuid);

        return sensor;
    }

    /**
     * Removes the sensor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param sensorId the primary key of the sensor
     * @return the sensor that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor remove(long sensorId)
        throws NoSuchSensorException, SystemException {
        return remove((Serializable) sensorId);
    }

    /**
     * Removes the sensor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the sensor
     * @return the sensor that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor remove(Serializable primaryKey)
        throws NoSuchSensorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Sensor sensor = (Sensor) session.get(SensorImpl.class, primaryKey);

            if (sensor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSensorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sensor);
        } catch (NoSuchSensorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Sensor removeImpl(Sensor sensor) throws SystemException {
        sensor = toUnwrappedModel(sensor);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(sensor)) {
                sensor = (Sensor) session.get(SensorImpl.class,
                        sensor.getPrimaryKeyObj());
            }

            if (sensor != null) {
                session.delete(sensor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (sensor != null) {
            clearCache(sensor);
        }

        return sensor;
    }

    @Override
    public Sensor updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Sensor sensor)
        throws SystemException {
        sensor = toUnwrappedModel(sensor);

        boolean isNew = sensor.isNew();

        SensorModelImpl sensorModelImpl = (SensorModelImpl) sensor;

        if (Validator.isNull(sensor.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            sensor.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (sensor.isNew()) {
                session.save(sensor);

                sensor.setNew(false);
            } else {
                session.merge(sensor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SensorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { sensorModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { sensorModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalUuid(),
                        sensorModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        sensorModelImpl.getUuid(),
                        sensorModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { sensorModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { sensorModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalCompanyId(),
                        sensorModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        sensorModelImpl.getCompanyId(),
                        sensorModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalCompanyId(),
                        sensorModelImpl.getOriginalGroupId(),
                        sensorModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);

                args = new Object[] {
                        sensorModelImpl.getCompanyId(),
                        sensorModelImpl.getGroupId(),
                        sensorModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalThingId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID,
                    args);

                args = new Object[] { sensorModelImpl.getThingId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID,
                    args);
            }

            if ((sensorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORTYPEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorModelImpl.getOriginalSensorTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENSORTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORTYPEID,
                    args);

                args = new Object[] { sensorModelImpl.getSensorTypeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENSORTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORTYPEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
            SensorImpl.class, sensor.getPrimaryKey(), sensor);

        clearUniqueFindersCache(sensor);
        cacheUniqueFindersCache(sensor);

        return sensor;
    }

    protected Sensor toUnwrappedModel(Sensor sensor) {
        if (sensor instanceof SensorImpl) {
            return sensor;
        }

        SensorImpl sensorImpl = new SensorImpl();

        sensorImpl.setNew(sensor.isNew());
        sensorImpl.setPrimaryKey(sensor.getPrimaryKey());

        sensorImpl.setUuid(sensor.getUuid());
        sensorImpl.setSensorId(sensor.getSensorId());
        sensorImpl.setCompanyId(sensor.getCompanyId());
        sensorImpl.setGroupId(sensor.getGroupId());
        sensorImpl.setThingId(sensor.getThingId());
        sensorImpl.setSensorTypeId(sensor.getSensorTypeId());
        sensorImpl.setUserId(sensor.getUserId());
        sensorImpl.setUserName(sensor.getUserName());
        sensorImpl.setCreateDate(sensor.getCreateDate());
        sensorImpl.setModifiedDate(sensor.getModifiedDate());
        sensorImpl.setName(sensor.getName());
        sensorImpl.setDescription(sensor.getDescription());
        sensorImpl.setEndpoint(sensor.getEndpoint());
        sensorImpl.setEnabled(sensor.isEnabled());
        sensorImpl.setStatus(sensor.getStatus());

        return sensorImpl;
    }

    /**
     * Returns the sensor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the sensor
     * @return the sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSensorException, SystemException {
        Sensor sensor = fetchByPrimaryKey(primaryKey);

        if (sensor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSensorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return sensor;
    }

    /**
     * Returns the sensor with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorException} if it could not be found.
     *
     * @param sensorId the primary key of the sensor
     * @return the sensor
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorException if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor findByPrimaryKey(long sensorId)
        throws NoSuchSensorException, SystemException {
        return findByPrimaryKey((Serializable) sensorId);
    }

    /**
     * Returns the sensor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the sensor
     * @return the sensor, or <code>null</code> if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Sensor sensor = (Sensor) EntityCacheUtil.getResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
                SensorImpl.class, primaryKey);

        if (sensor == _nullSensor) {
            return null;
        }

        if (sensor == null) {
            Session session = null;

            try {
                session = openSession();

                sensor = (Sensor) session.get(SensorImpl.class, primaryKey);

                if (sensor != null) {
                    cacheResult(sensor);
                } else {
                    EntityCacheUtil.putResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
                        SensorImpl.class, primaryKey, _nullSensor);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SensorModelImpl.ENTITY_CACHE_ENABLED,
                    SensorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return sensor;
    }

    /**
     * Returns the sensor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param sensorId the primary key of the sensor
     * @return the sensor, or <code>null</code> if a sensor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Sensor fetchByPrimaryKey(long sensorId) throws SystemException {
        return fetchByPrimaryKey((Serializable) sensorId);
    }

    /**
     * Returns all the sensors.
     *
     * @return the sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @return the range of sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the sensors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sensors
     * @param end the upper bound of the range of sensors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Sensor> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Sensor> list = (List<Sensor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SENSOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SENSOR;

                if (pagination) {
                    sql = sql.concat(SensorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Sensor>(list);
                } else {
                    list = (List<Sensor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the sensors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Sensor sensor : findAll()) {
            remove(sensor);
        }
    }

    /**
     * Returns the number of sensors.
     *
     * @return the number of sensors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SENSOR);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the sensor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.Sensor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Sensor>> listenersList = new ArrayList<ModelListener<Sensor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Sensor>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SensorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
