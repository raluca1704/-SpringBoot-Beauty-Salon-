package repository;

import databasemodell.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceRepository {
    private List<EmployeeService> employeeServices;

    public EmployeeServiceRepository() {
        this.employeeServices = new ArrayList<>();
    }

    public void addEmployeeService(EmployeeService employeeService) {
        employeeServices.add(employeeService);
    }

    public EmployeeService getEmployeeServiceByJobType(int jobTypID) {
        for (EmployeeService service : employeeServices) {
            if (service.getJobTypID() == jobTypID) {
                return service;
            }
        }
        return null; // databasemodell.EmployeeService not found
    }

    public List<EmployeeService> getAllEmployeeServices() {
        return new ArrayList<>(employeeServices); // Return a copy to avoid modifying the internal list
    }

    public void updateEmployeeService(EmployeeService updatedEmployeeService) {
        for (int i = 0; i < employeeServices.size(); i++) {
            if (employeeServices.get(i).getJobTypID() == updatedEmployeeService.getJobTypID()) {
                employeeServices.set(i, updatedEmployeeService);
                return;
            }
        }
    }

    public void deleteEmployeeService(int jobTypID) {
        employeeServices.removeIf(service -> service.getJobTypID() == jobTypID);
    }
}
