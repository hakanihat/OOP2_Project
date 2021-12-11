package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Table(name= "customer_boards")
@Entity
public class CustomerBoard  implements  Serializable{
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_board",nullable = false)
    private  int idCustomerBoard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private Customer byCustomer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inventory_number")
    private Product byInventoryNumber;

    @Column(name = "registered_date")
    private LocalDate registeredDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public CustomerBoard() {}

    public CustomerBoard(Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate, LocalDate returnDate) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
    }

    public CustomerBoard(int idCustomerBoard, Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate, LocalDate returnDate) {
        this.idCustomerBoard=idCustomerBoard;
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
    }

    public CustomerBoard(Customer byCustomer, Product byInventoryNumber, LocalDate registeredDate) {
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
    }

    public int getIdCustomerBoard() {
        return idCustomerBoard;
    }

    public void setIdCustomerBoard(int idCustomerBoard) {
        this.idCustomerBoard = idCustomerBoard;
    }

    public int getPkCustomerBoard() {
        return idCustomerBoard;
    }

    public void setPkCustomerBoard(int pkCustomerBoard) {
        this.idCustomerBoard = pkCustomerBoard;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBoard board = (CustomerBoard) o;
        return Objects.equals(byCustomer, board.byCustomer) && Objects.equals(byInventoryNumber, board.byInventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byCustomer, byInventoryNumber);
    }

    @Override
    public String toString() {
        return "CustomerBoard{" +
                "pkCustomerBoard=" + idCustomerBoard +
                ", byCustomer=" + byCustomer +
                ", byInventoryNumber=" + byInventoryNumber +
                ", registeredDate=" + registeredDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
