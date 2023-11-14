package controller;

import databasemodell.Appointment;
import observer.Subject;
import repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

import observer.Observer;
import java.util.ArrayList;

public class AppointmentController implements Subject {
    private AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);

        registerObserver(appointment.getClient()); // Assuming getClient returns a Client object
        notifyObservers("Your appointment on " + appointment.getDateTime() + " is confirmed.");
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
    public List<Appointment> getAppointmentsByClientID(int clientID) {
        return appointmentRepository.getAppointmentsByClientID(clientID);
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}