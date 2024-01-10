package org.salon_frumusete.controller;

//import org.salon_frumusete.databasemodell.AnniversaryGiftDecorator;
import org.salon_frumusete.databasemodell.LoyaltyCard;
//import org.salon_frumusete.databasemodell.LoyaltyCardDecorator;
import org.salon_frumusete.databasemodell.LoyltyCardINTERFACE;
import org.salon_frumusete.databasemodell.VIPDiscountDecorator;
import org.salon_frumusete.repository.LoyaltyCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loyaltycards")
public class LoyaltyCardController {

    @Autowired
    private LoyaltyCardRepository loyaltyCardRepository;


    @PostMapping
    public ResponseEntity<LoyaltyCard> addLoyaltyCard(@RequestBody LoyltyCardINTERFACE loyaltyCard) {
        LoyltyCardINTERFACE vipDiscountCard = new VIPDiscountDecorator(loyaltyCard, 0.1f); // Adjust the VIP discount as needed


        LoyltyCardINTERFACE savedVipDiscountCard = loyaltyCardRepository.save((LoyaltyCard)vipDiscountCard);

        return ResponseEntity.ok((LoyaltyCard) savedVipDiscountCard);
    }

    @GetMapping("/{loyaltyCardId}")
    public ResponseEntity<LoyaltyCard> getLoyaltyCardById(@PathVariable int loyaltyCardId) {
        return loyaltyCardRepository.findById(loyaltyCardId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyCard>> getAllLoyaltyCards() {
        return ResponseEntity.ok(loyaltyCardRepository.findAll());
    }

    @PutMapping("/{loyaltyCardId}")
    public ResponseEntity<LoyaltyCard> updateLoyaltyCard(@PathVariable int loyaltyCardId, @RequestBody LoyaltyCard loyaltyCardDetails) {
        return loyaltyCardRepository.findById(loyaltyCardId)
                .map(loyaltyCard -> {
                    loyaltyCard.setDiscount(loyaltyCardDetails.getDiscount());
                    return ResponseEntity.ok(loyaltyCardRepository.save(loyaltyCard));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{loyaltyCardId}")
    public ResponseEntity<Void> deleteLoyaltyCard(@PathVariable int loyaltyCardId) {
        return loyaltyCardRepository.findById(loyaltyCardId)
                .map(loyaltyCard -> {
                    loyaltyCardRepository.delete(loyaltyCard);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<LoyaltyCard> getLoyaltyCardByClientId(@PathVariable int clientId) {
        LoyaltyCard loyaltyCard = loyaltyCardRepository.findByClientID(clientId);
        if (loyaltyCard != null) {
            return ResponseEntity.ok(loyaltyCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}