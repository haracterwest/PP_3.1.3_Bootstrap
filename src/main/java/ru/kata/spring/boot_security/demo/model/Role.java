package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;


    public Role(Long id) {
        this.id = id;
    }

    public Role(String role) {
        this.role = role;
    }

    @Transient
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        role
                .replace("[", "")
                .replace("]", "");
        return role;

    }

    public String getRole() {
        return role.replace("[", "")
                .replace("]", "");

    }


    @Override
    public String getAuthority() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(getId(), role1.getId()) && Objects.equals(getRole(), role1.getRole()) && Objects.equals(users, role1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRole(), users);
        //return Objects.hash(getId(), getRole());
    }
}
