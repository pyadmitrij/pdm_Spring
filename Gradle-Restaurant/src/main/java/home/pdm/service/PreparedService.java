package home.pdm.service;

import home.pdm.dao.PreparedDAO;
import home.pdm.model.PreparedDish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PreparedService {

    private PreparedDAO preparedDAO;

    public void setPreparedDAO(PreparedDAO preparedDAO) {
        this.preparedDAO = preparedDAO;
    }

    @Transactional
    public void savePrepared(PreparedDish prepared) {
        preparedDAO.save(prepared);
    }

    @Transactional
    public List<PreparedDish> getPrepared() {
        return preparedDAO.findAll();
    }

    @Transactional
    public void updatePrepared(PreparedDish prepared) {
        preparedDAO.update(prepared);
    }

    @Transactional
    public void removePrepared(PreparedDish prepared) {
        preparedDAO.remove(prepared);
    }

    @Transactional
    public PreparedDish getPreparedById(int preparedId) {
        return preparedDAO.findById(preparedId);
    }

    @Transactional
    public PreparedDish getPreparedByName(String preparedName) {
        return preparedDAO.findByName(preparedName);
    }
}
