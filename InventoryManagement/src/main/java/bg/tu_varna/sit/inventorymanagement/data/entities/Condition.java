package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name= "conditions")
@Entity
public class Condition implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condition",nullable = false)
    private  Long idCondition;

    @Column(name = "prod_condition")
    private  String prodCondition;

    @OneToMany(mappedBy = "byCondition")
    private Set<Product> products = new HashSet<>();

    public Condition() {}

    public Condition(String prodCondition) {
        this.prodCondition = prodCondition;
    }

    public Long getPkCondition() {
        return idCondition;
    }

    public void setPkCondition(Long idCondition) {
        this.idCondition = idCondition;
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
                "idCondition=" + idCondition +
                ", prodCondition='" + prodCondition + '\'' +
                '}';
    }

}
