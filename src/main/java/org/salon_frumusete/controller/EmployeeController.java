package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Employee;
import org.salon_frumusete.repository.EmployeeRepository;

import java.time.LocalTime;
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

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.getEmployeesByName(name);
    }

    public LocalTime getWorkStartTimeById(int employeeID) {
        return employeeRepository.getWorkStartTimeById(employeeID);
    }

    public LocalTime getWorkEndTimeById(int employeeID) {
        return employeeRepository.getWorkEndTimeById(employeeID);
    }



}