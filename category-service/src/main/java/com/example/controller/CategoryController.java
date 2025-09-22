package com.example.controller;


import com.example.config.InventoryClient;
import com.example.model.dto.response.CategoryResponse;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;
    private final InventoryClient inventoryClient;

    @Value("${server.port}")
    public String port;

    @GetMapping
    public String getPort() {
        log.info("Category service was called");
        return "Port: " + port + " inventory stock: " + inventoryClient.getStockInDate(1L).getBody().toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
}

