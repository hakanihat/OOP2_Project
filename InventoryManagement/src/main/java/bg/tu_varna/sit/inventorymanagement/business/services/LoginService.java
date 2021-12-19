package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.MolRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import javafx.collections.ObservableList;

public class LoginService {
    private final AdminRepository repositoryAdmin = AdminRepository.getInstance();
    private final MolRepository repositoryMol = MolRepository.getInstance();
    private final AdminService adminService= AdminService.getInstance();
    private final MolService molService= MolService.getInstance();

    public static LoginService getInstance(){
        return LoginService.LoginServiceHolder.INSTANCE;
    }

    private static class LoginServiceHolder {
        public static final LoginService INSTANCE = new LoginService();
    }

    public boolean isAdminExist(AdminListViewModel ad)
    {
       ObservableList<AdminListViewModel> allAdmins = adminService.getAllAdmin();
            for (AdminListViewModel admin : allAdmins) {
                if (admin.equals(ad)) {
                    return true;
                }
            }
            return false;
    }

    public boolean isMolExist(MolListViewModel m)
    {
        ObservableList<MolListViewModel> allMols = molService.getAllMols();
            for (MolListViewModel mol : allMols) {
                if (mol.equals(m)) {
                    return true;
                }
            }
            return false;
        }
}
