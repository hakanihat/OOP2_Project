package bg.tu_varna.sit.inventorymanagement.presentation.models;

import java.util.Objects;

public class AdminListViewModel {
    private  String username;
    private  String password;

    public AdminListViewModel() {
    }

    public AdminListViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminListViewModel that = (AdminListViewModel) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return String.format("%s | %s", username , password);
    }
}
