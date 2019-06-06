package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository repo) {
        portfolioRepository = repo;
    }
    public List<Portfolio> getPortfoliosById(String userId) {
        return portfolioRepository.findByUserId(userId);
    }

    public List<Portfolio> getAllPortfolios() {
        List<Portfolio> portfolios = new ArrayList<>();
        portfolioRepository.findAll().forEach(portfolios::add);
        return portfolios;
    }

    public void addPortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }
    public Portfolio getPortfolioById(int id) {return portfolioRepository.findById(id).orElse(null);}
    public void updatePortfolio(Portfolio portfolio) { portfolioRepository.save(portfolio);}
    public void deletePortfolio(int portfolioID) {
        portfolioRepository.deleteById(portfolioID);
    }
    public boolean portfolioExists(int portfolioId) { return portfolioRepository.findById(portfolioId).isPresent();}
}
