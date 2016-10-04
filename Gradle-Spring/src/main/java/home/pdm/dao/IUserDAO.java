package home.pdm.dao;

import home.pdm.model.User;

import java.util.List;

public interface IUserDAO {

    void save(User user);

    User findUserBuId(Long id);

    List<User> findAll();

    User findByName (String name);

    void remove(User user);
}
