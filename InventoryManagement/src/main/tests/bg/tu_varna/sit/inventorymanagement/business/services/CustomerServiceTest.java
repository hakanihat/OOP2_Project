package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerServiceTest {
    private CustomerService customerService;
    private CustomerListViewModel customerListViewModel;
    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        this.customerService=CustomerService.getInstance();
        this.customerRepository=CustomerRepository.getInstance();
        this.customerListViewModel=new CustomerListViewModel("Milen","0874522958","milen@abv.bg");
    }

    @AfterEach
    void tearDown(){
        customerRepository.delete(customerService.listViewToEntity(customerListViewModel));
    }

    @Test
    void addTheCustomer() {
        Assertions.assertTrue(customerService.addTheCustomer(customerListViewModel));
    }

    @Test
    void listViewToEntity() {
        CustomerListViewModel temp = new CustomerListViewModel("test","test123","test@test");
        Assertions.assertNull(customerService.listViewToEntity(temp));
    }

    @Test
    void getAllCustomers() {
        ObservableList<CustomerListViewModel> cus= customerService.getAllCustomers();
        assertEquals(cus,customerService.getAllCustomers());
    }
}