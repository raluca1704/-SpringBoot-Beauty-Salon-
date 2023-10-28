package ui;

import controller.EmployeeController;
import controller.ServiceController;

import databasemodell.Employee;
import databasemodell.EmployeeService;
import databasemodell.Service;

import java.util.Scanner;

public class UI {

    private final ServiceController serviceController;
    private final EmployeeController employeeController;
    public UI(ServiceController serviceController, EmployeeController employeeController) {
        this.employeeController=employeeController;
        this.serviceController = serviceController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        while (working) {
            System.out.println("\nWelcome to Beauty Salon!");
            System.out.println("1. View Services");
            System.out.println("2. View Employees for your chosen service");
//          System.out.println("3. Make an appointment");
            System.out.println("4. Do you have a loyalty card?");
//          System.out.println("5. Get your receipt");
//          System.out.println("6. Please, give us a feedback");
//          System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewServices();
                    break;
                case 2:
                    viewEmployeesForSelectedService();
                   break;
//                case 3:
//                    System.out.print("View employees for the chosen service: ");
//
//                    viewEmployeesForSelectedService(serviceID);
//                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Best salon in town, thanks you for choosing us!");
    }
    private void viewServices() {

        for (Service service : serviceController.getAllServices()) {

            System.out.println(service.getServiceID() + ": " + service.getName() + " - " + service.getPrice());
        }
    }

    private void viewEmployeesForSelectedService() {
        for (Employee employee : employeeController.getAllEmployees()) {

            System.out.println(employee.getName() + " - " + employee.getJobTypname());
        }
    }

}
