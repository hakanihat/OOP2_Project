package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.HelloModel;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class HelloController implements EventHandler<MouseEvent> {

    private final AdminService service =AdminService.getInstance();
    @FXML
    private Label welcomeText;

    @FXML
    private Button helloButton;

    @FXML
    private ListView<AdminListViewModel> listView;

    private final HelloModel model;

    public HelloController() {
        this.model = new HelloModel();
    }

    @FXML
    private  void initialize()
    {
        helloButton.setOnMouseClicked(this::handle);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        welcomeText.setText(model.getWelcomeMessage());
        ObservableList<AdminListViewModel> adminListViewModels = service.getAllAdmin();
        listView.setItems(adminListViewModels);
    }
}