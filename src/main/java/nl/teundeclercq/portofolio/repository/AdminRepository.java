package nl.teundeclercq.portofolio.repository;

import nl.teundeclercq.portofolio.model.Admin;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository<Admin, String> {
}
