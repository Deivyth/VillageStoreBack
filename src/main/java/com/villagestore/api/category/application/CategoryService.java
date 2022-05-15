package com.villagestore.api.category.application;

import java.util.Optional;

public interface CategoryService {
    Optional<CategoryDto> getCategoryById(Long id);
    CategoryDto addCategory(CategoryDto categoryDto);
}
