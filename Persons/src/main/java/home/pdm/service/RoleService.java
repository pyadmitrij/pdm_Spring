package home.pdm.service;

import home.pdm.dao.IRoleDao;
import home.pdm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@Service
public class RoleService implements IRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger("RoleService");

    @Autowired
    private IRoleDao roleDao;

    public IRoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public void addRole(Role role) {
        LOGGER.info("Save new role.");
        roleDao.save(role);
    }

    @Transactional
    public void updateRole(Role role) {
        LOGGER.info("Update role.");
        roleDao.update(role);
    }

    @Transactional
    public List<Role> getAll() {
        LOGGER.info("Get all roles.");
        return roleDao.getAll();
    }

    @Transactional
    public Role getRole(Integer roleId) {
        LOGGER.info("Get role by ID.");
        return roleDao.read(roleId);
    }

    @Transactional
    public Role find(String name) {
        LOGGER.info("Get role by NAME.");
        return roleDao.find(name);
    }

    @Transactional
    public void deleteById(Integer roleId) {
        LOGGER.info("Delete role by ROLE_ID.");
        roleDao.deleteById(roleId);
    }

    @Transactional
    public void deleteByRole(Role role) {
        LOGGER.info("Delete role.");
        roleDao.delete(role);
    }
}
