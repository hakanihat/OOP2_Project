package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name= "products")
@Entity
public class Product implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PK_inventory_number",nullable = false)
    private  Long pkInventoryNumber;

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
    @JoinColumn(name = "PK_Condition")
    private Condition byCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Product_type")
    private ProductType byProductType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOL_PK_MOL")
    private Mol byMol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PK_Description")
    private Description byDescription;

    @OneToMany(mappedBy = "byInventoryNumber")
    private Set<CustomerBoard> products = new HashSet<>();

    public Product() {}

    public Long getPkInventoryNumber() {
        return pkInventoryNumber;
    }

    public void setPkInventoryNumber(Long pkInventoryNumber) {
        this.pkInventoryNumber = pkInventoryNumber;
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

    public ProductType getByProductType() {
        return byProductType;
    }

    public void setByProductType(ProductType byProductType) {
        this.byProductType = byProductType;
    }

    public Mol getByMol() {
        return byMol;
    }

    public void setByMol(Mol byMol) {
        this.byMol = byMol;
    }

    public Description getByDescription() {
        return byDescription;
    }

    public void setByDescription(Description byDescription) {
        this.byDescription = byDescription;
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
                "pkInventoryNumber=" + pkInventoryNumber +
                ", prodStatus=" + prodStatus +
                ", discardDate=" + discardDate +
                ", productValue=" + productValue +
                ", exploatationStart=" + exploatationStart +
                ", isDiscarded=" + isDiscarded +
                ", byCondition=" + byCondition +
                ", byProductType=" + byProductType +
                ", byMol=" + byMol +
                ", byDescription=" + byDescription +
                ", products=" + products +
                '}';
    }
}
