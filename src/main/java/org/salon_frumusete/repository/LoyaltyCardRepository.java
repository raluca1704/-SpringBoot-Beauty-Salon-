package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.LoyaltyCard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyCardRepository {
    // Consider initializing or connecting to your database here

    public void addLoyaltyCard(LoyaltyCard loyaltyCard) {
        String sql = "INSERT INTO loyalty_card (clientID, discount) VALUES (?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, loyaltyCard.getClientID());
            stmt.setDouble(2, loyaltyCard.getDiscount());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Assuming your loyaltyCard has an ID field, set it from the generated key
                    loyaltyCard.setLoyaltyCardID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public LoyaltyCard getLoyaltyCardByID(int loyaltyCardID) {
        String sql = "SELECT * FROM loyalty_card WHERE loyaltyCardID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, loyaltyCardID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractLoyaltyCardFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // LoyaltyCard not found
    }

    public List<LoyaltyCard> getAllLoyaltyCards() {
        List<LoyaltyCard> allLoyaltyCards = new ArrayList<>();
        String sql = "SELECT * FROM loyalty_card";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                LoyaltyCard loyaltyCard = extractLoyaltyCardFromResultSet(resultSet);
                allLoyaltyCards.add(loyaltyCard);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allLoyaltyCards;
    }

    public void updateLoyaltyCard(LoyaltyCard updatedLoyaltyCard) {
        String sql = "UPDATE loyalty_card SET clientID=?, discount=? WHERE loyaltyCardID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, updatedLoyaltyCard.getClientID());
            stmt.setDouble(2, updatedLoyaltyCard.getDiscount());
            stmt.setInt(3, updatedLoyaltyCard.getLoyaltyCardID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public LoyaltyCard getLoyaltyCardByClientID(int clientID) {
        String sql = "SELECT * FROM loyalty_card WHERE clientID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractLoyaltyCardFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // LoyaltyCard not found
    }

    // Helper method to extract LoyaltyCard from ResultSet
    private LoyaltyCard extractLoyaltyCardFromResultSet(ResultSet resultSet) throws SQLException {
        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setLoyaltyCardID(resultSet.getInt("loyaltyCardID"));
        loyaltyCard.setClientID(resultSet.getInt("clientID"));
        loyaltyCard.setDiscount(resultSet.getFloat("discount"));
        return loyaltyCard;
    }
}
