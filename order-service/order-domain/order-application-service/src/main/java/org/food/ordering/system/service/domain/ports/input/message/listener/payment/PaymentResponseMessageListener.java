package org.food.ordering.system.service.domain.ports.input.message.listener.payment;

import org.food.ordering.system.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    //These will come into picture with saga pattern
    void paymentCompleted(PaymentResponse paymentResponse);
    void paymentCancelled(PaymentResponse paymentResponse);
}
