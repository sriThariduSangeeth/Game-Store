package com.store.game.models;

import com.store.game.dto.ProductRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private int productId;
    private int quantity;
    private String productName;
    private String productCategory;
    private double productPrice;
    private String description;
    private String imgName;

    public Product(ProductRequest productRequest){
        this.productId = productRequest.getProductId();
        this.quantity = productRequest.getQuantity();
        this.productName = productRequest.getProductName();
        this.productCategory = productRequest.getProductCategory();
        this.productPrice = productRequest.getProductPrice();
        this.description = productRequest.getDescription();
        this.imgName = productRequest.getImgName();
    }
}
