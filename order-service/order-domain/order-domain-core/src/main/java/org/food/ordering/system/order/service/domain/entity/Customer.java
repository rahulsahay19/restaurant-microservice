package org.food.ordering.system.order.service.domain.entity;

import org.food.ordering.system.domain.entity.AggregateRoot;
import org.food.ordering.system.domain.valueobject.CustomerId;

//I will just use to check the existence of customer
public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
