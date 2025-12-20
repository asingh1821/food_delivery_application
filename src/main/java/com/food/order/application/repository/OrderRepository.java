package com.food.order.application.repository;


import com.food.order.application.dto.ResponseOrderDto;
import com.food.order.application.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
//    @Query("""
//            SELECT o.orderId, o.itemId, o.price, o.quantity "
//            "FROM Order o"
//            " WHERE o.userId = :userId
//            """)
//    ResponseOrderDto findOrderDetails(@Param("userId") Long userId);

}
