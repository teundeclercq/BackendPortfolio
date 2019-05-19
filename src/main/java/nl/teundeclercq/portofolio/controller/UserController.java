package nl.teundeclercq.portofolio.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import nl.teundeclercq.portofolio.service.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/AddUser/")
    public Map<String, String> addUser(@RequestBody String userId) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try{
            System.out.println(userId);
            this.userService.createUser(userId);
            map.put("Status", "Ok");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("Status", "Error");
            return map;
        }
    }

}
