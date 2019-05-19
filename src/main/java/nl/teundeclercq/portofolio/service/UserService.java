package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.User;
import nl.teundeclercq.portofolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String userId) {
        return userRepository.save(new User(userId));
    }
}
