package databasemodell;

import databasemodell.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeBuilderTest {

    @Test
    public void testEmployeeBuilder() {
        int employeeID = 1;
        String name = "John Doe";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        LocalTime workStartTime = LocalTime.of(9, 0);
        LocalTime workEndTime = LocalTime.of(17, 0);
        int serviceID = 101;
        String rating = "5 stars";

        Employee employee = new Employee.Builder()
                .employeeID(employeeID)
                .name(name)
                .birthDate(birthDate)
                .workStartTime(workStartTime)
                .workEndTime(workEndTime)
                .serviceID(serviceID)
                .rating(rating)
                .build();

        assertNotNull(employee);
        assertEquals(employeeID, employee.getEmployeeID());
        assertEquals(name, employee.getName());
        assertEquals(birthDate, employee.getBirthDate());
        assertEquals(workStartTime, employee.getWorkStartTime());
        assertEquals(workEndTime, employee.getWorkEndTime());
        assertEquals(serviceID, employee.getServiceID());
        assertEquals(rating, employee.getRating());
        System.out.println("Employee Builder Success");
    }

}