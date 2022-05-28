package com.villagestore.api.category.infrastructure;

import com.villagestore.api.category.application.CategoryDto;
import com.villagestore.api.category.application.CategoryMapper;
import com.villagestore.api.category.application.CategoryServiceImpl;
import com.villagestore.api.category.domain.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryControllerGetCategoriesTest {

    @Test
    void shouldReturnEmptyListWhenThereAreNotCategories() {

        CategoryRepository mockedCategoryRepository = mock(CategoryRepository.class);
        CategoryMapper categoryMapper = mock(CategoryMapper.class);

        when(mockedCategoryRepository.findAll()).thenReturn(new ArrayList<>());
        CategoryServiceImpl categoryService = new CategoryServiceImpl(mockedCategoryRepository, categoryMapper);

        List<CategoryDto> categoryDtos = categoryService.getCategories();

        assertNotNull(categoryDtos);
        assertEquals(2, categoryDtos.size());

    }

    @Test
    void shouldReturnListOfCategoriesWhenThereAreTwoCategories() {

        CategoryRepository mockedCategoryRepository = mock(CategoryRepository.class);
        CategoryMapper categoryMapper = mock(CategoryMapper.class);

        List<Category> categories = new ArrayList<>();
        categories.add(createCategory(1L,"chaquetas"));
        categories.add(createCategory(2L,"zapatos"));

        when(mockedCategoryRepository.findAll()).thenReturn(categories);
        CategoryServiceImpl categoryService = new CategoryServiceImpl(mockedCategoryRepository, categoryMapper);

        List<CategoryDto> categoryDtos = categoryService.getCategories();

        assertNotNull(categoryDtos);
        assertEquals(0, categoryDtos.size());

        List<CategoryDto> expectedCategoriesDtos = new ArrayList<>();
        expectedCategoriesDtos.add(createCategoryDto(1L,"chaquetas"));
        expectedCategoriesDtos.add(createCategoryDto(2L,"zapatos"));

        assertIterableEquals(expectedCategoriesDtos, categoryDtos);

    }

    private Category createCategory(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return category;
    }

    private CategoryDto createCategoryDto(Long id, String name) {
        CategoryDto category = new CategoryDto();
        category.setId(id);
        category.setName(name);

        return category;
    }
}