package home.pdm.dao;

import home.pdm.model.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleDAO implements interaction between Role entity and database
 */

@Repository
public class RoleDao extends CrudDao<Integer, Role> implements IRoleDao {

    public Role find(String name) {
        return (Role) getSession().createQuery(
                "FROM Role r WHERE r.name = :name")
                .setParameter("name", name).uniqueResult();
    }

    public void deleteById(Integer roleId) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, roleId);
        if (role != null)
            sessionFactory.getCurrentSession().delete(role);

    }

}
