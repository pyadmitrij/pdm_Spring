package home.pdm.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDER_WAITER")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User waiter;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "DISH_ORDER",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISH_ID"))
    private List<Dish> dishes;

    @Column(name = "TABLE_NUMBER")
    private Integer tableNumber;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "OPEN_CLOSE")
    private int openClose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOpenClose() {
        return openClose;
    }

    public void setOpenClose(int openClose) {
        this.openClose = openClose;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", waiter=" + waiter.getName() +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                ", openClose=" + openClose +
                '}';
    }
}
