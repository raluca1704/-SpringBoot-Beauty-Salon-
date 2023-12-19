package org.salon_frumusete.databasemodell;

import org.salon_frumusete.observer.Observer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "client")
public class Client implements Observer {


    @Id
    private int clientID;
    private String email;
    private String name;

    private String telephoneNumber;
    public Client() {
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + this.getName() + ": " + message);
    }
}