package home.pdm.service;

import home.pdm.model.User;

import java.util.List;

public interface IUserService {

    void addUser(User user);

    void updateUser(User user);

    User read(Integer userId);

    User findByUserName(String userName);

    User findByRoleId(Integer roleId);

    List<User> getAll();

    void deleteById(Integer userId);

    void deleteByUser(User user);

}
