package org.food.ordering.system.restaurant.service.domain;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import org.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {
    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);
}
