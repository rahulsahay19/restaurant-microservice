package org.food.ordering.system.payment.service.domain.ports.output.repository;

import org.food.ordering.system.payment.service.domain.entity.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findByOrderId(UUID orderId);
}
