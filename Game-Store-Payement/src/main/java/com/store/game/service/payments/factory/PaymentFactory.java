package com.store.game.service.payments.factory;

import com.store.game.enums.PaymentsTypes;
import com.store.game.service.payments.PaymentService;

public interface PaymentFactory {

    void init();
    PaymentService getPaymentService(PaymentsTypes types) throws IllegalArgumentException;
}
