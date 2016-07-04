package home.pdm.dao;

import home.pdm.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;

/**
 * UserDAO implements interaction between User entity and database
 */

@Repository
public class UserDao extends CrudDao<User, Integer> implements IUserDao {

    public User findByUserName(String userName) {
        Query query = getSessionFactory().getCurrentSession().createQuery(
                "FROM User WHERE userName = :userName")
                .setString("userName", userName);
        return (User) query.uniqueResult();
    }

    public User findByRoleId(Integer roleId) {
        Query query = getSessionFactory().getCurrentSession().createQuery(
                "FROM User WHERE roleId = roleId")
                .setInteger("roleId", roleId);
        return (User) query.uniqueResult();
    }

    public void deleteById(Integer userId) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
        if (user != null)
            sessionFactory.getCurrentSession().delete(user);
    }
}
