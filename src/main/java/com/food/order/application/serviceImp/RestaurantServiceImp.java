package com.food.order.application.serviceImp;

import com.food.order.application.entity.Restaurant;
import com.food.order.application.repository.RestaurantRepository;
import com.food.order.application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

//    @Autowired
//    private ItemRepository itemRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public String restaurantRegisteration(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "Registered!!! "+restaurant.getRestaurantId();
    }
}
