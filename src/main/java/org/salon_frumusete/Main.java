package org.salon_frumusete;

import org.salon_frumusete.controller.*;
import org.salon_frumusete.databasemodell.Appointment;
import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.databasemodell.Employee;
import org.salon_frumusete.databasemodell.Service;
import org.salon_frumusete.factory.ServiceFactory;
import org.salon_frumusete.repository.*;
import org.salon_frumusete.ui.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        AppointmentController appointmentController= new AppointmentController(appointmentRepository);
        ServiceRepository serviceRepository = new ServiceRepository();
        ServiceController serviceController = new ServiceController(serviceRepository);
        LoyaltyCardRepository loyaltyCardRepository = new LoyaltyCardRepository();
        LoyaltyCardController loyaltyCardController = new LoyaltyCardController(loyaltyCardRepository);
        ClientRepository clientRepository = new ClientRepository();
        ClientController clientController = new ClientController(clientRepository);

        FeedbackRepository feedbackRepository = new FeedbackRepository();
        FeedbackController feedbackController = new FeedbackController(feedbackRepository);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeController employeeController = new EmployeeController(employeeRepository);



        Client client = new Client();
        client.setName("aaaaa");
        client.setTelephoneNumber("0746787877");
        client.setEmail("sssss@gmail.com");

        clientRepository.addClient(client);



        // Replace direct Service instantiation with factory.ServiceFactory
        serviceController.addService(ServiceFactory.createService(1, "Hairstyling", 200));
        serviceController.addService(ServiceFactory.createService(2, "Haircoloring", 70));
        serviceController.addService(ServiceFactory.createService(3, "Haircutting", 150));
        serviceController.addService(ServiceFactory.createService(5, "Semipemanent Manicure", 100));
        serviceController.addService(ServiceFactory.createService(6, "Bridal Makeup", 300));
        serviceController.addService(ServiceFactory.createService(7, "Evening Makeup", 150));
        serviceController.addService(ServiceFactory.createService(8, "Fashion Makeup", 250));
        serviceController.addService(ServiceFactory.createService(9, "Theatrical Makeup", 200));
        serviceController.addService(ServiceFactory.createService(10, "Special Effects Makeup", 350));
        serviceController.addService(ServiceFactory.createService(11, "Facial Treatment", 150));
        serviceController.addService(ServiceFactory.createService(12, "Eyebrow Styling", 50));
        serviceController.addService(ServiceFactory.createService(13, "Skin Cleansing", 120));
        serviceController.addService(ServiceFactory.createService(14, "Anti-Aging Treatment", 200));
        serviceController.addService(ServiceFactory.createService(15, "Semipemanent Pedicure", 100));
        serviceController.addService(ServiceFactory.createService(16, "Manicure Construction", 180));
        serviceController.addService(ServiceFactory.createService(17, "Pedicure Construction", 180));
        serviceController.addService(ServiceFactory.createService(18, "Manicure Maintenance", 100));
        serviceController.addService(ServiceFactory.createService(19, "Pedicure Maintenance", 100));


        Employee employee1 = new Employee.Builder()
                .employeeID(1001)
                .serviceID(1)
                .name("John Smith")
                .birthDate(LocalDate.of(1985, 4, 10))
                .rating("9.81")
                .workStartTime(LocalTime.of(9, 0))
                .workEndTime(LocalTime.of(16, 0))
                .build();

        Employee employee2 = new Employee.Builder()
                .employeeID(1002)
                .serviceID(2)
                .name("Alice Johnson")
                .birthDate(LocalDate.of(1990, 5, 15))
                .rating("8.90")
                .workStartTime(LocalTime.of(16, 0))
                .workEndTime(LocalTime.of(20, 0))
                .build();

        Employee employee3 = new Employee.Builder()
                .employeeID(1003)
                .serviceID(3)
                .name("David Lee")
                .birthDate(LocalDate.of(1982, 8, 20))
                .rating("10")
                .workStartTime(LocalTime.of(8, 0))
                .workEndTime(LocalTime.of(14, 0))
                .build();

        Employee employee4 = new Employee.Builder()
                .employeeID(1004)
                .serviceID(4)
                .name("Emily Davis")
                .birthDate(LocalDate.of(1995, 3, 25))
                .rating("9.56")
                .workStartTime(LocalTime.of(14, 0))
                .workEndTime(LocalTime.of(18, 0))
                .build();

        Employee employee5 = new Employee.Builder()
                .employeeID(1005)
                .serviceID(5)
                .name("Johanna Smith")
                .birthDate(LocalDate.of(1985, 4, 17))
                .rating("9.70")
                .workStartTime(LocalTime.of(7, 0))
                .workEndTime(LocalTime.of(12, 0))
                .build();

        Employee employee6 = new Employee.Builder()
                .employeeID(1006)
                .serviceID(6)
                .name("Marry Jhons")
                .birthDate(LocalDate.of(1999, 6, 20))
                .rating("8.70")
                .workStartTime(LocalTime.of(13, 30))
                .workEndTime(LocalTime.of(20, 30))
                .build();

        Employee employee7 = new Employee.Builder()
                .employeeID(1007)
                .serviceID(7)
                .name("Clara Claris")
                .birthDate(LocalDate.of(1993, 5, 3))
                .rating("8.40")
                .workStartTime(LocalTime.of(9, 0))
                .workEndTime(LocalTime.of(16, 0))
                .build();

        Employee employee8 = new Employee.Builder()
                .employeeID(1008)
                .serviceID(8)
                .name("Elen Rules")
                .birthDate(LocalDate.of(1995, 1, 2))
                .rating("9.83")
                .workStartTime(LocalTime.of(10, 0))
                .workEndTime(LocalTime.of(15, 0))
                .build();

        employeeController.addEmployee(employee1);
        employeeController.addEmployee(employee2);
        employeeController.addEmployee(employee3);
        employeeController.addEmployee(employee4);
        employeeController.addEmployee(employee5);
        employeeController.addEmployee(employee6);
        employeeController.addEmployee(employee7);
        employeeController.addEmployee(employee8);



//        // Create default entities
//        Client defaultClient = new Client();
//        // Set properties for defaultClient
//        defaultClient.setClientID(1); // Set an ID
//        defaultClient.setName("Default Client");
//        // ... [Set other properties as needed]
//
//        Employee defaultEmployee = new Employee.Builder()
//                // Set properties for defaultEmployee
//                .employeeID(1)
//                .name("Default Employee")
//                .build();
//        // ... [Set other properties as needed]
//
//        Service defaultService = new Service();
//        // Set properties for defaultService
//        defaultService.setServiceID(1); // Set an ID
//        defaultService.setName("Default Service");
//        // ... [Set other properties as needed]
//
//        // Add default entities to their respective controllers
//        clientController.addClient(defaultClient);
//        employeeController.addEmployee(defaultEmployee);
//        serviceController.addService(defaultService);
//
//        // Create a default appointment
//        Appointment defaultAppointment = new Appointment();
//        defaultAppointment.setClient(defaultClient);
//        defaultAppointment.setEmployee(defaultEmployee);
//        defaultAppointment.setService(defaultService);
//        defaultAppointment.setDateTime(LocalDateTime.now()); // Set to current date and time, or any other date and time
//
//        // Add the default appointment
//        appointmentController.addAppointment(defaultAppointment);


           UI ui = UI.getInstance(feedbackController, clientController, loyaltyCardController, serviceController, employeeController, appointmentController);

       //  Start the ui.UI
            ui.start();
    }
}