package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCard, Integer> {
    LoyaltyCard findByClientId(int clientId);
}