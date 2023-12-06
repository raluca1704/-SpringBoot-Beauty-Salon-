package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Employee;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {


    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, birthDate, workStartTime, workEndTime, serviceID, rating) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employee.getName());
            stmt.setDate(2, Date.valueOf(employee.getBirthDate()));
            stmt.setTime(3, Time.valueOf(employee.getWorkStartTime()));
            stmt.setTime(4, Time.valueOf(employee.getWorkEndTime()));
            stmt.setInt(5, employee.getServiceID());
            stmt.setString(6, employee.getRating());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    employee = new Employee.Builder()
                            .employeeID(generatedId)
                            .name(employee.getName())
                            .birthDate(employee.getBirthDate())
                            .workStartTime(employee.getWorkStartTime())
                            .workEndTime(employee.getWorkEndTime())
                            .serviceID(employee.getServiceID())
                            .rating(employee.getRating())
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Employee getEmployeeById(int employeeID) {
        String sql = "SELECT * FROM employee WHERE employeeID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Statement stmt =  SqlServer.conn().prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Employee employee = extractEmployeeFromResultSet(resultSet);
                allEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    public void updateEmployee(Employee updatedEmployee) {
        String sql = "UPDATE employee SET name=?, birthDate=?, workStartTime=?, workEndTime=?, serviceID=?, rating=? " +
                "WHERE employeeID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, updatedEmployee.getName());
            stmt.setDate(2, Date.valueOf(updatedEmployee.getBirthDate()));
            stmt.setTime(3, Time.valueOf(updatedEmployee.getWorkStartTime()));
            stmt.setTime(4, Time.valueOf(updatedEmployee.getWorkEndTime()));
            stmt.setInt(5, updatedEmployee.getServiceID());
            stmt.setString(6, updatedEmployee.getRating());
            stmt.setInt(7, updatedEmployee.getEmployeeID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteEmployee(int employeeID) {
        String sql = "DELETE FROM employee WHERE employeeID=?";
        try (PreparedStatement stmt =  SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> matchingEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE name LIKE ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Employee employee = extractEmployeeFromResultSet(resultSet);
                matchingEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return matchingEmployees;
    }

    public LocalTime getWorkStartTimeById(int employeeID) {
        String sql = "SELECT workStartTime FROM employee WHERE employeeID=?";
        try (PreparedStatement stmt =  SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getTime("workStartTime").toLocalTime();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Employee not found
    }

    public LocalTime getWorkEndTimeById(int employeeID) {
        String sql = "SELECT workEndTime FROM employee WHERE employeeID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getTime("workEndTime").toLocalTime();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Employee not found
    }

    public String getServiceNameById(int employeeID) {
        String sql = "SELECT services.name FROM employee " +
                "INNER JOIN services ON employee.serviceID = services.serviceID " +
                "WHERE employee.employeeID = ?";
        try (PreparedStatement stmt =  SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Employee not found or associated service not found
    }

    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        return new Employee.Builder()
                .employeeID(resultSet.getInt("employeeID"))
                .name(resultSet.getString("name"))
                .birthDate(resultSet.getDate("birthDate").toLocalDate())
                .workStartTime(resultSet.getTime("workStartTime").toLocalTime())
                .workEndTime(resultSet.getTime("workEndTime").toLocalTime())
                .serviceID(resultSet.getInt("serviceID"))
                .rating(resultSet.getString("rating"))
                .build();
    }
}
