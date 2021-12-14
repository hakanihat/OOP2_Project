package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        this.adminService=AdminService.getInstance();
    }

    @Test
    void getAllAdmin() {
        ObservableList<AdminListViewModel> admins=adminService.getAllAdmin();
        assertEquals(admins,adminService.getAllAdmin());
    }
}