package views;

import java.sql.Date;
import java.time.LocalDate;

import modules.Bill;

import javafx.application.*;
import javafx.application.Application.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class BillView extends Application {

    Stage window;
    TableView<Bill> table;

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

        table = new TableView<>();

        table.setPrefHeight(250);
        table.setPrefWidth(800);

        billNoC.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        billDateC.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        billNoteC.prefWidthProperty().bind(table.widthProperty().multiply(0.40));
        billAmountC.prefWidthProperty().bind(table.widthProperty().multiply(0.25));

        table.getColumns().addAll(billNoC, billDateC, billNoteC, billAmountC);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

}
