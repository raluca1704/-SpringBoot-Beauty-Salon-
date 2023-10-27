package repository;

import databasemodell.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null; // databasemodell.Employee not found
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // Return a copy to avoid modifying the internal list
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == updatedEmployee.getEmployeeID()) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
    }

    public void deleteEmployee(int employeeID) {
        employees.removeIf(employee -> employee.getEmployeeID() == employeeID);
    }
}
