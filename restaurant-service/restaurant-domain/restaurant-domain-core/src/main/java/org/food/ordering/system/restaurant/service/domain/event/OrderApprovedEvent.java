package org.food.ordering.system.restaurant.service.domain.event;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.domain.valueobject.RestaurantId;
import org.food.ordering.system.restaurant.service.domain.entity.OrderApproval;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderApprovedEvent extends OrderApprovalEvent {
    private final DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher;
    public OrderApprovedEvent(OrderApproval orderApproval,
                              RestaurantId restaurantId,
                              List<String> failureMessages,
                              ZonedDateTime createdAt,
                              DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher) {
        super(orderApproval, restaurantId, failureMessages, createdAt);
        this.orderApprovedEventDomainEventPublisher = orderApprovedEventDomainEventPublisher;
    }

    //Fire method created to easily fire an event from application service
    @Override
    public void fire() {
        orderApprovedEventDomainEventPublisher.publish(this);
    }
}
