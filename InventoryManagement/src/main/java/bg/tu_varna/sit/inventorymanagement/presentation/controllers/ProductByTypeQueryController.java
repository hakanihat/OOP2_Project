package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.MOL_VIEW;
import static bg.tu_varna.sit.inventorymanagement.presentation.controllers.LoginController.whichUser;

public class ProductByTypeQueryController implements Initializable {
    Stage s ;
    public ProductByTypeQueryController(Stage stage){
        s=stage;
    }

    private final ProductService productService=ProductService.getInstance();

    @FXML
    private Button getProductsByTypeButton;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TableView<ProductListViewModel> allProdByTypeTable;

    @FXML
    private TableColumn<ProductListViewModel, Integer> inventoryCol;

    @FXML
    private TableColumn<ProductListViewModel, String> descriptionCol;

    @FXML
    private TableColumn<ProductListViewModel, String> typeCol;

    @FXML
    private TableColumn<ProductListViewModel, Boolean> statCol;

    @FXML
    private TableColumn<ProductListViewModel, LocalDate> expCol;

    @FXML
    private TableColumn<ProductListViewModel, Double> valueCol;

    @FXML
    private TableColumn<ProductListViewModel, Mol> molCol;

    @FXML
    private TableColumn<ProductListViewModel, Amortization> amortCol;

    @FXML
    private TableColumn<ProductListViewModel, LocalDate> disCol;

    @FXML
    private RadioButton dmaProducts;

    @FXML
    private RadioButton maProducts;

    boolean whatType;
    LocalDate myFromDate;
    LocalDate myToDate;

    @FXML
    public void getFromDate()
    {
        myFromDate=fromDate.getValue();
    }

    @FXML
    public void getToDate(){

        myToDate=toDate.getValue();
    }



    @FXML
    public void getAllProductsByType()
    {
        if(dmaProducts.isSelected())
            whatType=true;
        else if(maProducts.isSelected())
            whatType=false;
        if(myFromDate==null || myToDate==null)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            ObservableList<ProductListViewModel> productsInPeriod = productService.getAllProductsByTypeInPeriod(myFromDate, myToDate, whatType);
            allProdByTypeTable.setItems(productsInPeriod);
        }
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
        inventoryCol.setCellValueFactory(new PropertyValueFactory<>("idInventoryNumber"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("prodType"));
        statCol.setCellValueFactory(new PropertyValueFactory<>("prodStatus"));
        expCol.setCellValueFactory(new PropertyValueFactory<>("exploatationStart"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("productValue"));
        molCol.setCellValueFactory(new PropertyValueFactory<>("byMol"));
        amortCol.setCellValueFactory(new PropertyValueFactory<>("byAmortization"));
        disCol.setCellValueFactory(new PropertyValueFactory<>("discardDate"));
        allProdByTypeTable.getStyleClass().add("bg-1");
        allProdByTypeTable.setPadding(new Insets(5));
    }
}
