package com.talosdigital.safebuy.persistence.util;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface PersistenceService {

	@Transactional
	<T> T save(T entity);

	@Transactional
	<T> T update(T entity);

	@Transactional
	<T> void remove(T entity);

	<T> T findById(Class<T> entityClass, int id);

	/**
	 * The annotation @Transactional create the factory, initialize the entity
	 * manager, then initialize the transaction, do the persist, and in the end 
	 * close the connection with the database.
	 * @param resultClass
	 * @param query
	 * @param parameters
	 * @return List with all the results.
	 */
	@Transactional
	<T> List<T> executeQuery(Class<T> resultClass, String query,
			String... parameters);

}
