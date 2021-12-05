package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.ConditionService;
import bg.tu_varna.sit.inventorymanagement.business.services.CustomerService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConditionController {
    Stage s =new Stage();

    @FXML
    private TextField condition;

    @FXML
    private Button conButton;

    private final ConditionService conService=ConditionService.getInstance();
    public ConditionController(){ }

    public ConditionController(Stage stage){
        s=stage;
    }

    @FXML
    public void  addCondition()
    {   ConditionListViewModel addCon = new ConditionListViewModel(condition.getText());
        conService.addTheCondition(addCon);


    }
}
