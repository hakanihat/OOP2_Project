package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Table(name= "customer_boards")
@Entity
public class CustomerBoard  implements  Serializable{
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_board",nullable = false)
    private  Long idCustomerBoard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private Customer byCustomer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inventory_number")
    private Product byInventoryNumber;

    @Column(name = "registered_date")
    private Date registeredDate;

    @Column(name = "return_date")
    private Date returnDate;

    public CustomerBoard() {}

    public CustomerBoard(Long idCustomerBoard, Customer byCustomer, Product byInventoryNumber, Date registeredDate, Date returnDate) {
        this.idCustomerBoard = idCustomerBoard;
        this.byCustomer = byCustomer;
        this.byInventoryNumber = byInventoryNumber;
        this.registeredDate = registeredDate;
        this.returnDate = returnDate;
    }

    public Long getPkCustomerBoard() {
        return idCustomerBoard;
    }

    public void setPkCustomerBoard(Long pkCustomerBoard) {
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
                "pkCustomerBoard=" + idCustomerBoard +
                ", byCustomer=" + byCustomer +
                ", byInventoryNumber=" + byInventoryNumber +
                ", registeredDate=" + registeredDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
