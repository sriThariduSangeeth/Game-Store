package com.store.game.controller;

import com.store.game.dto.PaymentRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.service.payments.AllPayments;
import com.store.game.service.payments.PaymentService;
import com.store.game.service.payments.factory.PaymentFactory;
import com.store.game.service.payments.factory.PaymentFactoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(PaymentFactoryImpl paymentFactoryImpl) {
        this.paymentFactory = paymentFactoryImpl;
    }

    @PostMapping("/game/store/{type}/payement")
    public ResponseEntity<?> addPayemnt(@PathVariable PaymentsTypes type,
                                        @RequestBody PaymentRequest payment){
        return paymentFactory.getPaymentService(type).addPayment(payment);
    }

    @PutMapping("/game/store/{type}/payement")
    public ResponseEntity<?> updatePayemnt(@PathVariable PaymentsTypes type,
                                        @RequestBody PaymentRequest payment){
        return paymentFactory.getPaymentService(type).updateInvoice(payment);
    }

    @GetMapping("/game/store/{invoiceId}/payments/{type}")
    public ResponseEntity<?> reviewPayemnt(@PathVariable UUID invoiceId,
                                           @PathVariable PaymentsTypes type){
        return paymentFactory.getPaymentService(type).reviewPayment(invoiceId);
    }

    @GetMapping("/game/store/payments")
    public ResponseEntity<?> reviewAllPayemnt(){
        return paymentFactory.getPaymentService(PaymentsTypes.all).reviewInvoice(0);
    }
}
