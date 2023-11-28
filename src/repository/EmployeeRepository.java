package repository;

import databasemodell.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends SqlServer {
    private Connection connection;

    public Connection EmployeeRepository() {
        this.connection = SqlServer.conection();
        return connection;
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, birthDate, workStartTime, workEndTime, serviceID, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        String sql = "SELECT * FROM employees WHERE employeeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
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
        String sql = "UPDATE employees SET name=?, birthDate=?, workStartTime=?, workEndTime=?, serviceID=?, rating=? " +
                "WHERE employeeID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        String sql = "DELETE FROM employees WHERE employeeID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> matchingEmployees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE name LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        String sql = "SELECT workStartTime FROM employees WHERE employeeID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        String sql = "SELECT workEndTime FROM employees WHERE employeeID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        String sql = "SELECT services.name FROM employees " +
                "INNER JOIN services ON employees.serviceID = services.serviceID " +
                "WHERE employees.employeeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
