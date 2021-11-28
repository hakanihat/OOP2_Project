package bg.tu_varna.sit.inventorymanagement.presentation.models;

public class AdminListViewModel {
    private final String username;
    private final String password;

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
    public String toString() {
        return String.format("%s | %s", username , password);
    }
}
