package databasemodell;

import java.time.LocalDate;

public class EmployeeService {

    private String jobTypname;

    public EmployeeService(String jobTypname) {
        this.jobTypname = jobTypname;

    }
    public String getJobTypname() {
        return jobTypname;
    }


    public void setJobTypname(String jobTypname) {
        this.jobTypname = jobTypname;
    }

}

