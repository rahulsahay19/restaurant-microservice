package org.food.ordering.system.order.service.domain.ports.input.service;

import org.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import org.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import org.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import org.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
