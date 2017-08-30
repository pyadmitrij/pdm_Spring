package home.pdm.dao;

import home.pdm.model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderDAO implements CrudDAO<Order> {

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
        logger.info("Order successfully saved. Order details: " + order.toString());
    }

    @Override
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Order> result = session.createQuery("select o from Order o").list();
        for (Order order : result) {
            logger.info("Orders list: " + order.toString());
        }
        return result;
    }

    @Override
    public void update(Order order) {
        sessionFactory.getCurrentSession().update(order);
        logger.info("Order successfully update. Order details: " + order.toString());
    }

    @Override
    public void remove(Order order) {
        sessionFactory.getCurrentSession().delete(order);
        logger.info("Order successfully removed. Order details: " + order.toString());
    }

    @Override
    public Order findById(int id) {
        Order result = sessionFactory.getCurrentSession().load(Order.class, id);
        if (result == null)
            throw new RuntimeException("Cannot find Order by ID: " + id);
        logger.info("Order successfully loaded. Order id: " + id);
        return result;
    }

    @Override
    public Order findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Order o where o.name like :name");
        query.setParameter("name", name);
        logger.info("Order successfully loaded. Order name: " + name);
        return (Order) query.uniqueResult();
    }
}
