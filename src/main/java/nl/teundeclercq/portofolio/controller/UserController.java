package nl.teundeclercq.portofolio.controller;

import com.google.firebase.auth.FirebaseAuth;
import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.model.UserToDo;
import nl.teundeclercq.portofolio.service.AdminService;
import nl.teundeclercq.portofolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "https://portfolios4.teun-school.nl")
public class UserController {
    private static final Logger logger = Logger.getLogger( UserController.class.getName() );
    private static List<User> emptyUsers = new ArrayList<>();
    private static String exceptionMsg = "Exception";
    private static String status = "Status";
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @GetMapping("/roleAdmin/")
    public List<User> getAllAdminUsers() {
        return userService.findAllAdmins();
    }
    @PostMapping("/AddUser/")
    public Map<String, String> addUser(@RequestBody UserToDo userToDo) {
        HashMap<String, String> map = new HashMap<>();
        try{
            User user = new User(userToDo.getId(),
                    userToDo.getUsername(),
                    userToDo.getEmail(),
                    userToDo.getRole(),
                    userToDo.getPortfolios(),
                    userToDo.getAdmins());
            this.userService.createUser(user);
            map.put(status, "Ok");
            return map;
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
    @DeleteMapping("/Delete/{userId}")
    public Map<String, String> deleteUser(@PathVariable String userId) {
        HashMap<String, String> map = new HashMap<>();
        try{
            if(userService.userExists(userId)){
                this.userService.deleteUser(userId);
                FirebaseAuth.getInstance().deleteUser(userId);
                logger.log(Level.INFO,"Succesfully deleted the USER: " + userId);
                map.put(status, "Ok");
            } else {
                map.put(status, "USER not deleted");
            }
            return map;
        } catch (Exception e) {
            logger.log(Level.INFO, exceptionMsg, e);
            map.put(status, "Error");
            return map;
        }
    }
    @GetMapping("/All/{userId}")
    public List<User> getAllUsers(@PathVariable String userId) {
        if(this.userService.findUser(userId).getRole() == Role.ADMIN) {
            return this.userService.findAllUsers();
        } else {
            return emptyUsers;
        }
    }
    @PutMapping("/Update")
    public User updateUser(@RequestBody UserToDo userToDo) {
        User user = new User(userToDo.getId(),
                userToDo.getUsername(),
                userToDo.getEmail(),
                userToDo.getRole(),
                userToDo.getPortfolios(),
                userToDo.getAdmins());
        if(userService.userExists(user.getId())) {
            return userService.updateUser(user);
        } else {
            return null;
        }
    }
}
