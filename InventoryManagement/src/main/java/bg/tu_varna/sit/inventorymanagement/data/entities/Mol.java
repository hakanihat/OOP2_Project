package bg.tu_varna.sit.inventorymanagement.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name= "mols")
@Entity
public class Mol implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mol",nullable = false)
    private  Long idMol;

    @Column(name = "mol_name")
    private  String molName;

    @Column(name = "tel_num")
    private  String telNum;

    @Column(name = "email")
    private  String email;

    @Column(name = "username",nullable = false)
    private  String username;

    @Column(name = "password",nullable = false)
    private  String password;

    @OneToMany(mappedBy = "byMol")
    private Set<Product> products = new HashSet<>();

    public Mol() {}

    public Mol( String molName, String telNum, String email, String username, String password) {
        this.molName = molName;
        this.telNum = telNum;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getPkMol() {
        return idMol;
    }

    public void setPkMol(Long pkMol) {
        this.idMol = idMol;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mol mol = (Mol) o;
        return username.equals(mol.username) && password.equals(mol.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Mol{" +
                "pkMol=" + idMol +
                ", molName='" + molName + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
