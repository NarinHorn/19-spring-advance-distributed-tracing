package com.example.service.serviceimpl;

import com.example.config.CategoryClient;
import com.example.model.Product;
import com.example.model.dto.request.ProductRequest;
import com.example.model.dto.response.CategoryResponse;
import com.example.model.dto.response.ProductResponse;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
//import jakarta.ws.rs.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryClient categoryClient;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        ResponseEntity<CategoryResponse> response = categoryClient.get(productRequest.getCategoryId());
        CategoryResponse categoryResponse = response.getBody();
        Product product = productRequest.toEntity();
        Product savedProduct = productRepository.save(product);
        return savedProduct.toResponse(categoryResponse);
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product id " + id + " not found"));
        ResponseEntity<CategoryResponse> response = categoryClient.get(id);
        return product.toResponse(response.getBody());
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (Product p : productList) {
            ResponseEntity<CategoryResponse> response = categoryClient.get(p.getCategoryId());
            productResponseList.add(p.toResponse(response.getBody()));
        }

        return productResponseList;
    }
}
