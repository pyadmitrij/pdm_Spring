package home.pdm.service;

import home.pdm.dao.DishDAO;
import home.pdm.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishService {

    private DishDAO dishDAO;

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    @Transactional
    public void saveDish(Dish dish) {
        dishDAO.save(dish);
    }

    @Transactional
    public List<Dish> getDishes() {
        return dishDAO.findAll();
    }

    @Transactional
    public void updateDish(Dish dish) {
        dishDAO.update(dish);
    }

    @Transactional
    public void removeDish(Dish dish) {
        dishDAO.remove(dish);
    }

    @Transactional
    public Dish getDishById(int dishId) {
        return dishDAO.findById(dishId);
    }

    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDAO.findByName(dishName);
    }

}
