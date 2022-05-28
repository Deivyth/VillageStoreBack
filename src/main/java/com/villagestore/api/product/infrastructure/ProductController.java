package com.villagestore.api.product.infrastructure;

import com.villagestore.api.product.application.dto.ProductDto;
import com.villagestore.api.product.application.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(value = "/products-old", produces = "application/json")
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

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<Page<ProductDto>> getItemsByCriteriaPaged(@RequestParam(value = "filter", required = false) String filter, Pageable pageable) {
        Page<ProductDto> productDtos = this.productService.getItemsByCriteriaStringPaged(pageable, filter);
        return new ResponseEntity<Page<ProductDto>>(productDtos, HttpStatus.OK);
    }

    @PostMapping(value = "/products", produces = "application/json",consumes = "application/json")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        productDto = productService.addProduct(productDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/products", produces = "application/json",consumes = "application/json")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        productDto = productService.addProduct(productDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/products/{productId}")
    ResponseEntity<?> deleteProductById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
