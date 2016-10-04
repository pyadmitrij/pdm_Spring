package home.pdm.service;

import home.pdm.dao.IUserDAO;
import home.pdm.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserService {

    private IUserDAO userDAO;

    @Transactional
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
