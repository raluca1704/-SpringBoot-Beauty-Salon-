package org.salon_frumusete.databasemodell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "service")
public class Service {

    @Id
    private int serviceID;

    private String name;
    private float price;


    @Transient
    private PricingStrategy pricingStrategy;

    // Getters and Setters

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public float calculateFinalPrice(float loyaltyCardDiscount) {

        return (pricingStrategy != null) ? pricingStrategy.calculateFinalPrice(price, loyaltyCardDiscount) : price;
    }

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