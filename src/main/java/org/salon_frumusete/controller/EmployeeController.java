package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Employee;
import org.salon_frumusete.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) {
        return employeeRepository.findById(employeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employeeDetails) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setBirthDate(employeeDetails.getBirthDate());
                    employee.setWorkStartTime(employeeDetails.getWorkStartTime());
                    employee.setWorkEndTime(employeeDetails.getWorkEndTime());
                    employee.setServiceID(employeeDetails.getServiceID());
                    employee.setRating(employeeDetails.getRating());
                    return ResponseEntity.ok(employeeRepository.save(employee));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employeeRepository.delete(employee);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeRepository.findByNameContaining(name));
    }
}