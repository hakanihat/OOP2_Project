package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name= "products")
@Entity
public class Product implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_inventory_number",nullable = false)
    private  int idInventoryNumber;

    @Column(name = "description")
    private  String description;

    @Column(name = "product_type")
    private  String prodType;

    @Column(name = "prod_status")
    private  boolean prodStatus;

    @Column(name = "discard_date")
    private LocalDate discardDate;

    @Column(name = "product_value")
    private double productValue;

    @Column(name = "exploatation_start")
    private LocalDate exploatationStart;

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

    public Product(int idInventoryNumber, String description) {
        this.idInventoryNumber = idInventoryNumber;
        this.description = description;
    }

    public Product(String description, String prodType, boolean prodStatus, LocalDate discardDate, double productValue, LocalDate exploatationStart, boolean isDiscarded, Condition byCondition, Mol byMol, Amortization byAmortization) {
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = prodStatus;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.isDiscarded = isDiscarded;
        this.byCondition = byCondition;
        this.byMol = byMol;
        this.byAmortization = byAmortization;

    }

    public Product(String description, String prodType, boolean prodStatus, LocalDate discardDate, double productValue, LocalDate exploatationStart, boolean isDiscarded, Condition byCondition, Mol byMol) {
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = prodStatus;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.isDiscarded = isDiscarded;
        this.byCondition = byCondition;
        this.byMol = byMol;

    }
    public int getIdInventoryNumber() {
        return idInventoryNumber;
    }

    public void setIdInventoryNumber(int idInventoryNumber) {
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

    public LocalDate getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(LocalDate discardDate) {
        this.discardDate = discardDate;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public LocalDate getExploatationStart() {
        return exploatationStart;
    }

    public void setExploatationStart(LocalDate exploatationStart) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idInventoryNumber, product.idInventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInventoryNumber);
    }

    public void setProducts(Set<CustomerBoard> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return  description ;
    }
}
