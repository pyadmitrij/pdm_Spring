package home.pdm.dao;

import home.pdm.model.Dish;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DishDAO implements CrudDAO<Dish> {

    private static final Logger logger = LoggerFactory.getLogger(DishDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
        logger.info("Dish successfully saved. Dish details: " + dish.toString());
    }

    @Override
    public List<Dish> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Dish> result = session.createQuery("select d from Dish d").list();
        for (Dish dish : result) {
            logger.info("Dishes list: " + dish.toString());
        }
        return result;
    }

    @Override
    public void update(Dish dish) {
        sessionFactory.getCurrentSession().update(dish);
        logger.info("Dish successfully update. Dish details: " + dish.toString());
    }

    @Override
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
        logger.info("Dish successfully remove. Dish details: " + dish.toString());
    }

    @Override
    public Dish findById(int id) {
        Dish result = sessionFactory.getCurrentSession().load(Dish.class, id);
        if(result == null)
            throw new RuntimeException("Cannot find Dish by ID: " + id);
        logger.info("Dish successfully loaded. Dish id: " + id);
        return result;
    }

    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        logger.info("Dish successfully loaded. Dish name: " + name);
        return (Dish) query.uniqueResult();
    }

}
