package com.lrexperts.liferay.portlet.core.dao.hibernate;

import com.lrexperts.liferay.portlet.core.dao.GenericDAO;
import com.lrexperts.liferay.portlet.core.model.Model;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * The Class GenericDAOImpl.
 *
 * @param <T> the generic type
 * @author Diego A. Palmeira
 */
public class GenericDAOImpl<T extends Model> extends HibernateDaoSupport
		implements GenericDAO<T> {

	/** The Constant log. */
	private static final Log log = LogFactory.getLog(GenericDAOImpl.class);
	
	/** The persistent class. */
	private Class<T> persistentClass;

	/**
	 * Instantiates a new generic dao impl.
	 *
	 * @param persistentClass the persistent class
	 */
	public GenericDAOImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public List<T> getAll() throws DataAccessException {
		return super.getHibernateTemplate().loadAll(this.persistentClass);
	}

	@Override
	public T get(long identifier) throws DataAccessException {
		T entity = super.getHibernateTemplate().get(this.persistentClass, identifier);

		if (entity == null) {
			log.warn("Uh oh, '" + this.persistentClass + "' object with id '"
					+ identifier + "' not found...");
			throw new ObjectRetrievalFailureException(this.persistentClass, identifier);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(DetachedCriteria criteria) throws DataAccessException {
		return (List<T>) super.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> getAll(int firstResult, int maxResults)
			throws DataAccessException {
		return getAll(DetachedCriteria.forClass(persistentClass), firstResult,
				maxResults, null);
	}

	@Override
	public List<T> getAll(int firstResult, int maxResults, Order order)
			throws DataAccessException {
		return getAll(DetachedCriteria.forClass(persistentClass), firstResult,
				maxResults, order);
	}

	/**
	 * Gets all by criteria.
	 *
	 * @param criteria the criteria
	 * @param firstResult the first result
	 * @param maxResults the max results
	 * @param order the order
	 * @return the all
	 * @throws DataAccessException the data access exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll(DetachedCriteria criteria, int firstResult,
			int maxResults, Order order) throws DataAccessException {
		if (Validator.isNotNull(order))
			criteria.addOrder(order);
		return (List<T>) super.getHibernateTemplate().findByCriteria(criteria,
				firstResult, maxResults);
	}

	@Override
	public List<T> getAllByField(String key, Object value)
			throws DataAccessException {
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put(key, value);
		DetachedCriteria criteria = addFiltersToCriteria(filters);
		return getAll(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByField(String key, Object value, int start, int end)
			throws DataAccessException {
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put(key, value);
		DetachedCriteria criteria = addFiltersToCriteria(filters);
		return (List<T>) super.getHibernateTemplate()
				.findByCriteria(criteria, start, end);
	}

	@Override
	public List<T> getAllByFieldByOrder(String key, Object value,
			String propertyName, boolean ascending) throws DataAccessException {

		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put(key, value);
		DetachedCriteria criteria = addFiltersToCriteria(filters);
		Order order = ascending ? Order.asc(propertyName) : Order
				.desc(propertyName);
		criteria.addOrder(order);
		return getAll(criteria);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void store(T entity) throws DataAccessException {
		if (entity.getIdentifier() == null) {
			Long generated = (Long) getHibernateTemplate().save(entity);
			log.debug(entity.getClass());
			entity = (T) getHibernateTemplate().get(entity.getClass(),
					generated);
		} else {
			getHibernateTemplate().update(entity);
		}
	}

	@Override
	public void storeAll(Collection<T> entities) throws DataAccessException {
		for (Iterator<T> it = entities.iterator(); it.hasNext();) {
			super.getHibernateTemplate().saveOrUpdate(it.next());
        }
	}

	@Override
	public void remove(T entity) {
		super.getHibernateTemplate().delete(entity);
	}

	@Override
	public void remove(Long identifier) throws DataAccessException {
		super.getHibernateTemplate().delete(this.get(identifier));
	}

	@Override
	public void removeAll(Collection<T> entities) throws DataAccessException {
		super.getHibernateTemplate().deleteAll(entities);
	}

	@Override
	public int count() {
		return this.getAll().size();
	}

	@Override
	public boolean exists(Long identifier) throws DataAccessException {
		T entity = super.getHibernateTemplate().get(this.persistentClass, identifier);
		if (entity == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Adds filters to criteria.
	 *
	 * @param filters the filters
	 * @return the detached criteria
	 */
	private DetachedCriteria addFiltersToCriteria(Map<String, Object> filters) {
		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		addCriteriaFromFilters(filters, criteria);
		return criteria;
	}

	/**
	 * Adds the criteria from filters.
	 *
	 * @param filters the filters
	 * @param criteria the criteria
	 */
	private void addCriteriaFromFilters(Map<String, Object> filters,
			DetachedCriteria criteria) {
		if (Validator.isNotNull(filters)) {
			Set<String> propertyNames = filters.keySet();
			for (String propertyName : propertyNames)
				criteria.add(Restrictions.eq(propertyName,
						filters.get(propertyName)));
		}
	}

}
