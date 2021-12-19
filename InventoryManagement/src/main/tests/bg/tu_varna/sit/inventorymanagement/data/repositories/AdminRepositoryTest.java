package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.entities.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AdminRepositoryTest {
    private Admin admin;
    private AdminRepository adminRepository;
    private List<Admin> allAdmins;

    @BeforeEach
    void setUp() {
        this.admin=new Admin("a23","p16");
        this.adminRepository=AdminRepository.getInstance();
        this.allAdmins=adminRepository.getAll();

    }

    @AfterEach
    void tearDown() {
        adminRepository.delete(admin);
    }

    @Test
    void save() {
        List<Admin> admins =adminRepository.getAll();
        adminRepository.save(admin);
        Assertions.assertNotEquals(admins,adminRepository.getAll());
    }

    @Test
    void update() {
        List<Admin> admins=adminRepository.getAll();
         Admin a=adminRepository.getById(2);
            a.setUsername("admin11");
            a.setPassword("pass11");
            adminRepository.update(a);


        Assertions.assertNotEquals(admins,adminRepository.getAll());
    }

    @Test
    void delete() {
        List<Admin> admins =adminRepository.getAll();
        adminRepository.delete(admin);
        Assertions.assertEquals(admins,adminRepository.getAll());
    }

    @Test
    void getById() {
        Admin a1=adminRepository.getById(1);
        Admin a2=adminRepository.getById(1);
        Assertions.assertEquals(a1,a2);
    }

    @Test
    void getAll() {
        List<Admin> all=adminRepository.getAll();
        List<Admin> all2=adminRepository.getAll();
        Assertions.assertEquals(all,all2);
    }
}