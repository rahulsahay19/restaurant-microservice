package org.food.ordering.system.service.domain.ports.output;

import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.valueobject.TrackingId;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
