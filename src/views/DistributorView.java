package views;

import modules.Distributor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DistributorView extends Application {
    
    Stage window;
    TableView<Distributor> table;
    TextField distributorCode, distributorName, distributorAddress, distributorTel;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Pharmacy - Distributor");

        TableColumn<Distributor, String> distributorCodeC = new TableColumn<>("Distributor Code");
        distributorCodeC.setCellValueFactory(new PropertyValueFactory<>("distributorCode"));

        TableColumn<Distributor, String> distributorNameC = new TableColumn<>("Distributor Name");
        distributorNameC.setCellValueFactory(new PropertyValueFactory<>("distributorName"));

        TableColumn<Distributor, String> distributorAddressC = new TableColumn<>("Distributor Address");
        distributorAddressC.setCellValueFactory(new PropertyValueFactory<>("distributorAddress"));

        TableColumn<Distributor, String> distributorTelC = new TableColumn<>("Distributor Telephone");
        distributorTelC.setCellValueFactory(new PropertyValueFactory<>("distributorTel"));

        distributorCode = new TextField();
        distributorCode.setPromptText("Distributor Code");
        distributorCode.setPrefWidth(125);

        distributorName = new TextField();
        distributorName.setPromptText("Distributor Name");
        distributorName.setPrefWidth(125);
        
        distributorAddress = new TextField();
        distributorAddress.setPromptText("Distributor Address");
        distributorAddress.setPrefWidth(350);
        
        distributorTel = new TextField();
        distributorTel.setPromptText("Distributor Telphone");
        distributorTel.setPrefWidth(125);
        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(distributorCode, distributorName, distributorAddress, distributorTel, addButton, updateButton, deleteButton);

        table = new TableView<>();
        //table.setPrefWidth(450);
        //table.setPrefHeight(300);
        table.setItems(getDistributor());

        distributorCodeC.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        distributorNameC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        distributorAddressC.prefWidthProperty().bind(table.widthProperty().multiply(0.45));
        distributorTelC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));

        table.getColumns().addAll(distributorCodeC, distributorNameC, distributorAddressC, distributorTelC);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, table);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        Distributor d = new Distributor();
        d.setDistributorCode(distributorCode.getText());
        d.setDistributorName(distributorName.getText());
        d.setDistributorAddress(distributorAddress.getText());
        d.setDistributorTel(distributorTel.getText());
        table.getItems().add(d);
        distributorCode.clear();
        distributorName.clear();
        distributorAddress.clear();
        distributorTel.clear();
    }

    //Update button clicked
    public void updateButtonClicked() {

    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Distributor> selected, all;
        all = table.getItems();
        selected = table.getSelectionModel().getSelectedItems();
        selected.forEach(all::remove);
    }

    public ObservableList<Distributor> getDistributor() {
        ObservableList<Distributor> distributors = FXCollections.observableArrayList();
        return distributors;
    }

    
    
}
