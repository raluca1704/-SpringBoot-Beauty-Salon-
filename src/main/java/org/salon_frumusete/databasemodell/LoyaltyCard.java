package org.salon_frumusete.databasemodell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_card")
public class LoyaltyCard               implements LoyltyCardINTERFACE{
    @Id
    private int loyaltyCardID;
    private int clientID;
    private float discount;



    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }



    public int getLoyaltyCardID() {
        return loyaltyCardID;
    }

    public void setLoyaltyCardID(int loyaltyCardID) {
        this.loyaltyCardID = loyaltyCardID;
    }



}