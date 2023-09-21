package ict.skills.ictskillslogin;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        try {
            String input = loginPasswordField.getText();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert the string to bytes
            byte[] hashedBytes = digest.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            String hashedString = bytesToHex(hashedBytes);

            System.out.println("Original String: " + input);
            System.out.println("SHA-256 Hash: " + hashedString);
            System.out.println(hashedString.length());
        } catch (NoSuchAlgorithmException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(e.toString());
            a.show();
        }
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

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}