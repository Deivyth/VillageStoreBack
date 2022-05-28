package com.villagestore.api.product.application;

import com.villagestore.api.product.application.dto.ProductDto;
import com.villagestore.api.product.domain.Product;
import com.villagestore.api.product.infrastructure.ProductRepository;
import com.villagestore.api.specs.ProductSpecification;
import com.villagestore.api.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDto(products);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductDto> getProductById(Long id) {
        return productRepository
                .findById(id)
                .map(productMapper::toDto);
    }

    @Override
    @Transactional
    public ProductDto addProduct(ProductDto productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public Page<ProductDto> getItemsByCriteriaStringPaged(Pageable pageable, String filter) {
        ProductSpecification specification = new ProductSpecification(SearchCriteriaHelper.fromFilterString(filter));
        Page<Product> productPage = productRepository.findAll(specification, pageable);
        return productPage.map(productMapper::toDto);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
