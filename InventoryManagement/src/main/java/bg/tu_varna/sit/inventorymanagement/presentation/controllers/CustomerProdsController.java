package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerBoardService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerProdsController implements Initializable {
    Stage s ;
    public CustomerProdsController(Stage stage){
        s=stage;
    }

    private final CustomerBoardService customerBoardService=CustomerBoardService.getInstance();

    @FXML
    private Button getCusProd;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TableView<CustomerBoardListViewModel> cusProdTable;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Customer> customerProduct;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Product> productCustomer;

    @FXML
    private TableColumn<CustomerBoardListViewModel, LocalDate> registerProductDate;

    @FXML
    private TableColumn<CustomerBoardListViewModel, LocalDate> returnProductDate;

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
    private void getCusProdOpen(){

        ObservableList<CustomerBoardListViewModel> productsInPeriod = customerBoardService.getProductsInPeriod(myFromDate, myToDate);
        cusProdTable.setItems(productsInPeriod);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerProduct.setCellValueFactory(new PropertyValueFactory<>("byCustomer"));
        productCustomer.setCellValueFactory(new PropertyValueFactory<>("byInventoryNumber"));
        registerProductDate.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
        returnProductDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
    }
}
