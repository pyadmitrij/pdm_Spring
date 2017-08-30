package home.pdm.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "DISH_INGREDIENT")
public class DishIngredient {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISH_ID")
    private Dish dishId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Ingredient getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Ingredient ingredientId) {
        this.ingredientId = ingredientId;
    }
}
