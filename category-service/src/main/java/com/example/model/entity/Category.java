package com.example.model.entity;

import com.example.model.dto.response.CategoryResponse;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryResponse toResponse(){
        return CategoryResponse.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

}
