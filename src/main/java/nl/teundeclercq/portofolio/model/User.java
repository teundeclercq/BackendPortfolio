package nl.teundeclercq.portofolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    public User(String id) {
        this.id = id;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Portfolio> portfolios;
    @ManyToMany(mappedBy = "users")
    private Set<Admin> admins;
    public User() { }

    public User(String id, String username, String email, Role role, Set<Portfolio> portfolios, Set<Admin> admins) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.portfolios = portfolios;
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "USER{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", portfolios=" + portfolios +
                ", admins=" + admins +
                '}';
    }
}
