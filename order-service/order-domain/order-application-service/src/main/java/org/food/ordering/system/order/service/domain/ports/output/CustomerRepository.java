package org.food.ordering.system.order.service.domain.ports.output;

import org.food.ordering.system.order.service.domain.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
