package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.application.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public LoginController(){ }

    @FXML
    private Button logButton;

    @FXML
    private Label wrongLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event) throws IOException{
       // checkLogin();
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
