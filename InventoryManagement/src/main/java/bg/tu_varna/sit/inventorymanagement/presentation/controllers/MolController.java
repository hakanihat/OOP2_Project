package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import bg.tu_varna.sit.inventorymanagement.business.services.MolService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.LOGIN_VIEW;

public class MolController {
    Stage s = new Stage();
    public MolController(Stage stage){
        s=stage;
    }

    private final MolService adminService=MolService.getInstance();

    @FXML
    private Button logOutButton;

    @FXML
    public void logOutMol(){
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
