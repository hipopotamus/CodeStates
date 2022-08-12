package com.example.order;

import com.example.discount.DiscountPolicy;
import com.example.user.User;
import com.example.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final UserRepository userRepository;
    private final DiscountPolicy discountInfo;

    @Override
    public Order createOrder(Long userId, String itemName, int itemPrice) {
        User user = userRepository.findByUserId(userId);
        int discountPrice = discountInfo.discount(user, itemPrice);

        return new Order(userId, itemName, itemPrice, discountPrice);
    }
}