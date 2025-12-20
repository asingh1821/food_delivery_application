package com.food.order.application.service;

import com.food.order.application.dto.ItemDTO;
import com.food.order.application.dto.OrderDetailsDTO;
import com.food.order.application.dto.RequestOrderDTO;
import com.food.order.application.dto.ResponseOrderDto;
import com.food.order.application.entity.Item;
import com.food.order.application.entity.Order;
import com.food.order.application.entity.Restaurant;
import com.food.order.application.repository.ItemRepository;
import com.food.order.application.repository.OrderRepository;
import com.food.order.application.repository.RestaurantRepository;
import com.food.order.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String yourOrder(RequestOrderDTO requestOrderDTO) {
        Restaurant res = restaurantRepository.findByRestaurantName(requestOrderDTO.getRestaurantName());
        ItemDTO item = itemRepository.findItemsDetailsByRestaurantIdAndItemDetails(
                res.getRestaurantId(),
                requestOrderDTO.getItemName());
        Item nam = itemRepository.findByItemName(item.getName());
        Order order = new Order();
        order.setUserId(requestOrderDTO.getUserId());
        order.setRestaurantId(res.getRestaurantId());
        order.setQuantity(requestOrderDTO.getQuantity());
        //Item it = new Item();
        order.setItemId(nam.getItemId());
        order.setPrice(requestOrderDTO.getQuantity() * requestOrderDTO.getPrice());
        order.setStatus("CONFIRMED");
        orderRepository.save(order);
        return "Order placed successfully orderId: "+ order.getOrderId();
    }

//    @Override
//    public OrderDetailsDTO orderDetails(Long userId) {
//        ResponseOrderDto res = orderRepository.findOrderDetails(userId);
//        long itemId = res.getItem_id();
//        OrderDetailsDTO ord = new OrderDetailsDTO();
//        ord.setOrderId(res.getOrder_id());
//        ord.setItemName(itemRepository.findByItemId(itemId));
//        ord.setQuantity(res.getQuantity());
//        ord.setStatus(res.getStatus());
//
//        return ord;
//    }
}
