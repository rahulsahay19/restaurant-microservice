package org.food.ordering.system.restaurant.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.domain.valueobject.OrderApprovalStatus;
import org.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import org.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.food.ordering.system.domain.DomainConstants.UTC;

@Slf4j
public class RestaurantDomainServiceImpl implements RestaurantDomainService {

    @Override
    public OrderApprovalEvent validateOrder(Restaurant restaurant,
                                            List<String> failureMessages,
                                            DomainEventPublisher<OrderApprovedEvent>
                                                    orderApprovedEventDomainEventPublisher,
                                            DomainEventPublisher<OrderRejectedEvent>
                                                    orderRejectedEventDomainEventPublisher) {
        restaurant.validateOrder(failureMessages);
        log.info("Validating order with id: {}", restaurant.getOrderDetail().getId().getValue());

        if (failureMessages.isEmpty()) {
            log.info("Order is approved for order id: {}", restaurant.getOrderDetail().getId().getValue());
            restaurant.constructOrderApproval(OrderApprovalStatus.APPROVED);
            return new OrderApprovedEvent(restaurant.getOrderApproval(),
                    restaurant.getId(),
                    failureMessages,
                    ZonedDateTime.now(ZoneId.of(UTC)),
                    orderApprovedEventDomainEventPublisher);
        } else {
            log.info("Order is rejected for order id: {}", restaurant.getOrderDetail().getId().getValue());
            restaurant.constructOrderApproval(OrderApprovalStatus.REJECTED);
            return new OrderRejectedEvent(restaurant.getOrderApproval(),
                    restaurant.getId(),
                    failureMessages,
                    ZonedDateTime.now(ZoneId.of(UTC)),
                    orderRejectedEventDomainEventPublisher);
        }
    }
}

