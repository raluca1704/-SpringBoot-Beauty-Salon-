package ui;

import controller.EmployeeController;
import controller.ServiceController;

import databasemodell.Appointment;
import databasemodell.Client;
import databasemodell.Employee;
import databasemodell.Service;

import java.util.List;
import java.util.Scanner;

public class UI {
    //   private final Appointment appointmentController;
    private final ServiceController serviceController;
    private final EmployeeController employeeController;
    public UI(ServiceController serviceController, EmployeeController employeeController) {
        this.employeeController=employeeController;
        this.serviceController = serviceController;
       // this.appointmentController=appointmentController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        while (working) {
            System.out.println("\nWelcome to Beauty Salon!");
            System.out.println("1. Make an appointment at us!");
            System.out.println("2. View our services");
            System.out.println("3. View our employees ");
            System.out.println("4. Do you have a loyalty card?");
            System.out.println("5. Get your receipt");
            System.out.println("6. Please, give us a feedback");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {

                case 1:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.print("First we need to get to know you, please enter your name ");
                    String name1 = scanner3.nextLine();
                    Client client1= new Client();
                    client1.setName(name1);

                    client1.setClientID(10001);
//                    Appointment appointment1= new Appointment();
//                    appointment1.setClientID(client1.getClientID());
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.print("Now your email ");
                    String email = scanner4.nextLine();
                    client1.setEmail(email);
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.print("Also your phone number ");
                    String telephone = scanner5.nextLine();
                    client1.setName(telephone);
                    Scanner scaner = new Scanner(System.in);

                    System.out.print("All set! Now you need to choose one of our services: ");
                    viewServices();
                    String name = scaner.nextLine();
                    chooseService(name);
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Now, which of our employees specialized in this service would you like to choose? ");
                    viewEmployeesForSelectedService(name);
                    String employee = scanner1.nextLine();
                    System.out.print("Very good choice, here are the available date an time you can make your appointment ");
                    availibility(employee);

                    break;
                case 2:
                    viewServices();
                    break;
                case 3:
                    viewEmployees();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Best salon in town, thanks you for choosing us!");
    }
    private void viewServices() {

        for (Service service : serviceController.getAllServices()) {

            System.out.println("\n" + service.getServiceID() + ": " + service.getName() + " - " + service.getPrice());
        }
    }

    private void viewEmployees() {
        for (Employee employee : employeeController.getAllEmployees()) {

            System.out.println( employee.getName() + " - " + employee.getJobTypname()+ " - Rating: "+ employee.getRating());
        }
    }
    private void availibility(String employee){
        List<Employee> employeeChoosed = employeeController.getEmployeesByName(employee);
        int id= 0;
        for(Employee employee1:employeeChoosed){
            id=employee1.getEmployeeID();
        }
        System.out.println("\nMonday to friday between " + employeeController.getWorkStartTimeById(id)+ " and "+ employeeController.getWorkEndTimeById(id));
    }
    private void viewEmployeesForSelectedService(String name) {

        for (Employee employee : employeeController.getAllEmployees()) {

            if (name.contains("Pedicure") ||  name.contains("Manicure")) {
                if(employee.getJobTypname().equals("Nail Technician")){
                System.out.println("\n" + employee.getEmployeeID() + " - " + employee.getName() + "- Rating " + employee.getRating());
            }
            }
            if (name.contains("Hair") || name.contains("haircut")) {
                if(employee.getJobTypname().equals("Hairstylist")){
                    System.out.println("\n" + employee.getEmployeeID() + " - " + employee.getName() + "- Rating " + employee.getRating());
                }
            }
            if (name.contains("Makeup")) {
                if(employee.getJobTypname().equals("Makeup Artist")){
                    System.out.println("\n" + employee.getEmployeeID() + " - " + employee.getName() + "- Rating " + employee.getRating());
                }
            }
            if (name.contains("Treatment") ||  name.contains("Cleansing") ||  name.contains("Styling")) {
                if(employee.getJobTypname().equals("Cosmetician")){
                    System.out.println("\n" + employee.getEmployeeID() + " - " + employee.getName() + "- Rating " + employee.getRating());
                }
            }
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
