package org.food.ordering.system.restaurant.service.domain.repository;

import org.food.ordering.system.restaurant.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
