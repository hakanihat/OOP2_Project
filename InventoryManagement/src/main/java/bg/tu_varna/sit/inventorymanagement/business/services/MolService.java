package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.MolRepository;

public class MolService {
    private final MolRepository repositoryMol = MolRepository.getInstance();

    public static MolService getInstance(){
        return MolService.MolServiceHolder.INSTANCE;
    }

    private static class MolServiceHolder {
        public static final MolService INSTANCE = new MolService();
    }
}
