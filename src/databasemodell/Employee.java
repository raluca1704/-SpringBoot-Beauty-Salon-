package databasemodell;

import java.time.LocalDate;

public class Employee extends EmployeeService {
    private int employeeID;
    private  String name;
    private LocalDate birthDate;



    private String rating;

    public Employee(String jobTypname,int employeeID,String name,LocalDate birthDate, String rating) {
        super(jobTypname);
        this.rating=rating;
        this.name=name;
        this.birthDate=birthDate;
        this.employeeID=employeeID;

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
