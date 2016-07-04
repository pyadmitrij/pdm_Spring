package home.pdm.dao;

import home.pdm.model.User;

public interface IUserDao extends ICrudDao<Integer, User> {

    User findByUserName(String userName);

    User findByRoleId(Integer roleId);

    void deleteById(Integer userId);

}
