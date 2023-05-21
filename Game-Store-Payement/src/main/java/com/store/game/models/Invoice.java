package com.store.game.models;

import com.store.game.dto.PaymentRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {

    @Id
    @UuidGenerator
    private UUID invoiceId;
    private int customerId;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;
    private String status;


    public Invoice(PaymentRequest paymentRequest){
        this.invoiceId = paymentRequest.getInvoiceId();
        this.customerId = paymentRequest.getCustomerId();
        this.paymentDate = paymentRequest.getPaymentDate();
        this.amount = paymentRequest.getAmount();
        this.paymentMethod = paymentRequest.getPaymentMethod();
        this.status = paymentRequest.getStatus();
    }
}
