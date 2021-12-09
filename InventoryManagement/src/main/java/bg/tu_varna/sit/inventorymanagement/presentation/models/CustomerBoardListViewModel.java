package bg.tu_varna.sit.inventorymanagement.presentation.models;

import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;

import java.time.LocalDate;

public class CustomerBoardListViewModel {
    private Customer byCustomer;
    private Product byInventoryNumber;
    private LocalDate registeredDate;
    private LocalDate returnDate;

    public CustomerBoardListViewModel() {
    }

    public CustomerBoardListViewModel(Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate, LocalDate returnDate) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
    }

    public CustomerBoardListViewModel(Customer byCustomer) {
        this.byCustomer = byCustomer;
    }

    public CustomerBoardListViewModel(Customer byCustomer, Product byInventoryNumber) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
    }

    public Customer getByCustomer() {
        return byCustomer;
    }

    public void setByCustomer(Customer byCustomer) {
        this.byCustomer = byCustomer;
    }

    public Product getByInventoryNumber() {
        return byInventoryNumber;
    }

    public void setByInventoryNumber(Product byInventoryNumber) {
        this.byInventoryNumber = byInventoryNumber;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomerBoardListViewModel{" +
                "byCustomer=" + byCustomer +
                ", byInventoryNumber=" + byInventoryNumber ;
    }
}
