package home.pdm.dao;

import home.pdm.model.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MenuDAO implements CrudDAO<Menu> {

    private static final Logger logger = LoggerFactory.getLogger(MenuDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
        logger.info("Menu successfully saved. Menu details: " + menu.toString());
    }

    @Override
    public List<Menu> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Menu> result = session.createQuery("select m from Menu m").list();
        for (Menu menu : result)
            logger.info("Menu list: " + menu.toString());
        return result;
    }

    @Override
    public void update(Menu menu) {
        sessionFactory.getCurrentSession().update(menu);
        logger.info("Menu successfully update. Menu details: " + menu.toString());
    }

    @Override
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().delete(menu);
        logger.info("Menu successfully removed. Menu details: " + menu.toString());
    }

    @Override
    public Menu findById(int id) {
        Menu result = sessionFactory.getCurrentSession().load(Menu.class, id);
        if (result == null)
            throw new RuntimeException("Cannot find Menu by ID: " + id);
        logger.info("Menu successfully loaded. Menu id: " + id);
        return result;
    }

    @Override
    public Menu findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.name like :name");
        query.setParameter("name", name);
        logger.info("Menu successfully loaded. Menu name: " + name);
        return (Menu) query.uniqueResult();
    }
}
