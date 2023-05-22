package com.store.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private int productId;
    private int quantity;
    private String productName;
    private String productCategory;
    private double productPrice;
    private String description;
    private String imgName;
}
