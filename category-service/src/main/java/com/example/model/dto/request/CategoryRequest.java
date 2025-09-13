package com.example.model.dto.request;

import com.example.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

    private String name;

    public Category toEntity(){
        return Category.builder()
                .name(this.name)
                .build();
    }

    public Category toEntity(Long id){
        return Category.builder()
                .id(id)
                .name(this.name)
                .build();
    }

}
