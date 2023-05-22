package com.store.game.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.game.models.Cart;
import com.store.game.models.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao {


    public List<Product> getAllProducts(String obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(obj, new TypeReference<List<Product>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProduct(String obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(obj, Product.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getTotalCartPrice(List<Product> productList) {
        double sum = 0;
        if (productList.size() > 0) {
            for (Product item : productList) {
                sum += item.getProductPrice();
            }
        }

        return sum;
    }
}
