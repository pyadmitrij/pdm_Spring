package home.pdm.model;

import javax.persistence.*;

import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer userId;

    @NotEmpty
    @Column(name = "USER_NAME")
    @Size(min = 2, max = 20)
    private String userName;

    @NotEmpty
    @Column(name = "PASSWORD")
    @Size(min = 3, max = 20)
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(name = "USERS_ROLES",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    @Fetch(value = FetchMode.JOIN)
    private Set<Role> roles = new HashSet<Role>();

    public User() {
        userId = 0;
    }

    public User (Integer id, String name, String pass){
        userId = id;
        userName = name;
        password = pass;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId != other.userId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + userId + ", name=" + userName + "]";
    }
}
