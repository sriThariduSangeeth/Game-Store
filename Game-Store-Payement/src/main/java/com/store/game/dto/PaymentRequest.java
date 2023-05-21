package com.store.game.dto;

import com.store.game.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private int customerId;
    private UUID invoiceId;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;
    private String status;
    private int itemCount;
    private List<Product> products;

}
