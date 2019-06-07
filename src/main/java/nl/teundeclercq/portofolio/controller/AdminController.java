package nl.teundeclercq.portofolio.controller;

import com.google.firebase.auth.FirebaseAuth;
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
@CrossOrigin(origins = "https://portfolios4.teun-school.nl", maxAge = 3600)
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger( AdminController.class.getName() );

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
            map.put("Status", "Ok");
            return map;
        } catch(Exception e) {
            LOGGER.log(Level.INFO, "Exception", e);
            map.put("Status", "Error");
            return map;
        }
    }
    @DeleteMapping("/Delete/{userId}")
    public Map<String, String> deleteUserFromAdmin(@PathVariable String userId) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if (adminService.isAdmin(userId) != null) {
                adminService.deleteUserIdFromAdmin(userId);
                map.put("Status", "Ok");
            } else {
                map.put("Status", "Not Deleted");
            }
            return map;
        } catch(Exception e) {
            LOGGER.log(Level.INFO, "Exception", e);
            map.put("Status", "Error");
            return map;
        }
    }
}
