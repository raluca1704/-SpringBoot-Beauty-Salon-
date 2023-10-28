package ui;

import controller.EmployeeController;
import controller.ServiceController;

import databasemodell.Employee;
import databasemodell.EmployeeService;
import databasemodell.Service;

import java.util.List;
import java.util.Optional;
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
            System.out.println("1. View our services");
            System.out.println("2. View our employees");
            System.out.println("3. Make an appointment");
//          System.out.println("4. Do you have a loyalty card?");
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
                case 3:
                    Scanner scaner = new Scanner(System.in);
                    System.out.print("First you need to choose a service: ");
                    String name = scaner.nextLine();
                    chooseService(name);
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Now, which of our employees would you like to choose? ");
                    String nameemployee = scanner1.nextLine();
                    break;

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

            System.out.println(employee.getName() + " - " + employee.getJobTypname()+ " - Rating: "+ employee.getRating());
        }
    }
    private void chooseService(String name) {

        List<Service> serviceChoosed = serviceController.getServicesByName(name);
        int id= 0;
        for(Service service:serviceChoosed){
            id=service.getServiceID();
        }
        if (serviceChoosed.isEmpty()) {
            System.out.println("No services found with the name: " + name);
        } else {
            System.out.println("The original price for '" + name + "' is: " + serviceController.getServicePriceById(id)+ ", but it may differ by the job difficulty or the employee." );

        }
    }


}
