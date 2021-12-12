package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ProductByStatusQueryController {
    Stage s ;
    public ProductByStatusQueryController(Stage stage){
        s=stage;
    }

    private final ProductService productService=ProductService.getInstance();

    @FXML
    private Button getProductsByTypeButton;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TableView<ProductListViewModel> allProdTable;

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
    public void getAllProductsByType()
    {

    }
}
