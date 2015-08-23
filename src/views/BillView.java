package views;

import java.sql.Date;
import java.time.LocalDate;
import modules.Bill;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BillView extends Application {

    Stage window;
    TableView<Bill> table;
    TextField billNo, billNote, billAmount;
    DatePicker billDate;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Pharmacy - Bill");

        TableColumn<Bill, String> billNoC = new TableColumn<>("Bill No");
        billNoC.setCellValueFactory(new PropertyValueFactory<>("billNo"));

        TableColumn<Bill, Date> billDateC = new TableColumn<>("Bill Date");
        billDateC.setCellValueFactory(new PropertyValueFactory<>("billDate"));

        TableColumn<Bill, String> billNoteC = new TableColumn<>("Bill Note");
        billNoteC.setCellValueFactory(new PropertyValueFactory<>("billNote"));

        TableColumn<Bill, Double> billAmountC = new TableColumn<>("Bill Amount");
        billAmountC.setCellValueFactory(new PropertyValueFactory<>("billAmount"));

        billNo = new TextField();
        billNo.setPromptText("Bill No");
        billNo.setPrefWidth(100);
        
        billNote = new TextField();
        billNote.setPromptText("Bill Note");
        billNote.setPrefWidth(300);
        
        billDate = new DatePicker(LocalDate.now());
        billDate.setPrefWidth(125);
        
        billAmount = new TextField();
        billAmount.setPromptText("Bill Amount");
        billAmount.setPrefWidth(125);
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
        hBox.getChildren().addAll(billNo, billDate, billNote, billAmount, addButton, updateButton, deleteButton);

        table = new TableView<>();
        //table.setPrefWidth(450);
        //table.setPrefHeight(300);
        table.setItems(getBill());

        billNoC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        billDateC.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        billNoteC.prefWidthProperty().bind(table.widthProperty().multiply(0.40));
        billAmountC.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

        table.getColumns().addAll(billNoC, billDateC, billNoteC, billAmountC);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, table);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        //logic and database connection need to implement
        Bill bill = new Bill();
        bill.setBillNo(billNo.getText());
        bill.setBillNote(billNote.getText());
        bill.setBillAmount(Double.parseDouble(billAmount.getText()));
        bill.setBillDate(Date.valueOf(billDate.getValue()));
        table.getItems().add(bill);
        billNo.clear();
        billNote.clear();
        billAmount.clear();
       
    }

    //Update button clicked
    public void updateButtonClicked() {

    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Bill> selected, all;
        all = table.getItems();
        selected = table.getSelectionModel().getSelectedItems();
        selected.forEach(all::remove);
    }

    public ObservableList<Bill> getBill() {
        ObservableList<Bill> bills = FXCollections.observableArrayList();
        return bills;
    }

}
