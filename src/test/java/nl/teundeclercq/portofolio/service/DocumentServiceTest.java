package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.repository.DocumentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
public class DocumentServiceTest {
    DocumentService documentService;
    @Mock
    DocumentRepository documentRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        documentService = new DocumentService(documentRepository);
    }

    @Test
    public void getAllDocuments() {
        Document document = new Document();
        List<Document> documentData = new ArrayList<>();
        documentData.add(document);
        when(documentService.getAllDocuments()).thenReturn(documentData);
        List<Document> documents = documentService.getAllDocuments();
        assertEquals(1, documents.size());
        verify(documentRepository, times(1)).findAll();
    }

    @Test
    public void getDocumentsByPortfolioId() {
        Document document = new Document();
        List<Document> documentData = new ArrayList<>();
        documentData.add(document);
        when(documentService.getDocumentsByPortfolioId(1)).thenReturn(documentData);
        List<Document> documents = documentService.getDocumentsByPortfolioId(1);
        assertEquals(1, documents.size());
        verify(documentRepository, times(1)).findByPortfolioId(1);

    }

    @Test
    public void addDocument() {
        Document document = new Document();
        document.setId(1);
        documentService.addDocument(document);
        verify(documentRepository, times(1)).save(document);
    }

    @Test
    public void deleteDocument() {
        int id = 1;
        Document document = new Document();
        document.setId(id);
        documentService.deleteDocument(id);
        verify(documentRepository, times(1)).deleteById(id);
    }

    @Test
    public void updateDocument() {
        int id = 1;
        Document document = new Document();
        document.setId(id);
        documentService.updateDocument(document);
        verify(documentRepository, times(1)).save(document);
    }
}
