package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Admin;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.MolRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class LoginService {
    private final AdminRepository repositoryAdmin = AdminRepository.getInstance();
    private final MolRepository repositoryMol = MolRepository.getInstance();

    public static LoginService getInstance(){
        return LoginService.LoginServiceHolder.INSTANCE;
    }

    private static class LoginServiceHolder {
        public static final LoginService INSTANCE = new LoginService();
    }

    public ObservableList<AdminListViewModel> getAllAdmins() {
        List<Admin> admins=repositoryAdmin.getAll();

        return FXCollections.observableList(
                admins.stream().map(ad -> new AdminListViewModel(
                        ad.getUsername(),
                        ad.getPassword()
                )).collect(Collectors.toList()));
    }

    public ObservableList<MolListViewModel> getAllMols() {
        List<Mol> mols=repositoryMol.getAll();

        return FXCollections.observableList(
                mols.stream().map(m -> new MolListViewModel(
                        m.getUsername(),
                        m.getPassword()
                )).collect(Collectors.toList()));
    }

    public boolean isAdminExist(AdminListViewModel ad)
    {
       ObservableList<AdminListViewModel> allAdmins = getAllAdmins();
            for (AdminListViewModel admin : allAdmins) {
                if (admin.equals(ad)) {
                    return true;
                }
            }
            return false;
    }

    public boolean isMolExist(MolListViewModel m)
    {
        ObservableList<MolListViewModel> allMols = getAllMols();
            for (MolListViewModel mol : allMols) {
                if (mol.equals(m)) {
                    return true;
                }
            }
            return false;
        }
}
