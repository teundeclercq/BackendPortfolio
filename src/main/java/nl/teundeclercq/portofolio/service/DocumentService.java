package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;


    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        return documents;
    }
    public List<Document> getDocumentsByPortfolioId(int id) {
       return this.documentRepository.findByPortfolioId(id);
    }
    public void addDocument(Document document) {
        this.documentRepository.save(document);
    }
    public void deleteDocument(int id) {
        this.documentRepository.deleteById(id);
    }
    public void updateDocument(Document document) { this.documentRepository.save(document); }

}
