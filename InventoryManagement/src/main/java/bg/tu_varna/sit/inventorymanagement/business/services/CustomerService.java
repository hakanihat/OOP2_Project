package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository repositoryCustomer = CustomerRepository.getInstance();

    public static CustomerService getInstance(){
        return CustomerService.CustomerServiceHolder.INSTANCE;
    }

    private static class CustomerServiceHolder {
        public static final CustomerService INSTANCE = new CustomerService();
    }

    public boolean addTheCustomer(CustomerListViewModel c)
    {   List<Customer> customers = repositoryCustomer.getAll();
        Customer customer=new Customer(c.getCusName(), c.getTelNum(), c.getEmail());
        for(Customer cus: customers ){
            if(cus.equals(customer))
                return false;
        }
        repositoryCustomer.save(customer);
        return true;
    }

    public Customer listViewToEntity(CustomerListViewModel c){
        Customer temp = new Customer(c.getCusName(),c.getTelNum(),c.getEmail());
        List<Customer> customers = repositoryCustomer.getAll();
        for (Customer customer: customers) {
            if(customer.equals(temp))
                return customer;
        }
        return null;
    }

    public ObservableList<CustomerListViewModel> getAllCustomers() {
        List<Customer> customers = repositoryCustomer.getAll();

        return FXCollections.observableList(
                customers.stream().map(c -> new CustomerListViewModel(
                        c.getPkCustomer(),c.getCusName(),c.getTelNum(),c.getEmail()
                )).collect(Collectors.toList()));
    }
}
