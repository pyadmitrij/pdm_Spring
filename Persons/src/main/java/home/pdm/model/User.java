package home.pdm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_NAME")
    @Size(min = 2, max = 20)
    private String userName;

    @Column(name = "PASSWORD")
    @Size(min = 3, max = 20)
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(name="USERS_ROLES",
            joinColumns={@JoinColumn(name="USER_ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
    @Fetch(value= FetchMode.JOIN)
    private Set<Role> roles = new HashSet<Role>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
