package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private String notification;

    public AppointmentRepository() {
        // You may choose to initialize or connect to your database here
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (clientID, employeeID, serviceID, dateTime) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, appointment.getClientID());
            stmt.setInt(2, appointment.getEmployeeID());
            stmt.setInt(3, appointment.getServiceID());
            stmt.setObject(4, appointment.getDateTime());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Assuming your appointment has an ID field, set it from the generated key
                    // appointment.setAppointmentID(generatedKeys.getInt(1));
                }
                notification = "Your appointment on " + appointment.getDateTime() + " is confirmed.";
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> allAppointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                allAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allAppointments;
    }

    public List<Appointment> getAppointmentsForClient(int clientID) {
        List<Appointment> clientAppointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE clientID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                clientAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return clientAppointments;
    }

    public List<Appointment> getAppointmentsForEmployee(int employeeID) {
        List<Appointment> employeeAppointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE employeeID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, employeeID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                employeeAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return employeeAppointments;
    }

    public List<Appointment> getAppointmentsForService(int serviceID) {
        List<Appointment> serviceAppointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE serviceID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, serviceID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                serviceAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return serviceAppointments;
    }

    public void updateAppointment(Appointment updatedAppointment) {
        String sql = "UPDATE appointment SET serviceID=?, dateTime=? WHERE clientID=? AND employeeID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, updatedAppointment.getServiceID());
            stmt.setObject(2, updatedAppointment.getDateTime());
            stmt.setInt(3, updatedAppointment.getClientID());
            stmt.setInt(4, updatedAppointment.getEmployeeID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteAppointment(int clientID, int employeeID) {
        String sql = "DELETE FROM appointment WHERE clientID=? AND employeeID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            stmt.setInt(2, employeeID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    public List<Appointment> getAppointmentsByClientID(int clientID) {
        List<Appointment> clientAppointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE clientID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, clientID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Appointment appointment = extractAppointmentFromResultSet(resultSet);
                clientAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return clientAppointments;
    }
    public String getNotification() {
        return notification;
    }

    // Helper method to extract Appointment from ResultSet
    private Appointment extractAppointmentFromResultSet(ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        // Assuming your appointment has an ID field, set it from the result set
        // appointment.setAppointmentID(resultSet.getInt("appointmentID"));
        appointment.setClientID(resultSet.getInt("clientID"));
        appointment.setEmployeeID(resultSet.getInt("employeeID"));
        appointment.setServiceID(resultSet.getInt("serviceID"));
        appointment.setDateTime(resultSet.getObject("dateTime", LocalDateTime.class));
        return appointment;
    }
}
