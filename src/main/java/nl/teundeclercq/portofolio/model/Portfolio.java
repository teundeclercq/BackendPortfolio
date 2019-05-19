package nl.teundeclercq.portofolio.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "portfolio")
@Setter
@Getter
@ToString
public class Portfolio {
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

    public Portfolio() {
    }

    public Portfolio(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
    }
}
