package nl.teundeclercq.portofolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "document")
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "data", length = 10000000)
    private String data;
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;
    @JsonIgnore
    @ManyToMany(mappedBy = "documents")
    private Set<Admin> admins;
    public Document() { }
}
