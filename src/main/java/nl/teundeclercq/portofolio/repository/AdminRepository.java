package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Admin;
import nl.teundeclercq.portofolio.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, String> {
}
