package nl.teundeclercq.portofolio.controller;

import nl.teundeclercq.portofolio.model.Document;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.repository.DocumentRepository;
import nl.teundeclercq.portofolio.repository.UserRepository;
import nl.teundeclercq.portofolio.service.DocumentService;
import nl.teundeclercq.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Document")
@CrossOrigin(origins = "https://portfolios4.teun-school.nl", maxAge = 3600)
public class DocumentController {

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
            return null;
        }
    }
    @GetMapping("/ByPortfolio/{id}")
    public List<Document> getDocumentsByPortfolioId(@PathVariable int id) {
        List<Document> documents = this.documentService.getDocumentsByPortfolioId(id);
        if(!documents.isEmpty()) {
            return documents;
        } else {
            return null;
        }
    }

    @PostMapping("/Add")
    public void addDocument(@RequestBody Document document) {
        try {
            documentService.addDocument(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DeleteMapping("/Delete/{id}")
    public Map<String, String> deleteDocument(@PathVariable int id) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if(this.documentService.findDocument(id)) {
                this.documentService.deleteDocument(id);
                map.put("Status", "Ok");
            } else {
                map.put("Status", "Can't find document");
            }
            return map;
        } catch(Exception e) {
            e.printStackTrace();
            map.put("Status", "Error");
            return map;
        }
    }
    @PostMapping("/Update")
    public void updateDocument(@RequestBody Document document) {
        try {
            if (this.documentService.findDocument(document.getId())) {
                this.documentService.updateDocument(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
