package home.pdm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * GenericDAO implements CRUD(create, read, update, delete) methods
 * and other method that can handle in common way for all entities.
 *
 * @param <T>  class of entity(object that need to be persist).
 * @param <PK> Primary key of entity. Usually positive Long or Integer, auto increment.
 */

public class CrudDao<T, PK extends Serializable> implements ICrudDao<T, PK> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Class<T> type;

    @SuppressWarnings("unchecked")
    public CrudDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Creates a new instance in database.
     *
     * @param newInstance an instance of unsaved object
     * @return PK primary key from created in database object
     */
    @SuppressWarnings("unchecked")
    public PK save(T newInstance) {
        return (PK) currentSession().save(newInstance);
    }

    /**
     * Reads an instance of T from database.
     *
     * @param id primary key
     * @return T an instance of T, that have been read from database
     */
    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T) currentSession().get(type, id);
    }

    /**
     * Updates an instance of T in database. Object must be previously saved in database.
     *
     * @param transientObject Update table instance of T.
     */
    public void update(T transientObject) {
        currentSession().update(transientObject);
    }

    /**
     * Delete previously saved object from database.
     *
     * @param persistentObject persistent object that will be deleted from database.
     */
    public void delete(T persistentObject) {
        currentSession().delete(persistentObject);
    }

    /**
     * Read all instances of T from database
     *
     * @return List<T> List of T.
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) currentSession().createQuery(
                "FROM " + type.getSimpleName()).list();
    }

}