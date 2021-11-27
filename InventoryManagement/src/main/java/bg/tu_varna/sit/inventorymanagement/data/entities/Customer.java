package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name= "customers")
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Customer",nullable = false)
    private  Long pkCustomer;

    @Column(name = "cus_name")
    private  String cusName;

    @Column(name = "tel_num")
    private  String telNum;

    @Column(name = "email")
    private  String email;

    @OneToMany(mappedBy = "byCustomer")
    private Set<CustomerBoard> customers = new HashSet<>();

    public Customer() {}

    public Customer(Long pkCustomer, String cusName, String telNum, String email, Set<CustomerBoard> customers) {
        this.pkCustomer = pkCustomer;
        this.cusName = cusName;
        this.telNum = telNum;
        this.email = email;
        this.customers = customers;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Set<CustomerBoard> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerBoard> customers) {
        this.customers = customers;
    }

    public Long getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(Long pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "pkCustomer=" + pkCustomer +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
