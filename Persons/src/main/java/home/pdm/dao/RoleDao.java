package home.pdm.dao;

import home.pdm.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * RoleDAO implements interaction between Role entity and database
 */

@Repository
public class RoleDao extends CrudDao<Role, Integer> implements IRoleDao {

    public Role find(String name) {
        return (Role) currentSession().createQuery(
                "FROM Role r WHERE r.name = :name")
                .setParameter("name", name).uniqueResult();
    }

    public void deleteById(Integer roleId) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, roleId);
        if (role != null)
            sessionFactory.getCurrentSession().delete(role);

    }
}
