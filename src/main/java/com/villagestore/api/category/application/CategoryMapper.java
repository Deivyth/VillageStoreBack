package com.villagestore.api.category.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.category.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
    default Category fromId(Long id) {
        if(id == null) return null;

        Category category = new Category();
        category.setId(id);
        return category;
    }
}
