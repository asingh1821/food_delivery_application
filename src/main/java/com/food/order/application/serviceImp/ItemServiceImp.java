package com.food.order.application.serviceImp;

import com.food.order.application.dto.ItemDTO;
import com.food.order.application.entity.Item;
import com.food.order.application.entity.Restaurant;
import com.food.order.application.repository.ItemRepository;
import com.food.order.application.repository.RestaurantRepository;
import com.food.order.application.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ItemServiceImp implements ItemService {

    Logger logger = LoggerFactory.getLogger(ItemServiceImp.class);
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public ItemServiceImp() {
    }

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemServiceImp(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<String> addCatalog(Item item) {
        itemRepository.save(item);
        List<String> listOfItems = itemRepository.findItemNamesByRestaurantId(item.getRestaurantId());
        return listOfItems;
    }

    @Override
    public List<Object> searchingItemByRestaurantnameAndItemName(String restaurantName, String itemName) {
//        log.info("restaurant name : "+restaurantName);
        Restaurant res = restaurantRepository.findByRestaurantName(restaurantName);
        long restId = res.getRestaurantId();
//        log.info("restaurant id = "+ restId);
        ItemDTO dto = itemRepository.findItemsDetailsByRestaurantIdAndItemDetails(restId,itemName);
        List<Object> itemDetailsList = new ArrayList<>();
        itemDetailsList.add(dto.getName());
        itemDetailsList.add(dto.getPrice());
        itemDetailsList.add(dto.getQuantity());
        return itemDetailsList;
    }
    
}
