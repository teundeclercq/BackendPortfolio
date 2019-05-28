package nl.teundeclercq.portofolio.controller;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.service.PortfolioService;
import nl.teundeclercq.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Portfolio")
@CrossOrigin
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private UserService userService;

    @GetMapping("/AllByUID/{userId}")
    public List<Portfolio> getPortfoliosById(@PathVariable String userId) throws SQLException {
        return portfolioService.getPortfoliosById(userId);
    }

    @GetMapping("/Get/{PortfolioId}")
    public Portfolio getPortfolio(@PathVariable int PortfolioId) throws SQLException {
        return portfolioService.getPortfolioById(PortfolioId);
    }

    @PostMapping(value = "/AddByUID", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPortfolioById(@RequestBody Portfolio portfolio) throws SQLException {
        System.out.println("portfolio: " + portfolio);
        try {
            portfolioService.addPortfolio(portfolio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/DeleteByUID/{portfolioID}")
    public Map<String, String> deletePortfolioById(@PathVariable int portfolioID) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try {
            portfolioService.deletePortfolio(portfolioID);
            map.put("Status", "Ok");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("Status", "Error");
            return map;
        }

    }

    @PostMapping("/Portfolio/Update")
    public void updatePortfolio(@RequestBody Portfolio portfolio) throws SQLException {
        try {
            portfolioService.updatePortfolio(portfolio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
