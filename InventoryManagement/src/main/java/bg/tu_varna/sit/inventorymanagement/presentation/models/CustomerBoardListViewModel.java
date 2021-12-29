package bg.tu_varna.sit.inventorymanagement.presentation.models;

import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;

import java.time.LocalDate;
import java.util.Objects;

public class CustomerBoardListViewModel {
    private  int idCustomerBoard;
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

    public CustomerBoardListViewModel(Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate=null;
    }


    public int getIdCustomerBoard() {
        return idCustomerBoard;
    }

    public Customer getByCustomer() {
        return byCustomer;
    }

    public Product getByInventoryNumber() {
        return byInventoryNumber;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBoardListViewModel that = (CustomerBoardListViewModel) o;
        return Objects.equals(byCustomer, that.byCustomer) && Objects.equals(byInventoryNumber, that.byInventoryNumber);
    }

    @Override
    public String toString() {
        return "CustomerBoardListViewModel{" +
                "byCustomer=" + byCustomer +
                ", byInventoryNumber=" + byInventoryNumber ;
    }

}
