package ict.skills.ictskillslogin;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField loginUsernameField;
    @FXML
    private TextField loginPasswordField;
    @FXML
    private Label loginErrorLabel;

    @FXML
    protected void onLoginSubmit(ActionEvent event) throws IOException {
        openMainView(event);
    }
    @FXML
    protected void onLoginCancel(ActionEvent event) {
        Platform.exit();
    }
    private void openMainView (ActionEvent event) throws IOException {
        Parent fxmlView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-menu-view.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlView);
        stage.setScene(scene);
        stage.show();
    }
}