package org.food.ordering.system.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.ordering.system.order.service.domain.OrderDomainService;
import org.food.ordering.system.order.service.domain.entity.Customer;
import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import org.food.ordering.system.order.service.domain.exception.OrderDomainException;
import org.food.ordering.system.service.domain.dto.create.CreateOrderCommand;
import org.food.ordering.system.service.domain.mapper.OrderDataMapper;
import org.food.ordering.system.service.domain.ports.output.CustomerRepository;
import org.food.ordering.system.service.domain.ports.output.OrderRepository;
import org.food.ordering.system.service.domain.ports.output.RestaurantRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {
    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService, OrderRepository orderRepository,
                             CustomerRepository customerRepository, RestaurantRepository restaurantRepository,
                             OrderDataMapper orderDataMapper)
    {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional //This will make the operation transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand){
        chekCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant =  checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        saveOrder(order);
        log.info("Order is created with id {}:", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if(optionalRestaurant.isEmpty()){
            log.warn("Could not find restaurant with id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with id:" + createOrderCommand.getRestaurantId());
        }
        return optionalRestaurant.get();
    }

    private void chekCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if(customer.isEmpty()){
            log.warn("Could not find customer with id: {}", customerId);
            throw new OrderDomainException("Could not find customer with id:" + customerId);
        }
    }
    private Order saveOrder(Order order){
        Order orderResult = orderRepository.save(order);
        if(orderResult == null){
            log.info("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", order.getId().getValue());
        return orderResult;
    }
}

