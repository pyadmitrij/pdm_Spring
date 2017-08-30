package home.pdm.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "COOK")
public class Cook  extends User {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "prepared_dish")
    @Fetch(FetchMode.SELECT)
    private List<PreparedDish> cokedDish;

    public List<PreparedDish> getCokedDish() {
        return cokedDish;
    }

    public void setCokedDish(List<PreparedDish> cokedDish) {
        this.cokedDish = cokedDish;
    }
}
