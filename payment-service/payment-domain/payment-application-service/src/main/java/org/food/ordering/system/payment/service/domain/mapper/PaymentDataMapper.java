package org.food.ordering.system.payment.service.domain.mapper;

import org.food.ordering.system.domain.valueobject.CustomerId;
import org.food.ordering.system.domain.valueobject.Money;
import org.food.ordering.system.domain.valueobject.OrderId;
import org.food.ordering.system.payment.service.domain.dto.PaymentRequest;
import org.food.ordering.system.payment.service.domain.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {
    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .orderId(new OrderId(UUID.fromString(paymentRequest.getOrderId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }
}
