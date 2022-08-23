package com.example.discount;

import com.example.aop.Aspect_V1;
import com.example.user.User;
import com.example.user.UserGrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Import(Aspect_V1.class)
@SpringBootTest
class DiscountPolicyTest {

    @Autowired
    DiscountPolicy fixedDiscount;
    DiscountPolicy rateDiscount = new RateDiscount();


    @Test
    public void fixedDiscountTest() {

        User user1 = new User(0L, "testUser1", UserGrade.GRADE_1);
        User user2 = new User(0L, "testUser2", UserGrade.GRADE_2);

        int discountPrice1 = fixedDiscount.discount(user1, 5000);
        int discountPrice2 = fixedDiscount.discount(user2, 5000);

        assertThat(discountPrice1).isEqualTo(500);
        assertThat(discountPrice2).isEqualTo(1000);
    }

    @Test
    public void rateDiscountTest() {

        User user1 = new User(0L, "testUser1", UserGrade.GRADE_1);
        User user2 = new User(0L, "testUser2", UserGrade.GRADE_2);

        int discountPrice1 = rateDiscount.discount(user1, 5000);
        int discountPrice2 = rateDiscount.discount(user2, 5000);

        assertThat(discountPrice1).isEqualTo(5000 * 5 / 100);
        assertThat(discountPrice2).isEqualTo(5000 * 10 / 100);
    }

}