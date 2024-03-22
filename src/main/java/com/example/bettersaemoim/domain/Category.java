package com.example.bettersaemoim.domain;

import com.example.bettersaemoim.dto.response.CategoryResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Long parentId;

    public Category(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public CategoryResponseDto toCategoryResponseDto(List<Category> categories) {
        return new CategoryResponseDto(this, categories);
    }

    public void updateCategory(String categoryName) {
        this.name = categoryName;
    }
}
