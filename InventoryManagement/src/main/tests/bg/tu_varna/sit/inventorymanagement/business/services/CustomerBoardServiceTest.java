package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.*;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerBoardRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBoardServiceTest {
    private CustomerBoardService customerBoardService;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private CustomerBoard customerBoard;
    private CustomerBoardRepository customerBoardRepository;
    private CustomerBoardListViewModel customerBoardListViewModel;
    private Customer customer;
    private Product product;
    private Condition condition;
    private Mol mol;

    @BeforeEach
    void setUp() {
        this.customerBoardService=customerBoardService.getInstance();
        this.customerBoardRepository= customerBoardRepository.getInstance();
        this.customerRepository=customerRepository.getInstance();
        this.productRepository=productRepository.getInstance();
        this.condition=new Condition("random");
        this.mol=new Mol("1","12","123","1234","12345");
        this.customer= customerRepository.getById(1);
        this.product=productRepository.getById(1);
        this.customerBoardListViewModel=new CustomerBoardListViewModel(customer,product, LocalDate.of(2020,8,16));

    }

    @Test
    void addToTheBoard() {


        assertEquals(2,customerBoardService.addToTheBoard(customerBoardListViewModel));//trqbva da vzemesh slujitel i product ot bazata
    }

    @Test
    void returnTheProduct() {
        assertTrue(customerBoardService.returnTheProduct(customerBoardListViewModel));
    }

    @Test
    void getProductsInPeriod() {
        List<CustomerBoard> temp = new ArrayList<>();
        assertEquals(temp,customerBoardService.getProductsInPeriod(LocalDate.of(2030,10,10),LocalDate.of(2035,5,12)));
    }



    @Test
    void getAllBoards() {
        ObservableList<CustomerBoardListViewModel> cusBor= customerBoardService.getAllBoards();
        assertEquals(cusBor,customerBoardService.getAllBoards());
    }
}



