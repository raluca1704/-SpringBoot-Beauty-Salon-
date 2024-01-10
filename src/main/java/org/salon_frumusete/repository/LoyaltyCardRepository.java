package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCard, Integer> {
    LoyaltyCard findByClientID(int clientId);
}