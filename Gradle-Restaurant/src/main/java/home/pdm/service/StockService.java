package home.pdm.service;

import home.pdm.dao.StockDAO;
import home.pdm.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StockService {

    private StockDAO stockDAO;

    public void setStockDAO(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Transactional
    public void saveStock(Stock stock) {
        stockDAO.save(stock);
    }

    @Transactional
    public List<Stock> getStock() {
        return stockDAO.findAll();
    }

    @Transactional
    public void updateStock(Stock stock){
        stockDAO.update(stock);
    }

    @Transactional
    public void removeStock(Stock stock) {
        stockDAO.remove(stock);
    }

    @Transactional
    public Stock getStokById(int stockId) {
        return stockDAO.findById(stockId);
    }

    @Transactional
    public Stock getStockByName(String stockName) {
        return stockDAO.findByName(stockName);
    }
}
