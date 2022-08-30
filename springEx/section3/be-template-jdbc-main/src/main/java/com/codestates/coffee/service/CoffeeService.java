package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import com.codestates.coffee.repository.CoffeeRepository;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public Coffee createCoffee(Coffee coffee) {
        coffee.setCoffeeCode("1");
        return coffeeRepository.save(coffee);
    }

    public Coffee updateCoffee(Coffee coffee) {

        Coffee foundCoffee = coffeeRepository.findByCoffee(coffee.getCoffeeId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        foundCoffee.setKorName(coffee.getKorName());
        foundCoffee.setEngName(coffee.getEngName());
        foundCoffee.setPrice(coffee.getPrice());

        return coffeeRepository.save(foundCoffee);
    }

    public Coffee findCoffee(long coffeeId) {
        return coffeeRepository.findByCoffee(coffeeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));
    }

    public List<Coffee> findCoffees() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    public void deleteCoffee(long coffeeId) {
        Coffee coffee = coffeeRepository.findByCoffee(coffeeId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));
        coffeeRepository.delete(coffee);
    }

    // 주문에 해당하는 커피 정보 조회
    public List<Coffee> findOrderedCoffees(Order order) {
        return order.getOrderCoffees()
                .stream()
                .map(coffeeRef -> coffeeRepository.findById(coffeeRef.getCoffeeId())
                        .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND)))
                .collect(Collectors.toList());
    }
}
