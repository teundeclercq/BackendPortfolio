package nl.teundeclercq.portofolio.controller;

import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.model.DocumentToDo;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.service.DocumentService;
import nl.teundeclercq.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Documents")
public class DocumentController {
    private static final Logger logger = Logger.getLogger( DocumentController.class.getName() );
    private static List<Document> emptyDocuments = new ArrayList<>();
    private static String exceptionMsg = "Exception";
    private static String status = "Status";


    @Autowired
    private DocumentService documentService;
    private UserService userService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = "/User/{userId}")
    public List<Document> getAllDocuments(@PathVariable String userId) {
        User user = this.userService.findUser(userId);
        if(user != null) {
            return this.documentService.getAllDocuments();
        } else {
            return emptyDocuments;
        }
    }
    @GetMapping(value = "/Portfolio/{portfolioId}")
    public List<Document> getDocumentsByPortfolioId(@PathVariable int portfolioId) {
        List<Document> documents = this.documentService.getDocumentsByPortfolioId(portfolioId);
        if(!documents.isEmpty()) {
            return documents;
        } else {
            return emptyDocuments;
        }
    }

    @PostMapping("/")
    public void addDocument(@RequestBody DocumentToDo documentToDo) {
        try {
            Document document = new Document();
            document.setName(documentToDo.getName());
            document.setData(documentToDo.getData());
            document.setPortfolio(documentToDo.getPortfolio());
            document.setAdmins(documentToDo.getAdmins());
            documentService.addDocument(document);
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
        }
    }
    @DeleteMapping("/{documentId}")
    public Map<String, String> deleteDocument(@PathVariable int documentId) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if(this.documentService.findDocument(documentId)) {
                this.documentService.deleteDocument(documentId);
                map.put(status, "Ok");
            } else {
                map.put(status, "Can't find document");
            }
            return map;
        } catch(Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
    @PutMapping("/")
    public void updateDocument(@RequestBody DocumentToDo documentToDo) {
        try {
            Document document = new Document();
            document.setName(documentToDo.getName());
            document.setData(documentToDo.getData());
            document.setPortfolio(documentToDo.getPortfolio());
            document.setAdmins(documentToDo.getAdmins());
            if (this.documentService.findDocument(document.getId())) {
                this.documentService.updateDocument(document);
            }
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
        }
    }
}
