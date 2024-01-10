package org.salon_frumusete.databasemodell;


public interface PricingStrategy {
    float calculateFinalPrice(float price, float loyaltyCardDiscount);
}
