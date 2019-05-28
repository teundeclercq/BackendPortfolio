package nl.teundeclercq.portofolio.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

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
    public Document() { }
}
