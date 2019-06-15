package nl.teundeclercq.portofolio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "portfolio")
@ToString
@Getter
@Setter
public class Portfolio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "portfolio_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "portfolio_image", length = 10000000)
    private String portfolioImage;
    @JsonIgnore
    @OneToMany(mappedBy = "portfolio")
    private Set<Document> documents;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Portfolio() {
    }

    public Portfolio(String title, String subtitle, String description, String portfolioImage, Set<Document> documents, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.portfolioImage = portfolioImage;
        this.documents = documents;
        this.user = user;
    }
    public Portfolio(int id, String title, String subtitle, String description, String portfolioImage, Set<Document> documents, User user) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.portfolioImage = portfolioImage;
        this.documents = documents;
        this.user = user;
    }


}
