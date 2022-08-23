package com.example.order;

import com.example.discount.DiscountPolicy;
import com.example.user.User;
import com.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final UserRepository userRepository;
    private final DiscountPolicy discountInfo;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository, DiscountPolicy discountInfo) {
        this.userRepository = userRepository;
        this.discountInfo = discountInfo;
    }

    @Override
    public Order createOrder(Long userId, String itemName, int itemPrice) {
        User user = userRepository.findByUserId(userId);
        int discountPrice = discountInfo.discount(user, itemPrice);

        return new Order(userId, itemName, itemPrice, discountPrice);
    }
}