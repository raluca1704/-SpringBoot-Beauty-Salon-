package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    ProductRepository findByProductID(int productId);
}
