package com.villagestore.api.product.application;

import com.villagestore.api.EntityMapper;
import com.villagestore.api.category.application.CategoryMapper;
import com.villagestore.api.product.domain.Product;
import com.villagestore.api.user.application.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class , UserMapper.class})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {

    @Mapping(source = "categoryId", target = "category")
    @Mapping(source = "supplierId", target = "supplier")
    Product toEntity(ProductDto productDTO);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "supplier.name", target = "supplierName")
    ProductDto toDto(Product product);
}
