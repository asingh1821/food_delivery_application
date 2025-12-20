package com.food.order.application.repository;

import com.food.order.application.dto.ItemDTO;
import com.food.order.application.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT i.itemName FROM Item i WHERE i.restaurantId = :restaurantId")
    List<String> findItemNamesByRestaurantId(@Param("restaurantId") Long restaurantId);

    @Query("""
       SELECT i.itemName , i.price , i.quantity 
       FROM Item i
       WHERE i.restaurantId = :restaurantId
       AND i.itemName = :itemName
       """)
    ItemDTO findItemsDetailsByRestaurantIdAndItemDetails(@Param("restaurantId") Long restaurantId,
                                                         @Param("itemName") String itemName);

    Item findByItemName(String itemName);
    @Query("SELECT i.itemName FROM Item i WHERE i.itemId = :itemId")
    String findByItemId(@Param("itemId") Long itemId);

}
