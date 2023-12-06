package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.LoyaltyCard;
import org.salon_frumusete.repository.LoyaltyCardRepository;

import java.util.List;

public class LoyaltyCardController {
    private LoyaltyCardRepository loyaltyCardRepository;

    public LoyaltyCardController(LoyaltyCardRepository loyaltyCardRepository) {
        this.loyaltyCardRepository=loyaltyCardRepository;
    }
    public void addLoyaltyCard(LoyaltyCard loyaltyCard){
        loyaltyCardRepository.addLoyaltyCard(loyaltyCard);
    }
    public LoyaltyCard getLoyaltyCardByID(int loyaltyCardID){
        return loyaltyCardRepository.getLoyaltyCardByID(loyaltyCardID);

    }
    public List<LoyaltyCard> getAllLoyaltyCards(){
        return loyaltyCardRepository.getAllLoyaltyCards();
    }

    public void updateLoyaltyCard(LoyaltyCard updatedLoyaltyCard) {
        loyaltyCardRepository.updateLoyaltyCard(updatedLoyaltyCard);

    }
    public LoyaltyCard getLoyaltyCardByClientID(int clientID) {
        return loyaltyCardRepository.getLoyaltyCardByClientID(clientID);
    }

}
