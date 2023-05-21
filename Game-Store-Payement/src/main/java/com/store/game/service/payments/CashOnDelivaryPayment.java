package com.store.game.service.payments;

import com.store.game.dto.PaymentRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.models.BuyProducts;
import com.store.game.models.Invoice;
import com.store.game.repository.BuyProductsRepository;
import com.store.game.repository.InvoiceRepository;
import jakarta.el.PropertyNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class CashOnDelivaryPayment implements PaymentService {

    private final InvoiceRepository invoiceRepository;
    private final BuyProductsRepository buyProductsRepository;

    @Autowired
    public CashOnDelivaryPayment(InvoiceRepository invoiceRepository, BuyProductsRepository buyProductsRepository) {
        this.invoiceRepository = invoiceRepository;
        this.buyProductsRepository = buyProductsRepository;
    }

    @Override
    public ResponseEntity<?> addPayment(PaymentRequest payment) {
        List<BuyProducts> buyProductsList = new ArrayList<>();
        try {
            Invoice invoice = this.invoiceRepository.save(new Invoice(payment));
            if (Objects.nonNull(payment.getProducts()) && !payment.getProducts().isEmpty() && Objects.nonNull(invoice))
                payment.getProducts().forEach(product -> buyProductsList.add(new BuyProducts(invoice.getInvoiceId(), payment.getCustomerId(), product)));

            this.buyProductsRepository.saveAll(buyProductsList);
            return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            log.error("Data insert Error {}", ex.getMessage());
        } catch (Exception e) {
            log.error("Payment insert Error {}", e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateInvoice(PaymentRequest payment) {
        return null;
    }

    @Override
    public ResponseEntity<?> reviewPayment(@Nullable UUID id) {
        return new ResponseEntity<Invoice>(this.invoiceRepository.findById(id).orElseThrow(PropertyNotFoundException::new),HttpStatus.OK);
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
        return PaymentsTypes.cashOnDelivary;
    }
}
