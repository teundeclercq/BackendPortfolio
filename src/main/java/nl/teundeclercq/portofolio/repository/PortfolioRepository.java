package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findPortfoliosById (String userID);
}
