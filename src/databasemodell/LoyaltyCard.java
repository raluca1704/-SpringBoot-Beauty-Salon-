package databasemodell;

public class LoyaltyCard {
    private int loyaltyCardID;
    private int clientID;
    private float discount;
    private int bonusPunkt;
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

    public int getBonusPunkt() {
        return bonusPunkt;
    }

    public void setBonusPunkt(int bonusPunkt) {
        this.bonusPunkt = bonusPunkt;
    }

    public int getLoyaltyCardID() {
        return loyaltyCardID;
    }

    public void setLoyaltyCardID(int loyaltyCardID) {
        this.loyaltyCardID = loyaltyCardID;
    }



}
