import controller.*;
import databasemodell.Appointment;
import databasemodell.Client;
import databasemodell.Employee;
import databasemodell.Service;
import repository.*;
import ui.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        ServiceRepository serviceRepository = new ServiceRepository();
        ServiceController serviceController = new ServiceController(serviceRepository);
        LoyaltyCardRepository loyaltyCardRepository= new LoyaltyCardRepository();
        LoyaltyCardController loyaltyCardController= new LoyaltyCardController(loyaltyCardRepository);
     ClientRepository clientRepository= new ClientRepository();
     ClientController clientController= new ClientController(clientRepository);

     FeedbackRepository feedbackRepository= new FeedbackRepository();
     FeedbackController feedbackController= new FeedbackController(feedbackRepository);

     EmployeeRepository employeeRepository=new EmployeeRepository();
        EmployeeController employeeController= new EmployeeController(employeeRepository);

        AppointmentRepository appointmentRepository=new AppointmentRepository();
       AppointmentController appointmentController= new AppointmentController(appointmentRepository);

        Service service1 = new Service();

        service1.setServiceID(1);
        service1.setName("Hairstyling");
        service1.setPrice(200);
        serviceController.addService(service1);

        Service service2 = new Service();
        service2.setServiceID(2);
        service2.setName("Haircoloring");
        service2.setPrice(70);

        serviceController.addService(service2);

        Service service3 = new Service();

        service3.setServiceID(3);
        service3.setName("Haircutting");
        service3.setPrice(150);

        serviceController.addService(service3);



        Service service5 = new Service();

        service5.setServiceID(5);
        service5.setName("Semipemanent Manicure");
        service5.setPrice(100);

        serviceController.addService(service5);


        Service service6 = new Service();
        service6.setServiceID(6);
        service6.setName("Bridal Makeup");
        service6.setPrice(300);

        serviceController.addService(service6);

        Service service7 = new Service();

        service7.setServiceID(6);
        service7.setName("Evening Makeup");
        service7.setPrice(150);

        serviceController.addService(service7);

        Service service8 = new Service();

        service8.setServiceID(7);
        service8.setName("Fashion Makeup");
        service8.setPrice(250);

        serviceController.addService(service8);

        Service service9 = new Service();

        service9.setServiceID(8);
        service9.setName("Theatrical Makeup");
        service9.setPrice(200);

        serviceController.addService(service9);

        Service service10 = new Service();
        service10.setServiceID(9);
        service10.setName("Special Effects Makeup");
        service10.setPrice(350);

        serviceController.addService(service10);

        Service service16 = new Service();

        service7.setServiceID(10);
        service16.setName("Facial Treatment");
        service16.setPrice(150);

        serviceController.addService(service16);

        Service service17 = new Service();

        service17.setServiceID(11);
        service17.setName("Eyebrow Styling");
        service17.setPrice(50);

        serviceController.addService(service17);

        Service service18 = new Service();
        service18.setServiceID(12);
        service18.setName("Skin Cleansing");
        service18.setPrice(120);

        serviceController.addService(service18);

        Service service19 = new Service();
        service19.setServiceID(13);
        service19.setName("Anti-Aging Treatment");
        service19.setPrice(200);

        serviceController.addService(service19);
        Service service11 = new Service();
        service11.setServiceID(14);
        service11.setName("Semipemanent Pedicure");
        service11.setPrice(100);

        serviceController.addService(service11);

        Service service12 = new Service();
        service12.setServiceID(15);
        service12.setName("Manicure contruction");
        service12.setPrice(180);

        serviceController.addService(service12);

        Service service13 = new Service();

        service13.setServiceID(16);
        service13.setName("Pedicure contruction");
        service13.setPrice(180);

        serviceController.addService(service13);

        Service service14 = new Service();
        service14.setServiceID(17);
        service14.setName("Manicure maintenance");
        service14.setPrice(100);

        serviceController.addService(service14);

        Service service15 = new Service();
        service15.setServiceID(18);
        service15.setName("Pedicure maintenance");
        service15.setPrice(100);
        serviceController.addService(service15);


        Employee employee1 = new Employee();
     employee1.setTelephoneNumber("07333333");
        employee1.setServiceID(1);
        employee1.setEmployeeID(1001);
        employee1.setName("John Smith");
        employee1.setBirthDate(LocalDate.of(1985, 4, 10));
        employee1.setRating("9.81");
        employee1.setWorkStartTime(LocalTime.of(9, 0));
        employee1.setWorkEndTime(LocalTime.of(16, 0));

        Employee employee2 = new Employee();
     employee2.setTelephoneNumber("07333333");
        employee2.setServiceID(2);
        employee2.setEmployeeID(1002);
        employee2.setName("Alice Johnson");
        employee2.setBirthDate(LocalDate.of(1990, 5, 15));
        employee2.setRating("8.90");
        employee2.setWorkStartTime(LocalTime.of(16, 0));
        employee2.setWorkEndTime(LocalTime.of(20, 0));

        Employee employee3 = new Employee();
     employee3.setTelephoneNumber("07333333");
        employee3.setServiceID(3);
        employee3.setEmployeeID(1003);
        employee3.setName("David Lee");
        employee3.setBirthDate(LocalDate.of(1982, 8, 20));
        employee3.setRating("10");
        employee3.setWorkStartTime(LocalTime.of(8, 0));
        employee3.setWorkEndTime(LocalTime.of(14, 0));

        Employee employee4 = new Employee();

        employee4.setServiceID(4);
     employee4.setTelephoneNumber("07333333");
        employee4.setEmployeeID(1004);
        employee4.setName("Emily Davis");
        employee4.setBirthDate(LocalDate.of(1995, 3, 25));
        employee4.setRating("9.56");
        employee4.setWorkStartTime(LocalTime.of(14, 0));
        employee4.setWorkEndTime(LocalTime.of(18, 0));

        Employee employee5 = new Employee();
     employee5.setTelephoneNumber("07333333");
        employee5.setServiceID(5);
        employee5.setEmployeeID(1005);
        employee5.setName("Johanna Smith");
        employee5.setBirthDate(LocalDate.of(1985, 4, 17));
        employee5.setRating("9.70");
        employee5.setWorkStartTime(LocalTime.of(7, 0));
        employee5.setWorkEndTime(LocalTime.of(12, 0));

        Employee employee6 = new Employee();
     employee6.setTelephoneNumber("07333333");
        employee6.setServiceID(6);
        employee6.setEmployeeID(1006);
        employee6.setName("Marry Jhons");
        employee6.setBirthDate(LocalDate.of(1999, 6, 20));
        employee6.setRating("8.70");
        employee6.setWorkStartTime(LocalTime.of(13, 30));
        employee6.setWorkEndTime(LocalTime.of(20, 30));

        Employee employee7 = new Employee();
        employee7.setTelephoneNumber("07333333");
        employee7.setServiceID(7);
        employee7.setEmployeeID(1007);
        employee7.setName("Clara Claris");
        employee7.setBirthDate(LocalDate.of(1993, 5, 3));
        employee7.setRating("8.40");
        employee7.setWorkStartTime(LocalTime.of(9, 0));
        employee7.setWorkEndTime(LocalTime.of(16, 0));

        Employee employee8 = new Employee();
        employee8.setServiceID(8);
        employee8.setEmployeeID(1008);
        employee8.setName("Elen Rules");
        employee8.setBirthDate(LocalDate.of(1995, 1, 2));
        employee8.setRating("9.83");
        employee8.setWorkStartTime(LocalTime.of(10, 0));
        employee8.setWorkEndTime(LocalTime.of(15, 0));



        employeeController.addEmployee(employee1);
        employeeController.addEmployee(employee2);
        employeeController.addEmployee(employee3);
        employeeController.addEmployee(employee4);
        employeeController.addEmployee(employee5);
        employeeController.addEmployee(employee6);
        employeeController.addEmployee(employee7);
        employeeController.addEmployee(employee8);
//        Client client= new Client();
//        client.setEmail("newemail@yahoo.com");
//        client.setClientID(999);
//        client.setName("raluca");
//        client.setTelephoneNumber("075345999");
//        clientController.addClient(client);
//
//// Retrieve a client (you may need to modify this based on your logic)
//     Appointment appointment = new Appointment();
//     appointment.setServiceID(1);
//     appointment.setEmployeeID(1001);
//     appointment.setDateTime(LocalDateTime.of(2023, 01, 01, 11, 30));
//
//// Retrieve a client (you may need to modify this based on your logic)
//     Client client1 = clientController.getClientByName("raluca");
//
//// Set the client for the appointment
//     appointment.setClient(client1);
//
//// Add the appointment
//     appointmentController.addAppointment(appointment);


     UI ui = new UI(feedbackController, clientController, loyaltyCardController, serviceController, employeeController, appointmentController);

        // Start the ui.UI
        ui.start();
        }
    }
