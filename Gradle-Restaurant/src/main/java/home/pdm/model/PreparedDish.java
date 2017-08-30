package home.pdm.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PREPARED_DISH")
public class PreparedDish {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User userID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISH_ID")
    private Dish dishID;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order orderID;

    @Column(name = "DATA_DISH")
    private Date dateDish;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PREPARED_DISH")
    private Cook prepared;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Dish getDishID() {
        return dishID;
    }

    public void setDishID(Dish dishID) {
        this.dishID = dishID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public Date getDateDish() {
        return dateDish;
    }

    public void setDateDish(Date dateDish) {
        this.dateDish = dateDish;
    }

    public Cook getPrepared() {
        return prepared;
    }

    public void setPrepared(Cook prepared) {
        this.prepared = prepared;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "ID=" + ID +
                ", userID=" + userID.getName() +
                ", dishID=" + dishID.getName() +
                ", orderID=" + orderID +
                ", dateDish=" + dateDish +
                ", prepared=" + prepared +
                '}';
    }
}