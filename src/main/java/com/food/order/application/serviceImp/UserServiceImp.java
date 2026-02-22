package com.food.order.application.serviceImp;

import com.food.order.application.entity.User;
import com.food.order.application.repository.UserRepository;
import com.food.order.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ItemRepository itemRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String userRegisteration(User user) {
        userRepository.save(user);
        return "User Registered!!! " +"UserId: "+user.getUserId();
    }

//    @Override
//    public CatalogDTO searchItem(String restaurantName, String names) {
//
//        CatalogDTO dto = itemRepository.findItemNamePriceQuantity(restaurantName,names);
//        logger.info(dto.toString());
//        logger.info(String.valueOf(dto));
//        return  dto;
//    }
}
