package org.salon_frumusete.databasemodell;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private int productID;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;
    @OneToMany(mappedBy = "product")
    private List<ProductReceipt> productClientAssociations = new ArrayList<>();


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
