package com.store.game.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.game.models.Invoice;
import com.store.game.models.Product;

import java.util.List;

public class InvoiceDao {

    public List<Invoice> getAllInvoices(String obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(obj, new TypeReference<List<Invoice>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
