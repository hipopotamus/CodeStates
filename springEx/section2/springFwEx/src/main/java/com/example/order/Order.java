package com.example.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long userId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long userId, String itemName, int itemPrice, int discountPrice) {
        this.userId = userId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
}
