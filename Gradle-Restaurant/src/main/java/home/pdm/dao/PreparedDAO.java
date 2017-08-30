package home.pdm.dao;

import home.pdm.model.PreparedDish;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PreparedDAO implements CrudDAO<PreparedDish> {

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(PreparedDish prepared) {
        sessionFactory.getCurrentSession().save(prepared);
        logger.info("Prepared successfully saved. Prepared details: " + prepared.toString());
    }

    @Override
    public List<PreparedDish> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<PreparedDish> result = session.createQuery("select p from PreparedDish p").list();
        for (PreparedDish prepared : result) {
            logger.info("PreparedDish list: " + prepared.toString());
        }
        return result;
    }

    @Override
    public void update(PreparedDish prepared) {
        sessionFactory.getCurrentSession().update(prepared);
        logger.info("PreparedDish successfully update. PreparedDish details: " + prepared.toString());
    }

    @Override
    public void remove(PreparedDish prepared) {
        sessionFactory.getCurrentSession().delete(prepared);
        logger.info("Prepared successfully removed. Prepared details: " + prepared.toString());
    }

    @Override
    public PreparedDish findById(int id) {
        PreparedDish result = sessionFactory.getCurrentSession().load(PreparedDish.class, id);
        if (result == null)
            throw new RuntimeException("Cannot find PreparedDish by ID: " + id);
        logger.info("Order successfully loaded. PreparedDish id: " + id);
        return result;
    }

    @Override
    public PreparedDish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from PreparedDish p where p.name like :name");
        query.setParameter("name", name);
        logger.info("PreparedDish successfully loaded. PreparedDish name: " + name);
        return (PreparedDish) query.uniqueResult();
    }
}
