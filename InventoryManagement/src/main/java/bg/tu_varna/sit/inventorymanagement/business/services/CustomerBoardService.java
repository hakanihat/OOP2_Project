package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.CustomerBoard;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerBoardRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerBoardService {
    private final CustomerBoardRepository repositoryCustomerBoard = CustomerBoardRepository.getInstance();
    private final ProductService productService=ProductService.getInstance();



    public static CustomerBoardService getInstance(){
        return CustomerBoardService.CustomerBoardServiceHolder.INSTANCE;
    }


    private static class CustomerBoardServiceHolder {
        public static final CustomerBoardService INSTANCE = new CustomerBoardService();
    }


    public boolean addToTheBoard(CustomerBoardListViewModel cb) {
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();
        CustomerBoard customerBoard=new CustomerBoard(cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate());
        int num;
        Product prod=new Product();
        for(CustomerBoard board: customerBoards ){
            if(board.equals(customerBoard))
            { num=board.getByInventoryNumber().getIdInventoryNumber();
            prod=productService.getProductById(num);
            if( prod.isProdStatus()==false)
            { return false;}
            break;
            }
        }

        productService.changeStatus(prod);
        repositoryCustomerBoard.save(customerBoard);
        return true;
    }


    public CustomerBoard listViewToEntity(CustomerBoardListViewModel cb){
        CustomerBoard temp = new CustomerBoard(cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate());
        List<CustomerBoard> boards = repositoryCustomerBoard.getAll();
        for (CustomerBoard board: boards) {
            if(board.equals(temp))
                return board;
        }
        return null;
    }

    public ObservableList<CustomerBoardListViewModel> getAllBoards(){
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();

        return FXCollections.observableList(
                customerBoards.stream().map(cb -> new CustomerBoardListViewModel(
                        cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate()
                )).collect(Collectors.toList()));
    }
}
