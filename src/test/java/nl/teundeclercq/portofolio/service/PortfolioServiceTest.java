package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.repository.PortfolioRepository;
import nl.teundeclercq.portofolio.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class PortfolioServiceTest {
    PortfolioService portfolioService;
    UserService userService;
    @Mock
    PortfolioRepository portfolioRepository;
    @Mock
    UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        portfolioService = new PortfolioService(portfolioRepository);
        userService = new UserService(userRepository);

    }

    @Test
    public void getPortfoliosById() {
        Portfolio portfolio = new Portfolio();
        List<Portfolio> portfolioData = new ArrayList<>();
        portfolioData.add(portfolio);
        when(portfolioService.getPortfoliosById("UI12")).thenReturn(portfolioData);

        List<Portfolio> portfolios = portfolioService.getPortfoliosById("UI12");
        assertEquals(1, portfolios.size());

        verify(portfolioRepository, times(1)).findByUserId("UI12");
    }

    @Test
    public void getAllPortfolios() {
        Portfolio portfolio = new Portfolio();
        List<Portfolio> portfolioData = new ArrayList<>();
        portfolioData.add(portfolio);
        when(portfolioService.getAllPortfolios()).thenReturn(portfolioData);

        List<Portfolio> portfolios = portfolioService.getAllPortfolios();
        assertEquals(1, portfolios.size());
        verify(portfolioRepository, times(1)).findAll();
    }

    @Test
    public void addPortfolio() {
        Portfolio portfolio = new Portfolio();
        portfolioService.addPortfolio(portfolio);
        verify(portfolioRepository, times(1)).save(portfolio);
    }

    @Test
    public void getPortfolioById() {
        int id = 1;
        Portfolio portfolio = new Portfolio();
        portfolio.setId(id);
        portfolioService.addPortfolio(portfolio);
        portfolioService.getPortfolioById(id);
        verify(portfolioRepository, times(1)).findById(id);
    }

    @Test
    public void updatePortfolio() {
        int id = 1;
        Portfolio portfolio = new Portfolio();
        portfolio.setId(id);
        portfolioService.updatePortfolio(portfolio);
        verify(portfolioRepository, times(1)).save(portfolio);
    }

    @Test
    public void deletePortfolio() {
        int id = 1;
        Portfolio portfolio = new Portfolio();
        portfolio.setId(id);
        portfolioService.deletePortfolio(id);
        verify(portfolioRepository, times(1)).deleteById(1);
    }
}
