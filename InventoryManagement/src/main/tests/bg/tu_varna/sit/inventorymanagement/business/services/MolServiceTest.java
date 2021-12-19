package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MolServiceTest {
    private MolService molService;

    @BeforeEach
    void setUp() {
        this.molService=MolService.getInstance();
    }

    @Test
    void getAllMols() {
        ObservableList<MolListViewModel> mols= molService.getAllMols();
        assertEquals(mols,molService.getAllMols());
    }

    @Test
    void listViewToEntity() {
        MolListViewModel temp = new MolListViewModel("mol","molPass");
        Assertions.assertNull(molService.listViewToEntity(temp));
    }
}