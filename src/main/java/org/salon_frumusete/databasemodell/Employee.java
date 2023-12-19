package org.salon_frumusete.databasemodell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int employeeID;
    private String name;
    private LocalDate birthDate;
    private LocalTime workStartTime;
    private LocalTime workEndTime;
    private int serviceID;
    private String rating;

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalTime getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(LocalTime workStartTime) {
        this.workStartTime = workStartTime;
    }

    public LocalTime getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(LocalTime workEndTime) {
        this.workEndTime = workEndTime;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public static class Builder {
        private Employee employee = new Employee();

        public Builder employeeID(int employeeID) {
            employee.employeeID = employeeID;
            return this;
        }

        public Builder name(String name) {
            employee.name = name;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            employee.birthDate = birthDate;
            return this;
        }

        public Builder workStartTime(LocalTime workStartTime) {
            employee.workStartTime = workStartTime;
            return this;
        }

        public Builder workEndTime(LocalTime workEndTime) {
            employee.workEndTime = workEndTime;
            return this;
        }

        public Builder serviceID(int serviceID) {
            employee.serviceID = serviceID;
            return this;
        }

        public Builder rating(String rating) {
            employee.rating = rating;
            return this;
        }

        public Employee build() {
            return employee;
        }
    }

}