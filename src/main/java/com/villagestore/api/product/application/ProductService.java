package com.villagestore.api.product.application;

import com.villagestore.api.product.application.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    Optional<ProductDto> getProductById(Long id);
    ProductDto addProduct(ProductDto productDTO);
    Page<ProductDto> getItemsByCriteriaStringPaged(Pageable pageable, String filter);
    void deleteProduct(Long id);
}
