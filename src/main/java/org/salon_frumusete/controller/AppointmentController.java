package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Appointment;
import org.salon_frumusete.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByClientId(@PathVariable int clientId) {
        List<Appointment> appointments = appointmentRepository.findByClientId(clientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByEmployeeId(@PathVariable int employeeId) {
        List<Appointment> appointments = appointmentRepository.findByEmployeeId(employeeId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByServiceId(@PathVariable int serviceId) {
        List<Appointment> appointments = appointmentRepository.findByServiceId(serviceId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment appointmentDetails) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointment.setClient(appointmentDetails.getClient());
                    appointment.setEmployee(appointmentDetails.getEmployee());
                    appointment.setService(appointmentDetails.getService());
                    appointment.setDateTime(appointmentDetails.getDateTime());
                    return ResponseEntity.ok(appointmentRepository.save(appointment));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}