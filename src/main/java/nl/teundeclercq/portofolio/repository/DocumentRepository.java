package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer> {
    List<Document> findByPortfolioId(int id);
}
