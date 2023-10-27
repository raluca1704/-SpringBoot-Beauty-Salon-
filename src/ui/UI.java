package ui;

import java.util.Scanner;

public class UI {

//    /private final repository.AppointmentRepository appointmentRepository;
//    private final repository.EmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;

    public UI( ServiceRepository serviceRepository) {
//        this.appointmentRepository = appointmentRepository;
//        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        while (working) {
            System.out.println("\nWelcome to Beauty Salon!");
            System.out.println("1. View Services");
//            System.out.println("2. View Employees for your chosen service");
//            System.out.println("3. Make an appointment");
//            System.out.println("4. Do you have a loyalty card?");
//            System.out.println("5. Get your receipt");
//            System.out.println("6. Please, give us a feedback");
//            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewServices();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for shopping with us!");
    }
    private void viewServices() {
        for (Service service : serviceRepository.getAllServices()) {
            System.out.println(service.getServiceID() + ": " + service.getName() + " - " + service.getPrice());
        }
    }


}
