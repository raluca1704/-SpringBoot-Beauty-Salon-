package repository;

import databasemodell.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null; // Product not found
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return a copy to avoid modifying the internal list
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == updatedProduct.getProductID()) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    public void deleteProduct(int productID) {
        products.removeIf(product -> product.getProductID() == productID);
    }
}