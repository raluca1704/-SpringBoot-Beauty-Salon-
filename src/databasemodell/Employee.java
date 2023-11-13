package databasemodell;

import java.time.LocalDate;
import java.time.LocalTime;

public class Employee{
    private int employeeID;
    private  String name;
    private LocalDate birthDate;
    private LocalTime workStartTime;
    private  LocalTime workEndTime;
    private int serviceID;

    public int getServiceID() {
        return serviceID;
    }

    public void setWorkStartTime(LocalTime workStartTime) {
        this.workStartTime = workStartTime;
    }

    public void setWorkEndTime(LocalTime workEndTime) {
        this.workEndTime = workEndTime;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }




    private String rating;

    public LocalTime getWorkStartTime() {
        return workStartTime;
    }

    public LocalTime getWorkEndTime() {
        return workEndTime;
    }



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
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
