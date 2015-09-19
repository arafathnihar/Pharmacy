package operations;

import java.sql.*;
import javafx.collections.*;
import javax.sql.*;

import modules.Distributor;

public class DistributorModel {

    static DataSource ds = DatabaseSource.getMySQLDataSource();

    public static void add(Distributor d) {

        try (Connection con = ds.getConnection()) {
            String query = "INSERT INTO distributor VALUES (?,?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, d.getDistributorCode());
            pStmt.setString(2, d.getDistributorName());
            pStmt.setString(3, d.getDistributorAddress());
            pStmt.setString(4, d.getDistributorTel());
            pStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ObservableList getDistributors() {
        try (Connection con = ds.getConnection()) {
            ObservableList<Distributor> ol = FXCollections.observableArrayList();
            String query = "SELECT * FROM distributor";
            PreparedStatement pStmt = con.prepareStatement(query);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                ol.add(new Distributor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return ol;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void update(Distributor d) {
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE distributor SET "
                    + "dName='" + d.getDistributorName() + "',"
                    + "dAddress='" + d.getDistributorAddress() + "',"
                    + "dTelephone='" + d.getDistributorTel() + "'"
                    + " WHERE dCode='" + d.getDistributorCode() + "'";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void remove(String code) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE FROM distributor WHERE dCode='" + code + "'";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
