package controller;

import databasemodell.LoyaltyCard;
import repository.LoyaltyCardRepository;

import java.util.ArrayList;
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
}
