package home.pdm.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DISH")
public class Dish {

    @Id()
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private MenuCategory category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "INGREDIENT_DISH",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private List<Ingredient> ingredientID;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "WEIGHT")
    private Integer weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public List<Ingredient> getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(List<Ingredient> ingredientID) {
        this.ingredientID = ingredientID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", ingredientID=" + ingredientID +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
