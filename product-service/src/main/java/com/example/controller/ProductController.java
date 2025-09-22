package com.example.controller;

import com.example.config.CategoryClient;
import com.example.model.dto.request.ProductRequest;
import com.example.model.dto.response.ProductResponse;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryClient categoryClient;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productResponse);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Long id) {
        ProductResponse productResponse = productService.findById(id);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> list() {
        List<ProductResponse> productResponseList = productService.findAll();
        return ResponseEntity.ok(productResponseList);
    }

    @GetMapping("/ports")
    public String getPortOfCategory() {
        log.info("Product service is calling category service...");
        String categoryPort = categoryClient.getPort();
        log.info("Product service received response.");
        return "Product service received: " + categoryPort;
    }
}
