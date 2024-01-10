package org.salon_frumusete.databasemodell;
public class VIPDiscountDecorator implements LoyltyCardINTERFACE {
    private LoyaltyCard decoratedLoyaltyCard;
    private float vipDiscount;

    public VIPDiscountDecorator(LoyltyCardINTERFACE decoratedLoyaltyCard, float vipDiscount) {
        this.decoratedLoyaltyCard = (LoyaltyCard) decoratedLoyaltyCard;
        this.vipDiscount = vipDiscount;
    }

    @Override
    public int getClientID() {
        return decoratedLoyaltyCard.getClientID();
    }

    @Override
    public void setClientID(int clientID) {
        decoratedLoyaltyCard.setClientID(clientID);
    }

    @Override
    public float getDiscount() {
        return decoratedLoyaltyCard.getDiscount() + vipDiscount;
    }

    @Override
    public void setDiscount(float discount) {
        decoratedLoyaltyCard.setDiscount(discount);
    }

    @Override
    public int getLoyaltyCardID() {
        return decoratedLoyaltyCard.getLoyaltyCardID();
    }

    @Override
    public void setLoyaltyCardID(int loyaltyCardID) {
        decoratedLoyaltyCard.setLoyaltyCardID(loyaltyCardID);
    }
}
