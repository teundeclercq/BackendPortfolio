package nl.teundeclercq.portofolio.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PortfolioTest {
    Portfolio portfolio;
    @Before
    public void setUp() throws Exception {
        portfolio = new Portfolio();
    }

    @Test
    public void getId() {
        int portfolioId = 1;
        portfolio.setId(portfolioId);
        assertEquals(portfolioId, portfolio.getId());
    }

    @Test
    public void getTitle() {
        String title = "Gave Portfolio";
        portfolio.setTitle(title);
        assertEquals(title, portfolio.getTitle());
    }

    @Test
    public void getSubtitle() {
        String subtitle = "subtitle Gave Portfolio";
        portfolio.setSubtitle(subtitle);
        assertEquals(subtitle, portfolio.getSubtitle());
    }

    @Test
    public void getDescription() {
        String description = "get some description";
        portfolio.setDescription(description);
        assertEquals(description, portfolio.getDescription());
    }

    @Test
    public void getPortfolioImage() {
        String image = "image.png";
        portfolio.setPortfolioImage(image);
        assertEquals(image, portfolio.getPortfolioImage());
    }
}
