package com.villagestore.api.category.application;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    List<CategoryDto> getCategories();
    List<CategoryDto> getAllCategoriesByName(String partialName);
}
