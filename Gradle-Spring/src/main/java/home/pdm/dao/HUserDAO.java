package home.pdm.dao;

import home.pdm.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HUserDAO implements IUserDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User findUserBuId(Long id) {
        User result = sessionFactory.getCurrentSession().load(User.class, id);
        if (result == null)
            throw new RuntimeException("Cannot find User by ID: " + id);
        return result;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u from User u").list(); // select * from User
    }

    @Override
    public User findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from User u where u.name like :name");
        query.setParameter("name", name);
        return (User) query.uniqueResult();
    }

    @Override
    public void remove(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
