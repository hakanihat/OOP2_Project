package bg.tu_varna.sit.inventorymanagement.data.entities;


import javax.persistence.*;
import java.io.Serializable;

@Table(name= "admins")
@Entity
public class Admin implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Admin_id",nullable = false)
    private  Long pkAdminId;

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
        return pkAdminId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long pkAdminId) {
        this.pkAdminId = pkAdminId;
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
                "pkAdminId=" + pkAdminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
