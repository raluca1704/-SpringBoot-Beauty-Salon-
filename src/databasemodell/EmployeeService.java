package databasemodell;

import java.time.LocalDate;

public class EmployeeService {

    private String jobTypname;
    private String nameService;
    public EmployeeService(String jobTypname, String nameService) {
        this.jobTypname = jobTypname;
        this.nameService = nameService;
    }
    public String getJobTypname() {
        return jobTypname;
    }


    public void setJobTypname(String jobTypname) {
        this.jobTypname = jobTypname;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

}

