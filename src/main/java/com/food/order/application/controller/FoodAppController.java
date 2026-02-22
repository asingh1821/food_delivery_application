package com.food.order.application.controller;

import com.food.order.application.dto.RequestOrderDTO;
import com.food.order.application.entity.Item;
import com.food.order.application.entity.Restaurant;
import com.food.order.application.entity.User;
import com.food.order.application.serviceImp.ItemServiceImp;
import com.food.order.application.serviceImp.OrderServiceImp;
import com.food.order.application.serviceImp.RestaurantServiceImp;
import com.food.order.application.serviceImp.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-app")
@Slf4j
public class FoodAppController {

    Logger logger =  LoggerFactory.getLogger(FoodAppController.class);
    @Autowired
    private RestaurantServiceImp restaurantServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private ItemServiceImp itemServiceImp;

    @Autowired
    private OrderServiceImp orderServiceImp;

    public FoodAppController(OrderServiceImp orderServiceImp) {
        this.orderServiceImp = orderServiceImp;
    }

    public FoodAppController(RestaurantServiceImp restaurantServiceImp) {
        this.restaurantServiceImp = restaurantServiceImp;
    }

    public FoodAppController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public FoodAppController(ItemServiceImp itemServiceImp) {
        this.itemServiceImp = itemServiceImp;
    }

    public FoodAppController() {
    }

    @PostMapping("/register-user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        String msg = userServiceImp.userRegisteration(user);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/register-restaurant")
    public ResponseEntity<String> saveRestaurant(@RequestBody Restaurant restaurant) {
        String msg1 = restaurantServiceImp.restaurantRegisteration(restaurant);
        return ResponseEntity.ok(msg1);
    }

    @PostMapping("/register/items")
    public ResponseEntity<List<String>> addItemsToTheCatalog(
            @RequestBody Item items) {

        List<String> item = itemServiceImp.addCatalog(items);
        //log.info("Items : {}", item);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/itemdetails/{restaurantName}/{itemName}")
    public ResponseEntity<List<Object>> itemSearch(@PathVariable String restaurantName,
                                              @PathVariable String itemName) {

        List<Object> objList = itemServiceImp.searchingItemByRestaurantnameAndItemName(restaurantName, itemName);
        //log.info(i.toString());
        return ResponseEntity.ok(objList);
    }

    @PostMapping("/placeorder")
    public ResponseEntity<String> placeOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        //log.info(order.toString());
        String msg = orderServiceImp.yourOrder(requestOrderDTO);
        return ResponseEntity.ok(msg);
    }

//    @GetMapping("/findorder/userid/{id}")
//    public ResponseEntity<OrderDetailsDTO> getOrder(@PathVariable Long id) {
//        OrderDetailsDTO od = orderServiceImp.orderDetails(id);
//        return ResponseEntity.ok(od);
//    }

}
