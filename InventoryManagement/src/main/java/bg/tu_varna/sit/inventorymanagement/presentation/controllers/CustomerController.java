package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerController {
    Stage s =new Stage();

    @FXML
    private TextField cusName;

    @FXML
    private TextField cusTelNum;

    @FXML
    private TextField cusEmail;

    @FXML
    private Button cusButton;

    private final CustomerService cusService=CustomerService.getInstance();
    public CustomerController(){ }

    public CustomerController(Stage stage){
        s=stage;
    }

    @FXML
    public void  addCustomer()
    {   CustomerListViewModel addCus = new CustomerListViewModel(cusName.getText(),cusTelNum.getText(),cusEmail.getText());
        cusService.addTheCustomer(addCus);


    }
}
