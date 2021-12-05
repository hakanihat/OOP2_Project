package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.*;

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
    private Button openRegisterConditionButton;

    @FXML
    private Button openRegisterProductButton;
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
    public void productRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PRODUCT_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ProductController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void conditionRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CONDITION_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ConditionController(stage));
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

    public void fillComboBoxGrapeType(){
       // ObservableList<Amortization> amortizationsCat=
    }
}
