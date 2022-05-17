package com.villagestore.api.product.infrastructure;

import com.villagestore.api.product.application.dto.ProductDto;
import com.villagestore.api.product.application.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<List<ProductDto>> getProducts() {
       List<ProductDto> productDtos = productService.getAllProducts();
       return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{productId}", produces = "application/json")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
        return productService
                .getProductById(productId)
                .map(productDto -> new ResponseEntity(productDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/products", produces = "application/json",consumes = "application/json")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        productDto = productService.addProduct(productDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }
}
