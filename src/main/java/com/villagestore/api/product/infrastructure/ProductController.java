package com.villagestore.api.product.infrastructure;

import com.villagestore.api.product.application.ProductDto;
import com.villagestore.api.product.application.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final HttpServletRequest request;
    private final ProductService productService;

    public ProductController(HttpServletRequest request, ProductService productService) {
        this.request = request;
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        String accept = request.getHeader("Accept");
        if(accept != null & accept.contains("application/json")){
            List<ProductDto> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
