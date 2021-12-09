package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerBoardService;
import bg.tu_varna.sit.inventorymanagement.business.services.CustomerService;
import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerBoardController implements Initializable {
    Stage s ;
    public CustomerBoardController(Stage stage){
        s=stage;
    }

    private final CustomerBoardService customerBoardService=CustomerBoardService.getInstance();
    private final CustomerService customerService=CustomerService.getInstance();
    private final ProductService productService=ProductService.getInstance();

    @FXML
    private TableView<CustomerBoardListViewModel> boardTable;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Customer> customerProduct;

    @FXML
    private TableColumn<CustomerBoardListViewModel, Product> productCustomer;

    @FXML
    private Button cusButton;

    @FXML
    private Button cusButton1;

    @FXML
    private ComboBox<CustomerListViewModel> customersComboBox;

    @FXML
    private ComboBox<ProductListViewModel> productsComboBox;

    ObservableList<CustomerBoardListViewModel> temp;
    boolean isExist;

    @FXML
    private void boardRegistration(){
        temp.clear();
        boardTable.setItems(temp);
        LocalDate localDate = LocalDate.now();
        CustomerBoardListViewModel addToBoard = new CustomerBoardListViewModel(customerService.listViewToEntity(customersComboBox.getValue()),productService.listViewToEntity(productsComboBox.getValue()),localDate);
        isExist= customerBoardService.addToTheBoard(addToBoard);
        if(isExist) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"The product has been added successfully!",ButtonType.OK);
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"The product has been already added to customer's board!",ButtonType.OK);
            alert.show();
        }
        temp = customerBoardService.getAllBoards();
        boardTable.setItems(temp);
    }

    @FXML
    private void boardRemove(){

    }


    public void fillCustomerId()
    {
        ObservableList<CustomerListViewModel> customers=customerService.getAllCustomers();
        customersComboBox.setItems(customers);


    }

    public void fillProductInventoryNum()
    {
        ObservableList<ProductListViewModel> products=productService.getAllProducts();
        productsComboBox.setItems(products);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerProduct.setCellValueFactory(new PropertyValueFactory<>("byCustomer"));
        productCustomer.setCellValueFactory(new PropertyValueFactory<>("byInventoryNumber"));
        temp= customerBoardService.getAllBoards();
        boardTable.setItems(temp);
        fillCustomerId();
        fillProductInventoryNum();


    }

}
