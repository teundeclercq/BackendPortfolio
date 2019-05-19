package nl.teundeclercq.portofolio.controller;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/Portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @GetMapping("/AllByUID/{userId}")
    public List<Portfolio> getPortfoliosById(@PathVariable String userId) throws SQLException {
        return portfolioService.getPortfoliosById(userId);
    }
    @GetMapping("/Get/{PortfolioId}")
    public Portfolio getPortfolio(@PathVariable long PortfolioId) throws SQLException {
        return portfolioService.getPortfolioById(PortfolioId);
    }
    @PostMapping("/AddByUID/{userId}")
    public void addPortfolioById(@PathVariable String userId, @RequestBody Portfolio portfolio) throws SQLException {
        try {
            portfolioService.addPortfolio(portfolio, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/DeleteByUID/{userId}")
    public void deletePortfolioById(@PathVariable String userId, @RequestBody long portfolioId) throws SQLException {
        portfolioService.deletePortfolio(userId, portfolioId);
    }
    @PostMapping("/Portfolio/Update")
    public void updatePortfolio(@RequestBody Portfolio portfolio) throws SQLException {
        try {
            portfolioService.updatePortfolio(portfolio);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
