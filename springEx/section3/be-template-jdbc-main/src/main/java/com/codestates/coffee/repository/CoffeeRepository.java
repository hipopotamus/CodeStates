package com.codestates.coffee.repository;

import com.codestates.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    // TODO 예제 코드에 나와있는 쿼리 메서드를 정의해보세요.
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    @Query("select * from coffee where coffee_id = :coffeeId")
    Optional<Coffee> findByCoffee(Long coffeeId);
}
