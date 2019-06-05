package nl.teundeclercq.portofolio.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTest {
    Document document;
    @Before
    public void setUp() throws Exception {
        document = new Document();
    }

    @Test
    public void getId() {
        int documentId = 7;
        document.setId(documentId);
        assertEquals(documentId, document.getId());
    }

    @Test
    public void getName() {
        String documentName = "Sep4Documentatie";
        document.setName(documentName);
        assertEquals(documentName, document.getName());
    }

    @Test
    public void getData() {
        String documentName = "Sep4Documentatie.docx";
        document.setData(documentName);
        assertEquals(documentName, document.getData());
    }

}
