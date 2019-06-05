package nl.teundeclercq.portofolio.service;

import nl.teundeclercq.portofolio.model.Admin;
import nl.teundeclercq.portofolio.repository.AdminRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class AdminServiceTest {
    AdminService adminService;
    @Mock
    AdminRepository adminRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminService(adminRepository);

    }

    @Test
    public void addUserToAdmin() {
        String id = "UI127";



//        when(adminService.addUserToAdmin(id)).thenReturn(admin);
//        verify(adminRepository, times(1)).save(admin);

    }

    @Test
    public void deleteUserIdFromAdmin() {
        String id = "UI127";
        adminRepository.save(new Admin(id));
        adminRepository.deleteById(id);
        verify(adminRepository, times(1)).deleteById(id);

    }

    @Test
    public void isAdmin() {
//        String id = "UI127";
//        Admin admin = new Admin(id);
//        adminRepository.save(admin);
//        when(adminService.isAdmin(id)).thenReturn(Optional.of(admin).orElse(null));
//        verify(adminRepository, times(1)).existsById(id);
    }


    @Test
    public void getAllAdmins() {
        Admin admin = new Admin();
        List<Admin> adminData = new ArrayList<>();
        adminData.add(admin);
        when(adminService.getAllAdmins()).thenReturn(adminData);

        List<Admin> admins = adminService.getAllAdmins();

        assertEquals(admins.size(), 1);
        verify(adminRepository, times(1)).findAll();
    }
}
