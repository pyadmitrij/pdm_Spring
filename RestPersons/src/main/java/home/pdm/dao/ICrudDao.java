package home.pdm.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

public interface ICrudDao<PK extends Serializable, T> {

    PK save(T newInstance);

    T getByKey(PK pk);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> getAll();

    void persist(T entity);

    Criteria createEntityCriteria();

}