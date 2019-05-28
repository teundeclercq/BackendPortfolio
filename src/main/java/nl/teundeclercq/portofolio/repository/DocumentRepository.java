package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
    List<Document> findByPortfolioId(int id);
}
