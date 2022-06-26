package org.food.ordering.system.order.service.domain.ports.output.message.publisher.payment;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
