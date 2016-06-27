package home.pdm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy="roles")
    private Set<User> users = new HashSet<User>();

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
