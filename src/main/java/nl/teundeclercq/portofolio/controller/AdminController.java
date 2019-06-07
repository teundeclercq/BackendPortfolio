package nl.teundeclercq.portofolio.controller;
import nl.teundeclercq.portofolio.model.Admin;
import nl.teundeclercq.portofolio.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger( AdminController.class.getName() );
    private static String status = "status";
    private static String exceptionMsg = "Exception";

    @Autowired
    private AdminService adminService;
    @GetMapping("/All")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    @GetMapping("/Find")
    public Admin getAdmin(@RequestBody String userId) {
        return adminService.isAdmin(userId);
    }
    @PostMapping("/Add/")
    public Map<String, String> addUserToAdmin(@RequestBody String userId) {
        HashMap<String, String> map = new HashMap<>();
        try {
            this.adminService.addUserToAdmin(userId);
            map.put(status, "Ok");
            return map;
        } catch(Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
    @DeleteMapping("/Delete/{userId}")
    public Map<String, String> deleteUserFromAdmin(@PathVariable String userId) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if (adminService.isAdmin(userId) != null) {
                adminService.deleteUserIdFromAdmin(userId);
                map.put(status, "Ok");
            } else {
                map.put(status, "Not Deleted");
            }
            return map;
        } catch(Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
}
