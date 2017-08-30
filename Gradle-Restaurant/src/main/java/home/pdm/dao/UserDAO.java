package home.pdm.dao;

import home.pdm.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserDAO implements CrudDAO<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
        logger.info("User successfully saved. User details: " + user.toString());
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> result = session.createQuery("select u from User u").list();
        for (User user : result)
            logger.info("Users list: " + user.toString());
        return result;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
        logger.info("User successfully update. User details: " + user.toString());
    }

    @Override
    public void remove(User user) {
        sessionFactory.getCurrentSession().delete(user);
        logger.info("User successfully removed. User details: " + user.toString());
    }

    @Override
    public User findById(int id) {
        User result = sessionFactory.getCurrentSession().load(User.class, id);
        if (result == null)
            throw new RuntimeException("Cannot find User by ID: " + id);
        logger.info("User successfully loaded. User id: " + id);
        return result;
    }

    @Override
    public User findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from User u where u.name like :name");
        query.setParameter("name", name);
        logger.info("User successfully loaded. User name: " + name);
        return (User) query.uniqueResult();
    }

}
