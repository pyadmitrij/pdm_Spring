package home.pdm.dao;

import home.pdm.model.Orders;
import org.hibernate.SessionFactory;

import java.util.List;

public class HOrderDAO implements IOrderDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    @Override
    public List<Orders> findAllOrder() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
