package nl.teundeclercq.portofolio.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.firebase.auth.FirebaseAuth;
import netscape.javascript.JSObject;
import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.service.AdminService;
import nl.teundeclercq.portofolio.service.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @GetMapping("/roleAdmin/")
    public List<User> getAllAdminUsers() {
        return userService.findAllAdmins();
    }
    @PostMapping("/AddUser/")
    public Map<String, String> addUser(@RequestBody User user) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try{
            System.out.println(user);
            this.userService.createUser(user);
            map.put("Status", "Ok");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("Status", "Error");
            return map;
        }
    }
    @DeleteMapping("/Delete/{userId}")
    public Map<String, String> deleteUser(@PathVariable String userId) {
        HashMap<String, String> map = new HashMap<>();
        try{
            if(userService.findUser(userId) != null){
                this.userService.deleteUser(userId);
                FirebaseAuth.getInstance().deleteUser(userId);
                System.out.println("Succesfully deleted the user: " + userId);
                map.put("Status", "Ok");
            } else {
                map.put("Status", "User not deleted");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("Status", "Error");
            return map;
        }
    }
    @GetMapping("/All/{userId}")
    public List<User> getAllUsers(@PathVariable String userId) {
        if(this.userService.findUser(userId).getRole() == Role.Admin) {
            return this.userService.findAllUsers();
        } else {
            return null;
        }
    }
    @PutMapping("/Update")
    public User UpdateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
