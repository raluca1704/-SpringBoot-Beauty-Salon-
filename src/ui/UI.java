package ui;

import controller.EmployeeController;
import controller.ServiceController;
import  controller.AppointmentController;
import controller.LoyaltyCardController;
import  controller.ClientController;
import databasemodell.*;
import controller.FeedbackController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    //   private final Appointment appointmentController;
    private final ServiceController serviceController;
    private  final  FeedbackController feedbackController;
    private final EmployeeController employeeController;

    private final AppointmentController appointmentController;
    private final LoyaltyCardController loyaltyCardController;
    private final ClientController clientController;
    public UI(FeedbackController feedbackController, ClientController clientController,LoyaltyCardController loyaltyCardController,ServiceController serviceController, EmployeeController employeeController, AppointmentController appointmentController) {
        this.employeeController=employeeController;
        this.serviceController = serviceController;
        this.appointmentController=appointmentController;
        this.loyaltyCardController=loyaltyCardController;
        this.clientController=clientController;
        this.feedbackController=feedbackController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        while (working) {
            System.out.println("\nWelcome to Beauty Salon!");
            System.out.println("1. Make an appointment at us!");
            System.out.println("2. View our services");
            System.out.println("3. View our employees ");
            System.out.println("4. View your appointment");
            System.out.println("5. Do you have a loyalty card?");
            System.out.println("6. Get your receipt");
            System.out.println("7. Please, give us a feedback");

            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {

                case 1:
                    makeAppointment();

                    break;
                case 2:
                    viewServices();
                    break;
                case 3:
                    viewEmployees();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    handleLoyaltyCard();
                    break;
                case 6:
                    getReceipt();
                case 7:
                    giveFeedback();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Best salon in town, thanks you for choosing us!");
    }
    private void makeAppointment() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("First, we need to get to know you. Please enter your name: ");
        String name1 = scanner3.nextLine();
        Client client1 = new Client();
        client1.setName(name1);
        clientController.addClient(client1);

        // Choose service
        Scanner scanner = new Scanner(System.in);
        System.out.print("All set! Now you need to choose one of our services:\n ");
        viewServices();
        int serviceId = Integer.parseInt(scanner.nextLine());
        Service selectedService = chooseService(serviceId);

        // Choose employee
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Now, which of our employees specialized in this service would you like to choose? ");
        viewEmployeesForSelectedService(serviceId);
        int employeeid = scanner1.nextInt();
        Employee selectedEmployee = chooseEmployee(employeeid);

        // Display available date and time
        System.out.print("Very good choice! Here are the available date and time you can make your appointment: ");
        availibility(employeeid);

        // Confirm appointment
        System.out.print("Enter the date and time for your appointment (yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Create the appointment
        Appointment appointment = new Appointment();
        appointment.setClient(client1);
        appointment.setService(selectedService);
        appointment.setEmployee(selectedEmployee);
        appointment.setDateTime(appointmentDateTime);
        appointmentController.addAppointment(appointment);


        System.out.println("Appointment created successfully!");

    }

    private void viewServices() {

        for (Service service : serviceController.getAllServices()) {

            System.out.println(service.getServiceID() + ": " + service.getName() + " - " + service.getPrice());
        }
    }
    private Service chooseService(int serviceId) {

        Service serviceChoosed = serviceController.getServiceById(serviceId);

        if (serviceId > 18) {
            System.out.println("No service found with ID: " + serviceId);
        } else {
            if (serviceChoosed != null) {
                System.out.println("The original price for '" + serviceChoosed.getName() + "' is: " + serviceChoosed.getPrice() + ", but it may differ by the job difficulty or the employee.");
            } else {
                System.out.println("No service found with ID: " + serviceId);
            }
        }
        return serviceChoosed;
    }




    private void viewEmployees() {
        for (Employee employee : employeeController.getAllEmployees()) {
            int serviceID=employee.getServiceID();
            String serviceName = serviceController.getServiceNameById(serviceID);

            System.out.println(
                    employee.getEmployeeID() + " - " +
                            employee.getName() + " - " +
                            "Service: " + (serviceName != null ? serviceName : "Not assigned") +
                            " - Rating: " + employee.getRating()
            );
        }
    }

    private void availibility(int employeeid){

        System.out.println("\nMonday to friday between " + employeeController.getWorkStartTimeById(employeeid)+ " and "+ employeeController.getWorkEndTimeById(employeeid));
    }

    private void viewEmployeesForSelectedService(int serviceId) {
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : employeeController.getAllEmployees()) {
            if (employee.getServiceID() == serviceId) {
                employees.add(employee);
            }
        }

        if (employees.isEmpty()) {
            System.out.println("No employees found for the selected service with ID: " + serviceId);
        } else {
            System.out.println("Employees available for the selected service:");
            for (Employee employee : employees) {
                System.out.println(employee.getEmployeeID() + " - " + employee.getName() + " - Rating: " + employee.getRating());
            }
        }
    }



    private Employee chooseEmployee(int employeeid) {
        Employee choosedEmployee=employeeController.getEmployeeById(employeeid);

        if (employeeid==0) {
            System.out.println("No employee found with ID: " + employeeid);

        }
        return choosedEmployee;
    }

    private void viewAppointments() {

        List<Appointment> appointments =appointmentController.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            System.out.println("Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println("Client: " + appointment.getClient().getName() +
                        " - Service: " + appointment.getService().getName() +
                        " - Employee: "  +appointment.getEmployee().getName()+
                        " - Date and Time: " + appointment.getDateTime());
            }
        }
    }
    private void handleLoyaltyCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to check for a loyalty card: ");
        String clientName = scanner.nextLine();

        Client client = clientController.getClientByName(clientName);

        if (client != null) {
            LoyaltyCard loyaltyCard = loyaltyCardController.getLoyaltyCardByClientID(client.getClientID());

            if (loyaltyCard != null) {
                System.out.println("Congratulations! You have a loyalty card with a discount of " + loyaltyCard.getDiscount() + "%.");
            } else {
                System.out.println("You don't have a loyalty card. Do you want to create one? (yes/no)");
                String createCardChoice = scanner.nextLine().toLowerCase();

                if (createCardChoice.equals("yes")) {
                    createLoyaltyCard(client);
                    System.out.println("Loyalty card created successfully! You can now enjoy discounts on future appointments.");
                }
            }
        } else {
            System.out.println("Client not found with name: " + clientName);
        }
    }

    private void createLoyaltyCard(Client client) {
        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setClientID(client.getClientID());

        // Set discount as needed
        loyaltyCard.setDiscount(20); // You can set the default discount value
        loyaltyCardController.addLoyaltyCard(loyaltyCard);
    }
    public void getReceipt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to get the receipt: ");
        String clientName = scanner.nextLine();

        // Retrieve client by name
        Client client = clientController.getClientByName(clientName);

        if (client != null) {
            System.out.println("Fetching receipt for " + client.getName() + "...\n");

            // Retrieve client's appointments
            List<Appointment> clientAppointments = appointmentController.getAppointmentsByClientID(client.getClientID());

            if (clientAppointments.isEmpty()) {
                System.out.println("No appointments found for " + client.getName());
            } else {
                float totalCost = 0;

                System.out.println("Receipt for " + client.getName() + ":\n");

                for (Appointment appointment : clientAppointments) {
                    Service service = appointment.getService();
                    float servicePrice = service.getPrice();

                    // Check for loyalty card and apply discount
                    LoyaltyCard loyaltyCard = loyaltyCardController.getLoyaltyCardByClientID(client.getClientID());
                    if (loyaltyCard != null) {
                        float discountPercentage = loyaltyCard.getDiscount();
                        float discountedPrice = servicePrice - (servicePrice * (discountPercentage / 100));
                        totalCost += discountedPrice;
                        System.out.println(service.getName() + " - Original Price: " + servicePrice + " - Discounted Price: " + discountedPrice);
                    } else {
                        totalCost += servicePrice;
                        System.out.println(service.getName() + " - Price: " + servicePrice);
                    }
                }

                System.out.println("\nTotal Cost: $" + totalCost);
            }

            // Now you can use the 'client' object and 'clientAppointments' list to generate the receipt.
        } else {
            System.out.println("Client not found with name: " + clientName);
        }
    }
    private void giveFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to give feedback: ");
        String clientName = scanner.nextLine();

        Client client = clientController.getClientByName(clientName);

        if (client != null) {
            Feedback feedback = new Feedback();

            System.out.print("Enter your feedback description: ");
            feedback.setDescription(scanner.nextLine());

            System.out.print("Enter your feedback stars (0-5): ");
            float stars = scanner.nextFloat();
            feedback.setStars(stars);

            feedback.setClientID(client.getClientID());
            feedbackController.addFeedback(feedback);
            System.out.println("Thank you for your feedback!");
        } else {
            System.out.println("Client not found with name: " + clientName);
        }
    }



}











