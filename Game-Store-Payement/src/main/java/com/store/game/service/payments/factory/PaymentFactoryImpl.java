package com.store.game.service.payments.factory;

import com.store.game.enums.PaymentsTypes;
import com.store.game.service.payments.PaymentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentFactoryImpl implements PaymentFactory {

    private final List<PaymentService> services;
    private static final Map<PaymentsTypes, PaymentService> paymentServicingCache = new HashMap<>();

    @Autowired
    public PaymentFactoryImpl(List<PaymentService> services) {
        this.services = services;
    }

    @Override
    @PostConstruct
    public void init() {
        this.services.forEach(paymentService -> paymentServicingCache.put(paymentService.getType(), paymentService));
    }

    @Override
    public PaymentService getPaymentService(PaymentsTypes type) throws IllegalArgumentException {
        return Optional.ofNullable(paymentServicingCache.get(type)).orElseThrow(IllegalArgumentException::new);
    }
}
