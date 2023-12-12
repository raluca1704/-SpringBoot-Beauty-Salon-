package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByClientId(int clientId);
    List<Appointment> findByEmployeeId(int employeeId);
    List<Appointment> findByServiceId(int serviceId);
}