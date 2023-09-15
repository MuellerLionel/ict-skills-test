package ict.skills.ictskillslogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuViewController {
    @FXML
    private TextField loginUsernameField;
    @FXML
    private Button loginSubmitButton;

    @FXML
    protected void handleLogout(ActionEvent event) {
        System.out.println(event.getEventType());
    }
}