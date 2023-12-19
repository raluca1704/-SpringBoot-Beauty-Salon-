//package org.salon_frumusete.databasemodell;
//
//import org.salon_frumusete.databasemodell.LoyaltyCard;
//
//public abstract class LoyaltyCardDecorator extends LoyaltyCard {
//    protected LoyaltyCard decoratedLoyaltyCard;
//
//    public LoyaltyCardDecorator(LoyaltyCard decoratedLoyaltyCard) {
//        this.decoratedLoyaltyCard = decoratedLoyaltyCard;
//    }
//
//    @Override
//    public int getClientID() {
//        return decoratedLoyaltyCard.getClientID();
//    }
//
//    @Override
//    public float getDiscount() {
//        return decoratedLoyaltyCard.getDiscount();
//    }
//
//    @Override
//    public int getLoyaltyCardID() {
//        return decoratedLoyaltyCard.getLoyaltyCardID();
//    }
//}
