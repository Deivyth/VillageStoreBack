package com.villagestore.api.productLine.infrastructure;

import com.villagestore.api.order.application.OrderDTO;
import com.villagestore.api.productLine.application.ProductLineDTO;
import com.villagestore.api.productLine.application.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ProductLineController {

    private final ProductLineService productLineService;

    @Autowired
    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    @PostMapping(value = "/users/orders/product-line",  produces = "application/json")
    public ResponseEntity<ProductLineDTO> addUserOrders(@RequestBody ProductLineDTO productLineDTO) {
        ProductLineDTO productLine = productLineService.addProductLine(productLineDTO);
        return new ResponseEntity<>(productLine,HttpStatus.CREATED);
    }
}
