package controller;

import databasemodell.EmployeeService;
import repository.EmployeeServiceRepository;

import java.util.List;

public class EmployeeServiceController {
    private EmployeeServiceRepository employeeServiceRepository;

    public EmployeeServiceController(EmployeeServiceRepository employeeServiceRepository) {
        this.employeeServiceRepository = employeeServiceRepository;
    }

    public void addEmployeeService(EmployeeService employeeService) {
        employeeServiceRepository.addEmployeeService(employeeService);
    }

    public EmployeeService getEmployeeServiceByJobType(String jobTypname) {
        return employeeServiceRepository.getEmployeeServiceByJobType(jobTypname);
    }

    public List<EmployeeService> getAllEmployeeServices() {
        return employeeServiceRepository.getAllEmployeeServices();
    }

    public void updateEmployeeService(EmployeeService updatedEmployeeService) {
        employeeServiceRepository.updateEmployeeService(updatedEmployeeService);
    }
}
