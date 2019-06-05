package nl.teundeclercq.portofolio.repository;


import nl.teundeclercq.portofolio.model.Role;
import nl.teundeclercq.portofolio.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findUsersByRole(Role role);
}
