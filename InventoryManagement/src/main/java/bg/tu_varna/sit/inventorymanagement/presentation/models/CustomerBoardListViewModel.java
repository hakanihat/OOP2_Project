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

    public CustomerBoardListViewModel(int idCustomerBoard, Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate, LocalDate returnDate) {
        this.idCustomerBoard = idCustomerBoard;
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
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

    public CustomerBoardListViewModel(Customer byCustomer) {
        this.byCustomer = byCustomer;
    }

    public CustomerBoardListViewModel(Customer byCustomer, Product byInventoryNumber) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
    }

    public int getIdCustomerBoard() {
        return idCustomerBoard;
    }

    public void setIdCustomerBoard(int idCustomerBoard) {
        this.idCustomerBoard = idCustomerBoard;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBoardListViewModel that = (CustomerBoardListViewModel) o;
        return Objects.equals(byCustomer, that.byCustomer) && Objects.equals(byInventoryNumber, that.byInventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byCustomer, byInventoryNumber);
    }
}
