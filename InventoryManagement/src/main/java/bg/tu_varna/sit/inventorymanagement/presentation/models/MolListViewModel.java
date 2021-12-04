package bg.tu_varna.sit.inventorymanagement.presentation.models;

import bg.tu_varna.sit.inventorymanagement.data.entities.Product;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MolListViewModel {
    private  String molName;
    private  String telNum;
    private  String email;
    private  String username;
    private  String password;
    private Set<Product> products = new HashSet<>();

    public MolListViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getMolName() {
        return molName;
    }

    public void setMolName(String molName) {
        this.molName = molName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MolListViewModel that = (MolListViewModel) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
