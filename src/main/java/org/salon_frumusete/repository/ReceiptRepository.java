//package org.salon_frumusete.repository;
//
//import org.salon_frumusete.databasemodell.Receipt;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReceiptRepository {
//    // Consider initializing or connecting to your database here
//
//    public void addReceipt(Receipt receipt) {
//        String sql = "INSERT INTO receipt (clientID, appointmentID, paymentDateTime, amountPaid) VALUES (?, ?, ?, ?)";
//
//        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setInt(1, receipt.getClientID());
//            stmt.setInt(2, receipt.getAppointmentID());
//            stmt.setObject(3, receipt.getPaymentDateTime());
//            stmt.setDouble(4, receipt.getAmountPaid());
//
//            int rows = stmt.executeUpdate();
//            if (rows > 0) {
//                ResultSet generatedKeys = stmt.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    // Assuming your Receipt has an ID field, set it from the generated key
//                    receipt.setReceiptID(generatedKeys.getInt(1));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//    }
//
//    public Receipt getReceiptById(int receiptID) {
//        String sql = "SELECT * FROM receipt WHERE receiptID = ?";
//        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
//            stmt.setInt(1, receiptID);
//            ResultSet resultSet = stmt.executeQuery();
//            if (resultSet.next()) {
//                return extractReceiptFromResultSet(resultSet);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//        return null; // Receipt not found
//    }
//
//    public List<Receipt> getAllReceipts() {
//        List<Receipt> allReceipts = new ArrayList<>();
//        String sql = "SELECT * FROM receipt";
//        try (Statement stmt = SqlServer.conn().createStatement();
//             ResultSet resultSet = stmt.executeQuery(sql)) {
//            while (resultSet.next()) {
//                Receipt receipt = extractReceiptFromResultSet(resultSet);
//                allReceipts.add(receipt);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//        return allReceipts;
//    }
//
//    public void updateReceipt(Receipt updatedReceipt) {
//        String sql = "UPDATE receipt SET clientID=?, appointmentID=?, paymentDateTime=?, amountPaid=? WHERE receiptID=?";
//        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
//            stmt.setInt(1, updatedReceipt.getClientID());
//            stmt.setInt(2, updatedReceipt.getAppointmentID());
//            stmt.setObject(3, updatedReceipt.getPaymentDateTime());
//            stmt.setDouble(4, updatedReceipt.getAmountPaid());
//            stmt.setInt(5, updatedReceipt.getReceiptID());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//    }
//
//    public void deleteReceipt(int receiptID) {
//        String sql = "DELETE FROM receipt WHERE receiptID=?";
//        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
//            stmt.setInt(1, receiptID);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle the exception appropriately
//        }
//    }
//
//    // Helper method to extract Receipt from ResultSet
//    private Receipt extractReceiptFromResultSet(ResultSet resultSet) throws SQLException {
//        Receipt receipt = new Receipt();
//        receipt.setReceiptID(resultSet.getInt("receiptID"));
//        receipt.setClientID(resultSet.getInt("clientID"));
//        receipt.setAppointmentID(resultSet.getInt("appointmentID"));
//        receipt.setPaymentDateTime(resultSet.getObject("paymentDateTime", LocalDateTime.class));
//        receipt.setAmountPaid(resultSet.getDouble("amountPaid"));
//        return receipt;
//    }
//}
