package nl.teundeclercq.portofolio.repository;


import nl.teundeclercq.portofolio.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
