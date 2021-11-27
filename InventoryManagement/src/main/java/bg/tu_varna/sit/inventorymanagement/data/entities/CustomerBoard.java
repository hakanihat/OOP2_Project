package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name= "customer_boards")
@Entity
public class CustomerBoard  implements  Serializable{
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Customer_board",nullable = false)
    private  Long pkCustomerBoard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Customer")
    private Customer byCustomer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_inventory_number")
    private Product byInventoryNumber;

    @Column(name = "registered_date")
    private Date registeredDate;

    @Column(name = "return_date")
    private Date returnDate;

    public CustomerBoard() {}

    public CustomerBoard(Long pkCustomerBoard, Customer byCustomer, Product byInventoryNumber, Date registeredDate, Date returnDate) {
        this.pkCustomerBoard = pkCustomerBoard;
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
    }

    public Long getPkCustomerBoard() {
        return pkCustomerBoard;
    }

    public void setPkCustomerBoard(Long pkCustomerBoard) {
        this.pkCustomerBoard = pkCustomerBoard;
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

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomerBoard{" +
                "pkCustomerBoard=" + pkCustomerBoard +
                ", byCustomer=" + byCustomer +
                ", byInventoryNumber=" + byInventoryNumber +
                ", registeredDate=" + registeredDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
