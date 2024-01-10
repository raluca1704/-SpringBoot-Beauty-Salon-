package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.*;
import org.salon_frumusete.repository.AppointmentRepository;
import org.salon_frumusete.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private ReceiptRepository receiptRepository;
    private AppointmentRepository appointmentRepository;


    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        ReceiptGenerator.getInstance().generateReceipt(savedAppointment);
        return ResponseEntity.ok(savedAppointment);
    }
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByClientId(@PathVariable int clientId) {
        List<Appointment> appointments = appointmentRepository.findByClient_ClientID(clientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByEmployeeId(@PathVariable int employeeId) {
        List<Appointment> appointments = appointmentRepository.findByEmployee_EmployeeID(employeeId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByServiceId(@PathVariable int serviceId) {
        List<Appointment> appointments = appointmentRepository.findByService_ServiceID(serviceId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

//    @PutMapping("/{clientId}/{dateTime}")
//    public ResponseEntity<Appointment> updateAppointment(
//            @PathVariable int clientId,
//            @PathVariable String dateTime,
//            @RequestBody Appointment appointmentDetails
//    ) {
//        return appointmentRepository.findByClient_ClientIDAndDateTime(clientId, LocalDateTime.parse(dateTime))
//                .get(appointment -> {
//                    appointment.setEmployee(appointmentDetails.getEmployee());
//                    appointment.setService(appointmentDetails.getService());
//                    return ResponseEntity.ok(appointmentRepository.save(appointment));
//                }).orElse(ResponseEntity.notFound().build());
//    }

//    @DeleteMapping("/{clientId}/{dateTime}")
//    public ResponseEntity<Void> deleteAppointment(
//            @PathVariable int clientId,
//            @PathVariable String dateTime
//    ) {
//        return appointmentRepository.findByClient_ClientIDAndDateTime(clientId, LocalDateTime.parse(dateTime))
//                .map(appointment -> {
//                    appointmentRepository.delete(appointment);
//                    return ResponseEntity.ok().<Void>build();
//                }).orElse(ResponseEntity.notFound().build());
//    }
}
