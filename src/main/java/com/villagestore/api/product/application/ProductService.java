package com.villagestore.api.product.application;

import com.villagestore.api.product.application.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    Optional<ProductDto> getProductById(Long id);
    ProductDto addProduct(ProductDto productDTO);
    void deleteProduct(Long id);
}
