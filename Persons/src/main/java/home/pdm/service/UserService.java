package home.pdm.service;

import home.pdm.dao.IRoleDao;
import home.pdm.dao.IUserDao;
import home.pdm.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserService");

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IRoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * Save instance of User into database.
     * @param user new instance of User.
     * @see User
     */
    @Transactional
    public void addUser(User user) {
        LOGGER.info("Save new user.");
        userDao.save(user);
    }

    /**
     * Update instance of User from database.
     * @param user update instance of User.
     * @see User
     */
    @Transactional
    public void updateUser(User user) {
        LOGGER.info("Update user.");
        userDao.update(user);
    }

    /**
     * Read instance of User from database
     * @param userId primary key.
     * @return instance of user.
     * @see User
     */
    @Transactional
    public User read(Integer userId) {
        LOGGER.info("Get user by USER_ID.");
        return userDao.read(userId);
    }

    /**
     * Find user from database.
     * @param userName user.
     * @return instance of User from database.
     */
    @Transactional
    public User findByUserName(String userName) {
        LOGGER.info("Get user by USER_NAME.");
        return userDao.findByUserName(userName);
    }

    /**
     * Find user from database.
     * @param roleId user.
     * @return instance of User from database.
     */
    @Transactional
    public User findByRoleId(Integer roleId) {
        LOGGER.info("Get user by ROLE_ID.");
        return userDao.findByRoleId(roleId);
    }

    /**
     * Read list instance of User from database.
     * @return list instance of user.
     * @see User
     */
    @Transactional
    public List<User> getAll() {
        LOGGER.info("Get all users.");
        return userDao.getAll();
    }

    /**
     * Delete user from database.
     * @param userId delete instance of User.
     */
    @Transactional
    public void deleteById(Integer userId) {
        LOGGER.info("Delete user by USER_ID.");
        userDao.deleteById(userId);
    }


    /**
     * Delete user from database.
     * @param user delete instance of User.
     */
    @Transactional
    public void deleteByUser(User user) {
        LOGGER.info("Delete user.");
        userDao.delete(user);
    }
}
