package views;

import java.sql.*;

import java.time.LocalDate;

import modules.BillItem;
import modules.Bill;
import operations.BillItemModel;
import operations.DatabaseSource;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import javax.sql.DataSource;

public class BillItemView extends Application {

    Stage window;
    GridPane grid;
    static TableView<Bill> table1;
    static TableView<BillItem> table2;
    static TextField billNo, billNote, billAmount;
    static TextField billItemNo, productID, quantity, unitPrice, total;
    static DatePicker billDate;
    Scene scene;
    static DataSource ds = DatabaseSource.getMySQLDataSource();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        grid = new GridPane();

        window = primaryStage;
        window.setTitle("Pharmacy - Bill");

        billNo = new TextField();

        billDate = new DatePicker(LocalDate.now());
        billDate.setPrefWidth(125);

        billNote = new TextField();
        billNote.setPromptText("Bill Note");
        billNote.setPrefWidth(300);

        billAmount = new TextField();
        billAmount.setPromptText("Bill Amount");
        billAmount.setPrefWidth(125);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button updateButton = new Button("Update");
        //updateButton.setOnAction(e -> updateButtonClicked());
        Button deleteButton = new Button("Delete");
        //deleteButton.setOnAction(e -> deleteButtonClicked());
        Button viewItemsButton = new Button("View Bill Items");
        
        viewItemsButton.setOnAction(e -> viewItemsButtonClicked());
        //viewItemsButton.setDisable(true);
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(billDate, billNote, billAmount, addButton, updateButton, deleteButton, viewItemsButton);

        TableColumn<Bill, String> billNoC = new TableColumn<>("Bill No");
        billNoC.setCellValueFactory(new PropertyValueFactory<>("billNo"));

        TableColumn<Bill, Date> billDateC = new TableColumn<>("Bill Date");
        billDateC.setCellValueFactory(new PropertyValueFactory<>("billDate"));

        TableColumn<Bill, String> billNoteC = new TableColumn<>("Bill Note");
        billNoteC.setCellValueFactory(new PropertyValueFactory<>("billNote"));

        TableColumn<Bill, Double> billAmountC = new TableColumn<>("Bill Amount");
        billAmountC.setCellValueFactory(new PropertyValueFactory<>("billAmount"));

        table1 = new TableView<>();
        
        table1.setItems(getBills());
        
        table1.setPrefHeight(250);
        
        billNoC.prefWidthProperty().bind(table1.widthProperty().multiply(0.20));
        billDateC.prefWidthProperty().bind(table1.widthProperty().multiply(0.15));
        billNoteC.prefWidthProperty().bind(table1.widthProperty().multiply(0.40));
        billAmountC.prefWidthProperty().bind(table1.widthProperty().multiply(0.25));

        table1.getColumns().addAll(billNoC, billDateC, billNoteC, billAmountC);

        productID = new TextField();
        productID.setPromptText("Product ID");
        productID.setPrefWidth(100);

        unitPrice = new TextField();
        unitPrice.setPromptText("Unit Price");
        unitPrice.setPrefWidth(100);

        quantity = new TextField();
        quantity.setPromptText("Quantity");
        quantity.setPrefWidth(100);

        total = new TextField();
        total.setPromptText("Amount");
        total.setPrefWidth(100);

        Button addButton1 = new Button("Add");
        addButton1.setOnAction(e -> addButton1Clicked());
        Button updateButton1 = new Button("Update");
        //updateButton1.setOnAction(e -> updateButton1Clicked());
        Button deleteButton1 = new Button("Delete");
        //deleteButton1.setOnAction(e -> deleteButton1Clicked());

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(productID, unitPrice, quantity, total, addButton1, updateButton1, deleteButton1);
        
        TableColumn<BillItem, String> itemNoC = new TableColumn<>("Bill Item No");
        itemNoC.setCellValueFactory(new PropertyValueFactory<>("billItemNo"));

        TableColumn<BillItem, String> productIDC = new TableColumn<>("Product ID");
        productIDC.setCellValueFactory(new PropertyValueFactory<>("productID"));

        TableColumn<BillItem, Double> unitPriceC = new TableColumn<>("Unit Price");
        unitPriceC.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        TableColumn<BillItem, Integer> quantityC = new TableColumn<>("Quantity");
        quantityC.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<BillItem, Double> totalC = new TableColumn<>("Amount");
        totalC.setCellValueFactory(new PropertyValueFactory<>("total"));

        table2 = new TableView<>();

        itemNoC.prefWidthProperty().bind(table2.widthProperty().multiply(0.20));
        productIDC.prefWidthProperty().bind(table2.widthProperty().multiply(0.20));
        unitPriceC.prefWidthProperty().bind(table2.widthProperty().multiply(0.20));
        quantityC.prefWidthProperty().bind(table2.widthProperty().multiply(0.20));
        totalC.prefWidthProperty().bind(table2.widthProperty().multiply(0.20));

        table2.getColumns().addAll(itemNoC, productIDC, unitPriceC, quantityC, totalC);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(hBox1, table1);
        grid.add(vBox1, 0, 0);
        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(hBox2, table2);
        grid.add(vBox2, 0, 1);
        scene = new Scene(grid, 1000, 600);
        window.setScene(scene);
        window.show();
    }
    
    private static void addButtonClicked() {
        Bill b = new Bill();
        b.setBillNo(billNo.getText());
        b.setBillDate(Date.valueOf(billDate.getValue()));
        b.setBillNote(billNote.getText());
        b.setBillAmount(Double.parseDouble(billAmount.getText()));
        BillItemModel.addBill(b);
        table1.getItems().add(b);
        for ( int i = 0; i < table2.getItems().size(); i++) {
            table2.getItems().clear(); 
        } 
        clear1();
    }
    
    private static void addButton1Clicked() {
        BillItem bi = new BillItem();
        String s = "Bill-";
        try (Connection con = ds.getConnection()) {
            int i = 1;
            
            String query1 = "SELECT billNo FROM bill WHERE billNo='"+s+Integer.toString(i)+"'";
            PreparedStatement pStmt1 = con.prepareStatement(query1);
            ResultSet rs1 = pStmt1.executeQuery();
            if(rs1.first()){
                i++;
                bi.setBillNo(s+Integer.toString(i));
                billNo.setText(s+Integer.toString(i));
            }
            else{
                bi.setBillNo(s+Integer.toString(i));
                billNo.setText(s+Integer.toString(i));
            }
            String query2 = "SELECT * FROM billitem WHERE billNo='"+bi.getBillNo()+"'";
            PreparedStatement pStmt2 = con.prepareStatement(query2);
            ResultSet rs2 = pStmt2.executeQuery();
            if(rs2.wasNull()== false){
            while (rs2.next()) {
                if(rs2.last()){
                    String inS = rs2.getString("billItemNo");
                    int inN = Integer.parseInt(inS.substring(5));
                    inN++;
                    bi.setBillItemNo("Item-"+Integer.toString(inN));
                    System.out.print(inN);
                }
            }}
            else{
                bi.setBillItemNo("Item-1");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        bi.setProductID(productID.getText());
        bi.setUnitPrice(Double.parseDouble(unitPrice.getText()));
        bi.setQuantity(Integer.parseInt(quantity.getText()));
        bi.setTotal(Double.parseDouble(unitPrice.getText())*Integer.parseInt(quantity.getText()));
        BillItemModel.addBillItem(bi);
        table2.getItems().add(bi);
        clear2();
    }
    
    private static ObservableList<Bill> getBills() {
        ObservableList<Bill> bills = BillItemModel.getBills();
        return bills;
    }
    
    private static void viewItemsButtonClicked() {
        int index = table1.getSelectionModel().getSelectedIndex();
        Bill b = table1.getItems().get(index);
        ObservableList<BillItem> billItem = BillItemModel.getBillItems(b);
        table2.setItems(billItem);
    }
    
    private static void clear1(){
        billNote.clear();
        billAmount.clear();
    }
    
    private static void clear2() {
        productID.clear();
        unitPrice.clear();
        quantity.clear();
        total.clear();
    }
}
