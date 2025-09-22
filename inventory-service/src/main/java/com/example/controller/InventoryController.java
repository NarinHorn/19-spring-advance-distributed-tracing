package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    // In a real app, this would talk to a database
    @GetMapping("/{productId}")
    public ResponseEntity<Integer> getStockInDate(@PathVariable Long productId) {
        int quantity = 100;
        return ResponseEntity.ok(quantity);
    }
}
