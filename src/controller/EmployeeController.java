package controller;

import databasemodell.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public Employee getEmployeeById(int employeeID) {
        return employeeRepository.getEmployeeById(employeeID);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public void updateEmployee(Employee updatedEmployee) {
        employeeRepository.updateEmployee(updatedEmployee);
    }

    public void deleteEmployee(int employeeID) {
        employeeRepository.deleteEmployee(employeeID);
    }
}
