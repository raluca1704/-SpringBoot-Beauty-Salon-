import databasemodell.Service;
import repository.ServiceRepository;
import ui.UI;

public class Main {
    public static void main(String[] args) {
//        repository.AppointmentRepository appointmentRepository = new repository.AppointmentRepository();
//        repository.EmployeeRepository employeeRepository = new repository.EmployeeRepository();
        ServiceRepository serviceRepository = new ServiceRepository();

        Service service1=new Service();
        service1.setName("tuns femeia");

        // Create the ui.UI
        UI ui = new UI(serviceRepository);

        // Start the ui.UI
        ui.start();
        }
    }
