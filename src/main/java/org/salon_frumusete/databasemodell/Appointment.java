//package org.salon_frumusete.databasemodell;
//
//import java.time.LocalDateTime;
//
//public class Appointment {
//    private int clientID;
//    private int employeeID;
//    private int serviceID;
//    private LocalDateTime dateTime;
//
//    private Client client; // add Client reference
//    private Service service; // add Service reference
//    private Employee employee; // add Employee reference
//
//
//
//
//    public Client getClient() {
//        return client;
//    }
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public int getClientID() {
//        return clientID;
//    }
//
//    public void setClientID(int clientID) {
//        this.clientID = clientID;
//    }
//
//    public int getEmployeeID() {
//        return employeeID;
//    }
//
//    public void setEmployeeID(int employeeID) {
//        this.employeeID = employeeID;
//    }
//
//    public int getServiceID() {
//        return serviceID;
//    }
//
//    public void setServiceID(int serviceID) {
//        this.serviceID = serviceID;
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
//
//
//}
package org.salon_frumusete.databasemodell;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employeeID", referencedColumnName = "employeeID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "serviceID", referencedColumnName = "serviceID")
    private Service service;

    private LocalDateTime dateTime;

    // Getters and Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}