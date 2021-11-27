package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name= "conditions")
@Entity
public class Condition implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Condition",nullable = false)
    private  Long pkCondition;

    @Column(name = "prod_condition")
    private  String prodCondition;

    @OneToMany(mappedBy = "byCondition")
    private Set<Product> products = new HashSet<>();

    public Condition() {}

    public Condition(String prodCondition, Set<Product> products) {
        this.prodCondition = prodCondition;
        this.products = products;
    }

    public Long getPkCondition() {
        return pkCondition;
    }

    public void setPkCondition(Long pkCondition) {
        this.pkCondition = pkCondition;
    }

    public String getProdCondition() {
        return prodCondition;
    }

    public void setProdCondition(String prodCondition) {
        this.prodCondition = prodCondition;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "pkCondition=" + pkCondition +
                ", prodCondition='" + prodCondition + '\'' +
                '}';
    }
}
