package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginServiceTest {
    private LoginService loginService;
    private AdminListViewModel adminListViewModel;
    private MolListViewModel molListViewModel;

    @BeforeEach
    void setUp() {
        this.loginService=LoginService.getInstance();
        adminListViewModel=new AdminListViewModel("a1","1");
        molListViewModel= new MolListViewModel("t1","123");
    }


    @Test
    void isAdminExist() {
        assertTrue(loginService.isAdminExist(adminListViewModel));
    }

    @Test
    void isMolExist() {
        assertTrue(loginService.isMolExist( molListViewModel));
    }
}