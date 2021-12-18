package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name= "amortization")
@Entity
public class Amortization implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_amortization",nullable = false)
    private  Long idAmortization;

    @Column(name = "amort_deg")
    private  double amortDeg;

    @OneToOne(mappedBy = "byAmortization")
    private Product product;

    public Amortization() {}

    public Amortization(Long idAmortization, double amortDeg, Product product) {
        this.idAmortization = idAmortization;
        this.amortDeg = amortDeg;
        this.product = product;
    }

    public Long getIdAmortization() {
        return idAmortization;
    }

    public void setIdAmortization(Long idAmortization) {
        this.idAmortization = idAmortization;
    }

    public double getAmortDeg() {
        return amortDeg;
    }

    public void setAmortDeg(double amortDeg) {
        this.amortDeg = amortDeg;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amortization that = (Amortization) o;
        return Double.compare(that.amortDeg, amortDeg) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amortDeg);
    }

    @Override
    public String toString() {
        return  " "+idAmortization;
    }
}