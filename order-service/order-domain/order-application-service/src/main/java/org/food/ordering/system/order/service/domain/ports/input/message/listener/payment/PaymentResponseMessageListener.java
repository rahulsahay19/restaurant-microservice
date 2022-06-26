package org.food.ordering.system.order.service.domain.ports.input.message.listener.payment;

import org.food.ordering.system.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    //These will come into picture with saga pattern
    void paymentCompleted(PaymentResponse paymentResponse);
    void paymentCancelled(PaymentResponse paymentResponse);
}
