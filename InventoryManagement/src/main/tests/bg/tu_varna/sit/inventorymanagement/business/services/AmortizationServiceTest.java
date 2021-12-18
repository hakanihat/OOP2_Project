package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AmortizationRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AmortizationListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmortizationServiceTest {
    private AmortizationService amortizationService;
    private AmortizationRepository amortizationRepository;
    private Amortization amortization;

    @BeforeEach
    void setUp() {
        this.amortizationService=AmortizationService.getInstance();
        this.amortizationRepository=AmortizationRepository.getInstance();
        this.amortization=amortizationRepository.getById(1);

    }

    @Test
    void getAllAmortizations() {
        ObservableList<AmortizationListViewModel> amortizations= amortizationService.getAllAmortizations();
        assertEquals(amortizations,amortizationService.getAllAmortizations());
    }

    @Test
    void stringToEntity() {
        assertEquals(amortization,amortizationService.stringToEntity("Категория 1"));
    }
}