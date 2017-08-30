package home.pdm.dao;

import home.pdm.model.User;

import java.util.List;

public interface CrudDAO<T> {

    void save(T t);

    List<T> findAll();

    void update(T t);

    void remove(T t);

    T findById(int id);

    T findByName(String name);
}
