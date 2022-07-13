package org.food.ordering.system.order.service.dataaccess.restaurant.repository;

import org.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import org.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantJpaRepsoitory extends JpaRepository<RestaurantEntity, RestaurantEntityId> {
    //This will be converted to sql query using In statement
    Optional<List<RestaurantEntity>> findByRestaurantIdAndProductIdIn(UUID restaurantId, List<UUID> productIds);
}
