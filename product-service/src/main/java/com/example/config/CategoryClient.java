package com.example.config;

import com.example.model.dto.response.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "category-service",
        path = "/api/v1/categories",
        url = "http://localhost:8081"
)
public interface CategoryClient {
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> get(@PathVariable Long id);

    @GetMapping
    public String getPort();
}
