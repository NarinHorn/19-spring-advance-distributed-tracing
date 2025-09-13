package com.example.service.serviceimpl;

import com.example.exception.NotFoundException;
import com.example.model.dto.response.CategoryResponse;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category not " + id + " found.")
        ).toResponse();
    }
}
