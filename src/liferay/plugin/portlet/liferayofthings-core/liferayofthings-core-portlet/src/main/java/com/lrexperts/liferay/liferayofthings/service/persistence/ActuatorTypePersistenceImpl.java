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

import com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException;
import com.lrexperts.liferay.liferayofthings.model.ActuatorType;
import com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.ActuatorTypePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the actuator type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorTypePersistence
 * @see ActuatorTypeUtil
 * @generated
 */
public class ActuatorTypePersistenceImpl extends BasePersistenceImpl<ActuatorType>
    implements ActuatorTypePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ActuatorTypeUtil} to access the actuator type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ActuatorTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ActuatorTypeModelImpl.UUID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "actuatorType.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "actuatorType.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(actuatorType.uuid IS NULL OR actuatorType.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ActuatorTypeModelImpl.UUID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "actuatorType.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "actuatorType.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(actuatorType.uuid IS NULL OR actuatorType.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "actuatorType.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ActuatorTypeModelImpl.UUID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "actuatorType.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "actuatorType.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(actuatorType.uuid IS NULL OR actuatorType.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "actuatorType.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ActuatorTypeModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "actuatorType.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ActuatorTypeModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "actuatorType.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, ActuatorTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            ActuatorTypeModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorTypeModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "actuatorType.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "actuatorType.groupId = ?";
    private static final String _SQL_SELECT_ACTUATORTYPE = "SELECT actuatorType FROM ActuatorType actuatorType";
    private static final String _SQL_SELECT_ACTUATORTYPE_WHERE = "SELECT actuatorType FROM ActuatorType actuatorType WHERE ";
    private static final String _SQL_COUNT_ACTUATORTYPE = "SELECT COUNT(actuatorType) FROM ActuatorType actuatorType";
    private static final String _SQL_COUNT_ACTUATORTYPE_WHERE = "SELECT COUNT(actuatorType) FROM ActuatorType actuatorType WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "actuatorType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActuatorType exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ActuatorType exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ActuatorTypePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static ActuatorType _nullActuatorType = new ActuatorTypeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ActuatorType> toCacheModel() {
                return _nullActuatorTypeCacheModel;
            }
        };

    private static CacheModel<ActuatorType> _nullActuatorTypeCacheModel = new CacheModel<ActuatorType>() {
            @Override
            public ActuatorType toEntityModel() {
                return _nullActuatorType;
            }
        };

    public ActuatorTypePersistenceImpl() {
        setModelClass(ActuatorType.class);
    }

    /**
     * Returns all the actuator types where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuator types where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid(String uuid, int start, int end,
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActuatorType actuatorType : list) {
                if (!Validator.equals(uuid, actuatorType.getUuid())) {
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

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
                query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByUuid_First(uuid, orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the first actuator type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActuatorType> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByUuid_Last(uuid, orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the last actuator type in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<ActuatorType> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuator types before and after the current actuator type in the ordered set where uuid = &#63;.
     *
     * @param actuatorTypeId the primary key of the current actuator type
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType[] findByUuid_PrevAndNext(long actuatorTypeId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByPrimaryKey(actuatorTypeId);

        Session session = null;

        try {
            session = openSession();

            ActuatorType[] array = new ActuatorTypeImpl[3];

            array[0] = getByUuid_PrevAndNext(session, actuatorType, uuid,
                    orderByComparator, true);

            array[1] = actuatorType;

            array[2] = getByUuid_PrevAndNext(session, actuatorType, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActuatorType getByUuid_PrevAndNext(Session session,
        ActuatorType actuatorType, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
            query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(actuatorType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActuatorType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuator types where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (ActuatorType actuatorType : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Returns the actuator type where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByUUID_G(String uuid, long groupId)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByUUID_G(uuid, groupId);

        if (actuatorType == null) {
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

            throw new NoSuchActuatorTypeException(msg.toString());
        }

        return actuatorType;
    }

    /**
     * Returns the actuator type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the actuator type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof ActuatorType) {
            ActuatorType actuatorType = (ActuatorType) result;

            if (!Validator.equals(uuid, actuatorType.getUuid()) ||
                    (groupId != actuatorType.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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

                List<ActuatorType> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    ActuatorType actuatorType = list.get(0);

                    result = actuatorType;

                    cacheResult(actuatorType);

                    if ((actuatorType.getUuid() == null) ||
                            !actuatorType.getUuid().equals(uuid) ||
                            (actuatorType.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, actuatorType);
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
            return (ActuatorType) result;
        }
    }

    /**
     * Removes the actuator type where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the actuator type that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType removeByUUID_G(String uuid, long groupId)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByUUID_G(uuid, groupId);

        return remove(actuatorType);
    }

    /**
     * Returns the number of actuator types where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Returns all the actuator types where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuator types where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByUuid_C(String uuid, long companyId,
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActuatorType actuatorType : list) {
                if (!Validator.equals(uuid, actuatorType.getUuid()) ||
                        (companyId != actuatorType.getCompanyId())) {
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

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
                query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the first actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActuatorType> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the last actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<ActuatorType> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuator types before and after the current actuator type in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param actuatorTypeId the primary key of the current actuator type
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType[] findByUuid_C_PrevAndNext(long actuatorTypeId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByPrimaryKey(actuatorTypeId);

        Session session = null;

        try {
            session = openSession();

            ActuatorType[] array = new ActuatorTypeImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, actuatorType, uuid,
                    companyId, orderByComparator, true);

            array[1] = actuatorType;

            array[2] = getByUuid_C_PrevAndNext(session, actuatorType, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActuatorType getByUuid_C_PrevAndNext(Session session,
        ActuatorType actuatorType, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
            query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(actuatorType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActuatorType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuator types where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (ActuatorType actuatorType : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Returns all the actuator types where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the actuator types where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByCompanyId(long companyId, int start,
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActuatorType actuatorType : list) {
                if ((companyId != actuatorType.getCompanyId())) {
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

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator type in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the first actuator type in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActuatorType> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator type in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the last actuator type in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ActuatorType> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuator types before and after the current actuator type in the ordered set where companyId = &#63;.
     *
     * @param actuatorTypeId the primary key of the current actuator type
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType[] findByCompanyId_PrevAndNext(long actuatorTypeId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByPrimaryKey(actuatorTypeId);

        Session session = null;

        try {
            session = openSession();

            ActuatorType[] array = new ActuatorTypeImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, actuatorType,
                    companyId, orderByComparator, true);

            array[1] = actuatorType;

            array[2] = getByCompanyId_PrevAndNext(session, actuatorType,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActuatorType getByCompanyId_PrevAndNext(Session session,
        ActuatorType actuatorType, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
            query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuatorType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActuatorType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuator types where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ActuatorType actuatorType : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Returns all the actuator types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuator types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByGroupId(long groupId, int start, int end,
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActuatorType actuatorType : list) {
                if ((groupId != actuatorType.getGroupId())) {
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

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByGroupId_First(groupId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the first actuator type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActuatorType> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the last actuator type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<ActuatorType> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuator types before and after the current actuator type in the ordered set where groupId = &#63;.
     *
     * @param actuatorTypeId the primary key of the current actuator type
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType[] findByGroupId_PrevAndNext(long actuatorTypeId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByPrimaryKey(actuatorTypeId);

        Session session = null;

        try {
            session = openSession();

            ActuatorType[] array = new ActuatorTypeImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, actuatorType, groupId,
                    orderByComparator, true);

            array[1] = actuatorType;

            array[2] = getByGroupId_PrevAndNext(session, actuatorType, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActuatorType getByGroupId_PrevAndNext(Session session,
        ActuatorType actuatorType, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
            query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuatorType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActuatorType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuator types where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (ActuatorType actuatorType : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Returns all the actuator types where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuator types where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByC_G(long companyId, long groupId,
        int start, int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findByC_G(long companyId, long groupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ActuatorType actuatorType : list) {
                if ((companyId != actuatorType.getCompanyId()) ||
                        (groupId != actuatorType.getGroupId())) {
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

            query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByC_G_First(companyId, groupId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the first actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ActuatorType> list = findByC_G(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByC_G_Last(companyId, groupId,
                orderByComparator);

        if (actuatorType != null) {
            return actuatorType;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorTypeException(msg.toString());
    }

    /**
     * Returns the last actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator type, or <code>null</code> if a matching actuator type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<ActuatorType> list = findByC_G(companyId, groupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuator types before and after the current actuator type in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param actuatorTypeId the primary key of the current actuator type
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType[] findByC_G_PrevAndNext(long actuatorTypeId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = findByPrimaryKey(actuatorTypeId);

        Session session = null;

        try {
            session = openSession();

            ActuatorType[] array = new ActuatorTypeImpl[3];

            array[0] = getByC_G_PrevAndNext(session, actuatorType, companyId,
                    groupId, orderByComparator, true);

            array[1] = actuatorType;

            array[2] = getByC_G_PrevAndNext(session, actuatorType, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ActuatorType getByC_G_PrevAndNext(Session session,
        ActuatorType actuatorType, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATORTYPE_WHERE);

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
            query.append(ActuatorTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuatorType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ActuatorType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuator types where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (ActuatorType actuatorType : findByC_G(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching actuator types
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

            query.append(_SQL_COUNT_ACTUATORTYPE_WHERE);

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
     * Caches the actuator type in the entity cache if it is enabled.
     *
     * @param actuatorType the actuator type
     */
    @Override
    public void cacheResult(ActuatorType actuatorType) {
        EntityCacheUtil.putResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeImpl.class, actuatorType.getPrimaryKey(), actuatorType);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { actuatorType.getUuid(), actuatorType.getGroupId() },
            actuatorType);

        actuatorType.resetOriginalValues();
    }

    /**
     * Caches the actuator types in the entity cache if it is enabled.
     *
     * @param actuatorTypes the actuator types
     */
    @Override
    public void cacheResult(List<ActuatorType> actuatorTypes) {
        for (ActuatorType actuatorType : actuatorTypes) {
            if (EntityCacheUtil.getResult(
                        ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
                        ActuatorTypeImpl.class, actuatorType.getPrimaryKey()) == null) {
                cacheResult(actuatorType);
            } else {
                actuatorType.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all actuator types.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ActuatorTypeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ActuatorTypeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the actuator type.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ActuatorType actuatorType) {
        EntityCacheUtil.removeResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeImpl.class, actuatorType.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(actuatorType);
    }

    @Override
    public void clearCache(List<ActuatorType> actuatorTypes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ActuatorType actuatorType : actuatorTypes) {
            EntityCacheUtil.removeResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
                ActuatorTypeImpl.class, actuatorType.getPrimaryKey());

            clearUniqueFindersCache(actuatorType);
        }
    }

    protected void cacheUniqueFindersCache(ActuatorType actuatorType) {
        if (actuatorType.isNew()) {
            Object[] args = new Object[] {
                    actuatorType.getUuid(), actuatorType.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                actuatorType);
        } else {
            ActuatorTypeModelImpl actuatorTypeModelImpl = (ActuatorTypeModelImpl) actuatorType;

            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorType.getUuid(), actuatorType.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    actuatorType);
            }
        }
    }

    protected void clearUniqueFindersCache(ActuatorType actuatorType) {
        ActuatorTypeModelImpl actuatorTypeModelImpl = (ActuatorTypeModelImpl) actuatorType;

        Object[] args = new Object[] {
                actuatorType.getUuid(), actuatorType.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((actuatorTypeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    actuatorTypeModelImpl.getOriginalUuid(),
                    actuatorTypeModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new actuator type with the primary key. Does not add the actuator type to the database.
     *
     * @param actuatorTypeId the primary key for the new actuator type
     * @return the new actuator type
     */
    @Override
    public ActuatorType create(long actuatorTypeId) {
        ActuatorType actuatorType = new ActuatorTypeImpl();

        actuatorType.setNew(true);
        actuatorType.setPrimaryKey(actuatorTypeId);

        String uuid = PortalUUIDUtil.generate();

        actuatorType.setUuid(uuid);

        return actuatorType;
    }

    /**
     * Removes the actuator type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param actuatorTypeId the primary key of the actuator type
     * @return the actuator type that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType remove(long actuatorTypeId)
        throws NoSuchActuatorTypeException, SystemException {
        return remove((Serializable) actuatorTypeId);
    }

    /**
     * Removes the actuator type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the actuator type
     * @return the actuator type that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType remove(Serializable primaryKey)
        throws NoSuchActuatorTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ActuatorType actuatorType = (ActuatorType) session.get(ActuatorTypeImpl.class,
                    primaryKey);

            if (actuatorType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchActuatorTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(actuatorType);
        } catch (NoSuchActuatorTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ActuatorType removeImpl(ActuatorType actuatorType)
        throws SystemException {
        actuatorType = toUnwrappedModel(actuatorType);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(actuatorType)) {
                actuatorType = (ActuatorType) session.get(ActuatorTypeImpl.class,
                        actuatorType.getPrimaryKeyObj());
            }

            if (actuatorType != null) {
                session.delete(actuatorType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (actuatorType != null) {
            clearCache(actuatorType);
        }

        return actuatorType;
    }

    @Override
    public ActuatorType updateImpl(
        com.lrexperts.liferay.liferayofthings.model.ActuatorType actuatorType)
        throws SystemException {
        actuatorType = toUnwrappedModel(actuatorType);

        boolean isNew = actuatorType.isNew();

        ActuatorTypeModelImpl actuatorTypeModelImpl = (ActuatorTypeModelImpl) actuatorType;

        if (Validator.isNull(actuatorType.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            actuatorType.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (actuatorType.isNew()) {
                session.save(actuatorType);

                actuatorType.setNew(false);
            } else {
                session.merge(actuatorType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ActuatorTypeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorTypeModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { actuatorTypeModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorTypeModelImpl.getOriginalUuid(),
                        actuatorTypeModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        actuatorTypeModelImpl.getUuid(),
                        actuatorTypeModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorTypeModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { actuatorTypeModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorTypeModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { actuatorTypeModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((actuatorTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorTypeModelImpl.getOriginalCompanyId(),
                        actuatorTypeModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        actuatorTypeModelImpl.getCompanyId(),
                        actuatorTypeModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorTypeImpl.class, actuatorType.getPrimaryKey(), actuatorType);

        clearUniqueFindersCache(actuatorType);
        cacheUniqueFindersCache(actuatorType);

        return actuatorType;
    }

    protected ActuatorType toUnwrappedModel(ActuatorType actuatorType) {
        if (actuatorType instanceof ActuatorTypeImpl) {
            return actuatorType;
        }

        ActuatorTypeImpl actuatorTypeImpl = new ActuatorTypeImpl();

        actuatorTypeImpl.setNew(actuatorType.isNew());
        actuatorTypeImpl.setPrimaryKey(actuatorType.getPrimaryKey());

        actuatorTypeImpl.setUuid(actuatorType.getUuid());
        actuatorTypeImpl.setActuatorTypeId(actuatorType.getActuatorTypeId());
        actuatorTypeImpl.setCompanyId(actuatorType.getCompanyId());
        actuatorTypeImpl.setGroupId(actuatorType.getGroupId());
        actuatorTypeImpl.setUserId(actuatorType.getUserId());
        actuatorTypeImpl.setUserName(actuatorType.getUserName());
        actuatorTypeImpl.setCreateDate(actuatorType.getCreateDate());
        actuatorTypeImpl.setModifiedDate(actuatorType.getModifiedDate());
        actuatorTypeImpl.setName(actuatorType.getName());
        actuatorTypeImpl.setDescription(actuatorType.getDescription());
        actuatorTypeImpl.setIcon(actuatorType.getIcon());

        return actuatorTypeImpl;
    }

    /**
     * Returns the actuator type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the actuator type
     * @return the actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByPrimaryKey(Serializable primaryKey)
        throws NoSuchActuatorTypeException, SystemException {
        ActuatorType actuatorType = fetchByPrimaryKey(primaryKey);

        if (actuatorType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchActuatorTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return actuatorType;
    }

    /**
     * Returns the actuator type with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException} if it could not be found.
     *
     * @param actuatorTypeId the primary key of the actuator type
     * @return the actuator type
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType findByPrimaryKey(long actuatorTypeId)
        throws NoSuchActuatorTypeException, SystemException {
        return findByPrimaryKey((Serializable) actuatorTypeId);
    }

    /**
     * Returns the actuator type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the actuator type
     * @return the actuator type, or <code>null</code> if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ActuatorType actuatorType = (ActuatorType) EntityCacheUtil.getResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
                ActuatorTypeImpl.class, primaryKey);

        if (actuatorType == _nullActuatorType) {
            return null;
        }

        if (actuatorType == null) {
            Session session = null;

            try {
                session = openSession();

                actuatorType = (ActuatorType) session.get(ActuatorTypeImpl.class,
                        primaryKey);

                if (actuatorType != null) {
                    cacheResult(actuatorType);
                } else {
                    EntityCacheUtil.putResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
                        ActuatorTypeImpl.class, primaryKey, _nullActuatorType);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ActuatorTypeModelImpl.ENTITY_CACHE_ENABLED,
                    ActuatorTypeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return actuatorType;
    }

    /**
     * Returns the actuator type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param actuatorTypeId the primary key of the actuator type
     * @return the actuator type, or <code>null</code> if a actuator type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ActuatorType fetchByPrimaryKey(long actuatorTypeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) actuatorTypeId);
    }

    /**
     * Returns all the actuator types.
     *
     * @return the actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuator types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @return the range of actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the actuator types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of actuator types
     * @param end the upper bound of the range of actuator types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of actuator types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ActuatorType> findAll(int start, int end,
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

        List<ActuatorType> list = (List<ActuatorType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACTUATORTYPE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACTUATORTYPE;

                if (pagination) {
                    sql = sql.concat(ActuatorTypeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ActuatorType>(list);
                } else {
                    list = (List<ActuatorType>) QueryUtil.list(q, getDialect(),
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
     * Removes all the actuator types from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ActuatorType actuatorType : findAll()) {
            remove(actuatorType);
        }
    }

    /**
     * Returns the number of actuator types.
     *
     * @return the number of actuator types
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

                Query q = session.createQuery(_SQL_COUNT_ACTUATORTYPE);

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
     * Initializes the actuator type persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.ActuatorType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ActuatorType>> listenersList = new ArrayList<ModelListener<ActuatorType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ActuatorType>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ActuatorTypeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
