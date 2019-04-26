package nl.teundeclercq.portofolio.Models;

import javax.persistence.Entity;

@Entity
public class PortfolioItem {
    private Long id;
    private String name;
    private String description;
    private String fotoUrl;
    private String projectWebsiteURl;

    public PortfolioItem() {
    }

    public PortfolioItem(Long id, String name, String description, String fotoUrl, String projectWebsiteURl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fotoUrl = fotoUrl;
        this.projectWebsiteURl = projectWebsiteURl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getProjectWebsiteURl() {
        return projectWebsiteURl;
    }

    public void setProjectWebsiteURl(String projectWebsiteURl) {
        this.projectWebsiteURl = projectWebsiteURl;
    }
}
