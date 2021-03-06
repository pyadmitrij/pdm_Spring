package com.intita.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> 
{
	PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
    List<T> readAll();
    
    List<T> readWithRequest(String request);
    
    int count();
}
