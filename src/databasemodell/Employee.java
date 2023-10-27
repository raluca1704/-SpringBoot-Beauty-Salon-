package databasemodell;

import java.time.LocalDate;

public class Employee extends EmployeeService {
    private int employeeID;
    private  String name;
    private LocalDate birthDate;

    public Employee(String jobTypname,int employeeID,String name,LocalDate birthDate) {
        super(jobTypname);
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



}
