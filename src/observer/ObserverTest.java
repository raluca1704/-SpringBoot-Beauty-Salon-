package observer;

import controller.AppointmentController;
import databasemodell.Appointment;
import databasemodell.Client;
import org.junit.jupiter.api.Test;
import repository.AppointmentRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {

    @Test
    public void testClientNotification() {
        AppointmentRepository appointmentRepository = new AppointmentRepository();

        // Create a client and set its properties
        Client client = new Client();
        client.setClientID(1);
        client.setName("John Doe");

        // Create an appointment controller
        AppointmentController appointmentController = new AppointmentController(appointmentRepository);

        // Register the client as an observer
        appointmentController.registerObserver(client);

        // Create an appointment with the client's ID
        Appointment appointment = new Appointment();
        appointment.setClientID(client.getClientID());
        appointment.setDateTime(LocalDateTime.now().plusDays(1));

        // Add the appointment
        appointmentController.addAppointment(appointment);

        // Ensure that the notification is received
        assertEquals("Your appointment on " + appointment.getDateTime() + " is confirmed.", appointmentRepository.getNotification());
    }
}
