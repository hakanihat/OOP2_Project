package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name= "product_types")
@Entity
public class ProductType implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Product_type",nullable = false)
    private  Long pkProductType;

    @Column(name = "Product_type")
    private  String productType;

    @Column(name = "amort_deg")
    private  String amortDeg;

    @OneToMany(mappedBy = "byProductType")
    private Set<Product> products = new HashSet<>();

    public ProductType() {}

    public ProductType(Long pkProductType, String productType, String amortDeg, Set<Product> products) {
        this.pkProductType = pkProductType;
        this.productType = productType;
        this.amortDeg = amortDeg;
        this.products = products;
    }

    public Long getPkProductType() {
        return pkProductType;
    }

    public void setPkProductType(Long pkProductType) {
        this.pkProductType = pkProductType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAmortDeg() {
        return amortDeg;
    }

    public void setAmortDeg(String amortDeg) {
        this.amortDeg = amortDeg;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "pkProductType=" + pkProductType +
                ", productType='" + productType + '\'' +
                ", amortDeg='" + amortDeg + '\'' +
                ", products=" + products +
                '}';
    }
}
