package nl.teundeclercq.portofolio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class PortfolioToDo {
    private int id;
    private String title;
    private String subtitle;
    private String description;
    private String portfolioImage;
    private Set<Document> documents;
    private User user;

    public PortfolioToDo() {
    }

    public PortfolioToDo(String title, String subtitle, String description, String portfolioImage, Set<Document> documents, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.portfolioImage = portfolioImage;
        this.documents = documents;
        this.user = user;
    }
}
