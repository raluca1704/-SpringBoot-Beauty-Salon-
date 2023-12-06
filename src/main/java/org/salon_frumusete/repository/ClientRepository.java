package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        String sql = "INSERT INTO client (email, telephoneNumber, name) VALUES (?, ?, ?)";

        try (PreparedStatement stmt =SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, client.getEmail());
            stmt.setString(2, client.getTelephoneNumber());
            stmt.setString(3, client.getName());

            int rows = stmt.executeUpdate();
//            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    public Client getClientById(int clientID) {
        String sql = "SELECT * FROM client WHERE clientID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractClientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Client not found
    }

    public List<Client> getAllClients() {
        List<Client> allClients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Client client = extractClientFromResultSet(resultSet);
                allClients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allClients;
    }

    public void updateClient(Client updatedClient) {
        String sql = "UPDATE client SET email=?, telephoneNumber=?, name=? WHERE clientID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, updatedClient.getEmail());
            stmt.setString(2, updatedClient.getTelephoneNumber());
            stmt.setString(3, updatedClient.getName());
            stmt.setInt(4, updatedClient.getClientID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteClient(int clientID) {
        String sql = "DELETE FROM client WHERE clientID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Client getClientByName(String name) {
        String sql = "SELECT * FROM client WHERE name LIKE ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractClientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Client not found
    }

    // Helper method to extract Client from ResultSet
    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setClientID(resultSet.getInt("clientID"));
        client.setEmail(resultSet.getString("email"));
        client.setTelephoneNumber(resultSet.getString("telephoneNumber"));
        client.setName(resultSet.getString("name"));
        return client;
    }
}
