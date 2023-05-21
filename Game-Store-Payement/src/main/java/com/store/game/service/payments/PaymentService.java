package com.store.game.service.payments;

import com.store.game.dto.PaymentRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.models.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.UUID;

public interface PaymentService {
    ResponseEntity<?> addPayment(PaymentRequest payment);
    ResponseEntity<?> updateInvoice(PaymentRequest payment);
    ResponseEntity<?> reviewPayment(@Nullable UUID invoiceId);
    ResponseEntity<?> reviewPayment(@Nullable int customerId);
    ResponseEntity<?> reviewInvoice(@Nullable UUID invoiceId);
    ResponseEntity<?> reviewInvoice(@Nullable int customerId);
    PaymentsTypes getType();
}
