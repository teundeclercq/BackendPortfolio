package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Admin;
import nl.teundeclercq.portofolio.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin addUserToAdmin(String userid) {
        return this.adminRepository.save(new Admin(userid));
    }
    public void deleteUserIdFromAdmin(String userid) {
        this.adminRepository.deleteById(userid);
    }
    public Admin isAdmin(String userId) {
        return this.adminRepository.findById(userId).orElse(null);
    }
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }
}
