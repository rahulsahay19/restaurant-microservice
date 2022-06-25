package org.food.ordering.system.service.domain.mapper;

import org.food.ordering.system.domain.valueobject.CustomerId;
import org.food.ordering.system.domain.valueobject.Money;
import org.food.ordering.system.domain.valueobject.ProductId;
import org.food.ordering.system.domain.valueobject.RestaurantId;
import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.entity.OrderItem;
import org.food.ordering.system.order.service.domain.entity.Product;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.food.ordering.system.order.service.domain.valueobject.StreetAddress;
import org.food.ordering.system.service.domain.dto.create.CreateOrderCommand;
import org.food.ordering.system.service.domain.dto.create.CreateOrderResponse;
import org.food.ordering.system.service.domain.dto.create.OrderAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component //This is marked as spring component, so that it can be injected from service classes
public class OrderDataMapper {
   public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem -> new Product(new ProductId(orderItem.getProductId())))
                .collect(Collectors.toList()))
                .build();
    }

    //here, i just mapped the input values, which I get from the client
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand){
       return Order.builder()
               .customerId(new CustomerId(createOrderCommand.getCustomerId()))
               .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
               .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
               .price(new Money(createOrderCommand.getPrice()))
               .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
               .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<org.food.ordering.system.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
       return new StreetAddress(
               UUID.randomUUID(),
               orderAddress.getStreet(),
               orderAddress.getPostalCode(),
               orderAddress.getCity()
       );
    }
}
