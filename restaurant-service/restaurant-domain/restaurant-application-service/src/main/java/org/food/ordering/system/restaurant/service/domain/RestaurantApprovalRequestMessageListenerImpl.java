package org.food.ordering.system.restaurant.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import org.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;
import org.food.ordering.system.restaurant.service.domain.ports.input.message.listener.RestaurantApprovalRequestMessageListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RestaurantApprovalRequestMessageListenerImpl implements RestaurantApprovalRequestMessageListener {

    private final RestaurantApprovalRequestHelper restaurantApprovalRequestHelper;

    public RestaurantApprovalRequestMessageListenerImpl(RestaurantApprovalRequestHelper
                                                                restaurantApprovalRequestHelper) {
        this.restaurantApprovalRequestHelper = restaurantApprovalRequestHelper;
    }

    @Override
    public void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest) {
        OrderApprovalEvent orderApprovalEvent =
                restaurantApprovalRequestHelper.persistOrderApproval(restaurantApprovalRequest);
        orderApprovalEvent.fire();
    }
}
