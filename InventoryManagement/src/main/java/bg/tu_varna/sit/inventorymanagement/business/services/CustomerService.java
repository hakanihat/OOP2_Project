package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;

public class CustomerService {
    private final CustomerRepository repositoryCustomer = CustomerRepository.getInstance();

    public static CustomerService getInstance(){
        return CustomerService.CustomerServiceHolder.INSTANCE;
    }

    private static class CustomerServiceHolder {
        public static final CustomerService INSTANCE = new CustomerService();
    }

    public void addTheCustomer(CustomerListViewModel c)
    {
        Customer customer=new Customer(c.getCusName(), c.getTelNum(), c.getEmail());
        repositoryCustomer.save(customer);
    }
}
