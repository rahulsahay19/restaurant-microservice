package org.food.ordering.system.order.service.domain.ports.output;

import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
