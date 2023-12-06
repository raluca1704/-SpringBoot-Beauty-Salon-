package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Feedback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {
    // Consider initializing or connecting to your database here

    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO feedback (clientID,  description, stars) VALUES ( ?, ?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, feedback.getClientID());
            stmt.setString(2, feedback.getDescription());
            stmt.setInt(3, feedback.getStars());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Assuming your feedback has an ID field, set it from the generated key
                    feedback.setFeedbackID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Feedback getFeedbackById(int feedbackID) {
        String sql = "SELECT * FROM feedback WHERE feedbackID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, feedbackID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractFeedbackFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Feedback not found
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> allFeedbacks = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Feedback feedback = extractFeedbackFromResultSet(resultSet);
                allFeedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allFeedbacks;
    }

    public void updateFeedback(Feedback updatedFeedback) {
        String sql = "UPDATE feedback SET clientID=?, description=?, stars=? WHERE feedbackID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, updatedFeedback.getClientID());
            stmt.setString(2, updatedFeedback.getDescription());
            stmt.setInt(3, updatedFeedback.getStars());
            stmt.setInt(4, updatedFeedback.getFeedbackID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteFeedback(int feedbackID) {
        String sql = "DELETE FROM feedback WHERE feedbackID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, feedbackID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Helper method to extract Feedback from ResultSet
    private Feedback extractFeedbackFromResultSet(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setFeedbackID(resultSet.getInt("feedbackID"));
        feedback.setClientID(resultSet.getInt("clientID"));
        feedback.setDescription(resultSet.getString("description"));
        feedback.setStars(resultSet.getInt("stars"));
        return feedback;
    }
}
