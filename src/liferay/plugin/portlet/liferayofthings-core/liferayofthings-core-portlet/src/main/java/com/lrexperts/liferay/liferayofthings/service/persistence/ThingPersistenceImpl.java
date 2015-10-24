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

import com.lrexperts.liferay.liferayofthings.NoSuchThingException;
import com.lrexperts.liferay.liferayofthings.model.Thing;
import com.lrexperts.liferay.liferayofthings.model.impl.ThingImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.ThingPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the thing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThingPersistence
 * @see ThingUtil
 * @generated
 */
public class ThingPersistenceImpl extends BasePersistenceImpl<Thing>
    implements ThingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ThingUtil} to access the thing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ThingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ThingModelImpl.UUID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "thing.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "thing.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(thing.uuid IS NULL OR thing.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ThingModelImpl.UUID_COLUMN_BITMASK |
            ThingModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "thing.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "thing.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(thing.uuid IS NULL OR thing.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "thing.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ThingModelImpl.UUID_COLUMN_BITMASK |
            ThingModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "thing.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "thing.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(thing.uuid IS NULL OR thing.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "thing.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ThingModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "thing.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ThingModelImpl.GROUPID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "thing.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            ThingModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingModelImpl.GROUPID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "thing.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "thing.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            ThingModelImpl.COMPANYID_COLUMN_BITMASK |
            ThingModelImpl.GROUPID_COLUMN_BITMASK |
            ThingModelImpl.STATUS_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 = "thing.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 = "thing.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_STATUS_2 = "thing.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THINGGROUPID =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThingGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGGROUPID =
        new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, ThingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThingGroupId",
            new String[] { Long.class.getName() },
            ThingModelImpl.THINGGROUPID_COLUMN_BITMASK |
            ThingModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_THINGGROUPID = new FinderPath(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThingGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_THINGGROUPID_THINGGROUPID_2 = "thing.thingGroupId = ?";
    private static final String _SQL_SELECT_THING = "SELECT thing FROM Thing thing";
    private static final String _SQL_SELECT_THING_WHERE = "SELECT thing FROM Thing thing WHERE ";
    private static final String _SQL_COUNT_THING = "SELECT COUNT(thing) FROM Thing thing";
    private static final String _SQL_COUNT_THING_WHERE = "SELECT COUNT(thing) FROM Thing thing WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "thing.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Thing exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Thing exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ThingPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Thing _nullThing = new ThingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Thing> toCacheModel() {
                return _nullThingCacheModel;
            }
        };

    private static CacheModel<Thing> _nullThingCacheModel = new CacheModel<Thing>() {
            @Override
            public Thing toEntityModel() {
                return _nullThing;
            }
        };

    public ThingPersistenceImpl() {
        setModelClass(Thing.class);
    }

    /**
     * Returns all the things where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid(String uuid, int start, int end,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if (!Validator.equals(uuid, thing.getUuid())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

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
                query.append(ThingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByUuid_First(uuid, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByUuid_Last(uuid, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where uuid = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByUuid_PrevAndNext(long thingId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByUuid_PrevAndNext(session, thing, uuid,
                    orderByComparator, true);

            array[1] = thing;

            array[2] = getByUuid_PrevAndNext(session, thing, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByUuid_PrevAndNext(Session session, Thing thing,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Thing thing : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns the thing where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByUUID_G(String uuid, long groupId)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByUUID_G(uuid, groupId);

        if (thing == null) {
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

            throw new NoSuchThingException(msg.toString());
        }

        return thing;
    }

    /**
     * Returns the thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the thing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Thing) {
            Thing thing = (Thing) result;

            if (!Validator.equals(uuid, thing.getUuid()) ||
                    (groupId != thing.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_THING_WHERE);

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

                List<Thing> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Thing thing = list.get(0);

                    result = thing;

                    cacheResult(thing);

                    if ((thing.getUuid() == null) ||
                            !thing.getUuid().equals(uuid) ||
                            (thing.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, thing);
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
            return (Thing) result;
        }
    }

    /**
     * Removes the thing where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the thing that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing removeByUUID_G(String uuid, long groupId)
        throws NoSuchThingException, SystemException {
        Thing thing = findByUUID_G(uuid, groupId);

        return remove(thing);
    }

    /**
     * Returns the number of things where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByUuid_C(String uuid, long companyId, int start,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if (!Validator.equals(uuid, thing.getUuid()) ||
                        (companyId != thing.getCompanyId())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

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
                query.append(ThingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByUuid_C_PrevAndNext(long thingId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, thing, uuid, companyId,
                    orderByComparator, true);

            array[1] = thing;

            array[2] = getByUuid_C_PrevAndNext(session, thing, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByUuid_C_PrevAndNext(Session session, Thing thing,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Thing thing : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the things where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByCompanyId(long companyId, int start, int end,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if ((companyId != thing.getCompanyId())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByCompanyId_First(companyId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByCompanyId_Last(companyId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where companyId = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByCompanyId_PrevAndNext(long thingId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, thing, companyId,
                    orderByComparator, true);

            array[1] = thing;

            array[2] = getByCompanyId_PrevAndNext(session, thing, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByCompanyId_PrevAndNext(Session session, Thing thing,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Thing thing : findByCompanyId(companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByGroupId(long groupId, int start, int end,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if ((groupId != thing.getGroupId())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByGroupId_First(groupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByGroupId_Last(groupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where groupId = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByGroupId_PrevAndNext(long thingId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, thing, groupId,
                    orderByComparator, true);

            array[1] = thing;

            array[2] = getByGroupId_PrevAndNext(session, thing, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByGroupId_PrevAndNext(Session session, Thing thing,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Thing thing : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G(long companyId, long groupId, int start,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if ((companyId != thing.getCompanyId()) ||
                        (groupId != thing.getGroupId())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByC_G_First(companyId, groupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByC_G(companyId, groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByC_G_Last(companyId, groupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByC_G_PrevAndNext(long thingId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByC_G_PrevAndNext(session, thing, companyId, groupId,
                    orderByComparator, true);

            array[1] = thing;

            array[2] = getByC_G_PrevAndNext(session, thing, companyId, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByC_G_PrevAndNext(Session session, Thing thing,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (Thing thing : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        return findByC_G_S(companyId, groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G_S(long companyId, long groupId, int status,
        int start, int end) throws SystemException {
        return findByC_G_S(companyId, groupId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByC_G_S(long companyId, long groupId, int status,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if ((companyId != thing.getCompanyId()) ||
                        (groupId != thing.getGroupId()) ||
                        (status != thing.getStatus())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByC_G_S_First(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByC_G_S_First(companyId, groupId, status,
                orderByComparator);

        if (thing != null) {
            return thing;
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

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByC_G_S_First(long companyId, long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByC_G_S(companyId, groupId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByC_G_S_Last(companyId, groupId, status,
                orderByComparator);

        if (thing != null) {
            return thing;
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

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G_S(companyId, groupId, status);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByC_G_S(companyId, groupId, status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByC_G_S_PrevAndNext(long thingId, long companyId,
        long groupId, int status, OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByC_G_S_PrevAndNext(session, thing, companyId,
                    groupId, status, orderByComparator, true);

            array[1] = thing;

            array[2] = getByC_G_S_PrevAndNext(session, thing, companyId,
                    groupId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByC_G_S_PrevAndNext(Session session, Thing thing,
        long companyId, long groupId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        for (Thing thing : findByC_G_S(companyId, groupId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching things
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

            query.append(_SQL_COUNT_THING_WHERE);

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
     * Returns all the things where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @return the matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByThingGroupId(long thingGroupId)
        throws SystemException {
        return findByThingGroupId(thingGroupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things where thingGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingGroupId the thing group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByThingGroupId(long thingGroupId, int start, int end)
        throws SystemException {
        return findByThingGroupId(thingGroupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the things where thingGroupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingGroupId the thing group ID
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findByThingGroupId(long thingGroupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGGROUPID;
            finderArgs = new Object[] { thingGroupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THINGGROUPID;
            finderArgs = new Object[] {
                    thingGroupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Thing thing : list) {
                if ((thingGroupId != thing.getThingGroupId())) {
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

            query.append(_SQL_SELECT_THING_WHERE);

            query.append(_FINDER_COLUMN_THINGGROUPID_THINGGROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ThingModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(thingGroupId);

                if (!pagination) {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first thing in the ordered set where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByThingGroupId_First(long thingGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByThingGroupId_First(thingGroupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingGroupId=");
        msg.append(thingGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the first thing in the ordered set where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByThingGroupId_First(long thingGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Thing> list = findByThingGroupId(thingGroupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last thing in the ordered set where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByThingGroupId_Last(long thingGroupId,
        OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByThingGroupId_Last(thingGroupId, orderByComparator);

        if (thing != null) {
            return thing;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingGroupId=");
        msg.append(thingGroupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchThingException(msg.toString());
    }

    /**
     * Returns the last thing in the ordered set where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching thing, or <code>null</code> if a matching thing could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByThingGroupId_Last(long thingGroupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByThingGroupId(thingGroupId);

        if (count == 0) {
            return null;
        }

        List<Thing> list = findByThingGroupId(thingGroupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the things before and after the current thing in the ordered set where thingGroupId = &#63;.
     *
     * @param thingId the primary key of the current thing
     * @param thingGroupId the thing group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing[] findByThingGroupId_PrevAndNext(long thingId,
        long thingGroupId, OrderByComparator orderByComparator)
        throws NoSuchThingException, SystemException {
        Thing thing = findByPrimaryKey(thingId);

        Session session = null;

        try {
            session = openSession();

            Thing[] array = new ThingImpl[3];

            array[0] = getByThingGroupId_PrevAndNext(session, thing,
                    thingGroupId, orderByComparator, true);

            array[1] = thing;

            array[2] = getByThingGroupId_PrevAndNext(session, thing,
                    thingGroupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Thing getByThingGroupId_PrevAndNext(Session session, Thing thing,
        long thingGroupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_THING_WHERE);

        query.append(_FINDER_COLUMN_THINGGROUPID_THINGGROUPID_2);

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
            query.append(ThingModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(thingGroupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(thing);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Thing> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the things where thingGroupId = &#63; from the database.
     *
     * @param thingGroupId the thing group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByThingGroupId(long thingGroupId)
        throws SystemException {
        for (Thing thing : findByThingGroupId(thingGroupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things where thingGroupId = &#63;.
     *
     * @param thingGroupId the thing group ID
     * @return the number of matching things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByThingGroupId(long thingGroupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_THINGGROUPID;

        Object[] finderArgs = new Object[] { thingGroupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_THING_WHERE);

            query.append(_FINDER_COLUMN_THINGGROUPID_THINGGROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(thingGroupId);

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
     * Caches the thing in the entity cache if it is enabled.
     *
     * @param thing the thing
     */
    @Override
    public void cacheResult(Thing thing) {
        EntityCacheUtil.putResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingImpl.class, thing.getPrimaryKey(), thing);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { thing.getUuid(), thing.getGroupId() }, thing);

        thing.resetOriginalValues();
    }

    /**
     * Caches the things in the entity cache if it is enabled.
     *
     * @param things the things
     */
    @Override
    public void cacheResult(List<Thing> things) {
        for (Thing thing : things) {
            if (EntityCacheUtil.getResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
                        ThingImpl.class, thing.getPrimaryKey()) == null) {
                cacheResult(thing);
            } else {
                thing.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all things.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ThingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ThingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the thing.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Thing thing) {
        EntityCacheUtil.removeResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingImpl.class, thing.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(thing);
    }

    @Override
    public void clearCache(List<Thing> things) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Thing thing : things) {
            EntityCacheUtil.removeResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
                ThingImpl.class, thing.getPrimaryKey());

            clearUniqueFindersCache(thing);
        }
    }

    protected void cacheUniqueFindersCache(Thing thing) {
        if (thing.isNew()) {
            Object[] args = new Object[] { thing.getUuid(), thing.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, thing);
        } else {
            ThingModelImpl thingModelImpl = (ThingModelImpl) thing;

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { thing.getUuid(), thing.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    thing);
            }
        }
    }

    protected void clearUniqueFindersCache(Thing thing) {
        ThingModelImpl thingModelImpl = (ThingModelImpl) thing;

        Object[] args = new Object[] { thing.getUuid(), thing.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((thingModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    thingModelImpl.getOriginalUuid(),
                    thingModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new thing with the primary key. Does not add the thing to the database.
     *
     * @param thingId the primary key for the new thing
     * @return the new thing
     */
    @Override
    public Thing create(long thingId) {
        Thing thing = new ThingImpl();

        thing.setNew(true);
        thing.setPrimaryKey(thingId);

        String uuid = PortalUUIDUtil.generate();

        thing.setUuid(uuid);

        return thing;
    }

    /**
     * Removes the thing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param thingId the primary key of the thing
     * @return the thing that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing remove(long thingId)
        throws NoSuchThingException, SystemException {
        return remove((Serializable) thingId);
    }

    /**
     * Removes the thing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the thing
     * @return the thing that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing remove(Serializable primaryKey)
        throws NoSuchThingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Thing thing = (Thing) session.get(ThingImpl.class, primaryKey);

            if (thing == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchThingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(thing);
        } catch (NoSuchThingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Thing removeImpl(Thing thing) throws SystemException {
        thing = toUnwrappedModel(thing);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(thing)) {
                thing = (Thing) session.get(ThingImpl.class,
                        thing.getPrimaryKeyObj());
            }

            if (thing != null) {
                session.delete(thing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (thing != null) {
            clearCache(thing);
        }

        return thing;
    }

    @Override
    public Thing updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Thing thing)
        throws SystemException {
        thing = toUnwrappedModel(thing);

        boolean isNew = thing.isNew();

        ThingModelImpl thingModelImpl = (ThingModelImpl) thing;

        if (Validator.isNull(thing.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            thing.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (thing.isNew()) {
                session.save(thing);

                thing.setNew(false);
            } else {
                session.merge(thing);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ThingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { thingModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { thingModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingModelImpl.getOriginalUuid(),
                        thingModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        thingModelImpl.getUuid(), thingModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { thingModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { thingModelImpl.getOriginalGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { thingModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingModelImpl.getOriginalCompanyId(),
                        thingModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        thingModelImpl.getCompanyId(),
                        thingModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingModelImpl.getOriginalCompanyId(),
                        thingModelImpl.getOriginalGroupId(),
                        thingModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);

                args = new Object[] {
                        thingModelImpl.getCompanyId(),
                        thingModelImpl.getGroupId(), thingModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);
            }

            if ((thingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        thingModelImpl.getOriginalThingGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGGROUPID,
                    args);

                args = new Object[] { thingModelImpl.getThingGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGGROUPID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGGROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
            ThingImpl.class, thing.getPrimaryKey(), thing);

        clearUniqueFindersCache(thing);
        cacheUniqueFindersCache(thing);

        return thing;
    }

    protected Thing toUnwrappedModel(Thing thing) {
        if (thing instanceof ThingImpl) {
            return thing;
        }

        ThingImpl thingImpl = new ThingImpl();

        thingImpl.setNew(thing.isNew());
        thingImpl.setPrimaryKey(thing.getPrimaryKey());

        thingImpl.setUuid(thing.getUuid());
        thingImpl.setThingId(thing.getThingId());
        thingImpl.setCompanyId(thing.getCompanyId());
        thingImpl.setGroupId(thing.getGroupId());
        thingImpl.setUserId(thing.getUserId());
        thingImpl.setUserName(thing.getUserName());
        thingImpl.setCreateDate(thing.getCreateDate());
        thingImpl.setModifiedDate(thing.getModifiedDate());
        thingImpl.setThingGroupId(thing.getThingGroupId());
        thingImpl.setName(thing.getName());
        thingImpl.setDescription(thing.getDescription());
        thingImpl.setEndpoint(thing.getEndpoint());
        thingImpl.setEnabled(thing.isEnabled());
        thingImpl.setStatus(thing.getStatus());

        return thingImpl;
    }

    /**
     * Returns the thing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the thing
     * @return the thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByPrimaryKey(Serializable primaryKey)
        throws NoSuchThingException, SystemException {
        Thing thing = fetchByPrimaryKey(primaryKey);

        if (thing == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchThingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return thing;
    }

    /**
     * Returns the thing with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchThingException} if it could not be found.
     *
     * @param thingId the primary key of the thing
     * @return the thing
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchThingException if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing findByPrimaryKey(long thingId)
        throws NoSuchThingException, SystemException {
        return findByPrimaryKey((Serializable) thingId);
    }

    /**
     * Returns the thing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the thing
     * @return the thing, or <code>null</code> if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Thing thing = (Thing) EntityCacheUtil.getResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
                ThingImpl.class, primaryKey);

        if (thing == _nullThing) {
            return null;
        }

        if (thing == null) {
            Session session = null;

            try {
                session = openSession();

                thing = (Thing) session.get(ThingImpl.class, primaryKey);

                if (thing != null) {
                    cacheResult(thing);
                } else {
                    EntityCacheUtil.putResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
                        ThingImpl.class, primaryKey, _nullThing);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ThingModelImpl.ENTITY_CACHE_ENABLED,
                    ThingImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return thing;
    }

    /**
     * Returns the thing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param thingId the primary key of the thing
     * @return the thing, or <code>null</code> if a thing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Thing fetchByPrimaryKey(long thingId) throws SystemException {
        return fetchByPrimaryKey((Serializable) thingId);
    }

    /**
     * Returns all the things.
     *
     * @return the things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the things.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @return the range of things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the things.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ThingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of things
     * @param end the upper bound of the range of things (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of things
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Thing> findAll(int start, int end,
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

        List<Thing> list = (List<Thing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_THING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_THING;

                if (pagination) {
                    sql = sql.concat(ThingModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Thing>(list);
                } else {
                    list = (List<Thing>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the things from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Thing thing : findAll()) {
            remove(thing);
        }
    }

    /**
     * Returns the number of things.
     *
     * @return the number of things
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

                Query q = session.createQuery(_SQL_COUNT_THING);

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
     * Initializes the thing persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.Thing")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Thing>> listenersList = new ArrayList<ModelListener<Thing>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Thing>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ThingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
