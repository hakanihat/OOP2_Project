package bg.tu_varna.sit.inventorymanagement.data.entities;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

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
    public String toString() {
        return "Admin{" +
                "pkAdminId=" + idAdmin +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
