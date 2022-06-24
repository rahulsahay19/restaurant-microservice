package org.food.ordering.system.order.service.domain.event;

import org.food.ordering.system.domain.event.DomainEvent;
import org.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

//Marked this as abstract, As I don't want this to be created
public abstract class OrderEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
