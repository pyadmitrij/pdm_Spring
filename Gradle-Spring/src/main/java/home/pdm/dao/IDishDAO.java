package home.pdm.dao;

import home.pdm.model.Dish;

import java.util.List;

public interface IDishDAO {

    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);

}
