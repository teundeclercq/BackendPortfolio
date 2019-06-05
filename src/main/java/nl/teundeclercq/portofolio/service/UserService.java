package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repo) {
        userRepository = repo;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public List<User> findAllAdmins() {
        List<User> users = new ArrayList<>();
        userRepository.findUsersByRole(Role.Admin).forEach(users::add);
        return users;
    }
    public User updateUser(User user) {
        return userRepository.save(user); }
    public void deleteUser(String userId) { userRepository.deleteById(userId);}
    public User findUser(String userId) { return userRepository.findById(userId).orElse(null);}
}
