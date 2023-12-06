package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Appointment;
import org.salon_frumusete.observer.Observer;
import org.salon_frumusete.observer.Subject;
import org.salon_frumusete.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController implements Subject {
    private AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);

        registerObserver(appointment.getClient());
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

    public void deleteAppointment(int clientID, int employeeID) {
        appointmentRepository.deleteAppointment(clientID, employeeID);
    }
    public List<Appointment> getAppointmentsByClientID(int clientID) {
        return appointmentRepository.getAppointmentsByClientID(clientID);
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        if (o != null) {
            observers.add(o);
        } else {
            System.out.println("Attempted to register a null observer.");
        }

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