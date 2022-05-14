package com.villagestore.api.product.application;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDTO);

    void deleteProduct(Long id);

    Optional<ProductDto> getProduct(Long id);
}
