package bg.tu_varna.sit.inventorymanagement.presentation.controllers;


import bg.tu_varna.sit.inventorymanagement.business.services.AmortizationService;
import bg.tu_varna.sit.inventorymanagement.business.services.ConditionService;
import bg.tu_varna.sit.inventorymanagement.business.services.MolService;
import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.MOL_VIEW;
import static bg.tu_varna.sit.inventorymanagement.presentation.controllers.LoginController.whichUser;


public class ProductController implements Initializable {

    Stage s ;
    private final ProductService productService=ProductService.getInstance();
    private final MolService molService=MolService.getInstance();
    private final AmortizationService amortizationService=AmortizationService.getInstance();
    private final ConditionService conditionService=ConditionService.getInstance();

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

    @FXML
    private Button backButton;

    private final ObservableList<String> types = FXCollections.observableArrayList("ДМА","МА");
    private final ObservableList<String> categories =
            FXCollections.observableArrayList("Категория 1","Категория 2","Категория 3","Категория 4","Категория 5");

    public ProductController(Stage stage){
        s=stage;
    }

    public void fillMols()
    {
     ObservableList<MolListViewModel> mols=molService.getAllMols();
     prod_mol.setItems(mols);

    }

    @FXML
    public void registerProductByAdmin()
    {
     ProductListViewModel addProd = new ProductListViewModel(prod_description.getText(),prodType.getValue(),date_discard.getValue(),Double.parseDouble(prod_value.getText()) ,date_exp.getValue(),conditionService.getGoodCondition(),
                molService.listViewToEntity(prod_mol.getValue()),amortizationService.stringToEntity(amortizations.getValue()));
     if(prod_description.getText().equals("") || prodType.getValue().equals("") || date_discard.getValue()==null || prod_value.getText().equals("") || date_exp.getValue()==null || prod_mol.getValue().equals(""))
     {
         Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
         alert.show();
     }
     else {
         productService.addTheProduct(addProd);
         Alert alert=new Alert(Alert.AlertType.INFORMATION,"The customer has been registered successfully!", ButtonType.OK);
         alert.show();
     }
    }

    @FXML
    public void enableAmortization()
    {
        if(prodType.getValue().equals("МА"))
            amortizations.setDisable(true);
        else if(prodType.getValue().equals("ДМА"))
            amortizations.setDisable(false);
    }

    @FXML
    public void  goBack() {
        if (whichUser)
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MOL_VIEW));
                Stage stage = new Stage();
                fxmlLoader.setController(new MolController(stage));
                Parent root2 = fxmlLoader.load();
                stage.setScene(new Scene(root2));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        else {
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                Stage stage = new Stage();
                fxmlLoader.setController(new AdminController(stage));
                Parent root1 = fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prodType.setItems(types);
        amortizations.setItems(categories);
        fillMols();

    }

}
