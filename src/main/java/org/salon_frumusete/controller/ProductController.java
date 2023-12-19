package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Product;
import org.salon_frumusete.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return productRepository.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product productDetails) {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setName(productDetails.getName());
                    product.setPrice(productDetails.getPrice());
                    product.setQuantityInStock(productDetails.getQuantityInStock());
                    return ResponseEntity.ok(productRepository.save(product));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        return productRepository.findById(productId)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
