package databasemodell;

import java.time.LocalDate;
import java.time.LocalTime;

public class Employee {
    private int employeeID;
    private String name;
    private LocalDate birthDate;
    private LocalTime workStartTime;
    private LocalTime workEndTime;
    private int serviceID;
    private String rating;


    private Employee(Builder builder) {
        this.employeeID = builder.employeeID;
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.workStartTime = builder.workStartTime;
        this.workEndTime = builder.workEndTime;
        this.serviceID = builder.serviceID;
        this.rating = builder.rating;
    }

    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalTime getWorkStartTime() {
        return workStartTime;
    }

    public LocalTime getWorkEndTime() {
        return workEndTime;
    }

    public int getServiceID() {
        return serviceID;
    }

    public String getRating() {
        return rating;
    }


    public static class Builder {
        private int employeeID;
        private String name;
        private LocalDate birthDate;
        private LocalTime workStartTime;
        private LocalTime workEndTime;
        private int serviceID;
        private String rating;

        public Builder employeeID(int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder workStartTime(LocalTime workStartTime) {
            this.workStartTime = workStartTime;
            return this;
        }

        public Builder workEndTime(LocalTime workEndTime) {
            this.workEndTime = workEndTime;
            return this;
        }

        public Builder serviceID(int serviceID) {
            this.serviceID = serviceID;
            return this;
        }

        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}