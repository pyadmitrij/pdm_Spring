package home.pdm.dao;

import home.pdm.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IngredientDAO implements CrudDAO<Ingredient>{

    private static final Logger logger = LoggerFactory.getLogger(Ingredient.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
        logger.info("User successfully saved. User details: " + ingredient.toString());
    }

    @Override
    public List<Ingredient> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Ingredient> result = session.createQuery("select i from Ingredient i").list();
        for(Ingredient i : result)
            logger.info("Ingredient list: " + result.toString());
        return result;
    }

    @Override
    public void update(Ingredient ingredient) {
        sessionFactory.getCurrentSession().update(ingredient);
        logger.info("Ingredient successfully update. Ingredient details: " + ingredient.toString());
    }

    @Override
    public void remove(Ingredient ingredient) {
        sessionFactory.getCurrentSession().delete(ingredient);
        logger.info("Ingredient successfully remove. Ingredient details: " + ingredient.toString());
    }

    @Override
    public Ingredient findById(int id) {
        Ingredient result = sessionFactory.getCurrentSession().load(Ingredient.class, id);
        if(result == null)
            throw new RuntimeException("Cannot find Ingredient by ID: " + id);
        logger.info("Ingredient successfully loaded. Ingredient id: " + id);
        return result;
    }

    @Override
    public Ingredient findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", name);
        logger.info("Ingredient successfully loaded. Ingredient name: " + name);
        return (Ingredient) query.uniqueResult();
    }
}
