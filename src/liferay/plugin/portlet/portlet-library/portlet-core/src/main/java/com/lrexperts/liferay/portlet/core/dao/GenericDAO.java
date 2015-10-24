package com.lrexperts.liferay.portlet.core.dao;

import com.lrexperts.liferay.portlet.core.model.Model;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;

/**
 * The Interface GenericDAO.
 *
 * @param <T> the generic type
 * @author Diego A. Palmeira
 */
public interface GenericDAO<T extends Model> {
	
	/**
	 * Get all.
	 *
	 * @return the all
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAll() throws DataAccessException;
	
	/**
	 * Store.
	 *
	 * @param t the t
	 * @throws DataAccessException the data access exception
	 */
	public void store(T t) throws DataAccessException;

	/**
	 * Remove.
	 *
	 * @param t the t
	 * @throws DataAccessException the data access exception
	 */
	void remove(T t) throws DataAccessException;
	
	/**
	 * Remove by identifier.
	 *
	 * @param identifier the identifier
	 * @throws DataAccessException the data access exception
	 */
	public void remove(Long identifier) throws DataAccessException;
	
	/**
	 * Get from identifier.
	 *
	 * @param id the identifier
	 * @return the t
	 * @throws DataAccessException the data access exception
	 */
	public T get(long identifier) throws DataAccessException;
	
	/**
	 * Gets all by criteria.
	 *
	 * @param criteria the criteria
	 * @return the all
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAll(DetachedCriteria criteria) throws DataAccessException;
	
	/**
	 * Gets all by a defined range.
	 *
	 * @param firstResult the first result
	 * @param maxResults the max results
	 * @return the all
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAll(int firstResult, int maxResults)
			throws DataAccessException;
	
	/**
	 * Gets the by a defined range with order.
	 *
	 * @param firstResult the first result
	 * @param maxResults the max results
	 * @param order the order
	 * @return the all
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAll(int firstResult, int maxResults, Order order)
			throws DataAccessException;

	/**
	 * Gets all by field.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the all by field
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAllByField(String key, Object value)
			throws DataAccessException;

	/**
	 * Gets all by key and by field.
	 *
	 * @param key the key
	 * @param value the value
	 * @param start the start
	 * @param end the end
	 * @return the all by field
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAllByField(String key, Object value, int start, int end)
			throws DataAccessException;
	
	/**
	 * Gets all by field and by order.
	 *
	 * @param key the key
	 * @param value the value
	 * @param propertyName the property name
	 * @param ascending the ascending
	 * @return the all by field by order
	 * @throws DataAccessException the data access exception
	 */
	public List<T> getAllByFieldByOrder(String key, Object value,
			String propertyName, boolean ascending) throws DataAccessException;
	
	/**
	 * Count.
	 *
	 * @return the int
	 */
	public int count();
	
	/**
	 * Exists.
	 *
	 * @param id the identifier
	 * @return true, if successful
	 * @throws DataAccessException the data access exception
	 */
	public boolean exists(Long identifier) throws DataAccessException;
	
	/**
	 * Removes all.
	 *
	 * @param entities the entities
	 * @throws DataAccessException the data access exception
	 */
	public void removeAll(Collection<T> entities) throws DataAccessException;
	
	/**
	 * Store all.
	 *
	 * @param entities the entities
	 * @throws DataAccessException the data access exception
	 */
	public void storeAll(Collection<T> entities) throws DataAccessException;
}
