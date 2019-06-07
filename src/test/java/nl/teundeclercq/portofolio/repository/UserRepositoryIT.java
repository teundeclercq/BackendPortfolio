package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIT {
    User userUser;
    User admin;
    @Mock
    List<User> adminList;
    @Mock
    List<User> userList;

    @Mock
    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        adminList = new ArrayList<>();
        userList = new ArrayList<>();

        userUser = new User("UI12", "teundeclercq", "teundeclercq@gmail.com", Role.USER, null, null);
        admin = new User("UI13", "AnneSchroen", "anneschroen@gmail.com", Role.ADMIN, null, null);
        userList.add(userUser);
        adminList.add(admin);

        testEntityManager.persist(admin);
        testEntityManager.persist(userUser);
        when(userRepository.findUsersByRole(Role.ADMIN)).thenReturn(adminList);
        when(userRepository.findUsersByRole(Role.USER)).thenReturn(userList);
        when(userRepository.findById(userUser.getId())).thenReturn(Optional.of(userUser));
        when(userRepository.findById(admin.getId())).thenReturn(Optional.of(admin));
        when(userRepository.save(userUser)).thenReturn(userUser);
        when(userRepository.save(admin)).thenReturn(admin);

    }

    @Test
    public void findUsersByRole() {
        List<User> users = userRepository.findUsersByRole(Role.USER);

        assertEquals(1, users.size());
        assertEquals(users.get(0).getId(), this.userUser.getId());

        verify(userRepository, times(1)).findUsersByRole(Role.USER);
    }

    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById(this.userUser.getId());
        Optional<User> admin = userRepository.findById(this.admin.getId());
        assertEquals(user.get().getId(), this.userUser.getId());
        assertEquals(admin.get().getId(), this.admin.getId());
        verify(userRepository, times(1)).findById(this.userUser.getId());
        verify(userRepository, times(1)).findById(this.admin.getId());
    }

    @Test
    public void Save() {
        User admin = userRepository.save(this.admin);
        User user = userRepository.save(this.userUser);
        assertEquals(user, this.userUser);
        assertEquals(admin, this.admin);
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).save(admin);
    }

    @Test
    public void Delete() {
        Optional<User> user = userRepository.findById("UI12");
        userRepository.deleteById(user.get().getId());
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        assertEquals(0, userList.size());
        verify(userRepository, times(1)).deleteById("UI12");

    }

}
