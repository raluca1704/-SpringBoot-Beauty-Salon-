package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.ProductReceipt;

import java.util.ArrayList;
import java.util.List;

public class ProductReceiptRepository {
    private List<ProductReceipt> productReceipts;

    public ProductReceiptRepository() {
        this.productReceipts = new ArrayList<>();
    }

    public void addProductReceipt(ProductReceipt productReceipt) {
        productReceipts.add(productReceipt);
    }

    public List<ProductReceipt> getProductReceipts() {
        return new ArrayList<>(productReceipts); // Return a copy to avoid modifying the internal list
    }

    public void deleteProductReceipt(ProductReceipt productReceipt) {
        productReceipts.remove(productReceipt);
    }

    public void clearProductReceipts() {
        productReceipts.clear();
    }
}