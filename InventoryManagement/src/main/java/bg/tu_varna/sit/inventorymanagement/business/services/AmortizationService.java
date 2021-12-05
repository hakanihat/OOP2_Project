package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Admin;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AmortizationRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AmortizationListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class AmortizationService {
    private final AmortizationRepository repositoryAmortization = AmortizationRepository.getInstance();

    public static AmortizationService getInstance(){
        return AmortizationService.AmortizationServiceHolder.INSTANCE;
    }

    private static class AmortizationServiceHolder {
        public static final AmortizationService INSTANCE = new AmortizationService();
    }


    public ObservableList<AmortizationListViewModel> getAllAmortizations(){
        List<Amortization> amorts = repositoryAmortization.getAll();

        return FXCollections.observableList(
                amorts.stream().map(a -> new AmortizationListViewModel(a.getIdAmortization()
                )).collect(Collectors.toList()));
    }
}
