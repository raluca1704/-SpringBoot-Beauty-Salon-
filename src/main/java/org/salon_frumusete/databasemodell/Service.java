package org.salon_frumusete.databasemodell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service {

    @Id
    private int serviceID;

    private String name;
    private float price;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public  float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

}