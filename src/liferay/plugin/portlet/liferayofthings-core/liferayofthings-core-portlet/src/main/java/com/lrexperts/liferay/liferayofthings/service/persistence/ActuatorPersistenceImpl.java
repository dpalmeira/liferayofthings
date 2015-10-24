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

import com.lrexperts.liferay.liferayofthings.NoSuchActuatorException;
import com.lrexperts.liferay.liferayofthings.model.Actuator;
import com.lrexperts.liferay.liferayofthings.model.impl.ActuatorImpl;
import com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl;
import com.lrexperts.liferay.liferayofthings.service.persistence.ActuatorPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the actuator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActuatorPersistence
 * @see ActuatorUtil
 * @generated
 */
public class ActuatorPersistenceImpl extends BasePersistenceImpl<Actuator>
    implements ActuatorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ActuatorUtil} to access the actuator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ActuatorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ActuatorModelImpl.UUID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "actuator.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "actuator.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(actuator.uuid IS NULL OR actuator.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ActuatorModelImpl.UUID_COLUMN_BITMASK |
            ActuatorModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "actuator.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "actuator.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(actuator.uuid IS NULL OR actuator.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "actuator.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ActuatorModelImpl.UUID_COLUMN_BITMASK |
            ActuatorModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "actuator.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "actuator.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(actuator.uuid IS NULL OR actuator.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "actuator.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ActuatorModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "actuator.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ActuatorModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "actuator.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            ActuatorModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "actuator.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "actuator.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            },
            ActuatorModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorModelImpl.STATUS_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_S_COMPANYID_2 = "actuator.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_GROUPID_2 = "actuator.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_STATUS_2 = "actuator.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THINGID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThingId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByThingId",
            new String[] { Long.class.getName() },
            ActuatorModelImpl.THINGID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_THINGID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByThingId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_THINGID_THINGID_2 = "actuator.thingId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTUATORTYPEID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActuatorTypeId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTUATORTYPEID =
        new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActuatorTypeId",
            new String[] { Long.class.getName() },
            ActuatorModelImpl.ACTUATORTYPEID_COLUMN_BITMASK |
            ActuatorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTUATORTYPEID = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActuatorTypeId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ACTUATORTYPEID_ACTUATORTYPEID_2 = "actuator.actuatorTypeId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_ENDPOINT = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByEndpoint",
            new String[] { String.class.getName() },
            ActuatorModelImpl.ENDPOINT_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ENDPOINT = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEndpoint",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_1 = "actuator.endpoint IS NULL";
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_2 = "actuator.endpoint = ?";
    private static final String _FINDER_COLUMN_ENDPOINT_ENDPOINT_3 = "(actuator.endpoint IS NULL OR actuator.endpoint = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_C_G_E_EN = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, ActuatorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByC_G_E_EN",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName(), Boolean.class.getName()
            },
            ActuatorModelImpl.COMPANYID_COLUMN_BITMASK |
            ActuatorModelImpl.GROUPID_COLUMN_BITMASK |
            ActuatorModelImpl.ENDPOINT_COLUMN_BITMASK |
            ActuatorModelImpl.ENABLED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_E_EN = new FinderPath(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_E_EN",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName(), Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_E_EN_COMPANYID_2 = "actuator.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_GROUPID_2 = "actuator.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_1 = "actuator.endpoint IS NULL AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_2 = "actuator.endpoint = ? AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENDPOINT_3 = "(actuator.endpoint IS NULL OR actuator.endpoint = '') AND ";
    private static final String _FINDER_COLUMN_C_G_E_EN_ENABLED_2 = "actuator.enabled = ?";
    private static final String _SQL_SELECT_ACTUATOR = "SELECT actuator FROM Actuator actuator";
    private static final String _SQL_SELECT_ACTUATOR_WHERE = "SELECT actuator FROM Actuator actuator WHERE ";
    private static final String _SQL_COUNT_ACTUATOR = "SELECT COUNT(actuator) FROM Actuator actuator";
    private static final String _SQL_COUNT_ACTUATOR_WHERE = "SELECT COUNT(actuator) FROM Actuator actuator WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "actuator.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Actuator exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Actuator exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ActuatorPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Actuator _nullActuator = new ActuatorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Actuator> toCacheModel() {
                return _nullActuatorCacheModel;
            }
        };

    private static CacheModel<Actuator> _nullActuatorCacheModel = new CacheModel<Actuator>() {
            @Override
            public Actuator toEntityModel() {
                return _nullActuator;
            }
        };

    public ActuatorPersistenceImpl() {
        setModelClass(Actuator.class);
    }

    /**
     * Returns all the actuators where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid(String uuid, int start, int end,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if (!Validator.equals(uuid, actuator.getUuid())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByUuid_First(uuid, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByUuid_Last(uuid, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where uuid = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByUuid_PrevAndNext(long actuatorId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByUuid_PrevAndNext(session, actuator, uuid,
                    orderByComparator, true);

            array[1] = actuator;

            array[2] = getByUuid_PrevAndNext(session, actuator, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByUuid_PrevAndNext(Session session,
        Actuator actuator, String uuid, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Actuator actuator : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns the actuator where uuid = &#63; and groupId = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByUUID_G(String uuid, long groupId)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByUUID_G(uuid, groupId);

        if (actuator == null) {
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

            throw new NoSuchActuatorException(msg.toString());
        }

        return actuator;
    }

    /**
     * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the actuator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Actuator) {
            Actuator actuator = (Actuator) result;

            if (!Validator.equals(uuid, actuator.getUuid()) ||
                    (groupId != actuator.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

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

                List<Actuator> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Actuator actuator = list.get(0);

                    result = actuator;

                    cacheResult(actuator);

                    if ((actuator.getUuid() == null) ||
                            !actuator.getUuid().equals(uuid) ||
                            (actuator.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, actuator);
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
            return (Actuator) result;
        }
    }

    /**
     * Removes the actuator where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the actuator that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator removeByUUID_G(String uuid, long groupId)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByUUID_G(uuid, groupId);

        return remove(actuator);
    }

    /**
     * Returns the number of actuators where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByUuid_C(String uuid, long companyId, int start,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if (!Validator.equals(uuid, actuator.getUuid()) ||
                        (companyId != actuator.getCompanyId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByUuid_C_PrevAndNext(long actuatorId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, actuator, uuid,
                    companyId, orderByComparator, true);

            array[1] = actuator;

            array[2] = getByUuid_C_PrevAndNext(session, actuator, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByUuid_C_PrevAndNext(Session session,
        Actuator actuator, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Actuator actuator : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the actuators where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByCompanyId(long companyId, int start, int end,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((companyId != actuator.getCompanyId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByCompanyId_First(companyId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByCompanyId_Last(companyId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByCompanyId_PrevAndNext(long actuatorId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, actuator, companyId,
                    orderByComparator, true);

            array[1] = actuator;

            array[2] = getByCompanyId_PrevAndNext(session, actuator, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByCompanyId_PrevAndNext(Session session,
        Actuator actuator, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (Actuator actuator : findByCompanyId(companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByGroupId(long groupId, int start, int end,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((groupId != actuator.getGroupId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByGroupId_First(groupId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByGroupId_Last(groupId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where groupId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByGroupId_PrevAndNext(long actuatorId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, actuator, groupId,
                    orderByComparator, true);

            array[1] = actuator;

            array[2] = getByGroupId_PrevAndNext(session, actuator, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByGroupId_PrevAndNext(Session session,
        Actuator actuator, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Actuator actuator : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G(long companyId, long groupId, int start,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((companyId != actuator.getCompanyId()) ||
                        (groupId != actuator.getGroupId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByC_G_First(companyId, groupId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByC_G(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByC_G_Last(companyId, groupId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByC_G_PrevAndNext(long actuatorId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByC_G_PrevAndNext(session, actuator, companyId,
                    groupId, orderByComparator, true);

            array[1] = actuator;

            array[2] = getByC_G_PrevAndNext(session, actuator, companyId,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByC_G_PrevAndNext(Session session, Actuator actuator,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (Actuator actuator : findByC_G(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        return findByC_G_S(companyId, groupId, status, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G_S(long companyId, long groupId, int status,
        int start, int end) throws SystemException {
        return findByC_G_S(companyId, groupId, status, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByC_G_S(long companyId, long groupId, int status,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((companyId != actuator.getCompanyId()) ||
                        (groupId != actuator.getGroupId()) ||
                        (status != actuator.getStatus())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_S_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByC_G_S_First(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByC_G_S_First(companyId, groupId, status,
                orderByComparator);

        if (actuator != null) {
            return actuator;
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

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_S_First(long companyId, long groupId,
        int status, OrderByComparator orderByComparator)
        throws SystemException {
        List<Actuator> list = findByC_G_S(companyId, groupId, status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByC_G_S_Last(companyId, groupId, status,
                orderByComparator);

        if (actuator != null) {
            return actuator;
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

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_S_Last(long companyId, long groupId, int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G_S(companyId, groupId, status);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByC_G_S(companyId, groupId, status,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByC_G_S_PrevAndNext(long actuatorId, long companyId,
        long groupId, int status, OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByC_G_S_PrevAndNext(session, actuator, companyId,
                    groupId, status, orderByComparator, true);

            array[1] = actuator;

            array[2] = getByC_G_S_PrevAndNext(session, actuator, companyId,
                    groupId, status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByC_G_S_PrevAndNext(Session session,
        Actuator actuator, long companyId, long groupId, int status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G_S(long companyId, long groupId, int status)
        throws SystemException {
        for (Actuator actuator : findByC_G_S(companyId, groupId, status,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where companyId = &#63; and groupId = &#63; and status = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param status the status
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByThingId(long thingId) throws SystemException {
        return findByThingId(thingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where thingId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingId the thing ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByThingId(long thingId, int start, int end)
        throws SystemException {
        return findByThingId(thingId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where thingId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param thingId the thing ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByThingId(long thingId, int start, int end,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((thingId != actuator.getThingId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_THINGID_THINGID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(thingId);

                if (!pagination) {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByThingId_First(long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByThingId_First(thingId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingId=");
        msg.append(thingId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByThingId_First(long thingId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByThingId(thingId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByThingId_Last(long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByThingId_Last(thingId, orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("thingId=");
        msg.append(thingId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByThingId_Last(long thingId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByThingId(thingId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByThingId(thingId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where thingId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param thingId the thing ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByThingId_PrevAndNext(long actuatorId, long thingId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByThingId_PrevAndNext(session, actuator, thingId,
                    orderByComparator, true);

            array[1] = actuator;

            array[2] = getByThingId_PrevAndNext(session, actuator, thingId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByThingId_PrevAndNext(Session session,
        Actuator actuator, long thingId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(thingId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where thingId = &#63; from the database.
     *
     * @param thingId the thing ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByThingId(long thingId) throws SystemException {
        for (Actuator actuator : findByThingId(thingId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where thingId = &#63;.
     *
     * @param thingId the thing ID
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns all the actuators where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @return the matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByActuatorTypeId(long actuatorTypeId)
        throws SystemException {
        return findByActuatorTypeId(actuatorTypeId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators where actuatorTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param actuatorTypeId the actuator type ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByActuatorTypeId(long actuatorTypeId, int start,
        int end) throws SystemException {
        return findByActuatorTypeId(actuatorTypeId, start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators where actuatorTypeId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param actuatorTypeId the actuator type ID
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findByActuatorTypeId(long actuatorTypeId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTUATORTYPEID;
            finderArgs = new Object[] { actuatorTypeId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTUATORTYPEID;
            finderArgs = new Object[] {
                    actuatorTypeId,
                    
                    start, end, orderByComparator
                };
        }

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Actuator actuator : list) {
                if ((actuatorTypeId != actuator.getActuatorTypeId())) {
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

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_ACTUATORTYPEID_ACTUATORTYPEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ActuatorModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(actuatorTypeId);

                if (!pagination) {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByActuatorTypeId_First(long actuatorTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByActuatorTypeId_First(actuatorTypeId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("actuatorTypeId=");
        msg.append(actuatorTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the first actuator in the ordered set where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByActuatorTypeId_First(long actuatorTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Actuator> list = findByActuatorTypeId(actuatorTypeId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByActuatorTypeId_Last(long actuatorTypeId,
        OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByActuatorTypeId_Last(actuatorTypeId,
                orderByComparator);

        if (actuator != null) {
            return actuator;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("actuatorTypeId=");
        msg.append(actuatorTypeId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchActuatorException(msg.toString());
    }

    /**
     * Returns the last actuator in the ordered set where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByActuatorTypeId_Last(long actuatorTypeId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActuatorTypeId(actuatorTypeId);

        if (count == 0) {
            return null;
        }

        List<Actuator> list = findByActuatorTypeId(actuatorTypeId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the actuators before and after the current actuator in the ordered set where actuatorTypeId = &#63;.
     *
     * @param actuatorId the primary key of the current actuator
     * @param actuatorTypeId the actuator type ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator[] findByActuatorTypeId_PrevAndNext(long actuatorId,
        long actuatorTypeId, OrderByComparator orderByComparator)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByPrimaryKey(actuatorId);

        Session session = null;

        try {
            session = openSession();

            Actuator[] array = new ActuatorImpl[3];

            array[0] = getByActuatorTypeId_PrevAndNext(session, actuator,
                    actuatorTypeId, orderByComparator, true);

            array[1] = actuator;

            array[2] = getByActuatorTypeId_PrevAndNext(session, actuator,
                    actuatorTypeId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Actuator getByActuatorTypeId_PrevAndNext(Session session,
        Actuator actuator, long actuatorTypeId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACTUATOR_WHERE);

        query.append(_FINDER_COLUMN_ACTUATORTYPEID_ACTUATORTYPEID_2);

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
            query.append(ActuatorModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(actuatorTypeId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(actuator);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Actuator> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the actuators where actuatorTypeId = &#63; from the database.
     *
     * @param actuatorTypeId the actuator type ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByActuatorTypeId(long actuatorTypeId)
        throws SystemException {
        for (Actuator actuator : findByActuatorTypeId(actuatorTypeId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators where actuatorTypeId = &#63;.
     *
     * @param actuatorTypeId the actuator type ID
     * @return the number of matching actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByActuatorTypeId(long actuatorTypeId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTUATORTYPEID;

        Object[] finderArgs = new Object[] { actuatorTypeId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

            query.append(_FINDER_COLUMN_ACTUATORTYPEID_ACTUATORTYPEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(actuatorTypeId);

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
     * Returns the actuator where endpoint = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
     *
     * @param endpoint the endpoint
     * @return the matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByEndpoint(String endpoint)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByEndpoint(endpoint);

        if (actuator == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("endpoint=");
            msg.append(endpoint);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchActuatorException(msg.toString());
        }

        return actuator;
    }

    /**
     * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param endpoint the endpoint
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByEndpoint(String endpoint) throws SystemException {
        return fetchByEndpoint(endpoint, true);
    }

    /**
     * Returns the actuator where endpoint = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param endpoint the endpoint
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByEndpoint(String endpoint, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { endpoint };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                    finderArgs, this);
        }

        if (result instanceof Actuator) {
            Actuator actuator = (Actuator) result;

            if (!Validator.equals(endpoint, actuator.getEndpoint())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

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

                List<Actuator> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                        finderArgs, list);
                } else {
                    Actuator actuator = list.get(0);

                    result = actuator;

                    cacheResult(actuator);

                    if ((actuator.getEndpoint() == null) ||
                            !actuator.getEndpoint().equals(endpoint)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
                            finderArgs, actuator);
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
            return (Actuator) result;
        }
    }

    /**
     * Removes the actuator where endpoint = &#63; from the database.
     *
     * @param endpoint the endpoint
     * @return the actuator that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator removeByEndpoint(String endpoint)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByEndpoint(endpoint);

        return remove(actuator);
    }

    /**
     * Returns the number of actuators where endpoint = &#63;.
     *
     * @param endpoint the endpoint
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the matching actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByC_G_E_EN(companyId, groupId, endpoint,
                enabled);

        if (actuator == null) {
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

            throw new NoSuchActuatorException(msg.toString());
        }

        return actuator;
    }

    /**
     * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled) throws SystemException {
        return fetchByC_G_E_EN(companyId, groupId, endpoint, enabled, true);
    }

    /**
     * Returns the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching actuator, or <code>null</code> if a matching actuator could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, groupId, endpoint, enabled };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                    finderArgs, this);
        }

        if (result instanceof Actuator) {
            Actuator actuator = (Actuator) result;

            if ((companyId != actuator.getCompanyId()) ||
                    (groupId != actuator.getGroupId()) ||
                    !Validator.equals(endpoint, actuator.getEndpoint()) ||
                    (enabled != actuator.getEnabled())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_SELECT_ACTUATOR_WHERE);

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

                List<Actuator> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                        finderArgs, list);
                } else {
                    Actuator actuator = list.get(0);

                    result = actuator;

                    cacheResult(actuator);

                    if ((actuator.getCompanyId() != companyId) ||
                            (actuator.getGroupId() != groupId) ||
                            (actuator.getEndpoint() == null) ||
                            !actuator.getEndpoint().equals(endpoint) ||
                            (actuator.getEnabled() != enabled)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
                            finderArgs, actuator);
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
            return (Actuator) result;
        }
    }

    /**
     * Removes the actuator where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the actuator that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator removeByC_G_E_EN(long companyId, long groupId,
        String endpoint, boolean enabled)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = findByC_G_E_EN(companyId, groupId, endpoint, enabled);

        return remove(actuator);
    }

    /**
     * Returns the number of actuators where companyId = &#63; and groupId = &#63; and endpoint = &#63; and enabled = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param endpoint the endpoint
     * @param enabled the enabled
     * @return the number of matching actuators
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

            query.append(_SQL_COUNT_ACTUATOR_WHERE);

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
     * Caches the actuator in the entity cache if it is enabled.
     *
     * @param actuator the actuator
     */
    @Override
    public void cacheResult(Actuator actuator) {
        EntityCacheUtil.putResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorImpl.class, actuator.getPrimaryKey(), actuator);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { actuator.getUuid(), actuator.getGroupId() }, actuator);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT,
            new Object[] { actuator.getEndpoint() }, actuator);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN,
            new Object[] {
                actuator.getCompanyId(), actuator.getGroupId(),
                actuator.getEndpoint(), actuator.getEnabled()
            }, actuator);

        actuator.resetOriginalValues();
    }

    /**
     * Caches the actuators in the entity cache if it is enabled.
     *
     * @param actuators the actuators
     */
    @Override
    public void cacheResult(List<Actuator> actuators) {
        for (Actuator actuator : actuators) {
            if (EntityCacheUtil.getResult(
                        ActuatorModelImpl.ENTITY_CACHE_ENABLED,
                        ActuatorImpl.class, actuator.getPrimaryKey()) == null) {
                cacheResult(actuator);
            } else {
                actuator.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all actuators.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ActuatorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ActuatorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the actuator.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Actuator actuator) {
        EntityCacheUtil.removeResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorImpl.class, actuator.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(actuator);
    }

    @Override
    public void clearCache(List<Actuator> actuators) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Actuator actuator : actuators) {
            EntityCacheUtil.removeResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
                ActuatorImpl.class, actuator.getPrimaryKey());

            clearUniqueFindersCache(actuator);
        }
    }

    protected void cacheUniqueFindersCache(Actuator actuator) {
        if (actuator.isNew()) {
            Object[] args = new Object[] {
                    actuator.getUuid(), actuator.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                actuator);

            args = new Object[] { actuator.getEndpoint() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENDPOINT, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT, args,
                actuator);

            args = new Object[] {
                    actuator.getCompanyId(), actuator.getGroupId(),
                    actuator.getEndpoint(), actuator.getEnabled()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args,
                actuator);
        } else {
            ActuatorModelImpl actuatorModelImpl = (ActuatorModelImpl) actuator;

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuator.getUuid(), actuator.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    actuator);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ENDPOINT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { actuator.getEndpoint() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENDPOINT, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENDPOINT, args,
                    actuator);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_C_G_E_EN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuator.getCompanyId(), actuator.getGroupId(),
                        actuator.getEndpoint(), actuator.getEnabled()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args,
                    actuator);
            }
        }
    }

    protected void clearUniqueFindersCache(Actuator actuator) {
        ActuatorModelImpl actuatorModelImpl = (ActuatorModelImpl) actuator;

        Object[] args = new Object[] { actuator.getUuid(), actuator.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((actuatorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    actuatorModelImpl.getOriginalUuid(),
                    actuatorModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }

        args = new Object[] { actuator.getEndpoint() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINT, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENDPOINT, args);

        if ((actuatorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ENDPOINT.getColumnBitmask()) != 0) {
            args = new Object[] { actuatorModelImpl.getOriginalEndpoint() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINT, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENDPOINT, args);
        }

        args = new Object[] {
                actuator.getCompanyId(), actuator.getGroupId(),
                actuator.getEndpoint(), actuator.getEnabled()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args);

        if ((actuatorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_C_G_E_EN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    actuatorModelImpl.getOriginalCompanyId(),
                    actuatorModelImpl.getOriginalGroupId(),
                    actuatorModelImpl.getOriginalEndpoint(),
                    actuatorModelImpl.getOriginalEnabled()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_E_EN, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_E_EN, args);
        }
    }

    /**
     * Creates a new actuator with the primary key. Does not add the actuator to the database.
     *
     * @param actuatorId the primary key for the new actuator
     * @return the new actuator
     */
    @Override
    public Actuator create(long actuatorId) {
        Actuator actuator = new ActuatorImpl();

        actuator.setNew(true);
        actuator.setPrimaryKey(actuatorId);

        String uuid = PortalUUIDUtil.generate();

        actuator.setUuid(uuid);

        return actuator;
    }

    /**
     * Removes the actuator with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param actuatorId the primary key of the actuator
     * @return the actuator that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator remove(long actuatorId)
        throws NoSuchActuatorException, SystemException {
        return remove((Serializable) actuatorId);
    }

    /**
     * Removes the actuator with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the actuator
     * @return the actuator that was removed
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator remove(Serializable primaryKey)
        throws NoSuchActuatorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Actuator actuator = (Actuator) session.get(ActuatorImpl.class,
                    primaryKey);

            if (actuator == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchActuatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(actuator);
        } catch (NoSuchActuatorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Actuator removeImpl(Actuator actuator) throws SystemException {
        actuator = toUnwrappedModel(actuator);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(actuator)) {
                actuator = (Actuator) session.get(ActuatorImpl.class,
                        actuator.getPrimaryKeyObj());
            }

            if (actuator != null) {
                session.delete(actuator);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (actuator != null) {
            clearCache(actuator);
        }

        return actuator;
    }

    @Override
    public Actuator updateImpl(
        com.lrexperts.liferay.liferayofthings.model.Actuator actuator)
        throws SystemException {
        actuator = toUnwrappedModel(actuator);

        boolean isNew = actuator.isNew();

        ActuatorModelImpl actuatorModelImpl = (ActuatorModelImpl) actuator;

        if (Validator.isNull(actuator.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            actuator.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (actuator.isNew()) {
                session.save(actuator);

                actuator.setNew(false);
            } else {
                session.merge(actuator);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ActuatorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { actuatorModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { actuatorModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalUuid(),
                        actuatorModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        actuatorModelImpl.getUuid(),
                        actuatorModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { actuatorModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { actuatorModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalCompanyId(),
                        actuatorModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        actuatorModelImpl.getCompanyId(),
                        actuatorModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalCompanyId(),
                        actuatorModelImpl.getOriginalGroupId(),
                        actuatorModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);

                args = new Object[] {
                        actuatorModelImpl.getCompanyId(),
                        actuatorModelImpl.getGroupId(),
                        actuatorModelImpl.getStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_S,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalThingId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID,
                    args);

                args = new Object[] { actuatorModelImpl.getThingId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THINGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THINGID,
                    args);
            }

            if ((actuatorModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTUATORTYPEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        actuatorModelImpl.getOriginalActuatorTypeId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTUATORTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTUATORTYPEID,
                    args);

                args = new Object[] { actuatorModelImpl.getActuatorTypeId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTUATORTYPEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTUATORTYPEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
            ActuatorImpl.class, actuator.getPrimaryKey(), actuator);

        clearUniqueFindersCache(actuator);
        cacheUniqueFindersCache(actuator);

        return actuator;
    }

    protected Actuator toUnwrappedModel(Actuator actuator) {
        if (actuator instanceof ActuatorImpl) {
            return actuator;
        }

        ActuatorImpl actuatorImpl = new ActuatorImpl();

        actuatorImpl.setNew(actuator.isNew());
        actuatorImpl.setPrimaryKey(actuator.getPrimaryKey());

        actuatorImpl.setUuid(actuator.getUuid());
        actuatorImpl.setActuatorId(actuator.getActuatorId());
        actuatorImpl.setCompanyId(actuator.getCompanyId());
        actuatorImpl.setGroupId(actuator.getGroupId());
        actuatorImpl.setThingId(actuator.getThingId());
        actuatorImpl.setActuatorTypeId(actuator.getActuatorTypeId());
        actuatorImpl.setUserId(actuator.getUserId());
        actuatorImpl.setUserName(actuator.getUserName());
        actuatorImpl.setCreateDate(actuator.getCreateDate());
        actuatorImpl.setModifiedDate(actuator.getModifiedDate());
        actuatorImpl.setName(actuator.getName());
        actuatorImpl.setDescription(actuator.getDescription());
        actuatorImpl.setEndpoint(actuator.getEndpoint());
        actuatorImpl.setEnabled(actuator.isEnabled());
        actuatorImpl.setStatus(actuator.getStatus());

        return actuatorImpl;
    }

    /**
     * Returns the actuator with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the actuator
     * @return the actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByPrimaryKey(Serializable primaryKey)
        throws NoSuchActuatorException, SystemException {
        Actuator actuator = fetchByPrimaryKey(primaryKey);

        if (actuator == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchActuatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return actuator;
    }

    /**
     * Returns the actuator with the primary key or throws a {@link com.lrexperts.liferay.liferayofthings.NoSuchActuatorException} if it could not be found.
     *
     * @param actuatorId the primary key of the actuator
     * @return the actuator
     * @throws com.lrexperts.liferay.liferayofthings.NoSuchActuatorException if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator findByPrimaryKey(long actuatorId)
        throws NoSuchActuatorException, SystemException {
        return findByPrimaryKey((Serializable) actuatorId);
    }

    /**
     * Returns the actuator with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the actuator
     * @return the actuator, or <code>null</code> if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Actuator actuator = (Actuator) EntityCacheUtil.getResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
                ActuatorImpl.class, primaryKey);

        if (actuator == _nullActuator) {
            return null;
        }

        if (actuator == null) {
            Session session = null;

            try {
                session = openSession();

                actuator = (Actuator) session.get(ActuatorImpl.class, primaryKey);

                if (actuator != null) {
                    cacheResult(actuator);
                } else {
                    EntityCacheUtil.putResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
                        ActuatorImpl.class, primaryKey, _nullActuator);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ActuatorModelImpl.ENTITY_CACHE_ENABLED,
                    ActuatorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return actuator;
    }

    /**
     * Returns the actuator with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param actuatorId the primary key of the actuator
     * @return the actuator, or <code>null</code> if a actuator with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Actuator fetchByPrimaryKey(long actuatorId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) actuatorId);
    }

    /**
     * Returns all the actuators.
     *
     * @return the actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the actuators.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @return the range of actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the actuators.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lrexperts.liferay.liferayofthings.model.impl.ActuatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of actuators
     * @param end the upper bound of the range of actuators (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of actuators
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Actuator> findAll(int start, int end,
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

        List<Actuator> list = (List<Actuator>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACTUATOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACTUATOR;

                if (pagination) {
                    sql = sql.concat(ActuatorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Actuator>(list);
                } else {
                    list = (List<Actuator>) QueryUtil.list(q, getDialect(),
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
     * Removes all the actuators from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Actuator actuator : findAll()) {
            remove(actuator);
        }
    }

    /**
     * Returns the number of actuators.
     *
     * @return the number of actuators
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

                Query q = session.createQuery(_SQL_COUNT_ACTUATOR);

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
     * Initializes the actuator persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.lrexperts.liferay.liferayofthings.model.Actuator")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Actuator>> listenersList = new ArrayList<ModelListener<Actuator>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Actuator>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ActuatorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
