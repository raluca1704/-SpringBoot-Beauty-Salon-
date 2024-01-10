package org.salon_frumusete.databasemodell;

import javax.persistence.*;

@Entity
@Table(name = "product_receipt")
public class ProductReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(name = "quantity_purchased")
    private int quantityPurchased;
    @Column(name = "total_cost")
    private double totalCost;



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    public ProductReceipt() {
    }


    public int getId() {
        return id;
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
