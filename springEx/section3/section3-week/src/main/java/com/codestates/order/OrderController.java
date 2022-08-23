package com.codestates.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity<Map<String, String>> postOrder(@RequestParam String coffeeId,
                                                          @RequestParam String memberId) {
        Map<String, String> model = new HashMap<>();
        model.put("coffeeId", coffeeId);
        model.put("memberId", memberId);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Void> getOrder(@PathVariable long orderId) {
        log.info("# orderId: {}", orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Void> getOrders() {
        log.info("# get Orders");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
