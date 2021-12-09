package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerBoardService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerBoardController implements Initializable {
    Stage s ;
    public CustomerBoardController(Stage stage){
        s=stage;
    }

    private final CustomerBoardService customerBoardService=CustomerBoardService.getInstance();

    @FXML
    private TableView<CustomerBoardListViewModel> boardTable;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Customer> customerProduct;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Product> productCustomer;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerProduct.setCellValueFactory(new PropertyValueFactory<CustomerBoardListViewModel, Customer>("byCustomer"));
        productCustomer.setCellValueFactory(new PropertyValueFactory<CustomerBoardListViewModel, Product>("byInventoryNumber"));
        boardTable.setItems(customerBoardService.getAllBoards());

    }
}
