package databasemodell;

import java.time.LocalDate;

public class Employee extends EmployeeService {
    private int employeeID;
    private  String name;
    private LocalDate birthDate;

    public Employee(String jobTypname, String nameService,int employeeID,String name,LocalDate birthDate) {
        super(jobTypname, nameService);
        this
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

    public int getJobTypID() {
        return jobTypID;
    }

    public void setJobTypID(int jobTypID) {
        this.jobTypID = jobTypID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }



}
