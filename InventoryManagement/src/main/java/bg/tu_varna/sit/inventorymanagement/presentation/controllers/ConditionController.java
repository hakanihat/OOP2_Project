package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.ConditionService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
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

public class ConditionController {
    Stage s =new Stage();

    @FXML
    private TextField condition;

    @FXML
    private Button conButton;

    @FXML
    private Button backButton;

    private final ConditionService conService=ConditionService.getInstance();
    public ConditionController(){ }

    public ConditionController(Stage stage){
        s=stage;
    }

    @FXML
    public void  addCondition()
    {   ConditionListViewModel addCon = new ConditionListViewModel(condition.getText());
        if(condition.getText().equals(""))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            if (conService.addTheCondition(addCon)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The condition is added successfully!", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The condition is already added!", ButtonType.OK);
                alert.show();
            }
        }

    }

    @FXML
    public void  goBack()
    {
        if(whichUser)
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MOL_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new MolController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
        else
        {
            try
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                Stage stage = new Stage();
                fxmlLoader.setController(new AdminController(stage));
                Parent root1 =  fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }


}
