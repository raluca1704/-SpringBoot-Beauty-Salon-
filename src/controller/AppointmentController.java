package controller;

import databasemodell.Appointment;
import repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentController {
    private AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);
    }

    public List<Appointment> getAppointmentsForClient(int clientID) {
        return appointmentRepository.getAppointmentsForClient(clientID);
    }

    public List<Appointment> getAppointmentsForEmployee(int employeeID) {
        return appointmentRepository.getAppointmentsForEmployee(employeeID);
    }

    public List<Appointment> getAppointmentsForService(int serviceID) {
        return appointmentRepository.getAppointmentsForService(serviceID);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }

    public void updateAppointment(Appointment updatedAppointment) {
        appointmentRepository.updateAppointment(updatedAppointment);
    }

    public void deleteAppointment(int clientID, int employeeID, int serviceID, LocalDateTime dateTime) {
        appointmentRepository.deleteAppointment(clientID, employeeID, serviceID, dateTime);
    }
}
