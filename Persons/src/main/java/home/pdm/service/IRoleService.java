package home.pdm.service;

import home.pdm.model.Role;

import java.util.List;

public interface IRoleService {

    void addRole(Role role);

    void updateRole(Role role);

    List<Role> getAll();

    Role getRole(Integer roleId);

    Role find(String name);

    void deleteById(Integer roleId);

    void deleteByRole(Role role);

}
