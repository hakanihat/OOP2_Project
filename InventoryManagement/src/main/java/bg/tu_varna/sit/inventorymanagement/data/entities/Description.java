package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name= "descriptions")
@Entity

public class Description implements  Serializable{
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Description",nullable = false)
    private  Long pkDescription;

    @Column(name = "description")
    private  String description;

    @OneToMany(mappedBy = "byDescription")
    private Set<Product> products = new HashSet<>();

    public Description() {}

    public Description(String description, Set<Product> products) {
        this.description = description;
        this.products = products;
    }

    public Long getPkDescription() {
        return pkDescription;
    }

    public void setPkDescription(Long pkDescription) {
        this.pkDescription = pkDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Description{" +
                "pkDescription=" + pkDescription +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
