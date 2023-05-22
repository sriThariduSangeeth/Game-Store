package com.store.game.service.payments;

import com.store.game.dto.PaymentRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.models.Invoice;
import com.store.game.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AllPayments implements PaymentService{

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public AllPayments(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

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
        return new ResponseEntity<>(this.invoiceRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public PaymentsTypes getType() {
        return PaymentsTypes.all;
    }
}
