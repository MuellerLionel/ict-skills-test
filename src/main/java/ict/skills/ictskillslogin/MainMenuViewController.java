package ict.skills.ictskillslogin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuViewController {
    private Drink drinkA = new Drink("drinkA", 420);
    private Drink drinkB = new Drink("drinkB", 69);
    private ArrayList<Drink> drinks = new ArrayList<>(Arrays.asList(drinkA, drinkB));
    private ObservableList<Drink> listObs = FXCollections.observableList(drinks);
    private SimpleIntegerProperty index = new SimpleIntegerProperty();

    @FXML
    private TableColumn<Drink, String> nameCol;
    @FXML
    private  TableColumn<Drink, String> priceCol;


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        drinkTable.setEditable(true);
//
//        colorCol.setCellValueFactory(new PropertyValueFactory<Player, String>("color"));
//        nameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
//
//        playerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
//            @Override
//            public void changed(ObservableValue<?> observable,
//                                Object oldValue, Object newValue) {
//                index.set(players.indexOf(newValue));
//                System.out.println("Index is: "+players.indexOf(newValue));
//            }
//        });
//
//        setupTable();
//        addMenu.setVisible(false);
//    }
    @FXML
    protected void onLogout(ActionEvent event) throws IOException {
        Parent fxmlView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlView);
        stage.setScene(scene);
        stage.show();
    }
}