package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerBoardRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerBoardServiceTest {
    private CustomerBoardService customerBoardService;
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
        this.condition=new Condition("random");
        this.mol=new Mol("1","12","123","1234","12345");
        this.customer=new Customer("name","0895412586","fdfsf@abv.bg");
        this.product=new Product("Computer","МА",true,null, 888.50, LocalDate.of(2020,8,1),false,condition,mol);
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
        assertEquals(null,customerBoardService.getProductsInPeriod(LocalDate.of(2030,10,10),LocalDate.of(2035,5,12)));
    }



    @Test
    void getAllBoards() {
        ObservableList<CustomerBoardListViewModel> cusBor= customerBoardService.getAllBoards();
        assertEquals(cusBor,customerBoardService.getAllBoards());
    }
}



