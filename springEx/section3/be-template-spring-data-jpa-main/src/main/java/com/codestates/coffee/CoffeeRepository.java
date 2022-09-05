package com.codestates.coffee;

import com.codestates.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findByCoffeeCode(String coffeeCode);

    @Query("select c from Coffee c where c.id = :coffeeId")
    Coffee findCoffee(long coffeeId);
}
