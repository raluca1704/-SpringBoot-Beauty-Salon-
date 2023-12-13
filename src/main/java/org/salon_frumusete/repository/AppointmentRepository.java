package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByClient_ClientID(int clientId);

    List<Appointment> findByEmployee_EmployeeID(int employeeId);

    List<Appointment> findByService_ServiceID(int serviceId);

    List<Appointment> findByClient_ClientIDAndDateTime(int clientId, LocalDateTime dateTime);
}
