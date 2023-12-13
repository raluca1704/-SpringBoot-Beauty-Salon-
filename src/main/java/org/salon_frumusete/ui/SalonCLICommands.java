//package org.salon_frumusete.ui;
//
//import org.salon_frumusete.controller.*;
//import org.salon_frumusete.databasemodell.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@ShellComponent
//public class wSalonCLICommands {
//
//    @Autowired
//    private ServiceController serviceController;
//    @Autowired
//    private FeedbackController feedbackController;
//    @Autowired
//    private EmployeeController employeeController;
//    @Autowired
//    private LoyaltyCardController loyaltyCardController;
//    @Autowired
//    private ClientController clientController;
//    @Autowired
//    private AppointmentController appointmentController;
//
//    @ShellMethod("Welcome to Beauty Salon!")
//    public String welcome() {
//        return "Welcome to Beauty Salon!";
//    }
//
//    @ShellMethod("Make an appointment.")
//    public String makeAppointment(
//            @ShellOption(help = "Client name") String name,
//            @ShellOption(help = "Client email") String email,
//            @ShellOption(help = "Client phone") String phone,
//            @ShellOption(help = "Service ID") int serviceId,
//            @ShellOption(help = "Employee ID") int employeeId,
//            @ShellOption(help = "Appointment date and time (yyyy-MM-dd HH:mm)") String dateTimeStr) {
//
//        Client client = new Client();
//        client.setName(name);
//        client.setEmail(email);
//        client.setTelephoneNumber(phone);
//        clientController.addClient(client);
//
//        Service selectedService = serviceController.getServiceById(serviceId);
//        Employee selectedEmployee = employeeController.getEmployeeById(employeeId);
//        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//
//        Appointment appointment = new Appointment();
//        appointment.setClient(client);
//        appointment.setService(selectedService);
//        appointment.setEmployee(selectedEmployee);
//        appointment.setDateTime(dateTime);
//        appointmentController.addAppointment(appointment);
//
//        return String.format("Appointment made for %s with %s for %s.", name, selectedService.getName(), dateTimeStr);
//    }
//
//    @ShellMethod("View available services.")
//    public String viewServices() {
//        return serviceController.getAllServices().stream()
//                .map(service -> String.format("%d: %s - Price: %s", service.getServiceID(), service.getName(), service.getPrice()))
//                .collect(Collectors.joining("\n"));
//    }
//
//    @ShellMethod("View employees.")
//    public String viewEmployees() {
//        return employeeController.getAllEmployees().stream()
//                .map(employee -> String.format("%d: %s - Service ID: %d - Rating: %s", employee.getEmployeeID(), employee.getName(), employee.getServiceID(), employee.getRating()))
//                .collect(Collectors.joining("\n"));
//    }
//
//    @ShellMethod("View your appointments.")
//    public String viewAppointments(@ShellOption(help = "Client Name") String clientName) {
//        Client client = clientController.getClientByName(clientName);
//        if (client == null) {
//            return "Client not found.";
//        }
//
//        List<Appointment> appointments = appointmentController.getAppointmentsByClientID(client.getClientID());
//        if (appointments.isEmpty()) {
//            return "No appointments available.";
//        }
//
//        return appointments.stream()
//                .map(appointment -> String.format("Client: %s - Service: %s - Employee: %s - Date and Time: %s", appointment.getClient().getName(), appointment.getService().getName(), appointment.getEmployee().getName(), appointment.getDateTime()))
//                .collect(Collectors.joining("\n"));
//    }
//
//    @ShellMethod("Check or create a loyalty card.")
//    public String handleLoyaltyCard(
//            @ShellOption(help = "Client Name") String clientName,
//            @ShellOption(help = "Create new card (yes/no)", defaultValue = ShellOption.NULL) String createCardChoice) {
//
//        Client client = clientController.getClientByName(clientName);
//        if (client == null) {
//            return "Client not found.";
//        }
//
//        LoyaltyCard loyaltyCard = loyaltyCardController.getLoyaltyCardByClientID(client.getClientID());
//        if (loyaltyCard != null) {
//            return "You already have a loyalty card with a discount of " + loyaltyCard.getDiscount() + "%.";
//        } else {
//            if ("yes".equalsIgnoreCase(createCardChoice)) {
//                loyaltyCard = new LoyaltyCard();
//                loyaltyCard.setClientID(client.getClientID());
//                loyaltyCard.setDiscount(20);
//                loyaltyCardController.addLoyaltyCard(loyaltyCard);
//                return "Loyalty card created successfully.";
//            } else {
//                return "No loyalty card found.";
//            }
//        }
//    }
//
//    @ShellMethod("Get your receipt.")
//    public String getReceipt(@ShellOption(help = "Client Name") String clientName) {
//        Client client = clientController.getClientByName(clientName);
//        if (client == null) {
//            return "Client not found.";
//        }
//
//        List<Appointment> appointments = appointmentController.getAppointmentsByClientID(client.getClientID());
//        if (appointments.isEmpty()) {
//            return "No appointments available.";
//        }
//
//        float totalCost = 0;
//        StringBuilder receipt = new StringBuilder("Receipt for " + client.getName() + ":\n");
//        for (Appointment appointment : appointments) {
//            float price = appointment.getService().getPrice();
//            receipt.append("Service: ").append(appointment.getService().getName()).append(" - Price: ").append(price).append("\n");
//            totalCost += price;
//        }
//        receipt.append("\nTotal Cost: $").append(totalCost);
//
//        return receipt.toString();
//    }
//
//    @ShellMethod("Give feedback.")
//    public String giveFeedback(
//            @ShellOption(help = "Client Name") String clientName,
//            @ShellOption(help = "Feedback Description") String description,
//            @ShellOption(help = "Feedback Stars (0-5)") int stars) {
//
//        Client client = clientController.getClientByName(clientName);
//        if (client == null) {
//            return "Client not found.";
//        }
//
//        Feedback feedback = new Feedback();
//        feedback.setClientID(client.getClientID());
//        feedback.setDescription(description);
//        feedback.setStars(stars);
//        feedbackController.addFeedback(feedback);
//
//        return "Feedback received. Thank you!";
//    }
//
//    // Additional commands can be added here based on your UI logic
//}