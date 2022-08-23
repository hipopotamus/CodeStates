package com.example.discount;

import com.example.user.User;
import com.example.user.UserGrade;

public class RateDiscount implements DiscountPolicy{

    private int grade_1_Rate = 5;
    private int grade_2_rate = 10;

    @Override
    public int discount(User user, int price) {
        if (user.getUserGrade() == UserGrade.GRADE_1) {
            return price * grade_1_Rate / 100;
        } else if (user.getUserGrade() == UserGrade.GRADE_2) {
            return price * grade_2_rate / 100;
        }
        return 0;
    }
}
