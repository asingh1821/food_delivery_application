package com.food.order.application.repository;

import com.food.order.application.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
        Restaurant findByRestaurantName(String restaurantName);
        //Optional<Restaurant> findByRestaurantId(long restaurantId);
}
