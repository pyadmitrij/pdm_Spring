package home.pdm.service;

import home.pdm.dao.IngredientDAO;
import home.pdm.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientService {

    private IngredientDAO ingredientDAO;

    public void setIngredientDAO(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Transactional
    public void saveIngredient(Ingredient ingredient) {
        ingredientDAO.save(ingredient);
    }

    @Transactional
    public List<Ingredient> getIngredient() {
        return ingredientDAO.findAll();
    }

    @Transactional
    public void updateIngredient(Ingredient ingredient) {
        ingredientDAO.update(ingredient);
    }

    @Transactional
    public void removeIngredient(Ingredient ingredient) {
        ingredientDAO.remove(ingredient);
    }

    @Transactional
    public Ingredient getIngredientById(int ingredientId) {
        return ingredientDAO.findById(ingredientId);
    }

    @Transactional
    public Ingredient getIngredientByName(String ingredientName) {
        return ingredientDAO.findByName(ingredientName);
    }
}
