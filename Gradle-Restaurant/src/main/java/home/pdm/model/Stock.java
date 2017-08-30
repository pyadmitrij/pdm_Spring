package home.pdm.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(generator ="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int ID;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredientID;

    @Column(name = "WEIGHT")
    private int weight;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Ingredient getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Ingredient ingredientID) {
        this.ingredientID = ingredientID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ID=" + ID +
                ", ingredientID=" + ingredientID.getName() +
                ", weight=" + weight +
                '}';
    }
}
