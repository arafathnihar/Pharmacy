package views;

import modules.Distributor;
import operations.DistributorModel;

import javafx.application.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class DistributorView extends Application {

    Stage window;
    static TableView<Distributor> table;
    static TextField distributorCode, distributorName, distributorAddress, distributorTel;
    Scene scene;

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

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> editButtonClicked());
        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(distributorCode, distributorName, distributorAddress, distributorTel, addButton, editButton, updateButton, deleteButton);

        table = new TableView<>();

        table.setItems(getDistributor());

        distributorCodeC.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        distributorNameC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        distributorAddressC.prefWidthProperty().bind(table.widthProperty().multiply(0.45));
        distributorTelC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));

        table.getColumns().addAll(distributorCodeC, distributorNameC, distributorAddressC, distributorTelC);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, table);
        scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public static void addButtonClicked() {
        Distributor d = new Distributor();
        d.setDistributorCode(distributorCode.getText());
        d.setDistributorName(distributorName.getText());
        d.setDistributorAddress(distributorAddress.getText());
        d.setDistributorTel(distributorTel.getText());
        DistributorModel.add(d);
        table.getItems().add(d);
        clear();
    }

    public static void editButtonClicked() {
        int index = table.getSelectionModel().getSelectedIndex();
        Distributor d = table.getItems().get(index);
        distributorCode.setText(d.getDistributorCode());
        distributorCode.setEditable(false);
        distributorName.setText(d.getDistributorName());
        distributorAddress.setText(d.getDistributorAddress());
        distributorTel.setText(d.getDistributorTel());
    }

    public static void updateButtonClicked() {
        Distributor d = new Distributor();
        d.setDistributorCode(distributorCode.getText());
        d.setDistributorName(distributorName.getText());
        d.setDistributorAddress(distributorAddress.getText());
        d.setDistributorTel(distributorTel.getText());
        DistributorModel.update(d);
        clear();
        table.setItems(getDistributor());
    }

    public static void deleteButtonClicked() {
        int index = table.getSelectionModel().getSelectedIndex();
        //Distributor a = table.getItems().get(index);
        DistributorModel.remove(table.getItems().get(index).getDistributorCode());
        table.getItems().remove(index);
        clear();
        table.setItems(getDistributor());
    }

    public static ObservableList<Distributor> getDistributor() {
        ObservableList<Distributor> distributors = DistributorModel.getDistributors();
        return distributors;
    }

    public static void clear() {
        distributorCode.clear();
        distributorName.clear();
        distributorAddress.clear();
        distributorTel.clear();
    }

}
