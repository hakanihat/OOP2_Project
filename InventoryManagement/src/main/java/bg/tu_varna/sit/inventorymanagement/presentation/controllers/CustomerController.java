package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.CustomerService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.MOL_VIEW;
import static bg.tu_varna.sit.inventorymanagement.presentation.controllers.LoginController.whichUser;

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

    @FXML
    private Button backButton;

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
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The customer has been registered successfully!", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The customer has been already added to customer's board!", ButtonType.OK);
                alert.show();
            }
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
}
