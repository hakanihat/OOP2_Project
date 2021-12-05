package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.application.HelloApplication;
import bg.tu_varna.sit.inventorymanagement.business.services.LoginService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
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

    private final LoginService logService=LoginService.getInstance();
    public LoginController(){ }

    public LoginController(Stage stage){
        s=stage;
    }
    @FXML
    public void userLogin()
    {
        if(username.getText().equals("") && password.getText().equals(""))
        {
        wrongLogin.setText("Insert your username and password!");
        }
        else if(password.getText().equals(""))
        {
            wrongLogin.setText("Insert your password!");
            username.setText("");
            password.setText("");
        }
        else if(username.getText().equals("") )
        {
            wrongLogin.setText("Insert your username!");
            username.setText("");
            password.setText("");
        }
        else
        {
        if (asAdmin.isSelected())
        {
            AdminListViewModel adminFind = new AdminListViewModel(username.getText(), password.getText());
            if (logService.isAdminExist(adminFind))
            {
                try
                {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new AdminController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                wrongLogin.setText("No such Admin!");
                username.setText("");
                password.setText("");
            }
        } else if (asMol.isSelected())
        {
            MolListViewModel molFind = new MolListViewModel(username.getText(), password.getText());

            if (logService.isMolExist(molFind))
            {
                try
                {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MOL_VIEW));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new MolController(stage));
                    Parent root2 = fxmlLoader.load();
                    stage.setScene(new Scene(root2));
                    stage.show();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                wrongLogin.setText("No such Mol!");
                username.setText("");
                password.setText("");
            }
        }
        }
    }

}
