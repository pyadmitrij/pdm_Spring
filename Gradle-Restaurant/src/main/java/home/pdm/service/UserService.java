package home.pdm.service;

import home.pdm.dao.UserDAO;
import home.pdm.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public void updateUser(User user){
        userDAO.update(user);
    }

    @Transactional
    public void removeUser(User user) {
        userDAO.remove(user);
    }

    @Transactional
    public User getUserById(int userId) {
        return userDAO.findById(userId);
    }

    @Transactional
    public User getUserByName(String userName) {
        return userDAO.findByName(userName);
    }

}
