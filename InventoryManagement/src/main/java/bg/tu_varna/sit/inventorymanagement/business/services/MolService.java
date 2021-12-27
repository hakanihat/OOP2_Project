package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.data.repositories.MolRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class MolService {
    private final MolRepository repositoryMol = MolRepository.getInstance();
    private static final Logger log= Logger.getLogger(AdminService.class);

    public static MolService getInstance(){
        return MolService.MolServiceHolder.INSTANCE;
    }

    private static class MolServiceHolder {
        public static final MolService INSTANCE = new MolService();
    }

    public ObservableList<MolListViewModel> getAllMols(){
        List<Mol> mols = repositoryMol.getAll();
        if(mols!= null) {
            return FXCollections.observableList(
                    mols.stream().map(m -> new MolListViewModel(m.getUsername(),
                            m.getTelNum(), m.getEmail(), m.getUsername(), m.getPassword()
                    )).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any mols in database!");
            return null;
        }
    }

    public Mol listViewToEntity(MolListViewModel m){
        Mol temp = new Mol(m.getMolName(),m.getTelNum(),m.getEmail(),m.getUsername(),m.getPassword());
        List<Mol> mols = repositoryMol.getAll();
        for (Mol mol: mols) {
            if(mol.equals(temp))
                return mol;
        }
        return null;
    }
}
