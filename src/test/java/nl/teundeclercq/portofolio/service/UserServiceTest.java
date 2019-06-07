package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.repository.AdminRepository;
import nl.teundeclercq.portofolio.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class UserServiceTest {
    UserService userService;
    AdminService adminService;
    @Mock
    UserRepository userRepository;
    @Mock
    AdminRepository adminRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminService(adminRepository);
        userService = new UserService(userRepository);
    }

    @Test
    public void createUser() {
        String id = "12";
        User user = new User(id);
        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void findAllUsers() {
        User user = new User();
        List<User> userData = new ArrayList<>();
        userData.add(user);

        when(userService.findAllUsers()).thenReturn(userData);

        List<User> users = userService.findAllUsers();
        assertEquals(1, users.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void findAllAdmins() {
        Role role = Role.admin;
        User user = new User();
        user.setRole(role);
        List<User> userData = new ArrayList<>();
        userData.add(user);

        when(userService.findAllAdmins()).thenReturn(userData);
        List<User> users = userService.findAllAdmins();
        assertEquals(1, users.size());
        assertEquals(users.get(0).getRole(), role);
        verify(userRepository, times(1)).findUsersByRole(role);
    }

    @Test
    public void updateUser() {
        String id = "UI78";
        User user = new User(id);
        userService.updateUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void deleteUser() {
        String id = "UI78";
        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void findUser() {
        String id = "UI78";
        User user = new User(id);
        userService.createUser(user);
        userService.findUser(id);
        verify(userRepository, times(1)).findById(id);
    }
}
