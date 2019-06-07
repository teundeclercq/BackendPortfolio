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
@RequestMapping("/Document")
@CrossOrigin(origins = "https://portfolios4.teun-school.nl", maxAge = 3600)
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

    @GetMapping("/All/{id}")
    public List<Document> getAllDocuments(@PathVariable String id) {
        User user = this.userService.findUser(id);
        if(user != null) {
            return this.documentService.getAllDocuments();
        } else {
            return emptyDocuments;
        }
    }
    @GetMapping("/ByPortfolio/{id}")
    public List<Document> getDocumentsByPortfolioId(@PathVariable int id) {
        List<Document> documents = this.documentService.getDocumentsByPortfolioId(id);
        if(!documents.isEmpty()) {
            return documents;
        } else {
            return emptyDocuments;
        }
    }

    @PostMapping("/Add")
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
    @DeleteMapping("/Delete/{id}")
    public Map<String, String> deleteDocument(@PathVariable int id) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if(this.documentService.findDocument(id)) {
                this.documentService.deleteDocument(id);
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
    @PostMapping("/Update")
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
