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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private TableColumn<CustomerBoardListViewModel, LocalDate> registerProductDate;

    @FXML
    private TableColumn<CustomerBoardListViewModel, LocalDate> returnProductDate;

    @FXML
    private Button cusButton;

    @FXML
    private Button cusButton1;

    @FXML
    private Button backButton;

    @FXML
    private ComboBox<CustomerListViewModel> customersComboBox;

    @FXML
    private ComboBox<ProductListViewModel> productsComboBox;

    ObservableList<CustomerBoardListViewModel> temp;
    CustomerBoardListViewModel forRemove;
    int isExist;

    @FXML
    private void boardRegistration(){
        temp.clear();
        boardTable.setItems(temp);
        LocalDate localDate = LocalDate.now();
        CustomerBoardListViewModel addToBoard = new CustomerBoardListViewModel(customerService.listViewToEntity(customersComboBox.getValue()),productService.listViewToEntity(productsComboBox.getValue()),localDate);
        isExist= customerBoardService.addToTheBoard(addToBoard);

        if(isExist==0) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"The product is not available!",ButtonType.OK);
            alert.show();
        }
        else if(isExist==1)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"The product is discarded!",ButtonType.OK);
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"The product has been added successfully!",ButtonType.OK);
            alert.show();
        }
        temp = customerBoardService.getAllBoards();
        boardTable.setItems(temp);
    }

    @FXML
    public void getTheRow(){
        forRemove = boardTable.getSelectionModel().getSelectedItem();
    }


    @FXML
    private void boardRemove(ActionEvent event){
        LocalDate localDate2 = LocalDate.now();
        forRemove.setReturnDate(localDate2);
        temp.clear();

        if(customerBoardService.returnTheProduct(forRemove))
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"The product has been returned successfully!",ButtonType.OK);
            alert.show();
        }

        else
        {
            Alert alert=new Alert(Alert.AlertType.WARNING,"The product is already returned!",ButtonType.OK);
            alert.show();
        }

        temp = customerBoardService.getAllBoards();
        boardTable.setItems(temp);

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

        customerProduct.setCellValueFactory(new PropertyValueFactory<>("byCustomer"));
        productCustomer.setCellValueFactory(new PropertyValueFactory<>("byInventoryNumber"));
        registerProductDate.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
        returnProductDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        temp= customerBoardService.getAllBoards();
        boardTable.setItems(temp);
        fillCustomerId();
        fillProductInventoryNum();


    }

}
