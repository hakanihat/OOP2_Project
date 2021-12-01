package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.application.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.MOL_VIEW;

public class LoginController {
   Stage s =new Stage();

    @FXML
    private Button logButton;

    @FXML
    private Label wrongLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton asAdmin;

    @FXML
    private RadioButton asMol;

    public LoginController(){ }

    public LoginController(Stage stage){
        s=stage;
    }
    @FXML
    public void userLogin() {
        if(asAdmin.isSelected())
        {
      try{
          s.close();
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
          Stage stage = new Stage();
         fxmlLoader.setController(new AdminController(stage));
          Parent root1 = (Parent) fxmlLoader.load();
          stage.setScene(new Scene(root1));
          stage.show();
      }catch (Exception e){
          e.printStackTrace();
      }}
        else if(asMol.isSelected())
        { try{
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MOL_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new MolController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
            }catch (Exception e)
             {e.printStackTrace();}
        }
    }

    /*private void checkLogin() throws IOException{
        Scene scene
        if(username.getText().toString().equals("hakan") && password.getText().toString().equals("123"))
        {
            wrongLogin.setText("Success!");
            m.changeScene
        }
    }*/
}
