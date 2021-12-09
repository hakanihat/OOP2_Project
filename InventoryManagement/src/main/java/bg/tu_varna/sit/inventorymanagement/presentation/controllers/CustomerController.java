package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    boolean isExist;

    private final CustomerService cusService=CustomerService.getInstance();
    public CustomerController(){ }

    public CustomerController(Stage stage){
        s=stage;
    }

    @FXML
    public void  addCustomer()
    {   CustomerListViewModel addCus = new CustomerListViewModel(cusName.getText(),cusTelNum.getText(),cusEmail.getText());
        if(cusName.getText().equals("") || cusTelNum.getText().equals("") || cusEmail.getText().equals("")) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all field!", ButtonType.OK);
            alert.show();
        }
        else {
            isExist = cusService.addTheCustomer(addCus);
            if (isExist) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The product has been added successfully!", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The product has been already added to customer's board!", ButtonType.OK);
                alert.show();
            }
        }

    }
}
