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

import com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException;
import com.lrexperts.liferay.liferayofthings.model.ThingGroup;
import com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.ThingGroupPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the thing group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingGroupPersistence
 * @see ThingGroupUtil
 * @generated
 */
public class ThingGroupPersistenceImpl extends BasePersistenceImpl<ThingGroup>
    implements ThingGroupPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ThingGroupUtil} to access the thing group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ThingGroupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ThingGroupModelImpl.UUID_COLUMN_BITMASK |
            ThingGroupModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "thingGroup.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "thingGroup.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(thingGroup.uuid IS NULL OR thingGroup.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ThingGroupModelImpl.UUID_COLUMN_BITMASK |
            ThingGroupModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "thingGroup.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "thingGroup.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(thingGroup.uuid IS NULL OR thingGroup.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "thingGroup.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ThingGroupModelImpl.UUID_COLUMN_BITMASK |
            ThingGroupModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingGroupModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "thingGroup.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "thingGroup.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(thingGroup.uuid IS NULL OR thingGroup.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "thingGroup.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ThingGroupModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingGroupModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "thingGroup.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ThingGroupModelImpl.GROUPID_COLUMN_BITMASK |
            ThingGroupModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "thingGroup.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, ThingGroupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            ThingGroupModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingGroupModelImpl.GROUPID_COLUMN_BITMASK |
            ThingGroupModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "thingGroup.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "thingGroup.groupId = ?";
    private static final String _SQL_SELECT_THINGGROUP = "SELECT thingGroup FROM ThingGroup thingGroup";
    private static final String _SQL_SELECT_THINGGROUP_WHERE = "SELECT thingGroup FROM ThingGroup thingGroup WHERE ";
    private static final String _SQL_COUNT_THINGGROUP = "SELECT COUNT(thingGroup) FROM ThingGroup thingGroup";
    private static final String _SQL_COUNT_THINGGROUP_WHERE = "SELECT COUNT(thingGroup) FROM ThingGroup thingGroup WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "thingGroup.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThingGroup exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThingGroup exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ThingGroupPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static ThingGroup _nullThingGroup = new ThingGroupImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ThingGroup> toCacheModel() {
                return _nullThingGroupCacheModel;
            }
        };

    private static CacheModel<ThingGroup> _nullThingGroupCacheModel = new CacheModel<ThingGroup>() {
            @Override
            public ThingGroup toEntityModel() {
                return _nullThingGroup;
            }
        };

    public ThingGroupPersistenceImpl() {
        setModelClass(ThingGroup.class);
    }

    /**
     * Returns all the thing groups where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the thing groups where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid(String uuid, int start, int end,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ThingGroup thingGroup : list) {
                if (!Validator.equals(uuid, thingGroup.getUuid())) {
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

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
                query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Returns the first thing group in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByUuid_First(uuid, orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the first thing group in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<ThingGroup> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing group in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByUuid_Last(uuid, orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the last thing group in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<ThingGroup> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the thing groups before and after the current thing group in the ordered set where uuid = &#63;.
     *
     * @param thingGroupId the primary key of the current thing group
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup[] findByUuid_PrevAndNext(long thingGroupId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByPrimaryKey(thingGroupId);

        Session session = null;

        try {
            session = openSession();

            ThingGroup[] array = new ThingGroupImpl[3];

            array[0] = getByUuid_PrevAndNext(session, thingGroup, uuid,
                    orderByComparator, true);

            array[1] = thingGroup;

            array[2] = getByUuid_PrevAndNext(session, thingGroup, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ThingGroup getByUuid_PrevAndNext(Session session,
        ThingGroup thingGroup, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
            query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(thingGroup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ThingGroup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the thing groups where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (ThingGroup thingGroup : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Returns the thing group where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByUUID_G(String uuid, long groupId)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByUUID_G(uuid, groupId);

        if (thingGroup == null) {
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

            throw new NoSuchThingGroupException(msg.toString());
        }

        return thingGroup;
    }

    /**
     * Returns the thing group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the thing group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof ThingGroup) {
            ThingGroup thingGroup = (ThingGroup) result;

            if (!Validator.equals(uuid, thingGroup.getUuid()) ||
                    (groupId != thingGroup.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

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

                List<ThingGroup> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    ThingGroup thingGroup = list.get(0);

                    result = thingGroup;

                    cacheResult(thingGroup);

                    if ((thingGroup.getUuid() == null) ||
                            !thingGroup.getUuid().equals(uuid) ||
                            (thingGroup.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, thingGroup);
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
            return (ThingGroup) result;
        }
    }

    /**
     * Removes the thing group where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the thing group that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup removeByUUID_G(String uuid, long groupId)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByUUID_G(uuid, groupId);

        return remove(thingGroup);
    }

    /**
     * Returns the number of thing groups where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Returns all the thing groups where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the thing groups where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByUuid_C(String uuid, long companyId,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ThingGroup thingGroup : list) {
                if (!Validator.equals(uuid, thingGroup.getUuid()) ||
                        (companyId != thingGroup.getCompanyId())) {
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

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
                query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Returns the first thing group in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the first thing group in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ThingGroup> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing group in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the last thing group in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<ThingGroup> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the thing groups before and after the current thing group in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param thingGroupId the primary key of the current thing group
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup[] findByUuid_C_PrevAndNext(long thingGroupId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByPrimaryKey(thingGroupId);

        Session session = null;

        try {
            session = openSession();

            ThingGroup[] array = new ThingGroupImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, thingGroup, uuid,
                    companyId, orderByComparator, true);

            array[1] = thingGroup;

            array[2] = getByUuid_C_PrevAndNext(session, thingGroup, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ThingGroup getByUuid_C_PrevAndNext(Session session,
        ThingGroup thingGroup, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
            query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(thingGroup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ThingGroup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the thing groups where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (ThingGroup thingGroup : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Returns all the thing groups where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the thing groups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByCompanyId(long companyId, int start, int end,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ThingGroup thingGroup : list) {
                if ((companyId != thingGroup.getCompanyId())) {
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

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Returns the first thing group in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the first thing group in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ThingGroup> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing group in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the last thing group in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ThingGroup> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the thing groups before and after the current thing group in the ordered set where companyId = &#63;.
     *
     * @param thingGroupId the primary key of the current thing group
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup[] findByCompanyId_PrevAndNext(long thingGroupId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByPrimaryKey(thingGroupId);

        Session session = null;

        try {
            session = openSession();

            ThingGroup[] array = new ThingGroupImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, thingGroup,
                    companyId, orderByComparator, true);

            array[1] = thingGroup;

            array[2] = getByCompanyId_PrevAndNext(session, thingGroup,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ThingGroup getByCompanyId_PrevAndNext(Session session,
        ThingGroup thingGroup, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
            query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thingGroup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ThingGroup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the thing groups where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ThingGroup thingGroup : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Returns all the thing groups where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the thing groups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByGroupId(long groupId, int start, int end,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ThingGroup thingGroup : list) {
                if ((groupId != thingGroup.getGroupId())) {
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

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Returns the first thing group in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByGroupId_First(groupId, orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the first thing group in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ThingGroup> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing group in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByGroupId_Last(groupId, orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the last thing group in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<ThingGroup> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the thing groups before and after the current thing group in the ordered set where groupId = &#63;.
     *
     * @param thingGroupId the primary key of the current thing group
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup[] findByGroupId_PrevAndNext(long thingGroupId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByPrimaryKey(thingGroupId);

        Session session = null;

        try {
            session = openSession();

            ThingGroup[] array = new ThingGroupImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, thingGroup, groupId,
                    orderByComparator, true);

            array[1] = thingGroup;

            array[2] = getByGroupId_PrevAndNext(session, thingGroup, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ThingGroup getByGroupId_PrevAndNext(Session session,
        ThingGroup thingGroup, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
            query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thingGroup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ThingGroup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the thing groups where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (ThingGroup thingGroup : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Returns all the thing groups where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the thing groups where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findByC_G(long companyId, long groupId, int start,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ThingGroup thingGroup : list) {
                if ((companyId != thingGroup.getCompanyId()) ||
                        (groupId != thingGroup.getGroupId())) {
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

            query.append(_SQL_SELECT_THINGGROUP_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Returns the first thing group in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByC_G_First(companyId, groupId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the first thing group in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ThingGroup> list = findByC_G(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing group in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByC_G_Last(companyId, groupId,
                orderByComparator);

        if (thingGroup != null) {
            return thingGroup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingGroupException(msg.toString());
    }

    /**
     * Returns the last thing group in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing group, or <code>null</code> if a matching thing group could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<ThingGroup> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the thing groups before and after the current thing group in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param thingGroupId the primary key of the current thing group
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup[] findByC_G_PrevAndNext(long thingGroupId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = findByPrimaryKey(thingGroupId);

        Session session = null;

        try {
            session = openSession();

            ThingGroup[] array = new ThingGroupImpl[3];

            array[0] = getByC_G_PrevAndNext(session, thingGroup, companyId,
                    groupId, orderByComparator, true);

            array[1] = thingGroup;

            array[2] = getByC_G_PrevAndNext(session, thingGroup, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ThingGroup getByC_G_PrevAndNext(Session session,
        ThingGroup thingGroup, long companyId, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THINGGROUP_WHERE);

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
            query.append(ThingGroupModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thingGroup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ThingGroup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the thing groups where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (ThingGroup thingGroup : findByC_G(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching thing groups
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

            query.append(_SQL_COUNT_THINGGROUP_WHERE);

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
     * Caches the thing group in the entity cache if it is enabled.
     *
     * @param thingGroup the thing group
     */
    @Override
    public void cacheResult(ThingGroup thingGroup) {
        EntityCacheUtil.putResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupImpl.class, thingGroup.getPrimaryKey(), thingGroup);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { thingGroup.getUuid(), thingGroup.getGroupId() },
            thingGroup);

        thingGroup.resetOriginalValues();
    }

    /**
     * Caches the thing groups in the entity cache if it is enabled.
     *
     * @param thingGroups the thing groups
     */
    @Override
    public void cacheResult(List<ThingGroup> thingGroups) {
        for (ThingGroup thingGroup : thingGroups) {
            if (EntityCacheUtil.getResult(
                        ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
                        ThingGroupImpl.class, thingGroup.getPrimaryKey()) == null) {
                cacheResult(thingGroup);
            } else {
                thingGroup.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all thing groups.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ThingGroupImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ThingGroupImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the thing group.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ThingGroup thingGroup) {
        EntityCacheUtil.removeResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupImpl.class, thingGroup.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(thingGroup);
    }

    @Override
    public void clearCache(List<ThingGroup> thingGroups) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ThingGroup thingGroup : thingGroups) {
            EntityCacheUtil.removeResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
                ThingGroupImpl.class, thingGroup.getPrimaryKey());

            clearUniqueFindersCache(thingGroup);
        }
    }

    protected void cacheUniqueFindersCache(ThingGroup thingGroup) {
        if (thingGroup.isNew()) {
            Object[] args = new Object[] {
                    thingGroup.getUuid(), thingGroup.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                thingGroup);
        } else {
            ThingGroupModelImpl thingGroupModelImpl = (ThingGroupModelImpl) thingGroup;

            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroup.getUuid(), thingGroup.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    thingGroup);
            }
        }
    }

    protected void clearUniqueFindersCache(ThingGroup thingGroup) {
        ThingGroupModelImpl thingGroupModelImpl = (ThingGroupModelImpl) thingGroup;

        Object[] args = new Object[] {
                thingGroup.getUuid(), thingGroup.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((thingGroupModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    thingGroupModelImpl.getOriginalUuid(),
                    thingGroupModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new thing group with the primary key. Does not add the thing group to the database.
     *
     * @param thingGroupId the primary key for the new thing group
     * @return the new thing group
     */
    @Override
    public ThingGroup create(long thingGroupId) {
        ThingGroup thingGroup = new ThingGroupImpl();

        thingGroup.setNew(true);
        thingGroup.setPrimaryKey(thingGroupId);

        String uuid = PortalUUIDUtil.generate();

        thingGroup.setUuid(uuid);

        return thingGroup;
    }

    /**
     * Removes the thing group with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param thingGroupId the primary key of the thing group
     * @return the thing group that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup remove(long thingGroupId)
        throws NoSuchThingGroupException, SystemException {
        return remove((Serializable) thingGroupId);
    }

    /**
     * Removes the thing group with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the thing group
     * @return the thing group that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup remove(Serializable primaryKey)
        throws NoSuchThingGroupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ThingGroup thingGroup = (ThingGroup) session.get(ThingGroupImpl.class,
                    primaryKey);

            if (thingGroup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchThingGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(thingGroup);
        } catch (NoSuchThingGroupException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ThingGroup removeImpl(ThingGroup thingGroup)
        throws SystemException {
        thingGroup = toUnwrappedModel(thingGroup);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(thingGroup)) {
                thingGroup = (ThingGroup) session.get(ThingGroupImpl.class,
                        thingGroup.getPrimaryKeyObj());
            }

            if (thingGroup != null) {
                session.delete(thingGroup);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (thingGroup != null) {
            clearCache(thingGroup);
        }

        return thingGroup;
    }

    @Override
    public ThingGroup updateImpl(
        com.lrexperts.liferay.liferayofthings.model.ThingGroup thingGroup)
        throws SystemException {
        thingGroup = toUnwrappedModel(thingGroup);

        boolean isNew = thingGroup.isNew();

        ThingGroupModelImpl thingGroupModelImpl = (ThingGroupModelImpl) thingGroup;

        if (Validator.isNull(thingGroup.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            thingGroup.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (thingGroup.isNew()) {
                session.save(thingGroup);

                thingGroup.setNew(false);
            } else {
                session.merge(thingGroup);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ThingGroupModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroupModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { thingGroupModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroupModelImpl.getOriginalUuid(),
                        thingGroupModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        thingGroupModelImpl.getUuid(),
                        thingGroupModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroupModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { thingGroupModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroupModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { thingGroupModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((thingGroupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingGroupModelImpl.getOriginalCompanyId(),
                        thingGroupModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        thingGroupModelImpl.getCompanyId(),
                        thingGroupModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
            ThingGroupImpl.class, thingGroup.getPrimaryKey(), thingGroup);

        clearUniqueFindersCache(thingGroup);
        cacheUniqueFindersCache(thingGroup);

        return thingGroup;
    }

    protected ThingGroup toUnwrappedModel(ThingGroup thingGroup) {
        if (thingGroup instanceof ThingGroupImpl) {
            return thingGroup;
        }

        ThingGroupImpl thingGroupImpl = new ThingGroupImpl();

        thingGroupImpl.setNew(thingGroup.isNew());
        thingGroupImpl.setPrimaryKey(thingGroup.getPrimaryKey());

        thingGroupImpl.setUuid(thingGroup.getUuid());
        thingGroupImpl.setThingGroupId(thingGroup.getThingGroupId());
        thingGroupImpl.setCompanyId(thingGroup.getCompanyId());
        thingGroupImpl.setGroupId(thingGroup.getGroupId());
        thingGroupImpl.setUserId(thingGroup.getUserId());
        thingGroupImpl.setUserName(thingGroup.getUserName());
        thingGroupImpl.setCreateDate(thingGroup.getCreateDate());
        thingGroupImpl.setModifiedDate(thingGroup.getModifiedDate());
        thingGroupImpl.setName(thingGroup.getName());
        thingGroupImpl.setDescription(thingGroup.getDescription());
        thingGroupImpl.setEnabled(thingGroup.isEnabled());

        return thingGroupImpl;
    }

    /**
     * Returns the thing group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the thing group
     * @return the thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByPrimaryKey(Serializable primaryKey)
        throws NoSuchThingGroupException, SystemException {
        ThingGroup thingGroup = fetchByPrimaryKey(primaryKey);

        if (thingGroup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchThingGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return thingGroup;
    }

    /**
     * Returns the thing group with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException} if it could not be found.
     *
     * @param thingGroupId the primary key of the thing group
     * @return the thing group
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup findByPrimaryKey(long thingGroupId)
        throws NoSuchThingGroupException, SystemException {
        return findByPrimaryKey((Serializable) thingGroupId);
    }

    /**
     * Returns the thing group with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the thing group
     * @return the thing group, or <code>null</code> if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ThingGroup thingGroup = (ThingGroup) EntityCacheUtil.getResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
                ThingGroupImpl.class, primaryKey);

        if (thingGroup == _nullThingGroup) {
            return null;
        }

        if (thingGroup == null) {
            Session session = null;

            try {
                session = openSession();

                thingGroup = (ThingGroup) session.get(ThingGroupImpl.class,
                        primaryKey);

                if (thingGroup != null) {
                    cacheResult(thingGroup);
                } else {
                    EntityCacheUtil.putResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
                        ThingGroupImpl.class, primaryKey, _nullThingGroup);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ThingGroupModelImpl.ENTITY_CACHE_ENABLED,
                    ThingGroupImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return thingGroup;
    }

    /**
     * Returns the thing group with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param thingGroupId the primary key of the thing group
     * @return the thing group, or <code>null</code> if a thing group with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ThingGroup fetchByPrimaryKey(long thingGroupId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) thingGroupId);
    }

    /**
     * Returns all the thing groups.
     *
     * @return the thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the thing groups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @return the range of thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the thing groups.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of thing groups
     * @param end the upper bound of the range of thing groups (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of thing groups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ThingGroup> findAll(int start, int end,
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

        List<ThingGroup> list = (List<ThingGroup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_THINGGROUP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_THINGGROUP;

                if (pagination) {
                    sql = sql.concat(ThingGroupModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ThingGroup>(list);
                } else {
                    list = (List<ThingGroup>) QueryUtil.list(q, getDialect(),
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
     * Removes all the thing groups from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ThingGroup thingGroup : findAll()) {
            remove(thingGroup);
        }
    }

    /**
     * Returns the number of thing groups.
     *
     * @return the number of thing groups
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

                Query q = session.createQuery(_SQL_COUNT_THINGGROUP);

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
     * Initializes the thing group persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.ThingGroup")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ThingGroup>> listenersList = new ArrayList<ModelListener<ThingGroup>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ThingGroup>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ThingGroupImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
