package com.example.bettersaemoim.dto.response;

import com.example.bettersaemoim.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private String name;
    private List<CategoryResponseDto> categories;

    public CategoryResponseDto(Category category, List<Category> childCategories) {
        this.id = category.getId();
        this.name = category.getName();
        categories = childCategories.stream().filter(c -> c.getParentId().equals(category.getId())).map(c ->
                c.toCategoryResponseDto(childCategories)).toList();
    }
}
