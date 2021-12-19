package bg.tu_varna.sit.inventorymanagement.data.entities;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table(name= "admins")
@Entity
public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin",nullable = false)
    private  Long idAdmin;

    @Column(name = "username",nullable = false)
    private  String username;

    @Column(name = "password",nullable = false)
    private  String password;

    public Admin() {
    }

    public Admin( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "pkAdminId=" + idAdmin;
    }
}
