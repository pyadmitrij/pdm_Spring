package com.home.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface GenericDaoI<T, PK extends Serializable>
{
	PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
    List<T> readAll();
}
