package com.intita.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * GenericDaoImpl implements CRUD(create read update delete) methods 
 * and other method that can handle in common way for all entities.  
 * @author Zhuk Maxim
 *
 * @param <T>	class of entity(object that need to be persist).
 * @param <PK>	Primary key of entity. Usually positive Long or Integer, auto increment.  
 */
public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<T> type;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	/**
	 * Creates a new instance in database.
	 * @param newInstance	an instance of unsaved object
	 * @return PK primary key from created in database object   
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PK create(T newInstance) {
		return (PK) currentSession().save(newInstance);
	}

	/**
	 * Reads an instance of T from database.
	 * @param id primary key
	 * @return T an instance of T, that have been read from database
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T read(PK id) {
		return (T) currentSession().get(type, id);
	}
	
	/**
	 * Read all instances of T from database
	 * @return List<T> List of T.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> readAll() {
		return (List<T>) currentSession().createQuery(
				"FROM " + type.getSimpleName()).list();
	}
	
	/**
	 * Read all instances that match to request string.
	 * @param request End of request string. Must begins with where...
	 * @return List<T> List of T.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> readWithRequest(String request) {
		return (List<T>) currentSession().createQuery(
				"FROM " + type.getSimpleName()+request).list();
	}

	/**
	 * Updates an instance of T in database. Object must be previously saved in database.
	 * @param transientObject Updateable instance of T.
	 */
	@Override
	public void update(T transientObject) {
		currentSession().update(transientObject);
	}

	/**Delete previously saved object from database.
	 * @param persistentObject persistent object that will be deleted from database.
	 */
	@Override
	public void delete(T persistentObject) {
		currentSession().delete(persistentObject);
	}

	/**
	 * Returns current session.
	 * @return Session current session.
	 * @see	Session
	 */
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Returns session factory.
	 * @return	session factory.
	 * @see SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * Counts number of instances in database.
	 * @return number of instances in database.
	 */
	@Override
	public int count() {
		String queryStr = "SELECT count(*) FROM " + type.getSimpleName();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				queryStr);
		return ((Long) query.uniqueResult()).intValue();
	}
}
