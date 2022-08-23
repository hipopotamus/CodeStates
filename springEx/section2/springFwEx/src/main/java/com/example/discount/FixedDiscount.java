package com.example.discount;

import com.example.user.User;
import com.example.user.UserGrade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FixedDiscount implements DiscountPolicy {

    private int grade_1_Amount = 500;
    private int grade_2_Amount = 1000;

    @Override
    public int discount(User user, int price) {
        if (user.getUserGrade() == UserGrade.GRADE_1) {
            return grade_1_Amount;
        } else if (user.getUserGrade() == UserGrade.GRADE_2) {
            return grade_2_Amount;
        }
        return 0;
    }
}
