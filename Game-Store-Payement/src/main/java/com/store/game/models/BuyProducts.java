package com.store.game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BuyProducts implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private UUID invoiceId;
    private int customerId;
    private int productId;
    private int quantity;
    private String productName;
    private double productPrice;
    private String description;

    public BuyProducts(UUID invoiceId, int customerId, Product product){
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.productId = product.getProductId();
        this.quantity = product.getQuantity();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.description = product.getDescription();
    }
}
