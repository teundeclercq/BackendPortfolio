package nl.teundeclercq.portofolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "user_id")
    private String id;

    public User(String id, Set<Role> roles, Set<Portfolio> portfolios) {
        this.id = id;
        this.roles = roles;
        this.portfolios = portfolios;
    }

    public User(String id) {
        this.id = id;
    }

    //    @Column(name = "email")
//    private String email;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(name = "active")
//    private int active;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_portfolio", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "portfolio_id"))
    private Set<Portfolio> portfolios;

    public User() {
    }
}
