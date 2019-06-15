package nl.teundeclercq.portofolio.controller;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.model.PortfolioToDo;
import nl.teundeclercq.portofolio.service.PortfolioService;
import nl.teundeclercq.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/Portfolio")
public class PortfolioController {
    private static final Logger logger = Logger.getLogger(PortfolioController.class.getName());
    private static String exceptionMsg = "Exception";
    private static String status = "Status";
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private UserService userService;

    @GetMapping("/All")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/AllByUID/{userId}")
    public List<Portfolio> getPortfoliosById(@PathVariable String userId) {
        return portfolioService.getPortfoliosById(userId);
    }

    @GetMapping("/Get/{PortfolioId}")
    public Portfolio getPortfolio(@PathVariable int portfolioId) {
        return portfolioService.getPortfolioById(portfolioId);
    }

    @PostMapping(value = "/AddByUID", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPortfolioById(@RequestBody PortfolioToDo portfolioToDo) {
        try {
            Portfolio portfolio = new Portfolio(portfolioToDo.getTitle(),
                    portfolioToDo.getSubtitle(),
                    portfolioToDo.getDescription(),
                    portfolioToDo.getPortfolioImage(),
                    portfolioToDo.getDocuments(),
                    portfolioToDo.getUser());
            portfolioService.addPortfolio(portfolio);
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
        }
    }

    @DeleteMapping("/DeleteByUID/{portfolioID}")
    public Map<String, String> deletePortfolioById(@PathVariable int portfolioID) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if (portfolioService.portfolioExists(portfolioID)) {
                portfolioService.deletePortfolio(portfolioID);
                map.put(status, "Ok");
            } else {
                map.put(status, "Could not delete portfolio");
            }
            return map;
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(exceptionMsg, "Error");
            return map;
        }

    }

    @PostMapping("/Update")
    public void updatePortfolio(@RequestBody PortfolioToDo portfolioToDo) {
        try {
            Portfolio portfolio = new Portfolio(portfolioToDo.getId(),
                                                portfolioToDo.getTitle(),
                                                portfolioToDo.getSubtitle(),
                                                portfolioToDo.getDescription(),
                                                portfolioToDo.getPortfolioImage(),
                                                portfolioToDo.getDocuments(),
                                                portfolioToDo.getUser());
            if (portfolioService.portfolioExists(portfolioToDo.getId())) {
                portfolioService.updatePortfolio(portfolio);
            }
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
        }
    }


}
