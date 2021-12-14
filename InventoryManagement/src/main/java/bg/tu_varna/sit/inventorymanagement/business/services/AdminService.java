package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Admin;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;


public class AdminService {
    private static final Logger log= Logger.getLogger(AdminService.class);
    private final AdminRepository repositoryAdmin = AdminRepository.getInstance();

    public static AdminService getInstance(){
        return AdminServiceHolder.INSTANCE;
    }

    private static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
    }


    public ObservableList<AdminListViewModel> getAllAdmin(){
        List<Admin> admins = repositoryAdmin.getAll();

        if(admins!= null)
        {
        return FXCollections.observableList(
                admins.stream().map(a -> new AdminListViewModel(
                        a.getUsername(),
                        a.getPassword()
                )).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any admins in database!");
            return null;
        }
    }
}
