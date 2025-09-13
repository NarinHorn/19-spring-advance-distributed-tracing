package com.example.service;


import com.example.model.dto.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse findById(Long id);
}
