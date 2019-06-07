package nl.teundeclercq.portofolio.model;

import nl.teundeclercq.portofolio.repository.PortfolioRepository;
import nl.teundeclercq.portofolio.service.PortfolioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    User user;
    PortfolioService portfolioService;

    @Mock
    PortfolioRepository portfolioRepository;


    @Before
    public void setUp() throws Exception {

        portfolioService = new PortfolioService(portfolioRepository);
        user = new User();
    }

    @Test
    public void getId() {
        String userId = "Uj97daLa42";
        user.setId(userId);
        assertEquals(userId, user.getId());
    }

    @Test
    public void getUsername() {
        String userName = "teundeclercq";
        user.setUsername(userName);
        assertEquals(userName, user.getUsername());
    }

    @Test
    public void getEmail() {
        String email = "teundeclercq@gmail.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void getRole() {
        Role role = Role.USER;
        user.setRole(role);
        assertEquals(role, user.getRole());
    }
    @Test
    public void getPortfolios() {
        Portfolio portfolio = new Portfolio();
        HashSet portfolioData = new HashSet();
        portfolioData.add(portfolio);

        when(portfolioRepository.findAll()).thenReturn(portfolioData);

        List<Portfolio> portfolios = portfolioService.getAllPortfolios();
        assertEquals( 1, portfolios.size());
        verify(portfolioRepository, times(1)).findAll();
    }

    @Test
    public void toString1() {
        String username = "teundeclercq";
        String email = "teundeclercq@gmail.com";
        String id = "UI12";
        Role role = Role.USER;
        HashSet portfolios = new HashSet();
        portfolios.add(new Portfolio());
        HashSet admins = new HashSet();
        admins.add(new Admin());
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setId(id);
        user.setRole(role);
        user.setPortfolios(portfolios);
        user.setAdmins(admins);
        String toString = "USER{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", portfolios=" + portfolios +
                ", admins=" + admins +
                '}';
        assertEquals(user.toString(), toString);
    }
}
