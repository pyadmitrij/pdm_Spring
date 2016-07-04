package home.pdm.dao;

import home.pdm.model.Role;

public interface IRoleDao extends ICrudDao<Integer, Role> {

    Role find(String name);

    void deleteById(Integer roleId);

}
