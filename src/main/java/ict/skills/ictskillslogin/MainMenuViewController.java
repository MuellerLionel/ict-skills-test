package ict.skills.ictskillslogin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuViewController implements Initializable {
    //Table
    private OrderItem itemA = new OrderItem(1, "bacardi", 7.5f);
    private OrderItem itemB = new OrderItem(2, "rum", 6f);
    private OrderItem itemC = new OrderItem(4, "bier", 4.2f);
    private ArrayList<OrderItem> order = new ArrayList<>(Arrays.asList(itemA, itemB, itemC));
    private ObservableList<OrderItem> orderObs = FXCollections.observableList(order);
    private SimpleIntegerProperty index = new SimpleIntegerProperty();

    @FXML
    private TableView<OrderItem> orderItemTableView;
    @FXML
    private TableColumn<OrderItem, Integer> numberCol;
    @FXML
    private  TableColumn<OrderItem, String> nameCol;
    @FXML
    private  TableColumn<OrderItem, Float> totalCol;
    @FXML
    private  TableColumn<OrderItem, String> deleteCol;

    //edit
    @FXML
    private TextField editNumber;
    @FXML
    private TextField editName;
    @FXML
    private TextField editPrice;
    @FXML
    private Label editErrorLabel;
    private Boolean itemSelected = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearCurrentEdit();
        orderItemTableView.setEditable(false);

        numberCol.setCellValueFactory(new PropertyValueFactory<OrderItem, Integer>("count"));
        nameCol.setCellValueFactory(new PropertyValueFactory<OrderItem, String>("name"));
        totalCol.setCellValueFactory(new PropertyValueFactory<OrderItem, Float>("totalPrice"));
//        deleteCol.setCellValueFactory(new PropertyValueFactory<OrderItem, String>("dummy"));


        Callback<TableColumn<OrderItem, String>, TableCell<OrderItem, String>> cellFactory =
                new Callback<TableColumn<OrderItem, String>, TableCell<OrderItem, String>>() {
                    @Override
                    public TableCell call(final TableColumn<OrderItem, String> param) {
                        final TableCell<OrderItem, String> cell = new TableCell<OrderItem, String>() {

                            final Button btn = new Button("X");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        OrderItem i = getTableView().getItems().get(getIndex());
                                        System.out.println(i.getName()
                                                + "   " + i.getTotalPrice());
                                        order.remove(getIndex());
                                        getTableView().refresh();
                                        clearCurrentEdit();
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        deleteCol.setCellFactory(cellFactory);

        orderItemTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable,
                                Object oldValue, Object newValue) {
                index.set(order.indexOf(newValue));
                System.out.println("Index is: "+index.getValue());
                setCurrentEdit(index.getValue());
            }
        });
        orderItemTableView.setItems(orderObs);
    }
    private void setCurrentEdit(Integer index){
        OrderItem selectedItem = order.get(index);
        editNumber.setText(selectedItem.getCount().toString());
        editName.setText(selectedItem.getName());
        editPrice.setText(selectedItem.getPrice().toString());
        itemSelected = true;
        setEditErrorMessage(null);
    }
    private void clearCurrentEdit(){
        editNumber.setText("Stk.");
        editName.setText("Namen");
        editPrice.setText("Preis");
        itemSelected = false;

    }
    @FXML
    protected void editSaveChanges(ActionEvent event) {
        if (!itemSelected){
            setEditErrorMessage("Error: No Item Selected");
            return;
        }
        order.get(index.getValue()).setName(editName.getText());
        order.get(index.getValue()).setCount(Integer.valueOf(editNumber.getText()));
        order.get(index.getValue()).setPrice(Float.valueOf(editPrice.getText()));
        orderItemTableView.refresh();
    }
    @FXML
    protected void onLogout(ActionEvent event) throws IOException {
        Parent fxmlView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlView);
        stage.setScene(scene);
        stage.show();
    }
    private void setEditErrorMessage(String message) {
        if (message == null){
            editErrorLabel.setVisible(false);
            return;
        }
        editErrorLabel.setVisible(true);
        editErrorLabel.setText(message);
    }

}