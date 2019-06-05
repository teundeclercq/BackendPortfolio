package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PortfolioRepositoryIT {
    User user;
    Portfolio portfolio;
    @Mock
    List<Portfolio> portfolioList;
    @Mock
    HashSet<Portfolio> portfolios;

    @Mock
    @Autowired
    UserRepository userRepository;
    @Mock
    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    TestEntityManager testEntityManager;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        portfolios = new HashSet<>();
        portfolioList = new ArrayList<>();
        user = new User("UI12", "teundeclercq", "teundeclercq@gmail.com", Role.User, portfolios, null);
        portfolio = new Portfolio("teun", "test", "test", "test", null, user);
        portfolios.add(portfolio);
        portfolioList.add(portfolio);
        testEntityManager.persist(user);
        testEntityManager.persist(portfolio);

        when(portfolioRepository.findByUserId("UI12")).thenReturn(portfolioList);
        when(portfolioRepository.save(portfolio)).thenReturn(portfolio);
        when(portfolioRepository.findById(portfolio.getId())).thenReturn(Optional.of(portfolio));
    }

    @Test
    public void findByUserId() {
        List<Portfolio> portfolioList = portfolioRepository.findByUserId("UI12");
        assertEquals(portfolioList.size(), 1);
        verify(portfolioRepository, times(1)).findByUserId("UI12");
    }
    @Test
    public void Save() {
        Portfolio portfolio = portfolioRepository.save(this.portfolio);
        assertEquals(portfolio, this.portfolio);
        verify(portfolioRepository,times(1)).save(portfolio);
    }
    @Test
    public void Delete() {
        String id = "UI12";
        int portfolioId =portfolioRepository.findByUserId(id).get(0).getId();
        portfolioRepository.deleteById(portfolioId);
        List<Portfolio> portfolios = new ArrayList<>();
        portfolioRepository.findAll().forEach(portfolios::add);
        assertEquals(portfolios.size(), 0);
        verify(portfolioRepository, times(1)).deleteById(portfolioId);
    }
    @Test
    public void FindById() {
        List<Portfolio> portfolio = portfolioRepository.findByUserId("UI12");
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(portfolio.get(0).getId());
        assertEquals(portfolioOptional.get().getId(), portfolio.get(0).getId());
        verify(portfolioRepository, times(1)).findById(portfolio.get(0).getId());

    }


}
