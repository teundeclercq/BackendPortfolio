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
    @GetMapping("/All/{id}")
    public List<Portfolio> getAllPortfoliosById(@PathVariable String userId) throws SQLException {
        return portfolioService.getPortfoliosById(userId);
    }
    @GetMapping("/Get/{id}")
    public Portfolio getPortfolio(@PathVariable long userId) throws SQLException {
        return portfolioService.getPortfolioById(userId);
    }
    @PostMapping("/Add/{id}")
    public void addPortfolio(@PathVariable String userId, @RequestBody Portfolio portfolio) throws SQLException {
        try {
            portfolioService.addPortfolio(portfolio, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/Portfolio/Delete/{id}")
    public void deletePortfolio(@PathVariable long id) throws SQLException {
        portfolioService.deletePortfolio(id);
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
