package com.food.order.application.service;

import com.food.order.application.dto.ItemDTO;
import com.food.order.application.entity.Item;

import java.util.List;

public interface ItemService {
    List<String> addCatalog(Item item);
    List<Object> searchingItemByRestaurantnameAndItemName(String restaurantName, String itemName);
}
