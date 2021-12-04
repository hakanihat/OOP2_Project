package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import bg.tu_varna.sit.inventorymanagement.business.services.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.CUSTOMER_REGISTER_VIEW;
import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.LOGIN_VIEW;

public class AdminController {
    Stage s ;
    public AdminController(Stage stage){
        s=stage;
    }

    private final AdminService adminService=AdminService.getInstance();

    @FXML
    private Button logOutButton;
    @FXML
    private Button openRegisterCustomerButton;

    @FXML
    public void clientRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CUSTOMER_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new CustomerController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void logOutAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new LoginController(stage));
            Parent root1 = fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
