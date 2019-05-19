package nl.teundeclercq.portofolio.repository;


import nl.teundeclercq.portofolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
