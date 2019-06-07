package nl.teundeclercq.portofolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admin")
@Getter
@Setter
@ToString
public class Admin {
    @Id
    @Column(name = "admin_id")
    private String id;
    public Admin() {}
    public Admin(String id) { this.id = id; }
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Admin_Document",
               joinColumns = @JoinColumn(name = "admin_id"),
               inverseJoinColumns = @JoinColumn(name = "document_id"))
    private Set<Document> documents;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Admin_User",
               joinColumns = @JoinColumn(name = "admin_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
}
