package org.food.ordering.system.restaurant.service.domain.ports.output.message.publisher;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;

public interface OrderApprovedMessagePublisher extends DomainEventPublisher<OrderApprovedEvent> {
}
