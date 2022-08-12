package com.example.discount;

import com.example.user.User;

public interface DiscountPolicy {
    int discount(User user, int price);
}
