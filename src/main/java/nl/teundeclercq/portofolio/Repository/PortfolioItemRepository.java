package nl.teundeclercq.portofolio.Repository;

import nl.teundeclercq.portofolio.Models.PortfolioItem;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioItemRepository extends CrudRepository<PortfolioItem, Long> {
}
