package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.ProductReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReceiptRepository extends JpaRepository<ProductReceipt, Integer> {
    // Additional custom queries if needed
}
