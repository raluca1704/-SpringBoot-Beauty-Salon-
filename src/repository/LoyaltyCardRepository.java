package repository;

import databasemodell.Feedback;
import databasemodell.LoyaltyCard;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyCardRepository {
    private List<LoyaltyCard> loyaltyCards;
    public LoyaltyCardRepository (){
        {
            this.loyaltyCards = new ArrayList<>();
        }
    }
    public void addLoyaltyCard(LoyaltyCard loyaltyCard){
        loyaltyCards.add(loyaltyCard);
    }
    public LoyaltyCard getLoyaltyCardByID(int loyaltyCardID){
        for (LoyaltyCard loyaltyCard : loyaltyCards){
            if(loyaltyCard.getLoyaltyCardID()==loyaltyCardID){
                return loyaltyCard;
            }
        }
        return null;
    }
    public List<LoyaltyCard> getAllLoyaltyCards(){
        return new ArrayList<>(loyaltyCards);}

    public void updateLoyaltyCard(LoyaltyCard updatedLoyaltyCard) {
        for (int i = 0; i < loyaltyCards.size(); i++) {
            if (loyaltyCards.get(i).getLoyaltyCardID() == updatedLoyaltyCard.getLoyaltyCardID()) {
                loyaltyCards.set(i, updatedLoyaltyCard);
                return;
            }
        }
    }

}
