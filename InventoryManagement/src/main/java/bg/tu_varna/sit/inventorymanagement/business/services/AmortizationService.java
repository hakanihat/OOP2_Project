package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AmortizationRepository;
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

    public Amortization stringToEntity(String s){
        if(s=="Категория 1") {
            Amortization a = repositoryAmortization.getById(1);
            return a;
        }
       else if(s=="Категория 2") {
            Amortization a = repositoryAmortization.getById(2);
            return a;
        }
       else if(s=="Категория 3") {
            Amortization a = repositoryAmortization.getById(3);
            return a;
        }
       else if(s=="Категория 4") {
            Amortization a = repositoryAmortization.getById(4);
            return a;
        }
       else if(s=="Категория 5") {
            Amortization a = repositoryAmortization.getById(5);
            return a;
        }
       else return null;
    }
}
