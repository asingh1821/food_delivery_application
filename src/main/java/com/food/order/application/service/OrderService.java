package com.food.order.application.service;

import com.food.order.application.dto.RequestOrderDTO;
import com.food.order.application.dto.ResponseOrderDto;
import com.food.order.application.dto.OrderDetailsDTO;
public interface OrderService {

    String yourOrder(RequestOrderDTO requestOrderDTO);
//    OrderDetailsDTO orderDetails(Long userId);
}
