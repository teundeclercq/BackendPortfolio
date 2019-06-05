package nl.teundeclercq.portofolio.controller;

import com.jayway.jsonpath.JsonPath;
import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.service.DocumentService;
import nl.teundeclercq.portofolio.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.list;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class DocumentControllerTest {


    @Mock
    Document document;
    @Mock
    Document document1;
    @Mock
    UserService userService;
    @Mock
    DocumentService documentService;
    @InjectMocks
    DocumentController documentController;

    List<Document> documentSet;
    @Mock
    User user;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
//        documentSet = new ArrayList<>();
//        document = new Document();
//        document1 = new Document();
//        document.setName("teundoc.docx");
//        document1.setName("teundoc1.docx");
//        documentSet.add(document);
//        documentSet.add(document1);
//        user = new User();
//        user.setId("1");
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(documentController)
//                .build();
    }

    @Test
    public void getAllDocuments() throws Exception {
//        when(userService.findUser("1")).thenReturn(user);
//        when(documentService.getAllDocuments()).thenReturn(documentSet);
//
//        mockMvc.perform(get("/All/{id}","id"))
//                .andExpect(status().isOk());
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(documentController).build();
//
//        mockMvc.perform(get("/All/{id}", "id"))
//                .andExpect(status().isOk())
//                .andExpect()
//                .andReturn();

    }

    @Test
    public void getDocumentsByPortfolioId() {
    }

    @Test
    public void addDocument() {
    }

    @Test
    public void deleteDocument() {
    }

    @Test
    public void updateDocument() {
    }
}
