package com.example.service;

import com.example.model.dto.request.ProductRequest;
import com.example.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse findById(Long id);

    List<ProductResponse> findAll();
}
