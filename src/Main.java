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
        service1.setJobTypID(100);
        serviceRepository.addService(service1);

        Service service2 = new Service();
        service2.setServiceID(2);
        service2.setName("Man haircut");
        service2.setPrice(70);
        service1.setJobTypID(100);
        serviceRepository.addService(service2);

        Service service3 = new Service();
        service3.setServiceID(3);
        service3.setName("Hair coloring");
        service3.setPrice(150);
        service1.setJobTypID(100);
        serviceRepository.addService(service3);

        Service service4 = new Service();
        service4.setServiceID(4);
        service4.setName("Hair styling");
        service4.setPrice(100);
        service1.setJobTypID(100);
        serviceRepository.addService(service4);

        EmployeeService employeeService1 = new EmployeeService(100, "Service Name");
        employeeService1.setEmployeeID(1000);
        employeeService1.setName("Marinela Pop");
        employeeService1.setBirthDate(LocalDate.of(1990, 2, 5));


        Employee employee2 = new Employee();
        employee2.setEmployeeID(1001);
        employee2.setName("John Smith");
        employee2.setJobTypID(100);
        employee2.setBirthDate(LocalDate.of(1985, 4, 10));

        Employee employee3 = new Employee();
        employee3.setEmployeeID(1002);
        employee3.setName("Alice Johnson");
        employee3.setJobTypID(100);
        employee3.setBirthDate(LocalDate.of(1992, 8, 15));

        Employee employee4 = new Employee();
        employee4.setEmployeeID(1003);
        employee4.setName("David Lee");
        employee4.setJobTypID(102);
        employee4.setBirthDate(LocalDate.of(1980, 3, 20));

        Employee employee5 = new Employee();
        employee5.setEmployeeID(1004);
        employee5.setName("Emily Davis");
        employee5.setJobTypID(101);
        employee5.setBirthDate(LocalDate.of(1995, 6, 25));

        // Create the ui.UI
        UI ui = new UI(serviceRepository,employeeRepository);

        // Start the ui.UI
        ui.start();
        }
    }
