package operations;

import java.sql.*;
import javax.sql.*;
import javafx.collections.*;

import modules.Bill;
import modules.BillItem;

public class BillItemModel {

    static DataSource ds = DatabaseSource.getMySQLDataSource();

    public static void addBill(Bill b) {
        try (Connection con = ds.getConnection()) {
            String query = "INSERT INTO bill" + " VALUES (?,?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, b.getBillNo());
            pStmt.setDate(2, (Date)b.getBillDate());
            pStmt.setString(3, b.getBillNote());
            pStmt.setDouble(4, b.getBillAmount());
            pStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void addBillItem(BillItem bi) {
        try (Connection con = ds.getConnection()) {
            String query = "INSERT INTO billitem" + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, bi.getBillNo());
            pStmt.setString(2, bi.getBillItemNo());
            pStmt.setString(3, bi.getProductID());
            pStmt.setDouble(4, bi.getUnitPrice());
            pStmt.setInt(5, bi.getQuantity());
            pStmt.setDouble(6, bi.getTotal());
            pStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ObservableList getBills() {
        try (Connection con = ds.getConnection()) {
            ObservableList<Bill> ol = FXCollections.observableArrayList();
            String query = "SELECT * FROM bill";
            PreparedStatement pStmt = con.prepareStatement(query);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                ol.add(new Bill(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getDouble(4)));
            }
            return ol;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static ObservableList getBillItems(Bill b) {
        try (Connection con = ds.getConnection()) {
            ObservableList<BillItem> ol = FXCollections.observableArrayList();
            String query = "SELECT * FROM billitem WHERE billNo='"+b.getBillNo()+"'";
            PreparedStatement pStmt = con.prepareStatement(query);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                ol.add(new BillItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getInt(5),rs.getDouble(6)));
            }
            return ol;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    
}
