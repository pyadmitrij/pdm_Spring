package home.pdm.dao;

import home.pdm.model.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StockDAO implements CrudDAO<Stock> {

    private static final Logger logger = LoggerFactory.getLogger(StockDAO.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Stock stock) {
        sessionFactory.getCurrentSession().save(stock);
        logger.info("Stock successfully saved. Stock details: " + stock.toString());
    }

    @Override
    public List<Stock> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Stock> result = session.createQuery("select s from Stock s").list();
        for (Stock stock : result) {
            logger.info("Stock list: " + stock.toString());
        }
        return result;
    }

    @Override
    public void update(Stock stock) {
        sessionFactory.getCurrentSession().update(stock);
        logger.info("Stock successfully update. Stock details: " + stock.toString());
    }

    @Override
    public void remove(Stock stock) {
        sessionFactory.getCurrentSession().delete(stock);
        logger.info("Stock successfully remove. Stock details: " + stock.toString());
    }

    @Override
    public Stock findById(int id) {
        Stock result = sessionFactory.getCurrentSession().load(Stock.class, id);
        if(result == null)
            throw new RuntimeException("Cannot find Stock by ID: " + id);
        logger.info("Stock successfully loaded. Stock id: " + id);
        return result;
    }

    @Override
    public Stock findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from Stock s where s.name like :name");
        query.setParameter("name", name);
        logger.info("Stock successfully loaded. Stock name: " + name);
        return (Stock) query.uniqueResult();
    }
}
