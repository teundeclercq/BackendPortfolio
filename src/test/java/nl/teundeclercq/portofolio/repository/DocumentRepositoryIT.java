package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.model.Portfolio;
import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DocumentRepositoryIT {
    int portfolioid;
    int documentid;
    Document document;
    Portfolio portfolio;
    User user;

    @Autowired
    UserRepository userRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        HashSet<Portfolio> portfolios = new HashSet<>();
        HashSet<Document> documents = new HashSet<>();
        user = new User("UI12", "teundeclercq", "teundeclercq@gmail.com", Role.USER, portfolios, null);
        portfolio = new Portfolio("teun", "test", "test", "test", documents, user);
        document = new Document("documentnaam", "documentdata", portfolio, null);
        portfolios.add(portfolio);
        documents.add(document);

        testEntityManager.persist(user);
        testEntityManager.persist(portfolio);
        testEntityManager.persist(document);

        testEntityManager.flush();
    }

    @Test
    public void findByPortfolioId() {
        List<Portfolio> portfolio = portfolioRepository.findByUserId("UI12");
        assertEquals(1, portfolio.size());
        List<Document> documentList = documentRepository.findByPortfolioId(portfolio.get(0).getId());
        assertEquals(1, documentList.size());
    }

    @Test
    public void Save() {
//        document = new Document("doc", "doc", null, null );
        Document documenttje = documentRepository.save(document);
        assertEquals(documenttje.getId(), document.getId());
    }

    @Test
    public void Update() {
        int portfolioId = portfolioRepository.findByUserId("UI12").get(0).getId();
        int documentId = documentRepository.findByPortfolioId(portfolioId).get(0).getId();
        Document document = new Document("teuntje document", "teuntje", null, null);
        document.setId(documentId);
        documentRepository.save(document);

        assertEquals(this.document.getId(), documentRepository.save(document).getId());
    }

    @Test
    public void Delete() {
        documentRepository.delete(document);
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        assertEquals(0, documents.size());
    }
}
