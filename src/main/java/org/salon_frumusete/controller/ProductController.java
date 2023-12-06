package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Product;
import org.salon_frumusete.repository.ProductRepository;

import java.util.List;

public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public Product getProductById(int productID) {
        return productRepository.getProductById(productID);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void updateProduct(Product updatedProduct) {
        productRepository.updateProduct(updatedProduct);
    }

    public void deleteProduct(int productID) {
        productRepository.deleteProduct(productID);
    }
}