package com.store.game.service.payments;

import com.store.game.dto.PaymentRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.models.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.UUID;

public class AllPayments implements PaymentService{

    @Override
    public ResponseEntity<?> addPayment(PaymentRequest payment) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateInvoice(PaymentRequest payment) {
        return null;
    }

    @Override
    public ResponseEntity<Invoice> reviewPayment(@Nullable UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<?> reviewPayment(int customerId) {
        return null;
    }

    @Override
    public ResponseEntity<?> reviewInvoice(UUID invoiceId) {
        return null;
    }

    @Override
    public ResponseEntity<?> reviewInvoice(int customerId) {
        return null;
    }

    @Override
    public PaymentsTypes getType() {
        return PaymentsTypes.all;
    }
}
