package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.ProductReceipt;
import org.salon_frumusete.repository.ProductReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-receipts")
public class ProductReceiptController {

    @Autowired
    private ProductReceiptRepository productReceiptRepository;

    @PostMapping
    public ResponseEntity<ProductReceipt> addProductReceipt(@RequestBody ProductReceipt productReceipt) {
        ProductReceipt savedProductReceipt = productReceiptRepository.save(productReceipt);
        return ResponseEntity.ok(savedProductReceipt);
    }

    @GetMapping
    public ResponseEntity<List<ProductReceipt>> getProductReceipts() {
        return ResponseEntity.ok(productReceiptRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductReceipt(@PathVariable int id) {
        return productReceiptRepository.findById(id)
                .map(productReceipt -> {
                    productReceiptRepository.delete(productReceipt);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearProductReceipts() {
        productReceiptRepository.deleteAll();
        return ResponseEntity.ok().<Void>build();
    }
}
