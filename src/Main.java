import controller.EmployeeController;
import databasemodell.Employee;
import databasemodell.Service;
import controller.ServiceController;
import repository.EmployeeRepository;
import repository.ServiceRepository;
import ui.UI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        repository.AppointmentRepository appointmentRepository = new repository.AppointmentRepository();
      //repository.EmployeeRepository employeeRepository = new repository.EmployeeRepository();
        ServiceRepository serviceRepository = new ServiceRepository();
        ServiceController serviceController = new ServiceController(serviceRepository);

        EmployeeRepository employeeRepository=new EmployeeRepository();
        EmployeeController employeeController= new EmployeeController(employeeRepository);

        Service service1 = new Service();
        service1.setServiceID(1);
        service1.setName("Woman haircut");
        service1.setPrice(200);
        service1.setJobTypname("Hairstylist");
        serviceController.addService(service1);

        Service service2 = new Service();
        service2.setServiceID(2);
        service2.setName("Man haircut");
        service2.setPrice(70);
        service2.setJobTypname("Hairstylist");
        serviceController.addService(service2);

        Service service3 = new Service();
        service3.setServiceID(3);
        service3.setName("Hair coloring");
        service3.setPrice(150);
        service3.setJobTypname("Hairstylist");
        serviceController.addService(service3);

        Service service4 = new Service();
        service4.setServiceID(4);
        service4.setName("Hair styling");
        service4.setPrice(100);
        service4.setJobTypname("Hairstylist");
        serviceController.addService(service4);

        Service service5 = new Service();
        service5.setServiceID(5);
        service5.setName("Semipemanent Manicure");
        service5.setPrice(100);
        service5.setJobTypname("Nail Technician");
        serviceController.addService(service5);


        Service service6 = new Service();
        service6.setServiceID(6);
        service6.setName("Bridal Makeup");
        service6.setPrice(300);
        service6.setJobTypname("Makeup Artist");
        serviceController.addService(service6);

        Service service7 = new Service();
        service7.setServiceID(7);
        service7.setName("Evening Makeup");
        service7.setPrice(150);
        service7.setJobTypname("Makeup Artist");
        serviceController.addService(service7);

        Service service8 = new Service();
        service8.setServiceID(8);
        service8.setName("Fashion Makeup");
        service8.setPrice(250);
        service8.setJobTypname("Makeup Artist");
        serviceController.addService(service8);

        Service service9 = new Service();
        service9.setServiceID(9);
        service9.setName("Theatrical Makeup");
        service9.setPrice(200);
        service9.setJobTypname("Makeup Artist");
        serviceController.addService(service9);

        Service service10 = new Service();
        service10.setServiceID(10);
        service10.setName("Special Effects Makeup");
        service10.setPrice(350);
        service10.setJobTypname("Makeup Artist");
        serviceController.addService(service10);

        Service service16 = new Service();
        service16.setServiceID(16);
        service16.setName("Facial Treatment");
        service16.setPrice(150);
        service16.setJobTypname("Cosmetician");
        serviceController.addService(service16);

        Service service17 = new Service();
        service17.setServiceID(17);
        service17.setName("Eyebrow Styling");
        service17.setPrice(50);
        service17.setJobTypname("Cosmetician");
        serviceController.addService(service17);

        Service service18 = new Service();
        service18.setServiceID(18);
        service18.setName("Skin Cleansing");
        service18.setPrice(120);
        service18.setJobTypname("Cosmetician");
        serviceController.addService(service18);

        Service service19 = new Service();
        service19.setServiceID(19);
        service19.setName("Anti-Aging Treatment");
        service19.setPrice(200);
        service19.setJobTypname("Cosmetician");
        serviceController.addService(service19);
        Service service11 = new Service();
        service11.setServiceID(11);
        service11.setName("Semipemanent Pedicure");
        service11.setPrice(100);
        service11.setJobTypname("Nail Technician");
        serviceController.addService(service11);

        Service service12 = new Service();
        service12.setServiceID(12);
        service12.setName("Manicure contruction");
        service12.setPrice(180);
        service12.setJobTypname("Nail Technician");
        serviceController.addService(service12);

        Service service13 = new Service();
        service13.setServiceID(13);
        service13.setName("Pedicure contruction");
        service13.setPrice(180);
        service13.setJobTypname("Nail Technician");
        serviceController.addService(service13);

        Service service14 = new Service();
        service14.setServiceID(14);
        service14.setName("Manicure maintenance");
        service14.setPrice(100);
        service14.setJobTypname("Nail Technician");
        serviceController.addService(service14);

        Service service15 = new Service();
        service15.setServiceID(15);
        service15.setName("Pedicure maintenance");
        service15.setPrice(100);
        service15.setJobTypname("Nail Technician");
        serviceController.addService(service15);




        Employee employee1 = new Employee("Hairstylist", 1001, "John Smith", LocalDate.of(1985, 4, 10), "9.81");
        Employee employee2 = new Employee("Hairstylist", 1002, "Alice Johnson", LocalDate.of(1990, 5, 15),"8.90");
        Employee employee3 = new Employee("Nail Technician", 1003, "David Lee", LocalDate.of(1982, 8, 20),"10");
        Employee employee4 = new Employee("Nail Technician", 1004, "Emily Davis", LocalDate.of(1995, 3, 25),"9.56");
        Employee employee5 = new Employee("Makeup Artist", 1005, "Johanna Smith", LocalDate.of(1985, 4, 17),"9.70");
        Employee employee6 = new Employee("Makeup Artist", 1006, "Marry Jhons", LocalDate.of(1999, 6, 20),"8.70");
        Employee employee7 = new Employee("Cosmetician", 1007, "Clara Claris", LocalDate.of(1993, 5, 3),"8.40");
        Employee employee8 = new Employee("Cosmetician", 1007, "Elen Rules", LocalDate.of(1995, 1, 2),"9.83");



        employeeController.addEmployee(employee1);
        employeeController.addEmployee(employee2);
        employeeController.addEmployee(employee3);
        employeeController.addEmployee(employee4);
        employeeController.addEmployee(employee5);
        employeeController.addEmployee(employee6);
        employeeController.addEmployee(employee7);
        employeeController.addEmployee(employee8);

        // Create the ui.UI
        UI ui = new UI(serviceController, employeeController);

        // Start the ui.UI
        ui.start();
        }
    }
