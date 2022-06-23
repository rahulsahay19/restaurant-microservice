package org.food.ordering.system.order.service.domain.valueobject;

import org.food.ordering.system.domain.valueobject.BaseId;

//Uniqueness of orderItem only important in aggregate. Hence, UUID not required here
//Value objects are immutable and only holds data, so identifier is not important for them.
// That means 2 value objects with same data, but different id’s considered to be the same value object.
public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
