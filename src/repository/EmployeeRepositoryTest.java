package repository;

import databasemodell.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


class EmployeeRepositoryTest {

    @Test
    void addEmployee() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee("Hairstylist", 1011, "Marry Jay", LocalDate.of(1985, 4, 10), "9.86", LocalTime.of(9, 0), LocalTime.of(16, 0));
        employeeRepository.addEmployee(employee);
        Assertions.assertTrue(employeeRepository.getAllEmployees().contains(employee));
    }


    @Test
    void getAllEmployees() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee1= new  Employee("Hairstylist", 1011, "Marry Jay", LocalDate.of(1985, 4, 10), "9.86", LocalTime.of(9, 0), LocalTime.of(16, 0));
        Employee employee2 = new Employee("Hairstylist", 1012, "Marriana Jay", LocalDate.of(1985, 4, 10), "9.86", LocalTime.of(9, 0), LocalTime.of(16, 0));

        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        // Get all employees and check if both employees are in the list
        List<Employee> allEmployees = employeeRepository.getAllEmployees();
        Assertions.assertTrue(allEmployees.contains(employee1));
        Assertions.assertTrue(allEmployees.contains(employee2));
    }


}