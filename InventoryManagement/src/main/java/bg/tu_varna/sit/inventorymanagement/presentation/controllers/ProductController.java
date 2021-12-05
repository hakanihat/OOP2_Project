package bg.tu_varna.sit.inventorymanagement.presentation.controllers;


import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import bg.tu_varna.sit.inventorymanagement.business.services.AmortizationService;
import bg.tu_varna.sit.inventorymanagement.business.services.MolService;
import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AmortizationListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    Stage s ;
    private final ProductService productService=ProductService.getInstance();
    private final MolService molService=MolService.getInstance();
    public ProductController(Stage stage){
        s=stage;
    }
    @FXML
    private TextField prod_description;

    @FXML
    private ComboBox<String> prodType;

    @FXML
    private TextField prod_value;

    @FXML
    private DatePicker date_exp;

    @FXML
    private DatePicker date_discard;

    @FXML
    private ComboBox<MolListViewModel> prod_mol;

    @FXML
    private ComboBox<String> amortizations;

    @FXML
    private Button prodButton;

    private ObservableList<String> types = FXCollections.observableArrayList("ДМА","МА");
    private ObservableList<String> categories =
            FXCollections.observableArrayList("Категория 1","Категория 2","Категория 3","Категория 4","Категория 5");

    public void fillMols()
    {
     ObservableList<MolListViewModel> mols=molService.getAllMols();
     prod_mol.setItems(mols);

    }

    @FXML
    /*public void registerProductByAdmin()
    { ProductListViewModel addProd = new ProductListViewModel(prod_description.getText(),prodType.getValue(),prod_value.getText(),date_exp.getValue(),
            date_discard.getValue(),prod_mol.getValue(),amortizations.getValue());
        productService.addTheProduct(addProd);

    }*/ // Registrirai produkta!!!


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prodType.setItems(types);
        amortizations.setItems(categories);
        fillMols();

    }
}
