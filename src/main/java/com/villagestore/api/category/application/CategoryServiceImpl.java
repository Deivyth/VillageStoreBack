package com.villagestore.api.category.application;

import com.villagestore.api.category.domain.Category;
import com.villagestore.api.category.infrastructure.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List <Category> categories = categoryRepository.findAll();
        return categoryMapper.toDto(categories);
    }

    @Override
    public List<CategoryDto> getAllCategoriesByName(String partialName) {
        List<Category> categories = categoryRepository.findByNameContainsIgnoreCase(partialName);
        return categoryMapper.toDto(categories);
    }
}
