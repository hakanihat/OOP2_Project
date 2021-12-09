package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.CustomerBoard;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerBoardRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerBoardService {
    private final CustomerBoardRepository repositoryCustomerBoard = CustomerBoardRepository.getInstance();

    public static CustomerBoardService getInstance(){
        return CustomerBoardService.CustomerBoardServiceHolder.INSTANCE;
    }

    private static class CustomerBoardServiceHolder {
        public static final CustomerBoardService INSTANCE = new CustomerBoardService();
    }


    public ObservableList<CustomerBoardListViewModel> getAllBoards(){
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();

        return FXCollections.observableList(
                customerBoards.stream().map(cb -> new CustomerBoardListViewModel(
                        cb.getByCustomer()
                )).collect(Collectors.toList()));
    }
}
