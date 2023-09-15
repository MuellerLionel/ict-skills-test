package ict.skills.ictskillslogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField loginUsernameField;
    @FXML
    private Button loginSubmitButton;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        loginUsernameField.setText("Welcome to JavaFX Application!");
        System.out.println(event.getEventType());
    }
}