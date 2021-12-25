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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mol")
    private Mol byMol;


    @OneToMany(mappedBy = "byInventoryNumber")
    private Set<CustomerBoard> products = new HashSet<>();

    public Product() {}

    public Product(int idInventoryNumber, String description) {
        this.idInventoryNumber = idInventoryNumber;
        this.description = description;
    }

    public Product(int idInventoryNumber, boolean prodStatus) {
        this.idInventoryNumber = idInventoryNumber;
        this.prodStatus = prodStatus;
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

    public String getDescription() {
        return description;
    }

    public String getProdType() {
        return prodType;
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

    public double getProductValue() {
        return productValue;
    }

    public LocalDate getExploatationStart() {
        return exploatationStart;
    }

    public boolean isDiscarded() {
        return isDiscarded;
    }

    public Amortization getByAmortization() {
        return byAmortization;
    }

    public Mol getByMol() {
        return byMol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idInventoryNumber, product.idInventoryNumber);
    }


    @Override
    public String toString() {
        return idInventoryNumber+"-"+ description ;
    }
}
