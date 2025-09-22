package com.example.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "inventory-service",
        path = "/api/v1/inventory",
        url = "http://localhost:8084"
)
public interface InventoryClient {
    @GetMapping("/{productId}")
    public ResponseEntity<Integer> getStockInDate(@PathVariable Long productId);
}
