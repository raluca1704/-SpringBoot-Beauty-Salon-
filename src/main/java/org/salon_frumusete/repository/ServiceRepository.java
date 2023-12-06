package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    // Consider initializing or connecting to your database here

    public void addService(Service service) {
        String sql = "INSERT INTO service (name, price) VALUES (?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, service.getName());
            stmt.setFloat(2, service.getPrice());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Assuming your Service has an ID field, set it from the generated key
                    service.setServiceID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Service getServiceById(int serviceID) {
        String sql = "SELECT * FROM service WHERE serviceID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, serviceID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractServiceFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Service not found
    }

    public List<Service> getAllServices() {
        List<Service> allServices = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Service service = extractServiceFromResultSet(resultSet);
                allServices.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allServices;
    }

    public void updateService(Service updatedService) {
        String sql = "UPDATE service SET name=?, price=? WHERE serviceID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, updatedService.getName());
            stmt.setFloat(2, updatedService.getPrice());
            stmt.setInt(3, updatedService.getServiceID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteService(int serviceID) {
        String sql = "DELETE FROM service WHERE serviceID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, serviceID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<Service> getServicesByName(String name) {
        List<Service> matchingServices = new ArrayList<>();

        String sql = "SELECT * FROM service WHERE name LIKE ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Service service = extractServiceFromResultSet(resultSet);
                matchingServices.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return matchingServices;
    }

    public float getServicePriceById(int serviceID) {
        Service service = getServiceById(serviceID);

        if (service != null) {
            return service.getPrice();
        }

        return -1.0f; // You can choose an appropriate default value or handle the "not found" case as needed
    }

    public String getServiceNameById(int serviceID) {
        Service service = getServiceById(serviceID);

        if (service != null) {
            return service.getName();
        }

        return null; // Service not found
    }

    // Helper method to extract Service from ResultSet
    private Service extractServiceFromResultSet(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setServiceID(resultSet.getInt("serviceID"));
        service.setName(resultSet.getString("name"));
        service.setPrice(resultSet.getFloat("price"));
        return service;
    }
}
