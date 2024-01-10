package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.LoyaltyCard;
import org.salon_frumusete.databasemodell.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    ReceiptRepository findByReceiptID(int receiptId);
}
