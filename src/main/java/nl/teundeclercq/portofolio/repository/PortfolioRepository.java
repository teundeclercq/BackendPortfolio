package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {
    List<Portfolio> findByUserId (String userID);

}
