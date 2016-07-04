package home.pdm.dao;

import java.io.Serializable;
import java.util.List;

public interface ICrudDao<T, PK extends Serializable> {

    PK save(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> getAll();

}