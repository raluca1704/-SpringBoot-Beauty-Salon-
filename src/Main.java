import databasemodell.Employee;
import databasemodell.EmployeeService;
import databasemodell.Service;
import repository.ServiceRepository;
import ui.UI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        repository.AppointmentRepository appointmentRepository = new repository.AppointmentRepository();
        repository.EmployeeRepository employeeRepository = new repository.EmployeeRepository();
        ServiceRepository serviceRepository = new ServiceRepository();

        Service service1 = new Service();
        service1.setServiceID(1);
        service1.setName("Woman haircut");
        service1.setPrice(200);
        service1.setJobTypname("Hairstylist");
        serviceRepository.addService(service1);

        Service service2 = new Service();
        service2.setServiceID(2);
        service2.setName("Man haircut");
        service2.setPrice(70);
        service1.setJobTypname("Hairstylist");
        serviceRepository.addService(service2);

        Service service3 = new Service();
        service3.setServiceID(3);
        service3.setName("Hair coloring");
        service3.setPrice(150);
        service1.setJobTypname("Hairstylist");
        serviceRepository.addService(service3);

        Service service4 = new Service();
        service4.setServiceID(4);
        service4.setName("Hair styling");
        service4.setPrice(100);
        service1.setJobTypname("Hairstylist");
        serviceRepository.addService(service4);


        Employee employee1 = new Employee("Hairstylist", 1001, "John Smith", LocalDate.of(1985, 4, 10));
        Employee employee2 = new Employee("Nail Technician", 1002, "Alice Johnson", LocalDate.of(1990, 5, 15));
        Employee employee3 = new Employee("Esthetician", 1003, "David Lee", LocalDate.of(1982, 8, 20));
        Employee employee4 = new Employee("Makeup Artist", 1004, "Emily Davis", LocalDate.of(1995, 3, 25));
        Employee employee5 = new Employee("Hairstylist", 1005, "Johanna Smith", LocalDate.of(1985, 4, 17));
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);
        // Create the ui.UI
        UI ui = new UI(serviceRepository,employeeRepository);

        // Start the ui.UI
        ui.start();
        }
    }
