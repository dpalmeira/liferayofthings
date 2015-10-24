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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException;
import com.lrexperts.liferay.liferayofthings.model.SensorValue;
import com.lrexperts.liferay.liferayofthings.model.impl.SensorValueImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.SensorValuePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the sensor value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SensorValuePersistence
 * @see SensorValueUtil
 * @generated
 */
public class SensorValuePersistenceImpl extends BasePersistenceImpl<SensorValue>
    implements SensorValuePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SensorValueUtil} to access the sensor value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SensorValueImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            SensorValueModelImpl.UUID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "sensorValue.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "sensorValue.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sensorValue.uuid IS NULL OR sensorValue.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            SensorValueModelImpl.UUID_COLUMN_BITMASK |
            SensorValueModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "sensorValue.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "sensorValue.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(sensorValue.uuid IS NULL OR sensorValue.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "sensorValue.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            SensorValueModelImpl.UUID_COLUMN_BITMASK |
            SensorValueModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "sensorValue.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "sensorValue.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(sensorValue.uuid IS NULL OR sensorValue.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "sensorValue.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            SensorValueModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "sensorValue.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            SensorValueModelImpl.GROUPID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "sensorValue.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            SensorValueModelImpl.COMPANYID_COLUMN_BITMASK |
            SensorValueModelImpl.GROUPID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "sensorValue.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "sensorValue.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SENSORID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysensorId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORID =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysensorId",
            new String[] { Long.class.getName() },
            SensorValueModelImpl.SENSORID_COLUMN_BITMASK |
            SensorValueModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SENSORID = new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysensorId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SENSORID_SENSORID_2 = "sensorValue.sensorId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LTCREATEDATE =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, SensorValueImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLTCreateDate",
            new String[] {
                Date.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LTCREATEDATE =
        new FinderPath(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLTCreateDate",
            new String[] { Date.class.getName() });
    private static final String _FINDER_COLUMN_LTCREATEDATE_CREATEDATE_1 = "sensorValue.createDate < NULL";
    private static final String _FINDER_COLUMN_LTCREATEDATE_CREATEDATE_2 = "sensorValue.createDate < ?";
    private static final String _SQL_SELECT_SENSORVALUE = "SELECT sensorValue FROM SensorValue sensorValue";
    private static final String _SQL_SELECT_SENSORVALUE_WHERE = "SELECT sensorValue FROM SensorValue sensorValue WHERE ";
    private static final String _SQL_COUNT_SENSORVALUE = "SELECT COUNT(sensorValue) FROM SensorValue sensorValue";
    private static final String _SQL_COUNT_SENSORVALUE_WHERE = "SELECT COUNT(sensorValue) FROM SensorValue sensorValue WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sensorValue.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SensorValue exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SensorValue exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SensorValuePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static SensorValue _nullSensorValue = new SensorValueImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SensorValue> toCacheModel() {
                return _nullSensorValueCacheModel;
            }
        };

    private static CacheModel<SensorValue> _nullSensorValueCacheModel = new CacheModel<SensorValue>() {
            @Override
            public SensorValue toEntityModel() {
                return _nullSensorValue;
            }
        };

    public SensorValuePersistenceImpl() {
        setModelClass(SensorValue.class);
    }

    /**
     * Returns all the sensor values where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid(String uuid, int start, int end,
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if (!Validator.equals(uuid, sensorValue.getUuid())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
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
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByUuid_First(uuid, orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByUuid_Last(uuid, orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where uuid = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByUuid_PrevAndNext(long sensorValueId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByUuid_PrevAndNext(session, sensorValue, uuid,
                    orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByUuid_PrevAndNext(session, sensorValue, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByUuid_PrevAndNext(Session session,
        SensorValue sensorValue, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (SensorValue sensorValue : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns the sensor value where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByUUID_G(String uuid, long groupId)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByUUID_G(uuid, groupId);

        if (sensorValue == null) {
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

            throw new NoSuchSensorValueException(msg.toString());
        }

        return sensorValue;
    }

    /**
     * Returns the sensor value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the sensor value where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof SensorValue) {
            SensorValue sensorValue = (SensorValue) result;

            if (!Validator.equals(uuid, sensorValue.getUuid()) ||
                    (groupId != sensorValue.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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

                List<SensorValue> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    SensorValue sensorValue = list.get(0);

                    result = sensorValue;

                    cacheResult(sensorValue);

                    if ((sensorValue.getUuid() == null) ||
                            !sensorValue.getUuid().equals(uuid) ||
                            (sensorValue.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, sensorValue);
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
            return (SensorValue) result;
        }
    }

    /**
     * Removes the sensor value where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the sensor value that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue removeByUUID_G(String uuid, long groupId)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByUUID_G(uuid, groupId);

        return remove(sensorValue);
    }

    /**
     * Returns the number of sensor values where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns all the sensor values where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if (!Validator.equals(uuid, sensorValue.getUuid()) ||
                        (companyId != sensorValue.getCompanyId())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
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
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByUuid_C_PrevAndNext(long sensorValueId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, sensorValue, uuid,
                    companyId, orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByUuid_C_PrevAndNext(session, sensorValue, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByUuid_C_PrevAndNext(Session session,
        SensorValue sensorValue, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (SensorValue sensorValue : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns all the sensor values where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the sensor values where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByCompanyId(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if ((companyId != sensorValue.getCompanyId())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where companyId = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByCompanyId_PrevAndNext(long sensorValueId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, sensorValue,
                    companyId, orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByCompanyId_PrevAndNext(session, sensorValue,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByCompanyId_PrevAndNext(Session session,
        SensorValue sensorValue, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (SensorValue sensorValue : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns all the sensor values where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByGroupId(long groupId, int start, int end,
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if ((groupId != sensorValue.getGroupId())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByGroupId_First(groupId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByGroupId_Last(groupId, orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where groupId = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByGroupId_PrevAndNext(long sensorValueId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, sensorValue, groupId,
                    orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByGroupId_PrevAndNext(session, sensorValue, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByGroupId_PrevAndNext(Session session,
        SensorValue sensorValue, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (SensorValue sensorValue : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns all the sensor values where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByC_G(long companyId, long groupId, int start,
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if ((companyId != sensorValue.getCompanyId()) ||
                        (groupId != sensorValue.getGroupId())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
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
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByC_G_First(companyId, groupId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByC_G(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByC_G_Last(companyId, groupId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByC_G(companyId, groupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByC_G_PrevAndNext(long sensorValueId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByC_G_PrevAndNext(session, sensorValue, companyId,
                    groupId, orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByC_G_PrevAndNext(session, sensorValue, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByC_G_PrevAndNext(Session session,
        SensorValue sensorValue, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (SensorValue sensorValue : findByC_G(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching sensor values
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

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

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
     * Returns all the sensor values where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findBysensorId(long sensorId)
        throws SystemException {
        return findBysensorId(sensorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the sensor values where sensorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sensorId the sensor ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findBysensorId(long sensorId, int start, int end)
        throws SystemException {
        return findBysensorId(sensorId, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where sensorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sensorId the sensor ID
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findBysensorId(long sensorId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORID;
            finderArgs = new Object[] { sensorId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SENSORID;
            finderArgs = new Object[] { sensorId, start, end, orderByComparator };
        }

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if ((sensorId != sensorValue.getSensorId())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

            query.append(_FINDER_COLUMN_SENSORID_SENSORID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sensorId);

                if (!pagination) {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findBysensorId_First(long sensorId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchBysensorId_First(sensorId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sensorId=");
        msg.append(sensorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchBysensorId_First(long sensorId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findBysensorId(sensorId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findBysensorId_Last(long sensorId,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchBysensorId_Last(sensorId,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sensorId=");
        msg.append(sensorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchBysensorId_Last(long sensorId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBysensorId(sensorId);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findBysensorId(sensorId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where sensorId = &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param sensorId the sensor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findBysensorId_PrevAndNext(long sensorValueId,
        long sensorId, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getBysensorId_PrevAndNext(session, sensorValue,
                    sensorId, orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getBysensorId_PrevAndNext(session, sensorValue,
                    sensorId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getBysensorId_PrevAndNext(Session session,
        SensorValue sensorValue, long sensorId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

        query.append(_FINDER_COLUMN_SENSORID_SENSORID_2);

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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(sensorId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where sensorId = &#63; from the database.
     *
     * @param sensorId the sensor ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBysensorId(long sensorId) throws SystemException {
        for (SensorValue sensorValue : findBysensorId(sensorId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where sensorId = &#63;.
     *
     * @param sensorId the sensor ID
     * @return the number of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBysensorId(long sensorId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SENSORID;

        Object[] finderArgs = new Object[] { sensorId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

            query.append(_FINDER_COLUMN_SENSORID_SENSORID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sensorId);

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
     * Returns all the sensor values where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @return the matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByLTCreateDate(Date createDate)
        throws SystemException {
        return findByLTCreateDate(createDate, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values where createDate &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param createDate the create date
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByLTCreateDate(Date createDate, int start,
        int end) throws SystemException {
        return findByLTCreateDate(createDate, start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values where createDate &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param createDate the create date
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findByLTCreateDate(Date createDate, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LTCREATEDATE;
        finderArgs = new Object[] { createDate, start, end, orderByComparator };

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SensorValue sensorValue : list) {
                if ((createDate.getTime() <= sensorValue.getCreateDate()
                                                            .getTime())) {
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

            query.append(_SQL_SELECT_SENSORVALUE_WHERE);

            boolean bindCreateDate = false;

            if (createDate == null) {
                query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_1);
            } else {
                bindCreateDate = true;

                query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(SensorValueModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreateDate) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
                }

                if (!pagination) {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Returns the first sensor value in the ordered set where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByLTCreateDate_First(Date createDate,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByLTCreateDate_First(createDate,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("createDate=");
        msg.append(createDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the first sensor value in the ordered set where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByLTCreateDate_First(Date createDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<SensorValue> list = findByLTCreateDate(createDate, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last sensor value in the ordered set where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByLTCreateDate_Last(Date createDate,
        OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByLTCreateDate_Last(createDate,
                orderByComparator);

        if (sensorValue != null) {
            return sensorValue;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("createDate=");
        msg.append(createDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSensorValueException(msg.toString());
    }

    /**
     * Returns the last sensor value in the ordered set where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching sensor value, or <code>null</code> if a matching sensor value could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByLTCreateDate_Last(Date createDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByLTCreateDate(createDate);

        if (count == 0) {
            return null;
        }

        List<SensorValue> list = findByLTCreateDate(createDate, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the sensor values before and after the current sensor value in the ordered set where createDate &lt; &#63;.
     *
     * @param sensorValueId the primary key of the current sensor value
     * @param createDate the create date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue[] findByLTCreateDate_PrevAndNext(long sensorValueId,
        Date createDate, OrderByComparator orderByComparator)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = findByPrimaryKey(sensorValueId);

        Session session = null;

        try {
            session = openSession();

            SensorValue[] array = new SensorValueImpl[3];

            array[0] = getByLTCreateDate_PrevAndNext(session, sensorValue,
                    createDate, orderByComparator, true);

            array[1] = sensorValue;

            array[2] = getByLTCreateDate_PrevAndNext(session, sensorValue,
                    createDate, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SensorValue getByLTCreateDate_PrevAndNext(Session session,
        SensorValue sensorValue, Date createDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENSORVALUE_WHERE);

        boolean bindCreateDate = false;

        if (createDate == null) {
            query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_1);
        } else {
            bindCreateDate = true;

            query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_2);
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
            query.append(SensorValueModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCreateDate) {
            qPos.add(CalendarUtil.getTimestamp(createDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(sensorValue);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SensorValue> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the sensor values where createDate &lt; &#63; from the database.
     *
     * @param createDate the create date
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByLTCreateDate(Date createDate) throws SystemException {
        for (SensorValue sensorValue : findByLTCreateDate(createDate,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values where createDate &lt; &#63;.
     *
     * @param createDate the create date
     * @return the number of matching sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByLTCreateDate(Date createDate) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_LTCREATEDATE;

        Object[] finderArgs = new Object[] { createDate };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENSORVALUE_WHERE);

            boolean bindCreateDate = false;

            if (createDate == null) {
                query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_1);
            } else {
                bindCreateDate = true;

                query.append(_FINDER_COLUMN_LTCREATEDATE_CREATEDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCreateDate) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
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
     * Caches the sensor value in the entity cache if it is enabled.
     *
     * @param sensorValue the sensor value
     */
    @Override
    public void cacheResult(SensorValue sensorValue) {
        EntityCacheUtil.putResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueImpl.class, sensorValue.getPrimaryKey(), sensorValue);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { sensorValue.getUuid(), sensorValue.getGroupId() },
            sensorValue);

        sensorValue.resetOriginalValues();
    }

    /**
     * Caches the sensor values in the entity cache if it is enabled.
     *
     * @param sensorValues the sensor values
     */
    @Override
    public void cacheResult(List<SensorValue> sensorValues) {
        for (SensorValue sensorValue : sensorValues) {
            if (EntityCacheUtil.getResult(
                        SensorValueModelImpl.ENTITY_CACHE_ENABLED,
                        SensorValueImpl.class, sensorValue.getPrimaryKey()) == null) {
                cacheResult(sensorValue);
            } else {
                sensorValue.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all sensor values.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SensorValueImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SensorValueImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the sensor value.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SensorValue sensorValue) {
        EntityCacheUtil.removeResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueImpl.class, sensorValue.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(sensorValue);
    }

    @Override
    public void clearCache(List<SensorValue> sensorValues) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SensorValue sensorValue : sensorValues) {
            EntityCacheUtil.removeResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
                SensorValueImpl.class, sensorValue.getPrimaryKey());

            clearUniqueFindersCache(sensorValue);
        }
    }

    protected void cacheUniqueFindersCache(SensorValue sensorValue) {
        if (sensorValue.isNew()) {
            Object[] args = new Object[] {
                    sensorValue.getUuid(), sensorValue.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                sensorValue);
        } else {
            SensorValueModelImpl sensorValueModelImpl = (SensorValueModelImpl) sensorValue;

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValue.getUuid(), sensorValue.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    sensorValue);
            }
        }
    }

    protected void clearUniqueFindersCache(SensorValue sensorValue) {
        SensorValueModelImpl sensorValueModelImpl = (SensorValueModelImpl) sensorValue;

        Object[] args = new Object[] {
                sensorValue.getUuid(), sensorValue.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((sensorValueModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    sensorValueModelImpl.getOriginalUuid(),
                    sensorValueModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new sensor value with the primary key. Does not add the sensor value to the database.
     *
     * @param sensorValueId the primary key for the new sensor value
     * @return the new sensor value
     */
    @Override
    public SensorValue create(long sensorValueId) {
        SensorValue sensorValue = new SensorValueImpl();

        sensorValue.setNew(true);
        sensorValue.setPrimaryKey(sensorValueId);

        String uuid = PortalUUIDUtil.generate();

        sensorValue.setUuid(uuid);

        return sensorValue;
    }

    /**
     * Removes the sensor value with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param sensorValueId the primary key of the sensor value
     * @return the sensor value that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue remove(long sensorValueId)
        throws NoSuchSensorValueException, SystemException {
        return remove((Serializable) sensorValueId);
    }

    /**
     * Removes the sensor value with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the sensor value
     * @return the sensor value that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue remove(Serializable primaryKey)
        throws NoSuchSensorValueException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SensorValue sensorValue = (SensorValue) session.get(SensorValueImpl.class,
                    primaryKey);

            if (sensorValue == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSensorValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sensorValue);
        } catch (NoSuchSensorValueException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SensorValue removeImpl(SensorValue sensorValue)
        throws SystemException {
        sensorValue = toUnwrappedModel(sensorValue);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(sensorValue)) {
                sensorValue = (SensorValue) session.get(SensorValueImpl.class,
                        sensorValue.getPrimaryKeyObj());
            }

            if (sensorValue != null) {
                session.delete(sensorValue);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (sensorValue != null) {
            clearCache(sensorValue);
        }

        return sensorValue;
    }

    @Override
    public SensorValue updateImpl(
        com.lrexperts.liferay.liferayofthings.model.SensorValue sensorValue)
        throws SystemException {
        sensorValue = toUnwrappedModel(sensorValue);

        boolean isNew = sensorValue.isNew();

        SensorValueModelImpl sensorValueModelImpl = (SensorValueModelImpl) sensorValue;

        if (Validator.isNull(sensorValue.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            sensorValue.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (sensorValue.isNew()) {
                session.save(sensorValue);

                sensorValue.setNew(false);
            } else {
                session.merge(sensorValue);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SensorValueModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { sensorValueModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalUuid(),
                        sensorValueModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        sensorValueModelImpl.getUuid(),
                        sensorValueModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { sensorValueModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { sensorValueModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalCompanyId(),
                        sensorValueModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        sensorValueModelImpl.getCompanyId(),
                        sensorValueModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }

            if ((sensorValueModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        sensorValueModelImpl.getOriginalSensorId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENSORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORID,
                    args);

                args = new Object[] { sensorValueModelImpl.getSensorId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SENSORID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SENSORID,
                    args);
            }
        }

        EntityCacheUtil.putResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
            SensorValueImpl.class, sensorValue.getPrimaryKey(), sensorValue);

        clearUniqueFindersCache(sensorValue);
        cacheUniqueFindersCache(sensorValue);

        return sensorValue;
    }

    protected SensorValue toUnwrappedModel(SensorValue sensorValue) {
        if (sensorValue instanceof SensorValueImpl) {
            return sensorValue;
        }

        SensorValueImpl sensorValueImpl = new SensorValueImpl();

        sensorValueImpl.setNew(sensorValue.isNew());
        sensorValueImpl.setPrimaryKey(sensorValue.getPrimaryKey());

        sensorValueImpl.setUuid(sensorValue.getUuid());
        sensorValueImpl.setSensorValueId(sensorValue.getSensorValueId());
        sensorValueImpl.setCompanyId(sensorValue.getCompanyId());
        sensorValueImpl.setGroupId(sensorValue.getGroupId());
        sensorValueImpl.setSensorId(sensorValue.getSensorId());
        sensorValueImpl.setValue(sensorValue.getValue());
        sensorValueImpl.setCreateDate(sensorValue.getCreateDate());

        return sensorValueImpl;
    }

    /**
     * Returns the sensor value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the sensor value
     * @return the sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByPrimaryKey(Serializable primaryKey)
        throws NoSuchSensorValueException, SystemException {
        SensorValue sensorValue = fetchByPrimaryKey(primaryKey);

        if (sensorValue == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSensorValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return sensorValue;
    }

    /**
     * Returns the sensor value with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException} if it could not be found.
     *
     * @param sensorValueId the primary key of the sensor value
     * @return the sensor value
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue findByPrimaryKey(long sensorValueId)
        throws NoSuchSensorValueException, SystemException {
        return findByPrimaryKey((Serializable) sensorValueId);
    }

    /**
     * Returns the sensor value with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the sensor value
     * @return the sensor value, or <code>null</code> if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        SensorValue sensorValue = (SensorValue) EntityCacheUtil.getResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
                SensorValueImpl.class, primaryKey);

        if (sensorValue == _nullSensorValue) {
            return null;
        }

        if (sensorValue == null) {
            Session session = null;

            try {
                session = openSession();

                sensorValue = (SensorValue) session.get(SensorValueImpl.class,
                        primaryKey);

                if (sensorValue != null) {
                    cacheResult(sensorValue);
                } else {
                    EntityCacheUtil.putResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
                        SensorValueImpl.class, primaryKey, _nullSensorValue);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(SensorValueModelImpl.ENTITY_CACHE_ENABLED,
                    SensorValueImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return sensorValue;
    }

    /**
     * Returns the sensor value with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param sensorValueId the primary key of the sensor value
     * @return the sensor value, or <code>null</code> if a sensor value with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SensorValue fetchByPrimaryKey(long sensorValueId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) sensorValueId);
    }

    /**
     * Returns all the sensor values.
     *
     * @return the sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the sensor values.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @return the range of sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the sensor values.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.SensorValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of sensor values
     * @param end the upper bound of the range of sensor values (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of sensor values
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<SensorValue> findAll(int start, int end,
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

        List<SensorValue> list = (List<SensorValue>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SENSORVALUE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SENSORVALUE;

                if (pagination) {
                    sql = sql.concat(SensorValueModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<SensorValue>(list);
                } else {
                    list = (List<SensorValue>) QueryUtil.list(q, getDialect(),
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
     * Removes all the sensor values from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (SensorValue sensorValue : findAll()) {
            remove(sensorValue);
        }
    }

    /**
     * Returns the number of sensor values.
     *
     * @return the number of sensor values
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

                Query q = session.createQuery(_SQL_COUNT_SENSORVALUE);

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
     * Initializes the sensor value persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.SensorValue")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SensorValue>> listenersList = new ArrayList<ModelListener<SensorValue>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SensorValue>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SensorValueImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
