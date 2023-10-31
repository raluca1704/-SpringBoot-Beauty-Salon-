package databasemodell;

public class ProductReceipt {
    private Product product;
    private int quantityPurchased;
    private double totalCost;

    public ProductReceipt(Product product, int quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalCost = product.getPrice() * quantityPurchased;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public double getTotalCost() {
        return totalCost;
    }
}