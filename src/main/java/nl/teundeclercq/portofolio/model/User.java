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

    public User(String id) {
        this.id = id;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Portfolio> portfolios;

    public User() {
    }
}
