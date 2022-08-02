package org.food.ordering.system.order.service.domain;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import org.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import org.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;

//Here, I have returned the domain events from the domain service, which means event firing process will be on caller service
//which will be the application service. Means events will be created in domain core. However, event firing will be in application service
//I always keep my domain service in front of domains, so my application service never talk to domains directly
public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant, DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);
    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);
    void cancelOrder(Order order, List<String> failureMessages);
}
