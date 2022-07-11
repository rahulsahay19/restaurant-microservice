package org.food.ordering.system.order.service.dataaccess.order.adapter;

import org.food.ordering.system.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import org.food.ordering.system.order.service.dataaccess.order.repository.OrderJPARepository;
import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.ports.output.OrderRepository;
import org.food.ordering.system.order.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJPARepository orderJPARepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJPARepository orderJPARepository,
                               OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJPARepository = orderJPARepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJPARepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJPARepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}
