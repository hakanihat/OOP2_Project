package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Admin;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    private final AdminRepository repositoryAdmin = AdminRepository.getInstance();

    public static AdminService getInstance(){
        return AdminServiceHolder.INSTANCE;
    }

    private static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
    }


    public ObservableList<AdminListViewModel> getAllAdmin(){
        List<Admin> admins = repositoryAdmin.getAll();

        return FXCollections.observableList(
                admins.stream().map(a -> new AdminListViewModel(
                        a.getUsername(),
                        a.getPassword()
                )).collect(Collectors.toList()));
    }
}
