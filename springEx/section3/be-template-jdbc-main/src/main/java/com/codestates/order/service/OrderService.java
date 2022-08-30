package com.codestates.order.service;

import com.codestates.coffee.repository.CoffeeRepository;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final CoffeeRepository coffeeRepository;

    public Order createOrder(Order order) {
        // TODO should business logic

        memberRepository.findById(order.getMemberId().getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        order.getOrderCoffees()
                .forEach(coffeeRef -> coffeeRepository.findById(coffeeRef.getCoffeeId())
                        .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND)));
        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        // TODO should business logic

        return orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
    }

    // TODO 주문 상태 수정 메서드는 JPA 학습에서 추가됩니다.

    public List<Order> findOrders() {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void cancelOrder(long orderId) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
