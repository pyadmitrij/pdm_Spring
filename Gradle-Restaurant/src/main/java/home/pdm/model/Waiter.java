package home.pdm.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "WAITER")
public class Waiter extends User {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @Fetch(FetchMode.SELECT)
    private List<Order> orders;

    public List<Order> getOrder() {
        return orders;
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }

}