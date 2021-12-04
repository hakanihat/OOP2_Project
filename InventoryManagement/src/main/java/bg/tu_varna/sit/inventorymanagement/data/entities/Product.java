package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name= "products")
@Entity
public class Product implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_inventory_number",nullable = false)
    private  Long idInventoryNumber;

    @Column(name = "description")
    private  String description;

    @Column(name = "product_type")
    private  String prodType;

    @Column(name = "prod_status")
    private  boolean prodStatus;

    @Column(name = "discard_date")
    private Date discardDate;

    @Column(name = "product_value")
    private double productValue;

    @Column(name = "exploatation_start")
    private Date exploatationStart;

    @Column(name = "is_discarded")
    private boolean isDiscarded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_condition")
    private Condition byCondition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_amortization", referencedColumnName = "id_amortization")
    private Amortization byAmortization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mol")
    private Mol byMol;


    @OneToMany(mappedBy = "byInventoryNumber")
    private Set<CustomerBoard> products = new HashSet<>();

    public Product() {}

    public Long getIdInventoryNumber() {
        return idInventoryNumber;
    }

    public void setIdInventoryNumber(Long idInventoryNumber) {
        this.idInventoryNumber = idInventoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public boolean isProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(boolean prodStatus) {
        this.prodStatus = prodStatus;
    }

    public Date getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(Date discardDate) {
        this.discardDate = discardDate;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public Date getExploatationStart() {
        return exploatationStart;
    }

    public void setExploatationStart(Date exploatationStart) {
        this.exploatationStart = exploatationStart;
    }

    public boolean isDiscarded() {
        return isDiscarded;
    }

    public void setDiscarded(boolean discarded) {
        isDiscarded = discarded;
    }

    public Condition getByCondition() {
        return byCondition;
    }

    public void setByCondition(Condition byCondition) {
        this.byCondition = byCondition;
    }

    public Amortization getByAmortization() {
        return byAmortization;
    }

    public void setByAmortization(Amortization byAmortization) {
        this.byAmortization = byAmortization;
    }

    public Mol getByMol() {
        return byMol;
    }

    public void setByMol(Mol byMol) {
        this.byMol = byMol;
    }

    public Set<CustomerBoard> getProducts() {
        return products;
    }

    public void setProducts(Set<CustomerBoard> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idInventoryNumber=" + idInventoryNumber +
                ", description='" + description + '\'' +
                ", prodType='" + prodType + '\'' +
                ", prodStatus=" + prodStatus +
                ", discardDate=" + discardDate +
                ", productValue=" + productValue +
                ", exploatationStart=" + exploatationStart +
                ", isDiscarded=" + isDiscarded +
                ", byCondition=" + byCondition +
                ", byAmortization=" + byAmortization +
                ", byMol=" + byMol +
                ", products=" + products +
                '}';
    }
}
