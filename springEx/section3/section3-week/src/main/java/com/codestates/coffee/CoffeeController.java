package com.codestates.coffee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public ResponseEntity<Map<String, String>> postCoffee(@RequestParam String memberId,
                                                         @RequestParam String name,
                                                          @RequestParam String price) {
        Map<String, String> model = new HashMap<>();
        model.put("memberId", memberId);
        model.put("name", name);
        model.put("price", price);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity<Void> getCoffee(@PathVariable long coffeeId) {
        log.info("# coffeeId: {}", coffeeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Void> getCoffees() {
        log.info("# get Coffees");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
